/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.control.Banco;
import br.com.entity.Funcionario;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author aluno
 */
public class FuncionarioDAO implements GenericDAO<Funcionario, Serializable> {
    public Session session;
    
    public Funcionario logar(Funcionario funcionario){
        session=Banco.getSessionFactory().openSession();
        Funcionario funcionarioRetorno= (Funcionario) session.createCriteria(Funcionario.class)
                .add(Restrictions.eq("login", funcionario.getLogin()))
                .add(Restrictions.eq("senha", funcionario.getSenha())).uniqueResult();
        session.close();
        
        return funcionarioRetorno;
    }
    @Override
    public boolean salvar(Funcionario funcionario) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(funcionario);
        session.getTransaction().commit();
        session.close();
        return true;
    }
    public boolean primeiroFuncionario(){
        if(pegarTudo().isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean deletar(Funcionario funcionario) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(funcionario);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean atualizar(Funcionario funcionario) {
        session=Banco.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(funcionario);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Funcionario> pegarTudo() {
        session= Banco.getSessionFactory().openSession();
        List<Funcionario> funcionarios= (List<Funcionario>) session.createCriteria(Funcionario.class).list();
        session.close();
        return funcionarios;
    }

    @Override
    public Funcionario pegarPorId(Funcionario funcionario) {
        session= Banco.getSessionFactory().openSession();
        funcionario= (Funcionario) session.createCriteria(Funcionario.class).add(Restrictions.eq("id", funcionario.getId())).uniqueResult();
        session.close();
        return funcionario;  
    }
    
}
