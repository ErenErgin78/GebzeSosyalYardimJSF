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
 * @author Administrator
 */
@Named(value = "yakinlarKaydetBean")
@SessionScoped
public class YakinlarKaydetBean implements Serializable {

    public YakinlarKaydetBean() {
    }

    private String mesaj;

    @Inject
    private KisiBean kisiBean;

    @Inject
    private KisiYakinlarBean kisiYakinlarBean;

    @Inject
    private KisiDetayBean kisiDetayBean;

    @Inject
    private EgitimDurumBean egitimDurumBean;

    @Inject
    private TutanakSosyalGuvenceBean tutanakSosyalGuvenceBean;

    @Inject
    private KisiEngelBean kisiEngelBean;

    @Inject
    private MeslekBean meslekBean;

    public void YakinlarEkle() {

        try {

            Integer kisi_id = kisiBean.ekle();

            Integer yakinlar_id = kisiYakinlarBean.ekle();

            Integer kisi_detay_id = kisiDetayBean.ekle();

            
            mesaj = "İşlem Başarılı";
            
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

    public KisiBean getKisiBean() {
        return kisiBean;
    }

    public void setKisiBean(KisiBean kisiBean) {
        this.kisiBean = kisiBean;
    }

    public KisiYakinlarBean getKisiYakinlarBean() {
        return kisiYakinlarBean;
    }

    public void setKisiYakinlarBean(KisiYakinlarBean kisiYakinlarBean) {
        this.kisiYakinlarBean = kisiYakinlarBean;
    }

    public KisiDetayBean getKisiDetayBean() {
        return kisiDetayBean;
    }

    public void setKisiDetayBean(KisiDetayBean kisiDetayBean) {
        this.kisiDetayBean = kisiDetayBean;
    }

    public EgitimDurumBean getEgitimDurumBean() {
        return egitimDurumBean;
    }

    public void setEgitimDurumBean(EgitimDurumBean egitimDurumBean) {
        this.egitimDurumBean = egitimDurumBean;
    }

    public TutanakSosyalGuvenceBean getTutanakSosyalGuvenceBean() {
        return tutanakSosyalGuvenceBean;
    }

    public void setTutanakSosyalGuvenceBean(TutanakSosyalGuvenceBean tutanakSosyalGuvenceBean) {
        this.tutanakSosyalGuvenceBean = tutanakSosyalGuvenceBean;
    }

    public KisiEngelBean getKisiEngelBean() {
        return kisiEngelBean;
    }

    public void setKisiEngelBean(KisiEngelBean kisiEngelBean) {
        this.kisiEngelBean = kisiEngelBean;
    }

    public MeslekBean getMeslekBean() {
        return meslekBean;
    }

    public void setMeslekBean(MeslekBean meslekBean) {
        this.meslekBean = meslekBean;
    }
    
}
