/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.control.Banco;
import br.com.entity.Aluno;
import br.com.entity.Ficha;
import br.com.entity.ItemFicha;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ficha
 */
public class FichaDAO implements GenericDAO<Ficha, Serializable> {
    private Session session;

    @Override
    public boolean salvar(Ficha ficha) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(ficha);
        session.getTransaction().commit();
        session.close();
          for(ItemFicha itemFicha:ficha.getItemFichas()){
            itemFicha.setFicha(ficha);
            new ItemFichaDAO().salvar(itemFicha);
        }
        return true;
    }

    @Override
    public boolean deletar(Ficha ficha) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(ficha);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean atualizar(Ficha ficha) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(ficha);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Ficha> pegarTudo() {
        session= Banco.getSessionFactory().openSession();
        List<Ficha> fichas= (List<Ficha>) session.createCriteria(Ficha.class).list();
        session.close();
        return fichas;
    }

    @Override
    public Ficha pegarPorId(Ficha ficha) {
        session= Banco.getSessionFactory().openSession();
        ficha= (Ficha) session.createCriteria(Ficha.class).add(Restrictions.eq("id", ficha.getId())).uniqueResult();
        session.close();
        return ficha;  
    }

    public List<Ficha> pegarPorAluno(Aluno aluno) {
        session=Banco.getSessionFactory().openSession();
        List<Ficha> fichas=session.createCriteria(Ficha.class).add(Restrictions.eq("aluno", aluno)).list();
        session.close();
        return fichas;
    }
    
}
