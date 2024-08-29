package Controller;

import Entity.EngelAlt;
import dao.EngelAltDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "engelAltBean")
@ViewScoped
public class EngelAltBean implements Serializable {

    private EngelAlt entity;
    private EngelAltDAO dao;
    private List<EngelAlt> list;
    private List<SelectItem> tipList;

    private String engelAltTipiAdi;

    @PostConstruct
    public void init() {
        getDao().setIslemBasariliMesaj(null); // Sayfa yüklendiğinde mesajı sıfırlar
        tipList = engelTipGetir();
        entity = new EngelAlt(); // Yeni bir EngelAlt nesnesi oluşturur
    }

    public void engelAltEkle() {
        this.getDao().EngelAltEkle(getEntity());
    }

    public void engelAltSil(int engelAltId) {
        this.getDao().EngelAltSil(engelAltId);
    }

    public void engelAltMesajTemizle() {
        this.getDao().EngelAltMesajTemizle();
    }

    public List<SelectItem> engelTipGetir() {
        return this.getDao().EngelliTipGetir();
    }

    // EngelAlt entity'sini döndürür, eğer null ise yeni bir EngelAlt oluşturur
    public EngelAlt getEntity() {
        if (this.entity == null) {
            this.entity = new EngelAlt();
        }
        return this.entity;
    }

    public void setEntity(EngelAlt entity) {
        this.entity = entity;
    }

    public EngelAltDAO getDao() {
        if (this.dao == null) {
            this.dao = new EngelAltDAO();
            dao.setIslemBasariliMesaj(null);
        }
        return this.dao;
    }

    public void setDao(EngelAltDAO dao) {
        this.dao = dao;
    }

   

    public List<EngelAlt> getList() {
        this.list = this.getDao().EngelAltListesi(this.engelAltTipiAdi);        
        return this.list;
    }

    public void listeyenile() {
        this.list = this.getDao().EngelAltListesi(this.engelAltTipiAdi);
    }

    public void setList(List<EngelAlt> list) {
        this.list = list;
    }

    public List<SelectItem> getTipList() {
            tipList = engelTipGetir();
        return tipList;
    }

    public void setTipList(List<SelectItem> tipList) {
        this.tipList = tipList;
    }
     public EngelAltBean() {
    }

    public String getEngelAltTipiAdi() {
        return engelAltTipiAdi;
    }

    public void setEngelAltTipiAdi(String engelAltTipiAdi) {
        this.engelAltTipiAdi = engelAltTipiAdi;
    }
     
}
