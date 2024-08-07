package Controller;

import Entity.Kisi;
import Entity.KisiYakinlar;
import dao.KisiDAO;
import dao.KisiYakinlarDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "kisiYakinlarBean")
@ViewScoped
public class KisiYakinlarBean implements Serializable {

    private KisiYakinlar entity;
    private KisiYakinlarDAO dao;
    private List<KisiYakinlar> list;
    private int selectedKisiYakinlarId;
    private List<SelectItem> kisiyakinlarList;

    @PostConstruct
    public void init() {
        entity = new KisiYakinlar();
        kisiyakinlarList = new ArrayList<>();
        // You may want to load initial data here, if applicable.
        kisiyakinlarList = kisiYakinlarGetir(); 
    }

    public void create() {
        this.getDao().Create(getEntity());
    }

    public void delete(int kisiID) {
        this.getDao().DeleteKisi(kisiID);
        this.list = this.getDao().GetList(); // Silme işleminden sonra listeyi güncelle
    }

    public void sorgula() {
        Kisi kisi = new Kisi();
        kisi.setKimlik_no(this.entity.getKimlik_no());
        this.getDao().Sorgula(kisi);
        KisiYakinlar kisiyakinlar = null;
        this.entity = kisiyakinlar;
    }

    public List<SelectItem> kisiYakinlarGetir() {
        return this.getDao().KisiYakinlarGetir(selectedKisiYakinlarId);
    }

    public void kisiyakinlaryukle(AjaxBehaviorEvent event) {
        if (selectedKisiYakinlarId != 0) {
            kisiyakinlarList = this.getDao().KisiYakinlarGetir(selectedKisiYakinlarId);
        } else {
            kisiyakinlarList = new ArrayList<>();
        }
    }

    public void edit(KisiYakinlar kisiyakinlar) {
        this.entity = kisiyakinlar;
    }

    public KisiYakinlar getEntity() {
        if (this.entity == null) {
            this.entity = new KisiYakinlar();
        }
        return this.entity;
    }

    public void setEntity(KisiYakinlar entity) {
        this.entity = entity;
    }

    public KisiYakinlarDAO getDao() {
        if (this.dao == null) {
            this.dao = new KisiYakinlarDAO();
        }
        return this.dao;
    }

    public void setDao(KisiYakinlarDAO dao) {
        this.dao = dao;
    }

    public List<KisiYakinlar> getList() {
        if (this.list == null) {
            this.list = this.getDao().GetList();
        }
        return this.list;
    }

    public void setList(List<KisiYakinlar> list) {
        this.list = list;
    }

    public List<SelectItem> getKisiYakinlarList() {
        return kisiyakinlarList;
    }

    public void setKisiYakinlarList(List<SelectItem> kisiyakinlarList) {
        this.kisiyakinlarList = kisiyakinlarList;
    }

    public int getSelectedKisiYakinlarId() {
        return selectedKisiYakinlarId;
    }

    public void setSelectedKisiYakinlarId(int selectedKisiYakinlarId) {
        this.selectedKisiYakinlarId = selectedKisiYakinlarId;
    }
}




