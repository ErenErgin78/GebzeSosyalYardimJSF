package Controller;

import Entity.TutanakEvEsyalari;
import dao.TutanakEvEsyalariDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "tutanakEvEsyalariBean")
@ViewScoped
public class TutanakEvEsyalariBean implements Serializable {

    private TutanakEvEsyalari entity;
    private TutanakEvEsyalariDAO dao;
    private List<TutanakEvEsyalari> list;
    private List<SelectItem> tutanakevesyalarilist;

    @PostConstruct
    public void init() {
    }

    public TutanakEvEsyalariBean() {
    }

    public TutanakEvEsyalari getEntity() {
        return entity;
    }

    public void setEntity(TutanakEvEsyalari entity) {
        this.entity = entity;
    }

    public TutanakEvEsyalariDAO getDao() {
        return dao;
    }

    public void setDao(TutanakEvEsyalariDAO dao) {
        this.dao = dao;
    }

    public List<TutanakEvEsyalari> getList() {
        return list;
    }

    public void setList(List<TutanakEvEsyalari> list) {
        this.list = list;
    }

    public List<SelectItem> getTutanakevesyalarilist() {
        return tutanakevesyalarilist;
    }

    public void setTutanakevesyalarilist(List<SelectItem> tutanakevesyalarilist) {
        this.tutanakevesyalarilist = tutanakevesyalarilist;
    }

}
