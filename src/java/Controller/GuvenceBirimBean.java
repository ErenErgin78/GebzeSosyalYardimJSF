package Controller;

import Entity.GuvenceBirim;
import dao.GuvenceBirimDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "guvenceBirimBean")
@ViewScoped
public class GuvenceBirimBean implements Serializable {

    private GuvenceBirim entity;
    private GuvenceBirimDAO dao;
    private List<GuvenceBirim> list;
    private List<SelectItem> guvenceBirimlist;

    @PostConstruct
    public void init() {
    }

    public GuvenceBirimBean() {
    }

    public GuvenceBirim getEntity() {
        if (this.entity == null) {
            this.entity = new GuvenceBirim();
        }
        return this.entity;
    }

    public void setEntity(GuvenceBirim entity) {
        this.entity = entity;
    }

    public GuvenceBirimDAO getDao() {
        if(this.dao == null ){
        dao = new GuvenceBirimDAO();
        }
        return dao;
    }

    public void setDao(GuvenceBirimDAO dao) {
        this.dao = dao;
    }

    public List<GuvenceBirim> getList() {
        return list;
    }

    public void setList(List<GuvenceBirim> list) {
        this.list = list;
    }

    public List<SelectItem> getGuvenceBirimlist() {
        guvenceBirimlist = getDao().GuvenceBirimGetir();
        return guvenceBirimlist;
    }

    public void setGuvenceBirimlist(List<SelectItem> guvenceBirimlist) {
        this.guvenceBirimlist = guvenceBirimlist;
    }

}
