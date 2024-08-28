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

    // Sayfa yüklendiğinde mesajı sıfırlar ve yeni bir EngelAlt nesnesi oluşturur
    @PostConstruct
    public void init() {
        getDao().setIslemBasariliMesaj(null); // Sayfa yüklendiğinde mesajı sıfırlar
        tipList = engelTipGetir();
        entity = new EngelAlt(); // Yeni bir EngelAlt nesnesi oluşturur
    }

    // Yeni bir EngelAlt ekler ve listeyi günceller
    public void engelAltEkle() {
        this.getDao().EngelAltEkle(getEntity());
    }

    // Belirtilen EngelAlt'ı siler
    public void engelAltSil(int engelAltId) {
        this.getDao().EngelAltSil(engelAltId);
        this.list = this.getDao().EngelAltListesi();
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

    // DAO nesnesini döndürür, eğer null ise yeni bir EngelAltDAO oluşturur
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

    // Listeyi yeniden yükler
    public void listeyenile() {
        this.list = this.getDao().EngelAltListesi(this.engelAltTipiAdi);
    }

    public void setList(List<EngelAlt> list) {
        this.list = list;
    }

    // Tip listesini döndürür, eğer null ise engelTipGetir() ile listeyi doldurur
    public List<SelectItem> getTipList() {
            tipList = engelTipGetir();
        return tipList;
    }

    public void setTipList(List<SelectItem> tipList) {
        this.tipList = tipList;
    }
   

    }

    public String getEngelAltTipiAdi() {
        return engelAltTipiAdi;
    }

    public void setEngelAltTipiAdi(String engelAltTipiAdi) {
        this.engelAltTipiAdi = engelAltTipiAdi;
    }
     
}
     public EngelAltBean() {
