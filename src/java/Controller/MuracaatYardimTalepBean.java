/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.MuracaatYardimTalep;
import dao.MuracaatYardimTalepDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "muracaatYardimTalepBean")
@ViewScoped
public class MuracaatYardimTalepBean implements Serializable {

    private MuracaatYardimTalep entity;
    private MuracaatYardimTalepDAO dao;
    private List<MuracaatYardimTalep> list;
    private List<SelectItem> muracaatYardimTalepList;
    
    public MuracaatYardimTalep getEntity() {
        if (this.entity == null) {
            this.entity = new MuracaatYardimTalep();
        }
        return this.entity;
    }
    
   
    
    public void setEntity(MuracaatYardimTalep entity) {
        this.entity = entity;
    }
    
    public MuracaatYardimTalepDAO getDao() {
        if (this.dao == null) {
            this.dao = new MuracaatYardimTalepDAO();
        }
        return this.dao;
    }
    
    public void setDao(MuracaatYardimTalepDAO dao) {
        this.dao = dao;
    }
    
    public List<MuracaatYardimTalep> getList() {
        return list;
    }
    
    public void setList(List<MuracaatYardimTalep> list) {
        this.list = list;
    }
    
    public List<SelectItem> getMuracaatYardimTalepList() {
        muracaatYardimTalepList = getDao().MuracaatYardimTalepGetir();
        return muracaatYardimTalepList;
    }
    
    public void setMuracaatYardimTalepList(List<SelectItem> muracaatYardimTalepList) {
        this.muracaatYardimTalepList = muracaatYardimTalepList;
    }
    
    @PostConstruct
    public void init() {
        // Başlangıçta yapılması gereken işlemler buraya eklenebilir.
    }
    
    public MuracaatYardimTalepBean() {      
    }
}
