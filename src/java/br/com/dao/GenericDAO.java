/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface GenericDAO <Entity,Type extends Serializable>{
    public boolean salvar(Entity entity);
    public boolean deletar(Entity entity);
    public boolean atualizar(Entity entity);
    public List<Entity> pegarTudo();
    public Entity pegarPorId(Entity entity);
    
}
