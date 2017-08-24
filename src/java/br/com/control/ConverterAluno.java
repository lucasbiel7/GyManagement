/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.control;

import br.com.dao.AlunoDAO;
import br.com.entity.Aluno;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author aluno
 */
@FacesConverter(value="converterAluno",forClass=Aluno.class)
public class ConverterAluno implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Aluno aluno=new Aluno();
        aluno.setId(Integer.parseInt(value));
        return new AlunoDAO().pegarPorId(aluno);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((Aluno)value).getId());
    }
    
}
