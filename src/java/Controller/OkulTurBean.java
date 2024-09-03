/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.OkulTur;
import dao.OkulTurDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
@Named(value = "okulTurBean")
@ViewScoped
public class OkulTurBean implements Serializable {

    private OkulTur entity;
    private OkulTurDAO dao;
    private List<OkulTur> list;
    private List<SelectItem> okulturList;
    
    
    public OkulTur getEntity(){
        if(this.entity ==null){
           this.entity = new OkulTur();
        }
        return this.entity;
    }
    
    public void setEntity(OkulTur entity) {
           this.entity=entity;
    }
    
    public OkulTurDAO getDao(){
        if(this.dao == null){
           this.dao=new OkulTurDAO();
        }
        return this.dao;
    }
    
    public void setDao(OkulTurDAO dao){
         this.dao=dao;
    }
    
    public List<OkulTur> getList(){
        return list;     
    }
    
    
    public void setList(List<OkulTur> list){
        this.list=list;
    }
    
    public List<SelectItem> getOkulTurList(){
        okulturList=getDao().OkulTurGetir();
        return okulturList;
    }
    
    public void setOkulTipList(List <SelectItem> okultipList){
        this.okulturList=okultipList;
    }
    
    @PostConstruct
    public void init(){
    }
    
    public OkulTurBean(){
    }
    
}
