/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.Sokak;
import dao.SokakDAO;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Eren
 */
@Named(value = "sokakBean")
@SessionScoped
public class SokakBean implements Serializable {

    private Sokak entity;
    private SokakDAO dao;
    private List<Sokak> list;

    public void sokakekle() {
        this.getDao().SokakEkle(getEntity());
    }
    
    public void sokaksil(int SokakId) {
        this.getDao().SokakSil(SokakId);
         this.list = this.getDao().SokakListesi();
    }

    public Sokak getEntity() {
        if (this.entity == null) {
            this.entity = new Sokak();
        }
        return this.entity;
    }

    public void setEntity(Sokak entity) {
        this.entity = entity;
    }

    public SokakDAO getDao() {
        if (this.dao == null) {
            this.dao = new SokakDAO();
        }
        return this.dao;
    }

    public void setDao(SokakDAO dao) {
        this.dao = dao;
    }

    public List<Sokak> getList() {
        if (this.list == null) {
            this.list = this.getDao().SokakListesi();
        }
        return this.list;
    }

    public void setList(List<Sokak> list) {
        this.list = list;
    }

    public SokakBean() {
    }

}
