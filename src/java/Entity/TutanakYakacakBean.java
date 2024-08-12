package Entity;

import dao.EgitimDurumDAO;
import dao.TutanakYakacakDAO;
import jakarta.annotation.PostConstruct;
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

    @PostConstruct
    public void init() {
    }

    public TutanakYakacakBean() {
    }

    public List<SelectItem> tutanakYakacakGetir() {
        return this.getDao().TutanakYakacakGetir();
    }

    public TutanakYakacak getEntity() {
        return entity;
    }

    public void setEntity(TutanakYakacak entity) {
        this.entity = entity;
    }

    public TutanakYakacakDAO getDao() {
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
        return tutanakyakacaklist;
    }

    public void setTutanakyakacaklist(List<SelectItem> tutanakyakacaklist) {
        this.tutanakyakacaklist = tutanakyakacaklist;
    }

}
