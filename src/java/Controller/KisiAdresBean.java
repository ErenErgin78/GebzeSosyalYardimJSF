package Controller;

import Entity.KisiAdres;
import Entity.KisiIletisim;
import dao.KisiAdresDAO;
import dao.KisiIletisimDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "kisiAdresBean")
@ViewScoped
public class KisiAdresBean implements Serializable {

    private KisiAdres entity;
    private KisiAdresDAO dao;
    private List<KisiAdres> list;
    private int selectedKisiAdresId;
    private List<SelectItem> kisiadresList;

    @PostConstruct
    public void init() {
        entity = new KisiAdres();
        kisiadresList = new ArrayList<>();
        // You may want to load initial data here, if applicable.
        kisiadresList = getKisiAdresList();
    }

    public void create() {
        this.getDao().addKisiAdres(getEntity());
    }

    public void deleteKisiAdres(int kisiID) {
        this.getDao().deleteKisiAdres(kisiID);
        this.list = this.getDao().getKisiAdresList(); // Silme işleminden sonra listeyi güncelle
    }

    public void edit(KisiAdres kisiadres) {
        this.entity = kisiadres;
    }

    public KisiAdres getEntity() {
        if (this.entity == null) {
            this.entity = new KisiAdres();
        }
        return this.entity;
    }

    public void setEntity(KisiAdres entity) {
        this.entity = entity;
    }

    public KisiAdresDAO getDao() {
        if (this.dao == null) {
            this.dao = new KisiAdresDAO();
        }
        return this.dao;
    }

    public void setDao(KisiAdresDAO dao) {
        this.dao = dao;
    }

    public List<KisiAdres> getList() {
        if (this.list == null) {
            this.list = this.getDao().getKisiAdresList();
        }
        return this.list;
    }

    public void setList(List<KisiAdres> list) {
        this.list = list;
    }

    public List<SelectItem> getKisiAdresList() {
        return kisiadresList;
    }

    public void setKisiAdresList(List<SelectItem> kisiadresList) {
        this.kisiadresList = kisiadresList;
    }

    public int getSelectedKisiAdresId() {
        return selectedKisiAdresId;
    }

    public void setSelectedKisiAdresId(int selectedKisiAdresId) {
        this.selectedKisiAdresId = selectedKisiAdresId;
    }

    public KisiAdresBean() {
    }

}
