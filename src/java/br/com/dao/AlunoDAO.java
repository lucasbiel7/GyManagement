/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.control.Banco;
import br.com.entity.Aluno;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author aluno
 */
public class AlunoDAO implements GenericDAO<Aluno, Serializable> {
    private Session session;

    @Override
    public boolean salvar(Aluno aluno) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(aluno);
        session.getTransaction().commit();
        session.close();
        return true;
    }
    public Aluno login(Aluno aluno){
        session=Banco.getSessionFactory().openSession();
        aluno=(Aluno)session.createCriteria(Aluno.class).add(Restrictions.eq("nome", aluno.getNome())).uniqueResult();
        session.close();
        return aluno;   
    }
    @Override
    public boolean deletar(Aluno aluno) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(aluno);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean atualizar(Aluno aluno) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(aluno);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Aluno> pegarTudo() {
        session= Banco.getSessionFactory().openSession();
        List<Aluno> alunos= (List<Aluno>) session.createCriteria(Aluno.class).list(); 
        session.close();
        return alunos;
    }

    @Override
    public Aluno pegarPorId(Aluno aluno) {
        session= Banco.getSessionFactory().openSession();
        aluno= (Aluno) session.createCriteria(Aluno.class).add(Restrictions.eq("id", aluno.getId())).uniqueResult();
        aluno.setAvaliacoes(aluno.getAvaliacoes());
        session.close();
        return aluno;  
    }
        public List<Aluno> pegarSemAcesso() {
        session= Banco.getSessionFactory().openSession();
        List<Aluno> alunos= (List<Aluno>) session.createCriteria(Aluno.class).add(Restrictions.eq("liberado", false)).list(); 
        session.close(); 
        return alunos;
    }
}
