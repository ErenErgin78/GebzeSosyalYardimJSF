package Controller;

import Entity.TutanakEvTip;
import dao.TutanakEvTipDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "tutanakEvTipBean")
@ViewScoped
public class TutanakEvTipBean implements Serializable {

    private TutanakEvTip entity;
    private TutanakEvTipDAO dao;
    private List<TutanakEvTip> list;
    private List<SelectItem> tutanakEvTipList;

    @PostConstruct
    public void init() {
        tutanakEvTipList = tutanakEvTipGetir();
    }

    public TutanakEvTipBean() {
    }

    public List<SelectItem> tutanakEvTipGetir() {
        return this.getDao().TutanakEvTipGetir();
    }

   public TutanakEvTip getEntity() {
        if (this.entity == null) {
            this.entity = new TutanakEvTip();
        }
        return this.entity;
    }

    public void setEntity(TutanakEvTip entity) {
        this.entity = entity;
    }

    public TutanakEvTipDAO getDao() {
        if (this.dao == null) {
            this.dao = new TutanakEvTipDAO();
        }
        return this.dao;
    }

    public void setDao(TutanakEvTipDAO dao) {
        this.dao = dao;
    }

    public List<TutanakEvTip> getList() {
        return list;
    }

    public void setList(List<TutanakEvTip> list) {
        this.list = list;
    }

    public List<SelectItem> getTutanakEvTipList() {
        return tutanakEvTipList;
    }

    public void setTutanakEvTipList(List<SelectItem> tutanakEvTipList) {
        this.tutanakEvTipList = tutanakEvTipList;
    }

}
