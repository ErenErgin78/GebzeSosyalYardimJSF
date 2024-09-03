/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.model.SelectItem;
import Entity.Hastalik;
import dao.HastalikDAO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hamza
 */
@Named(value = "hastalikBean")
@ViewScoped
public class HastalikBean implements Serializable {

    private Hastalik entity;
    private HastalikDAO dao;
    private List<Hastalik> list;
    private List<SelectItem> hastalikList;

    public Hastalik getEntity() {
        if (this.entity == null) {
            this.entity = new Hastalik();
        }
        return this.entity;
    }

    public void setEntity(Hastalik entity) {
        this.entity = entity;
    }

    public HastalikDAO getDao() {
        if (this.dao == null) {
            this.dao = new HastalikDAO();
        }
        return dao;
    }

    public void setDao(HastalikDAO dao) {
        this.dao = dao;
    }

    public List<Hastalik> getList() {
        return list;
    }

    public void setList(List<Hastalik> list) {
        this.list = list;
    }

    public List<SelectItem> getHastalikList() {
        hastalikList = getDao().HastalikGetir();
        return hastalikList;
    }

    public void setHastalikList(List<SelectItem> hastalikList) {
        this.hastalikList = hastalikList;
    }

    /**
     * Creates a new instance of HastalikBean
     */
    public HastalikBean() {
    }

}
