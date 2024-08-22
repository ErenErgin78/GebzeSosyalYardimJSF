/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.Cekmece;
import dao.CekmeceDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "cekmeceBean")
@ViewScoped
public class CekmeceBean implements Serializable {

    private Cekmece entity;
    private CekmeceDAO dao;
    private List<Cekmece> list;
    
    // Cekmece nesnesi ekler
    public void cekmeceEkle() {
        this.getDao().CekmeceEkle(getEntity());
    }
    
    // Cekmece nesnesi siler
    public void cekmeceSil(int cekmeceId) {
        this.getDao().CekmeceSil(cekmeceId);
        this.list = this.getDao().CekmeceListesi();
    }
    
    // Cekmece nesnesini döndürür
    public Cekmece getEntity() {
        if (this.entity == null) {
            this.entity = new Cekmece();
        }
        return this.entity;
    }
    
    // Cekmece nesnesini ayarlar
    public void setEntity(Cekmece entity) {
        this.entity = entity;
    }
    
    // CekmeceDAO nesnesini döndürür
    public CekmeceDAO getDao() {
        if (this.dao == null) {
            this.dao = new CekmeceDAO();
            this.dao.setMesaj(null);
        }
        return this.dao;
    }
    
    // CekmeceDAO nesnesini ayarlar
    public void setDao(CekmeceDAO dao) {
        this.dao = dao;
    }

    // Cekmece listesi döndürür
    public List<Cekmece> getList() {

        this.list = this.getDao().CekmeceListesi();
        return this.list;
    }

     // Cekmece listesini ayarlar
    public void setList(List<Cekmece> list) {
        this.list = list;
    }

    // Sayfa yüklendiğinde mesajı sıfırlar
    @PostConstruct
    public void init() {
        getDao().setMesaj(null);
    }

    public CekmeceBean() {
    }

}
