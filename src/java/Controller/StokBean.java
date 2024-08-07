package Controller;

import Entity.Stok;
import dao.StokDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "stokBean")
@ViewScoped
public class StokBean implements Serializable {

    private Stok entity;
    private StokDAO dao;
    private List<Stok> list;

    public void stokekle() {
        this.getDao().StokEkle(getEntity());
    }

    public void stoksil(int stokId) {
        this.getDao().StokSil(stokId);
    }

    public Stok getEntity() {
        if (this.entity == null) {
            this.entity = new Stok();
        }
        return this.entity;
    }

    public void setEntity(Stok entity) {
        this.entity = entity;
    }

    public StokDAO getDao() {
        if (this.dao == null) {
            this.dao = new StokDAO();
            dao.setMesaj(null);
        }
        return this.dao;
    }

    public void setDao(StokDAO dao) {
        this.dao = dao;
    }

    public List<Stok> getList() {
        this.list = this.getDao().StokListesi();
        return this.list;
    }

    public void listeyenile() {
        this.list = this.getDao().StokListesi();
    }

    public void setList(List<Stok> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

    public StokBean() {
    }

}
