package br.com.control;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {

    private String email;
    private String nome;
    private String titulo;
    private String mensagem;

    public void enviarEmail() throws EmailException {
        SimpleEmail seEmail = new SimpleEmail();
        seEmail.setHostName("smtp.gmail.com");
        seEmail.addTo("projgymanagement@gmail.com",getNome());
        seEmail.setFrom("projgymanagement@gmail.com","Nome: "+getNome()+" Email: "+getEmail());
        seEmail.setSubject("Contato- GyManagement | "+getTitulo());
        seEmail.setCharset("ISO-8859-1");
        seEmail.setMsg(getMensagem());
        seEmail.setAuthentication("projgymanagement@gmail.com", "12345gym");
        seEmail.setSmtpPort(465);
        seEmail.setSSL(true);
        seEmail.setTLS(true);
        seEmail.send();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
