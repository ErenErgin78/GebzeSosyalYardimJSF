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
    private List<SelectItem> tipList;
    private int selectedKurumId;
    private String altKurumIsim;

    @PostConstruct
    public void init() {
        this.getDao().setIslemBasariliMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
        this.entity = new KurumAlt();
    }

    public void kurumAltEkle() {
        this.getDao().KurumAltEkle(getEntity());
        this.list = this.getDao().KurumAltListesi(); // Listeyi güncelle
    }

    public void kurumAltSil(int kurumAltId) {
        this.getDao().KurumAltSil(kurumAltId);
        this.list = this.getDao().KurumAltListesi(); // Listeyi güncelle
    }

    public List<SelectItem> kurumTipGetir() {
        return this.getDao().KurumAltGetir(selectedKurumId);
    }

    public void kurumyukle(AjaxBehaviorEvent event) {
        tipList = new ArrayList<>();
        if (selectedKurumId != 0) {
            tipList = this.getDao().KurumAltGetir(selectedKurumId);
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
            this.dao.setIslemBasariliMesaj(null);
        }
        return this.dao;
    }

    public void setDao(KurumAltDAO dao) {
        this.dao = dao;
    }

    public List<KurumAlt> getList() {
        if (this.list == null) {
            this.list = this.getDao().KurumAltListesi();
        }
        return this.list;
    }

    public void setList(List<KurumAlt> list) {
        this.list = list;
    }

    public List<SelectItem> getTipList() {
        if (tipList == null) {
            tipList = new ArrayList<>();
            if (selectedKurumId != 0) {
                tipList = this.getDao().KurumAltGetir(selectedKurumId);
            }
        }
        return tipList;
    }

    public void setTipList(List<SelectItem> tipList) {
        this.tipList = tipList;
    }

    public int getSelectedKurumId() {
        return selectedKurumId;
    }

    public void setSelectedKurumId(int selectedKurumId) {
        this.selectedKurumId = selectedKurumId;
    }

    public String getAltKurumIsim() {
        return altKurumIsim;
    }

    public void setAltKurumIsim(String altKurumIsim) {
        this.altKurumIsim = altKurumIsim;
    }
}
