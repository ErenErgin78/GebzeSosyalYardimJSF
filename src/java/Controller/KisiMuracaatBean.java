/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import static Various.ErrorFinder.DetectError;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

/**
 *
 * @author Eren
 */
@Named(value = "kisiMuracaatBean")
@SessionScoped
public class KisiMuracaatBean implements Serializable {

    public KisiMuracaatBean() {
    }

    private String mesaj;
    private Integer egitim_id;

    @Inject
    private KisiBean kisiBean;

    @Inject
    private KisiIletisimBean iletisimBean;

    @Inject
    private KisiAdresBean adresBean;

    @Inject
    private KisiYakinlarBean kisiYakinlarBean;
    
    @Inject
    private MuracaatBilgiBean muracaatBilgiBean;

    public void KisiMuracaatEkle() {
        try {

            Integer iletisim_id = iletisimBean.ekle();
            Integer adres_id = adresBean.ekle();
            
            Integer kisi_id = kisiBean.ekle();
            Integer muracaat_bilgi_id = muracaatBilgiBean.ekle();

            mesaj = muracaatBilgiBean.getDao().getMesaj();

        } catch (Exception ex) {
            mesaj = DetectError(ex);
        }
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public Integer getEgitim_id() {
        return egitim_id;
    }

    public void setEgitim_id(Integer egitim_id) {
        this.egitim_id = egitim_id;
    }
    
}
