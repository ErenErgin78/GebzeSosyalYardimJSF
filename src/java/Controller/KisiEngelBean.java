/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entity.KisiEngel;
import dao.KisiEngelDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "kisiEngelBean")
@SessionScoped
public class KisiEngelBean implements Serializable {

    private KisiEngel entity;
    private KisiEngelDAO dao;
    private List<KisiEngel> list;

    public void ekle() {
        this.getDao().KisiEngelEkle(getEntity());
    }

    public void delete(int kisiEngelID) {
        this.getDao().KisiEngelSil(kisiEngelID);
        this.list = this.getDao().GetList();
    }

    public void edit(KisiEngel engel) {
        this.entity = engel;
    }

    public KisiEngel getEntity() {
        if (this.entity == null) {
            this.entity = new KisiEngel();
        }
        return this.entity;
    }

    public void setEntity(KisiEngel entity) {
        this.entity = entity;
    }

    public KisiEngelDAO getDao() {
        if (this.dao == null) {
            this.dao = new KisiEngelDAO();
        }
        return this.dao;
    }

    public void setDao(KisiEngelDAO dao) {
        this.dao = dao;
    }

    public List<KisiEngel> getList() {
        if (this.list == null) {
            this.list = this.getDao().GetList();
        }
        return this.list;
    }

    public void setList(List<KisiEngel> list) {
        this.list = list;
    }
    // Sayfa yüklendiğinde yapılacak işlemler
    
    public KisiEngelBean() {
    }
}
