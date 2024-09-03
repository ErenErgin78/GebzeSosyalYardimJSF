/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entity.TutanakBorc;
import dao.TutanakBorcDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "tutanakBorcBean")
@SessionScoped
public class TutanakBorcBean implements Serializable {

    private TutanakBorc entity;
    private TutanakBorcDAO dao;
    private List<TutanakBorc> list;

    public void create() {
        this.getDao().TutanakBorcEkle(getEntity());
    }

    public void delete(int borcID) {
        this.getDao().TutanakBorcSil(borcID);
        this.list = this.getDao().GetList(); // Silme işleminden sonra listeyi yeniler
    }

    public void tutanakBorcMesajTemizle() {
        this.getDao().TutanakBorcMesajTemizle();
    }

    public void edit(TutanakBorc borc) {
        this.entity = borc;
    }

    public TutanakBorc getEntity() {
        if (this.entity == null) {
            this.entity = new TutanakBorc();
        }
        return this.entity;
    }

    public void setEntity(TutanakBorc entity) {
        this.entity = entity;
    }

    public TutanakBorcDAO getDao() {
        if (this.dao == null) {
            this.dao = new TutanakBorcDAO();
        }
        return this.dao;
    }

    public void setDao(TutanakBorcDAO dao) {
        this.dao = dao;
    }

    public List<TutanakBorc> getList() {
        if (this.list == null) {
            this.list = this.getDao().GetList();
        }
        return this.list;
    }

    public void setList(List<TutanakBorc> list) {
        this.list = list;
    }
}