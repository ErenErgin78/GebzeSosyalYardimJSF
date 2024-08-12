package Controller;

import Entity.TutanakSosyalGuvence;
import dao.TutanakSosyalGuvenceDAO;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "tutanakSosyalGuvenceBean")
@SessionScoped
public class TutanakSosyalGuvenceBean implements Serializable {

    private TutanakSosyalGuvence entity;
    private TutanakSosyalGuvenceDAO dao;
    private List<TutanakSosyalGuvence> list;

    // Yeni bir TutanakSosyalGuvence ekleme metodu
    public void tutanakSosyalGuvenceEkle() {
        this.getDao().TutanakSosyalGuvenceEkle(getEntity());
    }

    // Belirli bir TutanakSosyalGuvence'i silme metodu
    public void tutanakSosyalGuvenceSil(int tutanakSosyalGuvenceId) {
        this.getDao().TutanakSosyalGuvenceSil(tutanakSosyalGuvenceId);
    }

    // TutanakSosyalGuvence verilerini listeleme metodu
    public List<TutanakSosyalGuvence> getList() {
        if (this.list == null) {
            this.list = this.getDao().TutanakSosyalGuvenceListesi();
        }
        return this.list;
    }

    // Listeyi yenileme metodu
    public void listeYenile() {
        this.list = this.getDao().TutanakSosyalGuvenceListesi();
    }

    // Entity getter ve setter
    public TutanakSosyalGuvence getEntity() {
        if (this.entity == null) {
            this.entity = new TutanakSosyalGuvence();
        }
        return this.entity;
    }

    public void setEntity(TutanakSosyalGuvence entity) {
        this.entity = entity;
    }

    // DAO getter ve setter
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
