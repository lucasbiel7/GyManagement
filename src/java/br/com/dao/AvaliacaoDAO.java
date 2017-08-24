/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.control.Banco;
import br.com.entity.Aluno;
import br.com.entity.Avaliacao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author aluno
 */
public class AvaliacaoDAO implements GenericDAO<Avaliacao, Serializable> {
    public Session session;
    @Override
    public boolean salvar(Avaliacao avaliacao) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(avaliacao);
        session.getTransaction().commit();
        session.close();
        return true;
    }
    public List<Avaliacao> pegarPorAluno(Aluno aluno){
        session=Banco.getSessionFactory().openSession();
         List<Avaliacao> avaliacoes=session.createCriteria(Avaliacao.class).add(Restrictions.eq("aluno", aluno)).list();
         session.close();
         return avaliacoes;
    }
    @Override
    public boolean deletar(Avaliacao avaliacao) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(avaliacao);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean atualizar(Avaliacao avaliacao) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(avaliacao);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Avaliacao> pegarTudo() {
        session= Banco.getSessionFactory().openSession();
        List<Avaliacao> avaliacoes= (List<Avaliacao>) session.createCriteria(Avaliacao.class).list();
        session.close();
        return avaliacoes;
    }

    @Override
    public Avaliacao pegarPorId(Avaliacao avaliacao) {
        session= Banco.getSessionFactory().openSession();
        avaliacao= (Avaliacao) session.createCriteria(Avaliacao.class).add(Restrictions.eq("id", avaliacao.getId())).uniqueResult();
        session.close();
        return avaliacao; 
    }
    
}
