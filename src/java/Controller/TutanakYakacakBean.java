package Controller;

import Entity.TutanakYakacak;
import dao.TutanakYakacakDAO;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "tutanakYakacakBean")
@ViewScoped
public class TutanakYakacakBean implements Serializable {

    private TutanakYakacak entity;
    private TutanakYakacakDAO dao;
    private List<TutanakYakacak> list;
    private List<SelectItem> tutanakyakacaklist;

   
    public TutanakYakacakBean() {
    }

    public TutanakYakacak getEntity() {
        if (this.entity == null) {
            this.entity = new TutanakYakacak();
        }
        return this.entity;
    }

    public void setEntity(TutanakYakacak entity) {
        this.entity = entity;
    }

    public TutanakYakacakDAO getDao() {
        if (dao == null) {
            dao = new TutanakYakacakDAO();
        }
        return dao;
    }

    public void setDao(TutanakYakacakDAO dao) {
        this.dao = dao;
    }

    public List<TutanakYakacak> getList() {
        return list;
    }

    public void setList(List<TutanakYakacak> list) {
        this.list = list;
    }

    public List<SelectItem> getTutanakyakacaklist() {
        tutanakyakacaklist = getDao().TutanakYakacakGetir();
        return tutanakyakacaklist;
    }

    public void setTutanakyakacaklist(List<SelectItem> tutanakyakacaklist) {
        this.tutanakyakacaklist = tutanakyakacaklist;
    }

}
