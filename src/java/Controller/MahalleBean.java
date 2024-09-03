/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.Mahalle;
import dao.MahalleDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Eren
 */
@Named(value = "mahalleBean")
@ViewScoped
public class MahalleBean implements Serializable {

    private Mahalle entity;
    private MahalleDAO dao;
    private List<Mahalle> list;
    private List<SelectItem> mahalleList;

    public void mahallekle() {
        this.getDao().MahalleEkle(getEntity());
    }

    public void mahallesil(int MahalleID) {
        this.getDao().MahalleSil(MahalleID);
        this.list = this.getDao().MahalleListesi();
    }

    public List<SelectItem> mahallegetir() {
        return this.getDao().MahalleGetir();
    }

    public Mahalle getEntity() {
        if (this.entity == null) {
            this.entity = new Mahalle();
        }
        return this.entity;
    }

    public void setEntity(Mahalle entity) {
        this.entity = entity;
    }

    public MahalleDAO getDao() {
        if (this.dao == null) {
            this.dao = new MahalleDAO();
            this.dao.setIslemBasariliMesaj(null);
        }
        return this.dao;
    }

    public void setDao(MahalleDAO dao) {
        this.dao = dao;
    }

    public List<Mahalle> getList() {

        this.list = this.getDao().MahalleListesi();
        return this.list;
    }

    public void setList(List<Mahalle> list) {
        this.list = list;
    }

    public List<SelectItem> getMahalleList() {
        mahalleList = mahallegetir();
        return mahalleList;
    }

    public void setMahalleList(List<SelectItem> mahalleList) {
        this.mahalleList = mahalleList;
    }

    @PostConstruct
    public void init() {
        getDao().setIslemBasariliMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

    public MahalleBean() {

    }

}