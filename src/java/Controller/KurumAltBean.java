package Controller;

import Entity.KurumAlt;
import dao.KurumAltDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "kurumAltBean")
@ViewScoped
public class KurumAltBean implements Serializable {

    private KurumAlt entity;
    private KurumAltDAO dao;
    private List<KurumAlt> list;
    private List<SelectItem> TipList;
     private int selectedKurumId;

    @PostConstruct
    public void init() {
        getDao().setIslemBasariliMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
        TipList = kurumTipGetir();
        entity = new KurumAlt();
    }

    public void kurumAltEkle() {
        this.getDao().KurumAltEkle(getEntity());
    }

    public void kurumAltSil(int kurumAltId) {
        this.getDao().KurumAltSil(kurumAltId);
    }

    public List<SelectItem> kurumTipGetir() {
        return this.getDao().KurumAltGetir(selectedKurumId);
    }
     public void kurumyukle(AjaxBehaviorEvent event) {
        TipList = new ArrayList<>();
        if (selectedKurumId != 0) {
            TipList = this.getDao().KurumAltGetir(selectedKurumId);
        }
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
            dao.setIslemBasariliMesaj(null);
        }
        return this.dao;
    }

    public void setDao(KurumAltDAO dao) {
        this.dao = dao;
    }

    public List<KurumAlt> getList() {
        this.list = this.getDao().KurumAltListesi();
        return this.list;
    }

    public void listeyenile() {
        this.list = this.getDao().KurumAltListesi();
    }

    public void setList(List<KurumAlt> list) {
        this.list = list;
    }

    public List<SelectItem> getTipList() {
        TipList = getDao().KurumAltGetir(selectedKurumId);
        return TipList;
    }

    public void setTipList(List<SelectItem> TipList) {
        this.TipList = TipList;
    }

    public KurumAltBean() {
    }

    public int getSelectedKurumId() {
        return selectedKurumId;
    }

    public void setSelectedKurumId(int selectedKurumId) {
        this.selectedKurumId = selectedKurumId;
    }
    

}
