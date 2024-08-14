package Controller;

import Entity.MedeniDurum;
import dao.MedeniDurumDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "medeniDurumBean")
@ViewScoped
public class MedeniDurumBean implements Serializable {

    private MedeniDurum entity;
    private MedeniDurumDAO dao;
    private List<MedeniDurum> list;
    private List<SelectItem> medenidurumlist;

    @PostConstruct
    public void init() {
        medenidurumlist = getDao().MedeniDurumGetir();
    }

    public MedeniDurumBean() {
    }

    public MedeniDurum getEntity() {
        return entity;
    }

    public void setEntity(MedeniDurum entity) {
        this.entity = entity;
    }

    public MedeniDurumDAO getDao() {
        return dao;
    }

    public void setDao(MedeniDurumDAO dao) {
        this.dao = dao;
    }

    public List<MedeniDurum> getList() {
        return list;
    }

    public void setList(List<MedeniDurum> list) {
        this.list = list;
    }

    public List<SelectItem> getMedenidurumlist() {
        return medenidurumlist;
    }

    public void setMedenidurumlist(List<SelectItem> medenidurumlist) {
        this.medenidurumlist = medenidurumlist;
    }

}
