/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.Muracaat;
import dao.MuracaatDAO;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import java.util.List;

/**
 *
 * @author Eren
 */
@Named(value = "muracaatBean")
@Dependent
public class MuracaatBean {

    private Muracaat entity;
    private MuracaatDAO dao;
    private List<Muracaat> list;

    public void create() {
        this.getDao().Create(entity);
        this.entity = new Muracaat();
    }

    public void delete(int MuracaatID) {
        this.getDao().Delete(MuracaatID);
        this.list = this.getDao().GetList(); //listeyi yenile
    }

    public void edit(Muracaat muracaat) {
        this.entity = muracaat;
    }

    public Muracaat getEntity() {
        if (this.entity == null) {
            this.entity = new Muracaat();
        }
        return entity;
    }

    public void setEntity(Muracaat entity) {
        this.entity = entity;
    }

    public MuracaatDAO getDao() {
        if (this.dao == null) {
            this.dao = new MuracaatDAO();
        }
        return dao;
    }

    public void setDao(MuracaatDAO dao) {
        this.dao = dao;
    }

    public List<Muracaat> getList() {
        this.list = this.getDao().GetList();
        return list;
    }

    public void setList(List<Muracaat> list) {
        this.list = list;
    }

}
