/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.Okul;
import dao.OkulDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Eren
 */
@Named(value = "okulBean")
@ViewScoped
public class OkulBean implements Serializable {

    private Okul entity;
    private OkulDAO dao;
    private List<Okul> list;

    public void okulekle() {
        this.getDao().OkulEkle(getEntity());
    }

    public void okulsil(int okulid) {
        this.getDao().OkulSil(okulid);
    }

    public void okulMesajTemizle() {
        this.getDao().OkulMesajTemizle();
    }

    public void temizle() {
        entity = new Okul();
    }

    public Okul getEntity() {
        if (this.entity == null) {
            this.entity = new Okul();
        }
        return this.entity;
    }

    public void setEntity(Okul entity) {
        this.entity = entity;
    }

    public OkulDAO getDao() {
        if (this.dao == null) {
            this.dao = new OkulDAO();
        }
        dao.setMesaj(null);
        return this.dao;
    }

    public void setDao(OkulDAO dao) {
        this.dao = dao;
    }

    public List<Okul> getList() {

        this.list = this.getDao().OkulListesi();
        return this.list;
    }

    public void listeyenile() {
        this.list = this.getDao().OkulListesi();
    }

    public void setList(List<Okul> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        getDao().setIslemBasariliMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

    public OkulBean() {
    }

}
