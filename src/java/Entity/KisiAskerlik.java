/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

public class KisiAskerlik {

    private Integer askerlik_id;
    private Integer asker_hukumlu;
    private Integer sure;
    private String aciklama;
    private Date baslangic_tarihi;
    private Date bitis_tarihi;
    private Integer aktif = 1;
    private Date kayit_tarihi;
    private Date guncelleme_tarihi;

    // Boş constructor
    public KisiAskerlik() {
    }

    // Tüm alanları alan constructor
    public KisiAskerlik(Integer askerlik_id, Integer asker_hukumlu, Integer sure, String aciklama,
            Date baslangic_tarihi, Date bitis_tarihi, Integer aktif,
            Date kayit_tarihi, Date guncelleme_tarihi) {
        this.askerlik_id = askerlik_id;
        this.asker_hukumlu = asker_hukumlu;
        this.sure = sure;
        this.aciklama = aciklama;
        this.baslangic_tarihi = baslangic_tarihi;
        this.bitis_tarihi = bitis_tarihi;
        this.aktif = aktif;
        this.kayit_tarihi = kayit_tarihi;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    // ID'siz constructor
    public KisiAskerlik(Integer asker_hukumlu, Integer sure, String aciklama,
            Date baslangic_tarihi, Date bitis_tarihi, Integer aktif,
            Date kayit_tarihi, Date guncelleme_tarihi) {
        this.asker_hukumlu = asker_hukumlu;
        this.sure = sure;
        this.aciklama = aciklama;
        this.baslangic_tarihi = baslangic_tarihi;
        this.bitis_tarihi = bitis_tarihi;
        this.aktif = aktif;
        this.kayit_tarihi = kayit_tarihi;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    // Getter ve Setter metodları
    public Integer getAskerlik_id() {
        return askerlik_id;
    }

    public void setAskerlik_id(Integer askerlik_id) {
        this.askerlik_id = askerlik_id;
    }

    public Integer getAsker_hukumlu() {
        return asker_hukumlu;
    }

    public void setAsker_hukumlu(Integer asker_hukumlu) {
        this.asker_hukumlu = asker_hukumlu;
    }

    public Integer getSure() {
        return sure;
    }

    public void setSure(Integer sure) {
        this.sure = sure;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Date getBaslangic_tarihi() {
        return baslangic_tarihi;
    }

    public void setBaslangic_tarihi(Date baslangic_tarihi) {
        this.baslangic_tarihi = baslangic_tarihi;
    }

    public Date getBitis_tarihi() {
        return bitis_tarihi;
    }

    public void setBitis_tarihi(Date bitis_tarihi) {
        this.bitis_tarihi = bitis_tarihi;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

    public Date getKayit_tarihi() {
        return kayit_tarihi;
    }

    public void setKayit_tarihi(Date kayit_tarihi) {
        this.kayit_tarihi = kayit_tarihi;
    }

    public Date getGuncelleme_tarihi() {
        return guncelleme_tarihi;
    }

    public void setGuncelleme_tarihi(Date guncelleme_tarihi) {
        this.guncelleme_tarihi = guncelleme_tarihi;
    }
}
