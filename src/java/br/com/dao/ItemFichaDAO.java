/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.control.Banco;
import br.com.entity.Ficha;
import br.com.entity.ItemFicha;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ItemFichaDAO implements GenericDAO<ItemFicha, Serializable> {
    private Session session;

    @Override
    public boolean salvar(ItemFicha itemFicha) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(itemFicha);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean deletar(ItemFicha itemFicha) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(itemFicha);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean atualizar(ItemFicha itemFicha) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(itemFicha);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<ItemFicha> pegarTudo() {
        session= Banco.getSessionFactory().openSession();
        List<ItemFicha> itensFicha= (List<ItemFicha>) session.createCriteria(ItemFicha.class).list();
        session.close();
        return itensFicha;
    }

    @Override
    public ItemFicha pegarPorId(ItemFicha itemFicha) {
        session= Banco.getSessionFactory().openSession();
        itemFicha= (ItemFicha) session.createCriteria(ItemFicha.class).add(Restrictions.eq("id", itemFicha.getId())).uniqueResult();
        session.close();
        return itemFicha;  
    }
        public List<ItemFicha> pegarPorFicha(Ficha ficha){
        session=Banco.getSessionFactory().openSession();
         List<ItemFicha> itemFichas=session.createCriteria(ItemFicha.class).add(Restrictions.eq("ficha", ficha)).list();
         session.close();
         return itemFichas;
    }
    
}
