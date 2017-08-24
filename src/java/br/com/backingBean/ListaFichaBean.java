package br.com.backingBean;

import br.com.dao.ItemFichaDAO;
import br.com.entity.Ficha;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ListaFichaBean {

    private Ficha ficha;

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public String selectFicha(Ficha ficha) {
        setFicha(ficha);
        getFicha().setItemFichas(new ItemFichaDAO().pegarPorFicha(getFicha()));
        return "verFicha";
    }
}
