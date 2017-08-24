/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.control.Banco;
import br.com.entity.Exercicio;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author exercicio
 */
public class ExercicioDAO implements GenericDAO<Exercicio, Serializable> {
    private Session session;

    @Override
    public boolean salvar(Exercicio exercicio) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(exercicio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean deletar(Exercicio exercicio) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(exercicio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean atualizar(Exercicio exercicio) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(exercicio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Exercicio> pegarTudo() {
        session= Banco.getSessionFactory().openSession();
        List<Exercicio> exercicios= (List<Exercicio>) session.createCriteria(Exercicio.class).list();
        session.close();
        return exercicios;
    }
    @Override
    public Exercicio pegarPorId(Exercicio exercicio) {
        session= Banco.getSessionFactory().openSession();
        exercicio= (Exercicio) session.createCriteria(Exercicio.class).add(Restrictions.eq("id", exercicio.getId())).uniqueResult();
        session.close();
        return exercicio;  
    }
    
}
