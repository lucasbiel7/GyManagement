/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backingBean;

import br.com.dao.AlunoDAO;
import br.com.dao.PagamentoDAO;
import br.com.entity.Aluno;
import br.com.entity.Pagamento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author aluno
 */
@ManagedBean
@RequestScoped
public class PagamentoBean {
    private Pagamento pagamento;
    private PagamentoDAO pagamentoDAO;
    private GrowlMensagem growlMensagem;
    private List<Pagamento> pagamentos;
    public PagamentoBean() {
        setPagamento(new Pagamento());
        setPagamentoDAO(new PagamentoDAO());
        setGrowlMensagem(new GrowlMensagem());
    }
    
    public void realizarPagamento(){
        if(pagamentoDAO.salvar(pagamento)){
            getPagamento().getAluno().setLiberado(true);
            new AlunoDAO().atualizar(getPagamento().getAluno());
            growlMensagem.setTitulo("Pagamento efetuado!");
            growlMensagem.setMessage("O pagamento do aluno "+getPagamento().getAluno().getNome()+" foi efetuado com sucesso!");
        }else{
            growlMensagem.setTitulo("Ocorreu uma falha!");
            growlMensagem.setMessage("Ocorreu uma falha ao realizar o pagamento!");
        }
        growlMensagem.saveMessage();
        setPagamento(new Pagamento());
    }

    public String selectPagamento(Pagamento pagamento){
        setPagamento(pagamento);
        return "verPagamento";
    }
    public String verPagamentos(Aluno aluno){
        getPagamento().setAluno(aluno);
        setPagamentos(getPagamentoDAO().pegarPorAluno(aluno));
        return "verPagamentos";
    }
    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public PagamentoDAO getPagamentoDAO() {
        return pagamentoDAO;
    }

    public void setPagamentoDAO(PagamentoDAO pagamentoDAO) {
        this.pagamentoDAO = pagamentoDAO;
    }

    public GrowlMensagem getGrowlMensagem() {
        return growlMensagem;
    }

    public void setGrowlMensagem(GrowlMensagem growlMensagem) {
        this.growlMensagem = growlMensagem;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
    
}
