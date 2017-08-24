/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.control;

import br.com.dao.ExercicioDAO;
import br.com.entity.Exercicio;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="converterExercicio", forClass=Exercicio.class)
public class ConverterExercicio implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Exercicio exercicio = new Exercicio();
        exercicio.setId(Integer.parseInt(value));
        return new ExercicioDAO().pegarPorId(exercicio);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((Exercicio)value).getId());
    }
    
}
