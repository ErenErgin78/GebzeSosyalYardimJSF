/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

/**
 *
 * @author Eren
 */
@Named(value = "kisimuracaatBean")
@RequestScoped
public class KisiMuracaatMethod {

    @Inject
    private KisiBean kisiBean = new KisiBean();

    @Inject
    private MuracaatBean muracaatBean = new MuracaatBean();

    public void setKisiBean(KisiBean kisiBean) {
        this.kisiBean = kisiBean;
    }

    public void setMuracaatBean(MuracaatBean muracaatBean) {
        this.muracaatBean = muracaatBean;
    }

    public void create() {
        kisiBean.create();
        muracaatBean.create();
    }
    
    public void sorgula(){
    
    
    }
}
