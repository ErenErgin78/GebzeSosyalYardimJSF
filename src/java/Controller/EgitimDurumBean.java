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

    @PostConstruct
    public void init() {
        egitimlist = egitimDurumGetir();
    }

    public EgitimDurumBean() {
    }

    public List<SelectItem> egitimDurumGetir() {
        return this.getDao().EgitimDurumGetir();
    }

    public EgitimDurum getEntity() {
        return entity;
    }

    public void setEntity(EgitimDurum entity) {
        this.entity = entity;
    }

    public EgitimDurumDAO getDao() {
        return dao;
    }

    public void setDao(EgitimDurumDAO dao) {
        this.dao = dao;
    }

    public List<EgitimDurum> getList() {
        return list;
    }

    public void setList(List<EgitimDurum> list) {
        this.list = list;
    }

    public List<SelectItem> getEgitimlist() {
        return egitimlist;
    }

    public void setEgitimlist(List<SelectItem> egitimlist) {
        this.egitimlist = egitimlist;
    }

}
