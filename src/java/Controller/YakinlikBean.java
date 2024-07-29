package Controller;

import Entity.Yakinlik;
import dao.YakinlikDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "yakinlikBean")
@ViewScoped
public class YakinlikBean implements Serializable {

    private Yakinlik entity;
    private YakinlikDAO dao;
    private List<Yakinlik> list;

    public void yakinlikEkle() {
        this.getDao().YakinlikEkle(getEntity());
    }

    public void yakinlikSil(int yakinlikId) {
        this.getDao().YakinlikSil(yakinlikId);
    }

    public Yakinlik getEntity() {
        if (this.entity == null) {
            this.entity = new Yakinlik();
        }
        return this.entity;
    }

    public void setEntity(Yakinlik entity) {
        this.entity = entity;
    }

    public YakinlikDAO getDao() {
        if (this.dao == null) {
            this.dao = new YakinlikDAO();
            dao.setMesaj(null);
        }
        return this.dao;
    }

    public void setDao(YakinlikDAO dao) {
        this.dao = dao;
    }

    public List<Yakinlik> getList() {
        this.list = this.getDao().YakinlikListesi();
        return this.list;
    }

    public void listeYenile() {
        this.list = this.getDao().YakinlikListesi();
    }

    public void setList(List<Yakinlik> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // Sayfa yüklendiğinde mesajı sıfırlar
    }

    public YakinlikBean() {
    }
}