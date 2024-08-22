package Controller;

import Entity.TutanakBorc;
import dao.TutanakBorcDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "tutanakBorcBean")
@ViewScoped
public class TutanakBorcBean implements Serializable {

    private TutanakBorc entity;
    private TutanakBorcDAO dao;
    private List<TutanakBorc> list;

    public void tutanakEkle() {
        this.getDao().TutanakEkle(getEntity());
    }

    public void tutanakSil(int tutanakId) {
        this.getDao().TutanakSil(tutanakId);
    }

    public void tutanakBorcMesajTemizle() {
        this.getDao().TutanakBorcMesajTemizle();
    }

    public TutanakBorcBean() {
    }

    public TutanakBorc getEntity() {
        if (this.entity == null) {
            this.entity = new TutanakBorc();
        }
        return this.entity;
    }

    public void setEntity(TutanakBorc entity) {
        this.entity = entity;
    }

    public TutanakBorcDAO getDao() {
        if (this.dao == null) {
            this.dao = new TutanakBorcDAO();
            dao.setMesaj(null);
        }
        return this.dao;
    }

    public void setDao(TutanakBorcDAO dao) {
        this.dao = dao;
    }

    public List<TutanakBorc> getList() {
        this.list = this.getDao().TutanakListesi();
        return this.list;
    }

    public void listeYenile() {
        this.list = this.getDao().TutanakListesi();
    }

    public void setList(List<TutanakBorc> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

}
