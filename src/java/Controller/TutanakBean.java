package Controller;

import Entity.Tutanak;
import dao.TutanakDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "tutanakBean")
@ViewScoped
public class TutanakBean implements Serializable {

    private Tutanak entity;
    private TutanakDAO dao;
    private List<Tutanak> list;

    public void tutanakEkle() {
        this.getDao().TutanakEkle(getEntity());
    }

    public void tutanakSil(int tutanakId) {
        this.getDao().TutanakSil(tutanakId);
    }

    public Tutanak getEntity() {
        if (this.entity == null) {
            this.entity = new Tutanak();
        }
        return this.entity;
    }

    public void setEntity(Tutanak entity) {
        this.entity = entity;
    }

    public TutanakDAO getDao() {
        if (this.dao == null) {
            this.dao = new TutanakDAO();
            dao.setMesaj(null);
        }
        return this.dao;
    }

    public void setDao(TutanakDAO dao) {
        this.dao = dao;
    }

    public List<Tutanak> getList() {
        this.list = this.getDao().TutanakListesi();
        return this.list;
    }

    public void listeYenile() {
        this.list = this.getDao().TutanakListesi();
    }

    public void setList(List<Tutanak> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

    public TutanakBean() {
    }
}
