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
    private List<SelectItem> TipList;

    @PostConstruct
    public void init() {
        getDao().setIslemBasariliMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
        TipList = engelliTipGetir();
        entity = new EngelAlt();
    }

    public void engelAltEkle() {
        this.getDao().EngelAltEkle(getEntity());
    }

    public void engelAltSil(int engelAltId) {
        this.getDao().EngelAltSil(engelAltId);
    }

    public List<SelectItem> engelliTipGetir() {
        return this.getDao().EngelliTipGetir();
    }

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
        this.list = this.getDao().EngelAltListesi();
        return this.list;
    }

    public void listeyenile() {
        this.list = this.getDao().EngelAltListesi();
    }

    public void setList(List<EngelAlt> list) {
        this.list = list;
    }

    public List<SelectItem> getTipList() {
        TipList = engelliTipGetir();
        return TipList;
    }

    public void setTipList(List<SelectItem> TipList) {
        this.TipList = TipList;
    }

    public EngelAltBean() {
    }
}
