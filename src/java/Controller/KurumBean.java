/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.Kurum;
import dao.KurumDAO;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author korog
 */
@Named(value = "kurumBean")
@ViewScoped
public class KurumBean implements Serializable {

    private Kurum entity;
    private KurumDAO dao;
    private List<Kurum> list;
    private List<SelectItem> kurumList;

    public void kurumekle() {
        this.getDao().KurumEkle(getEntity());
        this.list = this.getDao().KurumListesi();
    }

    public void kurumsil(int kurumID) {
        this.getDao().KurumSil(kurumID);
        this.list = this.getDao().KurumListesi(); // Silme işleminden sonra listeyi güncelle
    }

    /**
     * Creates a new instance of KurumBean
     */
    public KurumBean() {
    }

    public Kurum getEntity() {
        if (this.entity == null) {
            this.entity = new Kurum();
        }
        return this.entity;
    }

    public void setEntity(Kurum entity) {
        this.entity = entity;
    }

    public KurumDAO getDao() {
        if (this.dao == null) {
            this.dao = new KurumDAO();
        }
        return this.dao;
    }

    public void setDao(KurumDAO dao) {
        this.dao = dao;
    }

    public List<Kurum> getList() {
        this.list = this.getDao().KurumListesi();
        return this.list;
    }

    public void setList(List<Kurum> list) {
        this.list = list;
    }

    public List<SelectItem> getKurumList() {
        kurumList = getDao().KurumGetir();
        return kurumList;
    }

    public void setKurumList(List<SelectItem> kurumList) {
        this.kurumList = kurumList;
    }
    
}
