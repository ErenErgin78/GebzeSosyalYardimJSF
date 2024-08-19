package Controller;

import Entity.TutanakDurum;
import dao.TutanakDurumDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "tutanakBean")
@ViewScoped
public class TutanakDurumBean implements Serializable {

    private TutanakDurum entity;
    private TutanakDurumDAO dao;
    private List<TutanakDurum> list;

    public void tutanakEkle() {
        this.getDao().TutanakEkle(getEntity());
    }

    public void tutanakSil(int tutanakId) {
        this.getDao().TutanakSil(tutanakId);
    }

    public void tutanakDurumMesajTemizle() {
        this.getDao().TutanakDurumMesajTemizle();
    }

    public TutanakDurum getEntity() {
        if (this.entity == null) {
            this.entity = new TutanakDurum();
        }
        return this.entity;
    }

    public void setEntity(TutanakDurum entity) {
        this.entity = entity;
    }

    public TutanakDurumDAO getDao() {
        if (this.dao == null) {
            this.dao = new TutanakDurumDAO();
            dao.setMesaj(null);
        }
        return this.dao;
    }

    public void setDao(TutanakDurumDAO dao) {
        this.dao = dao;
    }

    public List<TutanakDurum> getList() {
        this.list = this.getDao().TutanakListesi();
        return this.list;
    }

    public void listeYenile() {
        this.list = this.getDao().TutanakListesi();
    }

    public void setList(List<TutanakDurum> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

    public TutanakDurumBean() {
    }
}
