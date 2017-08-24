/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backingBean;

import br.com.dao.AlunoDAO;
import br.com.dao.AvaliacaoDAO;
import br.com.dao.FichaDAO;
import br.com.dao.PagamentoDAO;
import br.com.entity.Aluno;
import br.com.entity.Avaliacao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


/**
 *
 * @author aluno
 */
@ManagedBean
@SessionScoped
public class AlunoBean {
    private Aluno aluno;
    private AlunoDAO alunoDAO;
    private GrowlMensagem growlMensagem;
    private DataModel<Aluno> alunos;
    public AlunoBean() {
        setAluno(new Aluno());
        setAlunoDAO(new AlunoDAO());
        setGrowlMensagem(new GrowlMensagem());
    }
    public String cadastrar(){
        setAluno(new Aluno());
        return "cadastroAluno";
    }
    public String acessoAluno(){
        setAluno(new Aluno());
        return "index";
    }
    public List<Aluno> getListaAluno(){
        return getAlunoDAO().pegarTudo();
    }
     public List<Aluno> getAlunoSemAcesso(){
        return getAlunoDAO().pegarSemAcesso();
    }
    public String alterar(){
        if(getAlunoDAO().atualizar(getAluno())){
            getGrowlMensagem().setTitulo("Alterado com sucesso!");
            getGrowlMensagem().setMessage("O aluno "+aluno.getNome()+" foi alterado com sucesso!");
            setAluno(new Aluno());
        }else{
            getGrowlMensagem().setTitulo("Falha ao editar!");
            getGrowlMensagem().setMessage("Ocorreu um erro!");
        }
        getGrowlMensagem().saveMessage();
        
        return "verAluno";
    }
    public void cadastro(){
        if(alunoDAO.salvar(aluno)){
            getGrowlMensagem().setTitulo("Cadastrado com sucesso!");
            getGrowlMensagem().setMessage("O aluno "+aluno.getNome()+" foi cadastrado com sucesso!");
            setAluno(new Aluno());    
        }else{
            getGrowlMensagem().setTitulo("Falha ao cadastrar!");
            getGrowlMensagem().setMessage("Ocorreu um erro!");
        }
        getGrowlMensagem().saveMessage();
    }
    public void excluirAvaliacao(Avaliacao avaliacao) {
        if (new AvaliacaoDAO().deletar(avaliacao)) {
            getGrowlMensagem().setTitulo("Deletado com sucesso!");
            getGrowlMensagem().setMessage("A avaliação foi deletada com sucesso!");
            setAluno(new Aluno());
        } else {
            getGrowlMensagem().setTitulo("Falha ao deletar!");
            getGrowlMensagem().setMessage("Ocorreu um erro!");
        }
        getAluno().getAvaliacoes().remove(avaliacao);
        getGrowlMensagem().saveMessage();
    }
    public void login(){
        setAluno(getAlunoDAO().login(getAluno()) == null ? new Aluno() : getAlunoDAO().login(getAluno()));
        if(getAluno().getNome() == null){
            getGrowlMensagem().setTitulo("Nome de usuário não existente");
            getGrowlMensagem().setMessage("Por favor verifique se o nome digitado está correto.");
        }else if(getAluno().isLiberado()){
            getGrowlMensagem().setTitulo("Acesso Liberado");
            getGrowlMensagem().setMessage("Seja bem vindo "+getAluno().getNome()+" Acesso Liberado!");
            setAluno(new Aluno());
        }else{
            getGrowlMensagem().setTitulo("Acesso Negado");
            getGrowlMensagem().setMessage("");
        }
        getGrowlMensagem().saveMessage();
    }
    public void excluir(){
        setAluno(alunos.getRowData());
        if(getAlunoDAO().deletar(aluno)){
            getGrowlMensagem().setTitulo("Excluído com sucesso!");
            getGrowlMensagem().setMessage("O aluno foi excluído com sucesso!");
            setAluno(new Aluno());
        }else{
            getGrowlMensagem().setTitulo("Ocorreu uma falha!");
            getGrowlMensagem().setMessage("Não foi possível excluir o aluno!");
        }
        getGrowlMensagem().saveMessage();
    }

    public String selectAluno(){
        setAluno(getAlunoDAO().pegarPorId(alunos.getRowData()));
        return "editarAluno";
    }
    
    public DataModel<Aluno> getAlunos() {
        setAlunos(new ListDataModel<Aluno>(getAlunoDAO().pegarTudo()));
        return alunos;
    }

    public void setAlunos(DataModel<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    public Aluno getAluno() {
        return aluno;
    }
    public String verAvaliacoes(){
        setAluno(alunos.getRowData());
        getAluno().setAvaliacoes(new AvaliacaoDAO().pegarPorAluno(getAluno()));
        return "verAvaliacoes";
    }
      public String verFichas(){
        setAluno(alunos.getRowData());
        getAluno().setFichas(new FichaDAO().pegarPorAluno(getAluno()));
        return "verFichas";
    }
    public String verPagamentos(){
        setAluno(alunos.getRowData());
        getAluno().setPagamentos(new PagamentoDAO().pegarPorAluno(aluno));
        return "verPagamentos";
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AlunoDAO getAlunoDAO() {
        return alunoDAO;
    }

    public void setAlunoDAO(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public GrowlMensagem getGrowlMensagem() {
        return growlMensagem;
    }

    public void setGrowlMensagem(GrowlMensagem growlMensagem) {
        this.growlMensagem = growlMensagem;
    }   
}
