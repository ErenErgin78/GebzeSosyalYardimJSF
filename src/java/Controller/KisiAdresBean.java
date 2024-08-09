package Controller;

import Entity.Kisi;
import Entity.KisiAdres;
import dao.KisiAdresDAO;
import dao.KisiDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.event.AjaxBehaviorEvent;
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
    private List<SelectItem> mahalleList;
    private List<SelectItem> sokakList;
    private int selectedMahalleId;

    @PostConstruct
    public void init() {
        entity = new KisiAdres();
        sokakList = new ArrayList<>();
    }

    public void ekle() {

        this.getDao().KisiEkle(getEntity());
    }

    public void KisiAdresSil(int kisiID) {
        this.getDao().KisiAdresSil(kisiID);
        this.list = this.getDao().KisiAdresListesi(); // Silme işleminden sonra listeyi güncelle
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

    public void edit(KisiAdres kisiAdres) {
        this.entity = kisiAdres;
    }

    public KisiAdres getEntity() {
        return entity;
    }

    public void setEntity(KisiAdres entity) {
        this.entity = entity;
    }

    public KisiAdresDAO getDao() {
        return dao;
    }

    public void setDao(KisiAdresDAO dao) {
        this.dao = dao;
    }

    public List<KisiAdres> getList() {
        return list;
    }

    public void setList(List<KisiAdres> list) {
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

    public KisiAdresBean() {
    }

}
