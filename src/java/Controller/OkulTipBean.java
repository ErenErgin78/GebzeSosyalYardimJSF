/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.OkulTip;
import dao.OkulTipDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
@Named(value = "okulTipBean")
@ViewScoped
public class OkulTipBean implements Serializable {

    private OkulTip entity;
    private OkulTipDAO dao;
    private List<OkulTip> list;
    private List<SelectItem> okultipList;
    
    
    public OkulTip getEntity(){
        if(this.entity ==null){
           this.entity = new OkulTip();
        }
        return this.entity;
    }
    
    public void setEntity(OkulTip entity) {
           this.entity=entity;
    }
    
    public OkulTipDAO getDao(){
        if(this.dao == null){
           this.dao=new OkulTipDAO();
        }
        return this.dao;
    }
    
    public void setDao(OkulTipDAO dao){
         this.dao=dao;
    }
    
    public List<OkulTip> getList(){
        return list;     
    }
    
    
    public void setList(List<OkulTip> list){
        this.list=list;
    }
    
    public List<SelectItem> getOkulTipList(){
        okultipList=getDao().OkulTipGetir();
        return okultipList;
    }
    
    public void setOkulTipList(List <SelectItem> okultipList){
        this.okultipList=okultipList;
    }
    
    @PostConstruct
    public void init(){
    }
    
    public OkulTipBean(){
    }
    
}
