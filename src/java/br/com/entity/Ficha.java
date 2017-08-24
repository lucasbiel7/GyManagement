/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


@Entity
public class Ficha implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Funcionario funcionario;
    @OneToMany(mappedBy ="ficha", cascade= CascadeType.REMOVE)
    private List<ItemFicha> itemFichas=new ArrayList<ItemFicha>();
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<ItemFicha> getItemFichas() {
        return itemFichas;
    }

    public void setItemFichas(List<ItemFicha> itemFichas) {
        this.itemFichas = itemFichas;
    }
    
    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    
    
}
