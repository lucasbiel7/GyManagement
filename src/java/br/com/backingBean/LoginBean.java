/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backingBean;

import br.com.dao.AlunoDAO;
import br.com.dao.FuncionarioDAO;
import br.com.dao.PagamentoDAO;
import br.com.entity.Aluno;
import br.com.entity.Funcionario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author aluno
 */
@ManagedBean
@SessionScoped
public class LoginBean{
      private Funcionario funcionario=new Funcionario();
      private FuncionarioDAO funcionarioDAO;
      private GrowlMensagem growlMensagem;
      private boolean logado;
    public LoginBean() {
//        setFuncionario(new Funcionario());
        for(Aluno aluno:new AlunoDAO().pegarTudo()){
            new PagamentoDAO().atualizarPagamentos(aluno);
        }
        setFuncionarioDAO(new FuncionarioDAO());
        setGrowlMensagem(new GrowlMensagem());
        setLogado(false);
    }
    public boolean primeiroFuncionario(){
        return getFuncionarioDAO().primeiroFuncionario();
    }
    public String pagLogin(){
        return "index";
    }
    public String logout(){
        setFuncionario(new Funcionario());
        setLogado(false);
        return "index";
    }
   public String login(){
       String pag="";
       setFuncionario(getFuncionarioDAO().logar(funcionario) ==null  ? new Funcionario() : getFuncionarioDAO().logar(funcionario));
       if(getFuncionario().getNome() != null){
           getFuncionario().setNome(String.valueOf(getFuncionario().getNome().charAt(0)).toUpperCase()+getFuncionario().getNome().substring(1));
           growlMensagem.setTitulo("Logado com Sucesso!");
           growlMensagem.setMessage("Seja bem vindo "+getFuncionario().getNome());
           setLogado(true);
           pag="index";
       }else{
           growlMensagem.setTitulo("Falha ao logar!");
           growlMensagem.setMessage("Ocorreu uma falha, confira se seu usuário ou senha estão corretos.");
           setLogado(false);
       }
       growlMensagem.saveMessage();
       return pag;
   }
   
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    
}
