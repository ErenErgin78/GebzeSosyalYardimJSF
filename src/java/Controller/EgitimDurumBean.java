/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.EgitimDurum;
import dao.EgitimDurumDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.model.SelectItem;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Eren
 */
@Named(value = "egitimDurumBean")
@SessionScoped
public class EgitimDurumBean implements Serializable {

    private EgitimDurum entity;
    private EgitimDurumDAO dao;
    private List<EgitimDurum> list;
    private List<SelectItem> egitimlist;
    
    // Bean başlatıldığında eğitim durumu listesini getirir
    @PostConstruct
    public void init() {
        egitimlist = egitimDurumGetir();
    }

    // Constructor
    public EgitimDurumBean() {
    }

    // Eğitim durumu listesini SelectItem olarak getirir
    public List<SelectItem> egitimDurumGetir() {
        return this.getDao().EgitimDurumGetir();
    }

    // EgitimDurum nesnesini döndürür
    public EgitimDurum getEntity() {
        if(entity == null){
        entity = new EgitimDurum();
        }
        return entity;
    }

    // EgitimDurum nesnesini ayarlar
    public void setEntity(EgitimDurum entity) {
        this.entity = entity;
    }
    
    // EgitimDurumDAO nesnesini döndürür
    public EgitimDurumDAO getDao() {
        if(dao == null){
        dao = new EgitimDurumDAO();
        }
        return dao;
    }

    // EgitimDurumDAO nesnesini ayarlar
    public void setDao(EgitimDurumDAO dao) {
        this.dao = dao;
    }

    // EgitimDurum listesini döndürür
    public List<EgitimDurum> getList() {
        return list;
    }

    // EgitimDurum listesini ayarlar
    public void setList(List<EgitimDurum> list) {
        this.list = list;
    }
    
    // Eğitim durumu listesini döndürür
    public List<SelectItem> getEgitimlist() {
        egitimlist = egitimDurumGetir();
        return egitimlist;
    }

    // Eğitim durumu listesini ayarlar
    public void setEgitimlist(List<SelectItem> egitimlist) {
        this.egitimlist = egitimlist;
    }

}
