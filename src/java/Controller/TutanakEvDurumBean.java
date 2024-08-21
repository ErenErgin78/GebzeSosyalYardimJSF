package Controller;

import Entity.TutanakEvDurum;
import dao.TutanakEvDurumDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "tutanakEvDurumBean")
@ViewScoped
public class TutanakEvDurumBean implements Serializable {
 private TutanakEvDurum entity;
    private TutanakEvDurumDAO dao;
    private List<TutanakEvDurum> list;
    private List<SelectItem> tutanakevdurumlist;

    @PostConstruct
    public void init() {
        tutanakevdurumlist = getDao().TutanakEvDurumGetir();
    }
    public TutanakEvDurumBean() {
    }

   public TutanakEvDurum getEntity() {
        if (this.entity == null) {
            this.entity = new TutanakEvDurum();
        }
        return this.entity;
    }

    public void setEntity(TutanakEvDurum entity) {
        this.entity = entity;
    }

    public TutanakEvDurumDAO getDao() {
        if (this.dao == null) {
            this.dao = new TutanakEvDurumDAO();
        }
        return this.dao;
    }

    public void setDao(TutanakEvDurumDAO dao) {
        this.dao = dao;
    }

    public List<TutanakEvDurum> getList() {
        return list;
    }

    public void setList(List<TutanakEvDurum> list) {
        this.list = list;
    }

    public List<SelectItem> getTutanakevdurumlist() {
        return tutanakevdurumlist;
    }

    public void setTutanakevdurumlist(List<SelectItem> tutanakevdurumlist) {
        this.tutanakevdurumlist = tutanakevdurumlist;
    }

}
