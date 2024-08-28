/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import dao.MuracaatSecimDAO;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

/**
 *
 * @author Eren
 */
@Named(value = "muracaatSecimBean")
@ViewScoped
public class MuracaatSecimBean implements Serializable {

    private MuracaatSecimDAO dao;

    @Inject
    private MuracaatBean muracaatBean;

    @Inject
    private KisiBean kisi;

    @Inject
    private KisiDetayBean kisiDetay;

    @Inject
    private KisiEngelBean kisiEngel;

    @Inject
    private KisiYakinlarBean kisiYakinlar;

    public void BilgileriEkle() {

    }

    public MuracaatSecimBean() {
    }

    public MuracaatSecimDAO getDao() {
        if (dao == null) {
            dao = new MuracaatSecimDAO();
        }
        return dao;
    }

    public void setDao(MuracaatSecimDAO dao) {
        this.dao = dao;
    }

}