/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.Yardim;
import dao.YardimDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Eren
 */
@Named(value = "yardimBean")
@ViewScoped
public class YardimBean implements Serializable {

    private Yardim entity;
    private YardimDAO dao;
    private List<Yardim> list;
    private List <SelectItem> yardimList;

    public void yardimEkle() {
        this.getDao().YardimEkle(getEntity());
    }

    public void yardimSil(int yardimID) {
        this.getDao().YardimSil(yardimID);
        this.list = this.getDao().YardimListesi(); // Silme işleminden sonra listeyi güncelle
    }

    public void yardimMesajTemizle() {
        this.getDao().YardimMesajTemizle();
    }

    public Yardim getEntity() {
        if (this.entity == null) {
            this.entity = new Yardim();
        }
        return this.entity;
    }

    public void setEntity(Yardim entity) {
        this.entity = entity;
    }

    public YardimDAO getDao() {
        if (this.dao == null) {
            this.dao = new YardimDAO();
        }
        return this.dao;
    }

    public void setDao(YardimDAO dao) {
        this.dao = dao;
    }

    public List<Yardim> getList() {
        if (this.list == null) {
            this.list = this.getDao().YardimListesi();
        }
        dao.setMesaj(null);
        return this.list;
    }

    public void setList(List<Yardim> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

    public YardimBean() {

    }

}