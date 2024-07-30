package Controller;

import Entity.YardimAlt;
import dao.YardimAltDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "yardimAltBean")
@ViewScoped
public class YardimAltBean implements Serializable {

    private YardimAlt entity;
    private YardimAltDAO dao;
    private List<YardimAlt> list;

    public void yardimAltEkle() {
        this.getDao().YardimAltEkle(getEntity());
    }

    public void yardimAltSil(int yardimAltId) {
        this.getDao().YardimAltSil(yardimAltId);
    }

    public YardimAlt getEntity() {
        if (this.entity == null) {
            this.entity = new YardimAlt();
        }
        return this.entity;
    }

    public void setEntity(YardimAlt entity) {
        this.entity = entity;
    }

    public YardimAltDAO getDao() {
        if (this.dao == null) {
            this.dao = new YardimAltDAO();
            dao.setIslemBasariliMesaj(null);
        }
        return this.dao;
    }

    public void setDao(YardimAltDAO dao) {
        this.dao = dao;
    }

    public List<YardimAlt> getList() {
        this.list = this.getDao().YardimAltListesi();
        return this.list;
    }

    public void listeyenile() {
        this.list = this.getDao().YardimAltListesi();
    }

    public void setList(List<YardimAlt> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        getDao().setIslemBasariliMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

    public YardimAltBean() {
    }
}
