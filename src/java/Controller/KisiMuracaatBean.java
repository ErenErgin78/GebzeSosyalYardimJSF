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

    @Inject
    private KisiBean kisiBean;

    @Inject
    private KisiDetayBean kisiDetayBean;

    @Inject
    private KisiIletisimBean iletisimBean;

    @Inject
    private KisiAdresBean adresBean;

    @Inject
    private MuracaatBean muracaatBean;

    @Inject
    private MuracaatDurumBean muracaatDurumBean;

    @Inject
    private MuracaatBilgiBean muracaatBilgiBean;

    @Inject
    private MuracaatYardimTalepBean muracaatYardimTalepBean;

    // Kişi müracaatını ekler ve ilgili işlemleri yapar
    public void KisiMuracaatEkle() {
        try {
            Integer adres_id = adresBean.ekle();

            Integer iletisim_id = iletisimBean.ekle();

            Integer kisi_detay_id = kisiDetayBean.ekleMuracaat(iletisim_id, adres_id);

            Integer kisi_id = kisiBean.ekle(kisi_detay_id);

            Integer muracaat_bilgi_id = muracaatBilgiBean.ekle();
            
            Integer muracaat_durum_id= muracaatDurumBean.ekle();

            muracaatBean.ekle(kisi_id, muracaat_bilgi_id);
            
            

            mesaj = "İşlem Başarılı";

        } catch (Exception ex) {
            mesaj = DetectError(ex);
        }
    }

    // Mesajı getirir
    public String getMesaj() {
        return mesaj;
    }

    // Mesajı ayarlar
    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

}
