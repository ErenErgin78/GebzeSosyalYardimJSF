/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.Okul;
import dao.OkulDAO;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Eren
 */
@Named(value = "okulBean")
@SessionScoped
public class OkulBean implements Serializable {

    private Okul entity;
    private OkulDAO dao;
    private List<Okul> list;

    public void create() {
        this.getDao().Create(getEntity());
    }
    
    public void okulsil(int okulid){
        this.getDao().OkulSil(okulid);
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
        return this.dao;
    }

    public void setDao(OkulDAO dao) {
        this.dao = dao;
    }

    public List<Okul> getList() {

        this.list = this.getDao().OkulListesi();
        return this.list;
    }

    public void setList(List<Okul> list) {
        this.list = list;
    }

    public OkulBean() {
    }

}
