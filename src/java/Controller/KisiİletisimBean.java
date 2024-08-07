package Controller;

import Entity.Kisi;
import Entity.KisiIletisim;
import dao.KisiIletisimDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "kisiIletisimBean")
@ViewScoped
public class KisiİletisimBean implements Serializable {

    private KisiIletisim entity;
    private KisiIletisimDAO dao;
    private List<KisiIletisim> list;
    private int selectedKisiİletisimId;
    private List<SelectItem> kisiiletisimList;

    @PostConstruct
    public void init() {
        entity = new KisiIletisim();
        kisiiletisimList = new ArrayList<>();
        // You may want to load initial data here, if applicable.

    }

    public void create() {
        this.getDao().addKisiIletisim(getEntity());
    }

    public void deleteKisiIletisim(int kisiID) {
        this.getDao().deleteKisiIletisim(kisiID);
        this.list = this.getDao().getKisiIletisimList(); // Silme işleminden sonra listeyi güncelle
    }

    public void edit(KisiIletisim kisiiletisim) {
        this.entity = kisiiletisim;
    }

    public KisiIletisim getEntity() {
        if (this.entity == null) {
            this.entity = new KisiIletisim();
        }
        return this.entity;
    }

    public void setEntity(KisiIletisim entity) {
        this.entity = entity;
    }

    public KisiIletisimDAO getDao() {
        if (this.dao == null) {
            this.dao = new KisiIletisimDAO();
        }
        return this.dao;
    }

    public void setDao(KisiIletisimDAO dao) {
        this.dao = dao;
    }

    public List<KisiIletisim> getList() {
        if (this.list == null) {
            this.list = this.getDao().getKisiIletisimList();
        }
        return this.list;
    }

    public void setList(List<KisiIletisim> list) {
        this.list = list;
    }

    public List<SelectItem> getKisiİletisimList() {
        return kisiiletisimList;
    }

    public void setKisiİletisimList(List<SelectItem> kisiiletisimList) {
        this.kisiiletisimList = kisiiletisimList;
    }

    public int getSelectedKisiİletisimId() {
        return selectedKisiİletisimId;
    }

    public void setSelectedKisiİletisimId(int selectedKisiİletisimId) {
        this.selectedKisiİletisimId = selectedKisiİletisimId;
    }

    public KisiİletisimBean() {
    }

}
