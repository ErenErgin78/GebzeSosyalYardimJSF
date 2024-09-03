/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entity.KisiAskerlik;
import dao.KisiAskerlikDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "kisiAskerlikBean")
@SessionScoped
public class KisiAskerlikBean implements Serializable {

    private KisiAskerlik entity;
    private KisiAskerlikDAO dao;
    private List<KisiAskerlik> list;

    public void create() {
        this.getDao().AskerlikEkle(getEntity());
    }

    public void delete(int askerlikID) {
        this.getDao().AskerlikSil(askerlikID);
        this.list = this.getDao().KisiAskerlikListesi(); // Silme işleminden sonra listeyi yeniler
    }

    public void edit(KisiAskerlik askerlik) {
        this.entity = askerlik;
    }

    public KisiAskerlik getEntity() {
        if (this.entity == null) {
            this.entity = new KisiAskerlik();
        }
        return this.entity;
    }

    public void setEntity(KisiAskerlik entity) {
        this.entity = entity;
    }

    public KisiAskerlikDAO getDao() {
        if (this.dao == null) {
            this.dao = new KisiAskerlikDAO();
        }
        return this.dao;
    }

    public void setDao(KisiAskerlikDAO dao) {
        this.dao = dao;
    }

    public List<KisiAskerlik> getList() {
        if (this.list == null) {
            this.list = this.getDao().KisiAskerlikListesi();
        }
        return this.list;
    }

    public void setList(List<KisiAskerlik> list) {
        this.list = list;
    }
    
}
