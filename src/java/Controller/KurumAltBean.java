package Controller;

import Entity.KurumAlt;
import dao.KurumAltDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "kurumAltBean")
@ViewScoped
public class KurumAltBean implements Serializable {

    private KurumAlt entity;
    private KurumAltDAO dao;
    private List<KurumAlt> list;
    private List<SelectItem> tipList;

    private String kurumAltTipiAdi;

    @PostConstruct
    public void init() {
        getDao().setIslemBasariliMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
        tipList = kurumTipGetir();
        entity = new KurumAlt();
    }

    public void kurumAltEkle() {
        this.getDao().KurumAltEkle(getEntity());
    }

    public void kurumAltSil(int kurumAltId) {
        this.getDao().KurumAltSil(kurumAltId);
    }

    public void kurumAltMesajTemizle() {
        this.getDao().KurumAltMesajTemizle();
    }

    public List<SelectItem> kurumTipGetir() {
        return this.getDao().KurumTipGetir();
    }

    public KurumAlt getEntity() {
        if (this.entity == null) {
            this.entity = new KurumAlt();
        }
        return this.entity;
    }

    public void setEntity(KurumAlt entity) {
        this.entity = entity;
    }

    public KurumAltDAO getDao() {
        if (this.dao == null) {
            this.dao = new KurumAltDAO();
            this.dao.setIslemBasariliMesaj(null);
        }
        return this.dao;
    }

    public void setDao(KurumAltDAO dao) {
        this.dao = dao;
    }

    public List<KurumAlt> getList() {
        this.list = this.getDao().KurumAltListesi(this.kurumAltTipiAdi);
        return this.list;
    }

    public void listeyenile() {
        this.list = this.getDao().KurumAltListesi(this.kurumAltTipiAdi);
    }

    public void setList(List<KurumAlt> list) {
        this.list = list;
    }

    public List<SelectItem> getTipList() {
        tipList = kurumTipGetir();
        return tipList;
    }

    public void setTipList(List<SelectItem> tipList) {
        this.tipList = tipList;
    }

    public void KurumAltBean() {
    }

    public String getKurumAltTipiAdi() {
        return kurumAltTipiAdi;
    }

    public void setKurumAltTipiAdi(String kurumAltTipiAdi) {
        this.kurumAltTipiAdi = kurumAltTipiAdi;
    }

}