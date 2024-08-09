package Controller;

import Entity.Kisi;
import dao.KisiDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "kisiBean")
@SessionScoped
public class KisiBean implements Serializable {

    private Kisi entity;
    private KisiDAO dao;
    private List<Kisi> list;
    private List<SelectItem> mahalleList;
    private List<SelectItem> sokakList;
    private int selectedMahalleId;

    @PostConstruct
    public void init() {
        entity = new Kisi();
        mahalleList = mahallegetir();
        sokakList = new ArrayList<>();
    }

    public void ekle() {

        this.getDao().KisiEkle(getEntity());
    }

    public void KisiSil(int kisiID) {
        this.getDao().KisiSil(kisiID);
        this.list = this.getDao().KisiListesi(); // Silme işleminden sonra listeyi güncelle
    }

    //Muracaat Girişte dinamik mahalle ve sokak değişimi için
    public List<SelectItem> mahallegetir() {
        return this.getDao().MahalleGetir();
    }

    public List<SelectItem> sokakgetir() {
        return this.getDao().SokakGetir(selectedMahalleId);
    }

    public void sokakyukle(AjaxBehaviorEvent event) {
        sokakList = new ArrayList<>();
        if (selectedMahalleId != 0) {
            sokakList = this.getDao().SokakGetir(selectedMahalleId);;
        }
    }

    public void edit(Kisi kisi) {
        this.entity = kisi;
    }

    public Kisi getEntity() {
        if (this.entity == null) {
            this.entity = new Kisi();
        }
        entity.setKisi_id(selectedMahalleId);
        return this.entity;
    }

    public void setEntity(Kisi entity) {
        this.entity = entity;
    }

    public KisiDAO getDao() {
        if (this.dao == null) {
            this.dao = new KisiDAO();
        }
        return this.dao;
    }

    public void setDao(KisiDAO dao) {
        this.dao = dao;
    }

    public List<Kisi> getList() {
        if (this.list == null) {
            this.list = this.getDao().KisiListesi();
        }
        return this.list;
    }

    public void setList(List<Kisi> list) {
        this.list = list;
    }

    public List<SelectItem> getMahalleList() {
        return mahalleList;
    }

    public void setMahalleList(List<SelectItem> mahalleList) {
        this.mahalleList = mahalleList;
    }

    public List<SelectItem> getSokakList() {
        return sokakList;
    }

    public void setSokakList(List<SelectItem> sokakList) {
        this.sokakList = sokakList;
    }

    public int getSelectedMahalleId() {
        return selectedMahalleId;
    }

    public void setSelectedMahalleId(int selectedMahalleId) {
        this.selectedMahalleId = selectedMahalleId;
    }

}
