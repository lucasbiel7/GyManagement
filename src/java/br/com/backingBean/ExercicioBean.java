/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backingBean;

import br.com.dao.ExercicioDAO;
import br.com.entity.Exercicio;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author aluno
 */
@ManagedBean
@RequestScoped
public class ExercicioBean {
    private Exercicio exercicio;
    private ExercicioDAO exercicioDAO;
    private GrowlMensagem growlMensagem;
    private List<Exercicio> exercicios;
    public ExercicioBean() {
        setExercicio(new Exercicio());
        setExercicioDAO(new ExercicioDAO());
        setGrowlMensagem(new GrowlMensagem());
    }    
    public void salvar(){
        if(getExercicioDAO().salvar(exercicio)){
            getGrowlMensagem().setTitulo("Cadastrado com sucesso!");
            getGrowlMensagem().setMessage("O exercício foi cadastrado com sucesso!");
            setExercicio(new Exercicio());
        }else{
            getGrowlMensagem().setTitulo("Falha ao cadastrar!");
            getGrowlMensagem().setMessage("Ocorreu uma falha ao cadastrar o exercício!");
        }
        getGrowlMensagem().saveMessage();
    }

    public List<Exercicio> getExercicios() {
        setExercicios(getExercicioDAO().pegarTudo());
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }
    
    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public ExercicioDAO getExercicioDAO() {
        return exercicioDAO;
    }

    public void setExercicioDAO(ExercicioDAO exercicioDAO) {
        this.exercicioDAO = exercicioDAO;
    }

    public GrowlMensagem getGrowlMensagem() {
        return growlMensagem;
    }

    public void setGrowlMensagem(GrowlMensagem growlMensagem) {
        this.growlMensagem = growlMensagem;
    }
    
}
