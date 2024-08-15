package Controller;

import Entity.YardimTalep;
import dao.YardimTalepDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "yardimTalepBean")
@ViewScoped
public class YardimTalepBean implements Serializable {

    private YardimTalep entity;
    private YardimTalepDAO dao;
    private List<YardimTalep> list;

    public void yardimTalepEkle() {
        this.getDao().YardimTalepEkle(getEntity());
    }

    public void yardimTalepSil(int yardimTalepId) {
        this.getDao().YardimTalepSil(yardimTalepId);
    }

    public YardimTalep getEntity() {
        if (this.entity == null) {
            this.entity = new YardimTalep();
        }
        return this.entity;
    }

    public void setEntity(YardimTalep entity) {
        this.entity = entity;
    }

    public YardimTalepDAO getDao() {
        if (this.dao == null) {
            this.dao = new YardimTalepDAO();
            dao.setMesaj(null);
        }
        return this.dao;
    }

    public void setDao(YardimTalepDAO dao) {
        this.dao = dao;
    }

    public List<YardimTalep> getList() {
        this.list = this.getDao().YardimTalepListesi();
        return this.list;
    }

    public void listeYenile() {
        this.list = this.getDao().YardimTalepListesi();
    }

    public void setList(List<YardimTalep> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // Sayfa yüklendiğinde mesajı sıfırlar
    }

    public YardimTalepBean() {
    }
}
