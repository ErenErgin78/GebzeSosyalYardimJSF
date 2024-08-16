/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.Kisi;
import Entity.KisiAdres;
import Entity.KisiIletisim;
import Entity.KisiYakinlar;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

/**
 *
 * @author Eren
 */
@Named(value = "muracaatSecimBean")
@SessionScoped
public class MuracaatSecimBean implements Serializable {

    @Inject
    private Kisi kisi;
    
    @Inject
    private KisiAdres kisiAdres;
    
    @Inject
     private KisiYakinlar kisiYakinlar;
    
    public MuracaatSecimBean() {
    }
    
}
