package Controller;

import Entity.Sokak;
import dao.SokakDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "sokakBean")
@ViewScoped
public class SokakBean implements Serializable {

    private Sokak entity;
    private SokakDAO dao;
    private List<Sokak> list;
    private List<SelectItem> sokakList;
    private int selectedMahalleId;

    public void sokakekle() {
        this.getDao().SokakEkle(getEntity());
    }
    

    public void sokaksil(int SokakId) {
        this.getDao().SokakSil(SokakId);
        this.list = this.getDao().SokakListesi();
    }

    public void sokakMesajTemizle() {
        this.getDao().SokakMesajTemizle();
    }

    public List<SelectItem> sokakgetir() {
        return this.getDao().SokakGetir(selectedMahalleId);
    }

    public void sokakyukle(AjaxBehaviorEvent event) {
        sokakList = new ArrayList<>();
        if (selectedMahalleId != 0) {
            sokakList = this.getDao().SokakGetir(selectedMahalleId);
        }
    }

    public Sokak getEntity() {
        if (this.entity == null) {
            this.entity = new Sokak();
        }
        return this.entity;
    }

    public void setEntity(Sokak entity) {
        this.entity = entity;
    }

    public SokakDAO getDao() {
        if (this.dao == null) {
            this.dao = new SokakDAO();
            this.dao.setIslemBasariliMesaj(null);
        }
        return this.dao;
    }

    public void setDao(SokakDAO dao) {
        this.dao = dao;
    }

    public List<Sokak> getList() {
        this.list = this.getDao().SokakListesi();
        return this.list;
    }

    public void setList(List<Sokak> list) {
        this.list = list;

    }

    public List<SelectItem> getSokakList() {
        sokakList = getDao().SokakGetir(selectedMahalleId);
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

    @PostConstruct
    public void init() {
        getDao().setIslemBasariliMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

    public SokakBean() {
    }

}
