/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.MuracaatDurum;
import dao.MuracaatDurumDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.faces.model.SelectItem;
import java.util.List;

/**
 *
 * @author emirh
 */
@Named(value = "muracaatDurumBean")
@Dependent
public class MuracaatDurumBean {

    private MuracaatDurum entity;
    private MuracaatDurumDAO dao;
    private List<MuracaatDurum> list;
    private List<SelectItem> MuracaatDurumList;
    
     public Integer ekle() {
        return this.getDao().MuracaatDurumEkle(getEntity());
    }
    public MuracaatDurum getEntity() {
        if (this.entity == null) {
            this.entity = new MuracaatDurum();
        }
        return this.entity;
    }

    public void setEntity(MuracaatDurum entity) {
        this.entity = entity;
    }

    public MuracaatDurumDAO getDao() {
        if (this.dao == null) {
            this.dao = new MuracaatDurumDAO();
        }
        return this.dao;
    }

    public void setDao(MuracaatDurumDAO dao) {
        this.dao = dao;
    }

    public List<MuracaatDurum> getList() {
        return list;
    }

    public void setList(List<MuracaatDurum> list) {
        this.list = list;
    }

    public List<SelectItem> getMuracaatDurumList() {
        MuracaatDurumList = getDao().MuracaatDurumGetir();
        return MuracaatDurumList;
    }

    public void setMuracaatDurumList(List<SelectItem> MuracaatDurumList) {
        this.MuracaatDurumList = MuracaatDurumList;
    }

    @PostConstruct
    public void init() {
    }

    public MuracaatDurumBean() {
    }
}