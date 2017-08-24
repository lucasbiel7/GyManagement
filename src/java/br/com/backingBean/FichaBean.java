/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backingBean;

import br.com.dao.FichaDAO;
import br.com.entity.Exercicio;
import br.com.entity.Ficha;
import br.com.entity.Funcionario;
import br.com.entity.ItemFicha;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aluno
 */
@ManagedBean
@ViewScoped
public class FichaBean {
    private Ficha ficha;
    private FichaDAO fichaDAO;
    private GrowlMensagem growlMensagem;
    private ItemFicha itemFicha;

    public FichaBean() {
        setFicha(new Ficha());
        setFichaDAO(new FichaDAO());
        setGrowlMensagem(new GrowlMensagem());
        setItemFicha(new ItemFicha());
        getItemFicha().setExercicio(new Exercicio());
    }
//DO FELIPE
    public String cadastrar(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance( ).getExternalContext( ).getSession(true);
        getFicha().setFuncionario(((LoginBean)session.getAttribute("loginBean")).getFuncionario());
        if(getFichaDAO().salvar(getFicha())){
            getGrowlMensagem().setTitulo("Cadastrado com sucesso!");
            getGrowlMensagem().setMessage("A ficha foi realizada com sucesso!");
        }else{
            getGrowlMensagem().setTitulo("Falha ao cadastrar!");
            getGrowlMensagem().setMessage("Ocorreu um erro!");
        }
        getGrowlMensagem().saveMessage();
        return "index";
    }
    
    public void addItemFicha(){
        getFicha().getItemFichas().add(itemFicha);
        getGrowlMensagem().setTitulo("Exercício Adicionado");
        getGrowlMensagem().setMessage("O item do exercicio "+itemFicha.getExercicio().getNome()+" foi adicionado");
        setItemFicha(new ItemFicha());
        getGrowlMensagem().saveMessage();
    }
        public void deletarItemFicha(ItemFicha itemFicha){
            getFicha().getItemFichas().remove(itemFicha);
            getGrowlMensagem().setTitulo("Exercício deletado");
            getGrowlMensagem().setMessage("O item do exercicio "+itemFicha.getExercicio().getNome()+" foi excluido");
            getGrowlMensagem().saveMessage();
    }
        public void excluir(Ficha ficha) {
        setFicha(ficha);
        if (getFichaDAO().deletar(getFicha())) {
            getGrowlMensagem().setTitulo("Deletado com sucesso!");
            getGrowlMensagem().setMessage("A ficha foi deletada com sucesso!");
        } else {
            getGrowlMensagem().setTitulo("Falha ao deletar!");
            getGrowlMensagem().setMessage("Ocorreu um erro!");
        }
        getGrowlMensagem().saveMessage();
    }
            

        
    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha Ficha) {
        this.ficha = Ficha;
    }

    public FichaDAO getFichaDAO() {
        return fichaDAO;
    }

    public void setFichaDAO(FichaDAO fichaDAO) {
        this.fichaDAO = fichaDAO;
    }

    public ItemFicha getItemFicha() {
        return itemFicha;
    }

    public void setItemFicha(ItemFicha itemFicha) {
        this.itemFicha = itemFicha;
    }
    
    public GrowlMensagem getGrowlMensagem() {
        return growlMensagem;
    }

    public void setGrowlMensagem(GrowlMensagem growlMensagem) {
        this.growlMensagem = growlMensagem;
    }

   
}
