/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backingBean;

import br.com.control.Email;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author aluno
 */
@ManagedBean
@RequestScoped
public class EmailBean {

    private Email email;
    private GrowlMensagem growlMensagem;

    public EmailBean() {
        setGrowlMensagem(new GrowlMensagem());
        setEmail(new Email());
    }

    public void enviarEmail() {
        try {
            email.enviarEmail();
            getGrowlMensagem().setTitulo("A mensagem enviada!");
            getGrowlMensagem().setMessage("Mensagem enviado com sucesso!");
            getGrowlMensagem().saveMessage();
            setEmail(new Email());
        } catch (EmailException e) {
            getGrowlMensagem().setTitulo("Ocorreu um erro!");
            getGrowlMensagem().setMessage("Ocorreu uma falha ao enviar a mensagem!");
            getGrowlMensagem().saveMessage();
        }
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public GrowlMensagem getGrowlMensagem() {
        return growlMensagem;
    }

    public void setGrowlMensagem(GrowlMensagem growlMensagem) {
        this.growlMensagem = growlMensagem;
    }
}
