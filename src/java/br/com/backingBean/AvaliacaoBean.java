/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backingBean;

import br.com.dao.AvaliacaoDAO;
import br.com.entity.Aluno;
import br.com.entity.Avaliacao;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aluno
 */
@ManagedBean
@RequestScoped
public class AvaliacaoBean {

    private Aluno aluno;
    private Avaliacao avaliacao;
    private AvaliacaoDAO avaliacaoDAO;
    private GrowlMensagem growlMensagem;
    private DataModel<Avaliacao> avaliacoes;

    public AvaliacaoBean() {
        setAvaliacao(new Avaliacao());
        setAvaliacaoDAO(new AvaliacaoDAO());
        setGrowlMensagem(new GrowlMensagem());
    }

    public String cadastrar() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        getAvaliacao().setFuncionario(((LoginBean) session.getAttribute("loginBean")).getFuncionario());
        getAvaliacao().setDataAvaliacao(new Date());
        if (getAvaliacaoDAO().salvar(getAvaliacao())) {
            getGrowlMensagem().setTitulo("Cadastrado com sucesso!");
            getGrowlMensagem().setMessage("A avaliação foi realizada com sucesso!");
        } else {
            getGrowlMensagem().setTitulo("Falha ao cadastrar!");
            getGrowlMensagem().setMessage("Ocorreu um erro!");
        }
        getGrowlMensagem().saveMessage();
        return "index";
    }
    public String selectAvaliacao(Avaliacao avaliacao){
        setAvaliacao(avaliacao);
        return "verAvaliacao";
    }
    public String alterar() {
        if (getAvaliacaoDAO().atualizar(getAvaliacao())) {
            getGrowlMensagem().setTitulo("Alterado com sucesso!");
            getGrowlMensagem().setMessage("A avaliação do aluno " + aluno.getNome() + " foi alterado com sucesso!");
        } else {
            getGrowlMensagem().setTitulo("Falha ao editar!");
            getGrowlMensagem().setMessage("Ocorreu um erro!");
        }
        getGrowlMensagem().saveMessage();
        return "index";
    }

    public void excluir(Avaliacao avaliacao) {
        setAvaliacao(avaliacao);
        if (getAvaliacaoDAO().deletar(getAvaliacao())) {
            getGrowlMensagem().setTitulo("Deletado com sucesso!");
            getGrowlMensagem().setMessage("A avaliação foi deletada com sucesso!");
        } else {
            getGrowlMensagem().setTitulo("Falha ao deletar!");
            getGrowlMensagem().setMessage("Ocorreu um erro!");
        }
        getGrowlMensagem().saveMessage();
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public AvaliacaoDAO getAvaliacaoDAO() {
        return avaliacaoDAO;
    }

    public void setAvaliacaoDAO(AvaliacaoDAO avaliacaoDAO) {
        this.avaliacaoDAO = avaliacaoDAO;
    }

    public GrowlMensagem getGrowlMensagem() {
        return growlMensagem;
    }

    public void setGrowlMensagem(GrowlMensagem growlMensagem) {
        this.growlMensagem = growlMensagem;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public DataModel<Avaliacao> getAvaliacoes() {
        setAvaliacoes(new ListDataModel<Avaliacao>(getAvaliacaoDAO().pegarTudo()));
        return avaliacoes;
    }

    public void setAvaliacoes(DataModel<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
