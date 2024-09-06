/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import jakarta.inject.Named;
import Entity.TutanakBasvuru;
import dao.TutanakBasvuruDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author emirh
 */
@Named(value = "tutanakBasvuruBean")
@ViewScoped
public class TutanakBasvuruBean implements Serializable {

    private TutanakBasvuru entity;
    private TutanakBasvuruDAO dao;
    private List<TutanakBasvuru> list;
    private List<SelectItem> tutanakBasvuruList;


    public void tutanakBasvuruEkle() {
        this.getDao().TutanakBasvuruEkle(getEntity());
    }

    public void tutanakBasvuruSil(int tutanakBasvuruId) {
        this.getDao().TutanakBasvuruSil(tutanakBasvuruId);
    }

    public void tutanakBasvuruMesajTemizle() {
        this.getDao().TutanakBasvuruMesajTemizle();
    }

    public TutanakBasvuru getEntity() {
        if (this.entity == null) {
            this.entity = new TutanakBasvuru();
        }
        return entity;
    }

    public void setEntity(TutanakBasvuru entity) {
        this.entity = entity;
    }

    public TutanakBasvuruDAO getDao() {
        if (this.dao == null) {
            this.dao = new TutanakBasvuruDAO();
            dao.setMesaj(null);
        }
        return this.dao;
    }

    public void setDao(TutanakBasvuruDAO dao) {
        this.dao = dao;
    }

    public List<TutanakBasvuru> getList() {
        this.list = this.getDao().TutanakListesi();
        return this.list;
    }

    public void listeYenile() {
        this.list = this.getDao().TutanakListesi();
    }

    public void setList(List<TutanakBasvuru> list) {
        this.list = list;
    }

    public List<SelectItem> getTutanakBasvuruList() {
        tutanakBasvuruList = getDao().TutanakBasvuruGetir();
        return tutanakBasvuruList;
    }

    public void setTutanakBasvuruList(List<SelectItem> tutanakBasvuruList) {
        this.tutanakBasvuruList = tutanakBasvuruList;
    }

    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // Sayfa yüklendiğinde mesajı sıfırlar
    }

    /**
     * Creates a new instance of TutanakBasvuruBean
     */
    public TutanakBasvuruBean() {
    }

}
