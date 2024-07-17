/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.Kisi;
import dao.KisiDAO;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Eren
 */
@Named(value = "kisiBean")
@Dependent
public class KisiBean {

    private Kisi entity;
    private KisiDAO dao;
    private List<Kisi> list;

    public void create() {
        this.getDao().Create(entity);
        this.entity = new Kisi();
    }

    public void delete(int KisiID) {
        this.getDao().Delete(KisiID);
        this.list = this.getDao().GetList(); //listeyi yenile
    }

    public void edit(Kisi kisi) {
        this.entity = kisi;
    }

    public Kisi getEntity() {
        if (this.entity == null) {
            this.entity = new Kisi();
        }
        return entity;
    }

    public void setEntity(Kisi entity) {
        this.entity = entity;
    }

    public KisiDAO getDao() {
        if (this.dao == null) {
            this.dao = new KisiDAO();
        }
        return dao;
    }

    public void setDao(KisiDAO dao) {
        this.dao = dao;
    }

    public List<Kisi> getList() {
        this.list = this.getDao().GetList();
        return list;
    }

    public void setList(List<Kisi> list) {
        this.list = list;
    }
    public KisiBean() {
    }
    
}
