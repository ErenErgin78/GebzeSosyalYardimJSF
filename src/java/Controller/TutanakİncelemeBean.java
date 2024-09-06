/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import jakarta.inject.Named;
import Entity.Tutanakİnceleme;
import dao.TutanakİncelemeDAO;
import jakarta.faces.model.SelectItem;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author emirh
 */
@Named(value = "tutanakİncelemeBean")
@ViewScoped
public class TutanakİncelemeBean implements Serializable {

    private Tutanakİnceleme entity;
    private TutanakİncelemeDAO dao;
    private List<Tutanakİnceleme> list;
    private List<SelectItem> TutanakİncelemeList;
    

    public Tutanakİnceleme getEntity() {
         if(this.entity ==null){
           this.entity = new Tutanakİnceleme();
        }
        return entity;
    }

    public void setEntity(Tutanakİnceleme entity) {
        this.entity = entity;
    }

    public TutanakİncelemeDAO getDao() {
        if(this.dao == null){
           this.dao=new TutanakİncelemeDAO();
        }
        
        return dao;
    }

    public void setDao(TutanakİncelemeDAO dao) {
        this.dao = dao;
    }

    public List<Tutanakİnceleme> getList() {
        return list;
    }

    public void setList(List<Tutanakİnceleme> list) {
        this.list = list;
    }

    public List<SelectItem> getTutanakİncelemeList() {
        return TutanakİncelemeList;
    }

    public void setTutanakİncelemeList(List<SelectItem> TutanakİncelemeList) {
        this.TutanakİncelemeList = TutanakİncelemeList;
    }

    public TutanakİncelemeBean() {
    }
    
    

}
