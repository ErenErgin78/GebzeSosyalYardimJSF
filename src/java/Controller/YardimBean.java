package Controller;

import Entity.Yardim;
import dao.YardimDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "yardimBean")
@ViewScoped
public class YardimBean implements Serializable {

    private Yardim entity;
    private YardimDAO dao;
    private List<Yardim> list;
    private List<SelectItem> yardimTurList;

    @PostConstruct
    public void init() {
        getDao().setIslemBasariliMesaj(null); // Sayfa yüklendiğinde mesajı sıfırlar
        yardimTurList = yardimTurGetir();
        entity = new Yardim();
    }

    public void yardimEkle() {
        this.getDao().YardimEkle(getEntity());
    }

    public void yardimSil(int yardimTipId) {
        this.getDao().YardimSil(yardimTipId);
    }

    public void yardimMesajTemizle() {
        this.getDao().YardimMesajTemizle();
    }

    public List<SelectItem> yardimTurGetir() {
        return this.getDao().YardimTurGetir();
    }

    public Yardim getEntity() {
        if (this.entity == null) {
            this.entity = new Yardim();
        }
        return this.entity;
    }

    public void setEntity(Yardim entity) {
        this.entity = entity;
    }

    public YardimDAO getDao() {
        if (this.dao == null) {
            this.dao = new YardimDAO();
            dao.setIslemBasariliMesaj(null);
        }
        return this.dao;
    }

    public void setDao(YardimDAO dao) {
        this.dao = dao;
    }

    public List<Yardim> getList() {
        this.list = this.getDao().YardimListesi();
        return this.list;
    }

    public void listeyenile() {
        this.list = this.getDao().YardimListesi();
    }

    public void setList(List<Yardim> list) {
        this.list = list;
    }

    public List<SelectItem> getYardimTurList() {
        yardimTurList = yardimTurGetir();
        return yardimTurList;
    }

    public void setYardimTurList(List<SelectItem> yardimTurList) {
        this.yardimTurList = yardimTurList;
    }

    public YardimBean() {
    }
}
