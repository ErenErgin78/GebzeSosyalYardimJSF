package Controller;

import Entity.TutanakSosyalGuvence;
import dao.TutanakSosyalGuvenceDAO;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.model.SelectItem;
import java.io.Serializable;
import java.util.List;

@Named(value = "tutanakSosyalGuvenceBean")
@SessionScoped
public class TutanakSosyalGuvenceBean implements Serializable {

    private TutanakSosyalGuvence entity;
    private TutanakSosyalGuvenceDAO dao;
    private List<TutanakSosyalGuvence> list;

    private List<SelectItem> guvenceList;
    private List<SelectItem> birimList;

    public List<SelectItem> getGuvenceList() {
        guvenceList = getDao().GuvenceGetir();
        return guvenceList;
    }

    public List<SelectItem> getBirimList() {
        birimList = getDao().BirimGetir();
        return birimList;
    }

    public void tutanakSosyalGuvenceEkle() {
        this.getDao().TutanakSosyalGuvenceEkle(getEntity());
    }

    public void tutanakSosyalGuvenceSil(int tutanakSosyalGuvenceId) {
        this.getDao().TutanakSosyalGuvenceSil(tutanakSosyalGuvenceId);
    }

    public void tutanakSosyalGuvenceMesajTemizle() {
        this.getDao().TutanakSosyalGuvenceMesajTemizle();
    }

    public List<TutanakSosyalGuvence> getList() {
        if (this.list == null) {
            this.list = this.getDao().TutanakSosyalGuvenceListesi();
        }
        return this.list;
    }

    public void listeYenile() {
        this.list = this.getDao().TutanakSosyalGuvenceListesi();
    }

    public TutanakSosyalGuvence getEntity() {
        if (this.entity == null) {
            this.entity = new TutanakSosyalGuvence();
        }
        return this.entity;
    }

    public void setEntity(TutanakSosyalGuvence entity) {
        this.entity = entity;
    }

    public TutanakSosyalGuvenceDAO getDao() {
        if (this.dao == null) {
            this.dao = new TutanakSosyalGuvenceDAO();
        }
        return this.dao;
    }

    public void setDao(TutanakSosyalGuvenceDAO dao) {
        this.dao = dao;
    }

    // Constructor
    public TutanakSosyalGuvenceBean() {
    }
}
