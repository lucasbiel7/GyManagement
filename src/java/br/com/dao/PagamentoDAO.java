/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.control.Banco;
import br.com.entity.Aluno;
import br.com.entity.Pagamento;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author aluno
 */
public class PagamentoDAO implements GenericDAO<Pagamento, Serializable> {

    public Session session;

    @Override
    public boolean salvar(Pagamento paga) {
        session = Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(paga);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean deletar(Pagamento paga) {
        session = Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(paga);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean atualizar(Pagamento paga) {
        session = Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(paga);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Pagamento> pegarTudo() {
        session = Banco.getSessionFactory().openSession();
        List<Pagamento> pagamento = (List<Pagamento>) session.createCriteria(Pagamento.class).list();
        session.close();
        return pagamento;
    }

    @Override
    public Pagamento pegarPorId(Pagamento pagamento) {
        session = Banco.getSessionFactory().openSession();
        pagamento = (Pagamento) session.createCriteria(Pagamento.class).add(Restrictions.eq("id", pagamento.getId())).uniqueResult();
        session.close();
        return pagamento;
    }

    public List<Pagamento> pegarPorAluno(Aluno aluno) {
        session = Banco.getSessionFactory().openSession();
        List<Pagamento> pagamento = (List<Pagamento>) session.createCriteria(Pagamento.class).add(Restrictions.eq("aluno", aluno)).addOrder(Order.desc("dataPagamento")).list();
        session.close();
        return pagamento;
    }
    public void atualizarPagamentos(Aluno aluno) {
        List<Pagamento> pagamentos = pegarPorAluno(aluno);
        if (pagamentos.size() > 0) {
            Pagamento pagamento = pagamentos.get(0);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(pagamento.getDataPagamento());
            calendar.add(Calendar.DAY_OF_MONTH, 30);
            if (calendar.getTime().before(new Date()) && aluno.isLiberado()) {
                aluno.setLiberado(false);
                System.out.println("aluno que pegou "+aluno.getNome());
                new AlunoDAO().atualizar(aluno);
            }
        }
    }
}
