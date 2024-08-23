/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.Kurum;
import dao.KurumDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "kurumBean")
@ViewScoped
public class KurumBean implements Serializable {

    private Kurum entity;
    private KurumDAO dao;
    private List<Kurum> list;
    private List<SelectItem> kurumTipList;

    public void kurumEkle() {
        this.getDao().KurumEkle(getEntity());
        this.list = this.getDao().KurumListesi();
    }

    public void kurumSil(int kurumID) {
        this.getDao().KurumSil(kurumID);
        this.list = this.getDao().KurumListesi(); // Silme işleminden sonra listeyi güncelle
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

        dao.setIslemBasariliMesaj(null);
        return this.list;
    }

    public void setList(List<Kurum> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        getDao().setIslemBasariliMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

    public KurumBean() {

    }

    public List<SelectItem> getKurumTipList() {
        kurumTipList = getDao().KurumGetir();
        return kurumTipList;
    }

    public void setKurumTipList(List<SelectItem> kurumTipList) {
        this.kurumTipList = kurumTipList;
    }

}
