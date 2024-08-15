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

    private String mesaj = "1";

    Integer a = 0;
    @Inject
    private KisiBean kisiBean;

    @Inject
    private KisiAdresBean adresBean;

    @Inject
    private KisiIletisimBean iletisimBean;

    @Inject
    private KisiYakinlarBean kisiYakinlarBean;

    @Inject
    private KisiDetayBean kisiDetayBean;

    @Inject
    private MuracaatBilgiBean muracaatBilgiBean;

    @Inject
    private MuracaatBean muracaatBean;

    public void KisiMuracaatEkle() {
        try {
            StringBuilder nullMessages = new StringBuilder();

            Integer adres_id = adresBean.ekle();
            if (adres_id == null) {
                nullMessages.append("adres_id is null. ");
            }

            Integer iletisim_id = iletisimBean.ekle();
            if (iletisim_id == null) {
                nullMessages.append("iletisim_id is null. ");
            }

            Integer kisi_detay_id = kisiDetayBean.ekle(iletisim_id, adres_id);
            if (kisi_detay_id == null) {
                nullMessages.append("kisi_detay_id is null. ");
            }

            Integer kisi_id = kisiBean.ekle(kisi_detay_id);
            if (kisi_id == null) {
                nullMessages.append("kisi_id is null. ");
            }

            Integer muracaat_bilgi_id = muracaatBilgiBean.ekle();
            if (muracaat_bilgi_id == null) {
                nullMessages.append("muracaat_bilgi_id is null. ");
            }

            Integer muracaat_id = muracaatBean.ekle(kisi_id, muracaat_bilgi_id);
            if (muracaat_id == null) {
                nullMessages.append("muracaat_id is null. ");
            }

            Integer yakinlar_id = kisiYakinlarBean.ekle(kisi_id);
            if (yakinlar_id == null) {
                nullMessages.append("yakinlar_id is null. ");
            }

            if (nullMessages.length() > 0) {
                mesaj = nullMessages.toString();
            } else {
                mesaj = muracaatBilgiBean.getDao().getMesaj();
            }

        } catch (Exception ex) {
            mesaj = DetectError(ex);
        }
    }

    public String getMesaj() {

        a++;

        mesaj = a.toString();
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

}
