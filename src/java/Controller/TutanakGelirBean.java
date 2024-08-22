package Controller;

import Entity.TutanakGelir;
import dao.TutanakDurumDAO;
import dao.TutanakGelirDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "tutanakGelirBean")
@ViewScoped
public class TutanakGelirBean implements Serializable {

    private TutanakGelir entity;
    private TutanakGelirDAO dao;
    private List<TutanakGelir> list;

    public void tutanakEkle() {
        this.getDao().TutanakEkle(getEntity());
    }

    public void tutanakSil(int tutanakId) {
        this.getDao().TutanakSil(tutanakId);
    }

    public void tutanakGelirMesajTemizle() {
        this.getDao().TutanakGelırMesajTemizle();
    }

    public TutanakGelirBean() {
    }

    public TutanakGelir getEntity() {
        if (this.entity == null) {
            this.entity = new TutanakGelir();
        }
        return this.entity;
    }

    public void setEntity(TutanakGelir entity) {
        this.entity = entity;
    }

    public TutanakGelirDAO getDao() {
        if (this.dao == null) {
            this.dao = new TutanakGelirDAO();
            dao.setMesaj(null);
        }
        return this.dao;
    }

    public void setDao(TutanakGelirDAO dao) {
        this.dao = dao;
    }

    public List<TutanakGelir> getList() {
        this.list = this.getDao().TutanakListesi();
        return this.list;
    }

    public void listeYenile() {
        this.list = this.getDao().TutanakListesi();
    }

    public void setList(List<TutanakGelir> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

}
