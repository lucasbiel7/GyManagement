/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.control;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author aluno
 */
public class Validar implements Validator{
    
        public static boolean validaCPF(String cpf)throws NumberFormatException, ParseException{ 
            String novoCPF="";
            int soma=0,dig10,dig11;
            int peso=10;
            for(int a=0;a<cpf.length();a++){
                if(!(a==3 ||a==7||a==11)){
                    novoCPF+=cpf.charAt(a);
                }
           }
            for (int i = 0; i < 9; i++){
                soma+=Integer.parseInt(String.valueOf(novoCPF.charAt(i)))*peso--;
            } 
            if(soma % 11<2){
               dig10=0;
            }else{
                dig10=11-(soma % 11);
            }
            soma=0;
            peso=11;
             for (int i = 0; i < 10; i++){
                soma+=Integer.parseInt(String.valueOf(novoCPF.charAt(i)))*peso--;
            } 
             if(soma % 11<2){
               dig11=0;
            }else{
                dig11=11-(soma % 11);
            }
             if(novoCPF.equals("11111111111")||novoCPF.equals("22222222222")||novoCPF.equals("33333333333")||novoCPF.equals("44444444444")||novoCPF.equals("55555555555")||novoCPF.equals("66666666666")||novoCPF.equals("77777777777")||novoCPF.equals("88888888888")||novoCPF.equals("99999999999")){
                 return false;
             }
             else if(dig10==Integer.parseInt(String.valueOf(novoCPF.charAt(9))) && dig11==Integer.parseInt(String.valueOf(novoCPF.charAt(10))))
                return true;
             else
                 return false;
        } 

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       String cpf=String.valueOf(value);
            try {
                if(!Validar.validaCPF(cpf)){
                    FacesMessage message = new FacesMessage("CPF Inválido!");
                    throw new ValidatorException(message);
                }    
            } catch (NumberFormatException | ParseException ex) {
                Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
     
}
