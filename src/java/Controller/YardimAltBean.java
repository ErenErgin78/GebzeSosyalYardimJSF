package Controller;

import Entity.YardimAlt;
import dao.YardimAltDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
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
    private List<SelectItem> TipList;

    private String yardimAltTipiAdi;

    @PostConstruct
    public void init() {
        getDao().setIslemBasariliMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
        TipList = yardimTipGetir();
        entity = new YardimAlt();
    }

    public void yardimAltEkle() {
        this.getDao().YardimAltEkle(getEntity());
    }

    public void yardimAltSil(int yardimAltId) {
        this.getDao().YardimAltSil(yardimAltId);
    }

    public void yardimAltMesajTemizle() {
        this.getDao().YardimAltMesajTemizle();
    }

    public List<SelectItem> yardimTipGetir() {
        return this.getDao().YardimTipGetir();
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
        this.list = this.getDao().YardimAltListesi(this.yardimAltTipiAdi);
        return this.list;
    }

    public void listeyenile() {
        this.list = this.getDao().YardimAltListesi(this.yardimAltTipiAdi);
    }

    public void setList(List<YardimAlt> list) {
        this.list = list;
    }

    public List<SelectItem> getTipList() {
        TipList = yardimTipGetir();
        return TipList;
    }

    public void setTipList(List<SelectItem> TipList) {
        this.TipList = TipList;
    }

    public YardimAltBean() {
    }

    public String getYardimAltTipiAdi() {
        return yardimAltTipiAdi;
    }

    public void setYardimAltTipiAdi(String yardimAltTipiAdi) {
        this.yardimAltTipiAdi = yardimAltTipiAdi;
    }
}
