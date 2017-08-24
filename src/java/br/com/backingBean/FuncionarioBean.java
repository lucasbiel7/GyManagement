/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backingBean;

import br.com.dao.FuncionarioDAO;
import br.com.entity.Funcionario;
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
public class FuncionarioBean {
    private Funcionario funcionario;
    private DataModel<Funcionario> funcionarios;
    private FuncionarioDAO funcionarioDAO;
    private GrowlMensagem growlMensagem;
    private boolean editarPerfil=false;
    public FuncionarioBean() {
        setFuncionario(new Funcionario());
        setFuncionarioDAO(new FuncionarioDAO());
        setGrowlMensagem(new GrowlMensagem());
        getFuncionarios();    
    }
    
    public String editarFuncionario(Funcionario funcionario){
        setFuncionario(funcionario);
        editarPerfil=true;
        return "editarFuncionario";
    }
    public String selectFuncionario(){
        setFuncionario(funcionarios.getRowData());
        return "editarFuncionario";
    }
    public String cadastrarFuncionario(int nivel){
        if(nivel==3){
            getFuncionario().setCargo("Gerente");
        }else if(nivel==2){
            getFuncionario().setCargo("Instrutor");
        }else{
             getFuncionario().setCargo("Recepcinista");
        }
        getFuncionario().setNivelDeAcesso(nivel);
        return "cadastroFuncionario";
    }
    
    public String editarFuncionario(){
        if(getFuncionarioDAO().atualizar(getFuncionario())){
            getGrowlMensagem().setTitulo("Editado com sucesso!");
            getGrowlMensagem().setMessage("O funcionário foi editado com sucesso!");
        }else{
            getGrowlMensagem().setTitulo("Ocorreu uma falha!");
            getGrowlMensagem().setMessage("Falha ao editar este funcionário!");
        }
            getGrowlMensagem().saveMessage();
        if(editarPerfil){
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            ((LoginBean)session.getAttribute("loginBean")).setFuncionario(getFuncionario());
            return "index";
        }else{
            return "verFuncionario";
        }
    }
    
    public String cadastrarFuncionario(){
       if(getFuncionarioDAO().salvar(getFuncionario())){
            getGrowlMensagem().setTitulo("Cadastrado com sucesso!");
            getGrowlMensagem().setMessage("O funcionário foi cadastrado com sucesso!");
        }else{
            getGrowlMensagem().setTitulo("Ocorreu uma falha!");
            getGrowlMensagem().setMessage("Falha ao cadastrar este funcionário!");
        }
            getGrowlMensagem().saveMessage();
        return "index";
    }
    
    public void excluir(){
       setFuncionario(funcionarios.getRowData());
        if(getFuncionarioDAO().deletar(getFuncionario())){
            getGrowlMensagem().setTitulo("Excluído com sucesso!");
            getGrowlMensagem().setMessage("O funcionário foi excluído com sucesso!");
        }else{
            getGrowlMensagem().setTitulo("Ocorreu uma falha!");
            getGrowlMensagem().setMessage("Falha ao excluir este funcionário!");
        }
            setFuncionarios(getFuncionarios());
            getGrowlMensagem().saveMessage();
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public DataModel<Funcionario> getFuncionarios() {
        setFuncionarios(new ListDataModel<Funcionario>(funcionarioDAO.pegarTudo()));
        return funcionarios;
    }

    public void setFuncionarios(DataModel<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public GrowlMensagem getGrowlMensagem() {
        return growlMensagem;
    }

    public void setGrowlMensagem(GrowlMensagem growlMensagem) {
        this.growlMensagem = growlMensagem;
    }

    public boolean isEditarPerfil() {
        return editarPerfil;
    }

    public void setEditarPerfil(boolean editarPerfil) {
        this.editarPerfil = editarPerfil;
    }
    
}
