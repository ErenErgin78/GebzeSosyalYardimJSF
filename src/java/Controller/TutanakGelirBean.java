package Controller;

import Entity.TutanakGelir;
import dao.TutanakGelirDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "tutanakGelirBean")
@SessionScoped
public class TutanakGelirBean implements Serializable {

    private TutanakGelir entity;
    private TutanakGelirDAO dao;
    private List<TutanakGelir> list;

    // TutanakGelir ekleme metodu
    public void tutanakGelirEkle() {
        this.getDao().TutanakGelirEkle(getEntity());
    }

    // TutanakGelir silme metodu
    public void tutanakGelirSil(int tutanakGelirId) {
        this.getDao().TutanakGelirSil(tutanakGelirId);
    }

    public void tutanakGelirMesajTemizle() {
        this.getDao().TutanakGelirMesajTemizle();
    }

    // TutanakGelir entity getter ve setter
    public TutanakGelir getEntity() {
        if (this.entity == null) {
            this.entity = new TutanakGelir();
        }
        return this.entity;
    }

    public void setEntity(TutanakGelir entity) {
        this.entity = entity;
    }

    // TutanakGelirDAO getter ve setter
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

    // TutanakGelir listeleme metodu
    public List<TutanakGelir> getList() {
        this.list = this.getDao().TutanakGelirListesi();
        return this.list;
    }

    // Listeyi yenileme metodu
    public void listeYenile() {
        this.list = this.getDao().TutanakGelirListesi();
    }

    public void setList(List<TutanakGelir> list) {
        this.list = list;
    }

    // Sayfa yüklendiğinde yapılacak işlemler
    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

    // Constructor
    public TutanakGelirBean() {
    }
}