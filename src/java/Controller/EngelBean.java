/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.Engel;
import dao.EngelDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "engelBean")
@ViewScoped
public class EngelBean implements Serializable {

    private Engel entity;
    private EngelDAO dao;
    private List<Engel> list;
    private List<SelectItem> engelTipList;

    public void engelEkle() {
        this.getDao().EngelEkle(getEntity());
        this.list = this.getDao().EngelListesi();
    }

    public void engelSil(int engelID) {
        this.getDao().EngelSil(engelID);
        this.list = this.getDao().EngelListesi(); // Silme işleminden sonra listeyi güncelle
    }

    public Engel getEntity() {
        if (this.entity == null) {
            this.entity = new Engel();
        }
        return this.entity;
    }

    public void setEntity(Engel entity) {
        this.entity = entity;
    }

    public EngelDAO getDao() {
        if (this.dao == null) {
            this.dao = new EngelDAO();
        }
        return this.dao;
    }

    public void setDao(EngelDAO dao) {
        this.dao = dao;
    }

    public List<Engel> getList() {
        this.list = this.getDao().EngelListesi();

        dao.setMesaj(null);
        return this.list;
    }

    public void setList(List<Engel> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

    public EngelBean() {

    }

    public List<SelectItem> getEngelTipList() {
        engelTipList = getDao().EngelGetir();
        return engelTipList;
    }

    public void setEngelTipList(List<SelectItem> engelTipList) {
        this.engelTipList = engelTipList;
    }

}
