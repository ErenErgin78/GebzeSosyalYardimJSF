/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

public class TutanakBorc {

    private Integer borc_id;
    private Float elektrik;
    private Float su;
    private Float dogalgaz;
    private Float kira;
    private Float kredi_karti;
    private Float diger;
    private String diger_aciklama;
    private Date guncelleme_tarihi;

    // Boş constructor
    public TutanakBorc() {
    }

    // Tüm alanları alan constructor
    public TutanakBorc(Integer borc_id, Float elektrik, Float su, Float dogalgaz, Float kira, 
               Float kredi_karti, Float diger, String diger_aciklama, Date guncelleme_tarihi) {
        this.borc_id = borc_id;
        this.elektrik = elektrik;
        this.su = su;
        this.dogalgaz = dogalgaz;
        this.kira = kira;
        this.kredi_karti = kredi_karti;
        this.diger = diger;
        this.diger_aciklama = diger_aciklama;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    // ID'siz constructor
    public TutanakBorc(Float elektrik, Float su, Float dogalgaz, Float kira, 
                Float kredi_karti, Float diger, String diger_aciklama, Date guncelleme_tarihi) {
        this.elektrik = elektrik;
        this.su = su;
        this.dogalgaz = dogalgaz;
        this.kira = kira;
        this.kredi_karti = kredi_karti;
        this.diger = diger;
        this.diger_aciklama = diger_aciklama;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    // Getter ve Setter metodları
    public Integer getBorc_id() {
        return borc_id;
    }

    public void setBorc_id(Integer borc_id) {
        this.borc_id = borc_id;
    }

    public Float getElektrik() {
        return elektrik;
    }

    public void setElektrik(Float elektrik) {
        this.elektrik = elektrik;
    }

    public Float getSu() {
        return su;
    }

    public void setSu(Float su) {
        this.su = su;
    }

    public Float getDogalgaz() {
        return dogalgaz;
    }

    public void setDogalgaz(Float dogalgaz) {
        this.dogalgaz = dogalgaz;
    }

    public Float getKira() {
        return kira;
    }

    public void setKira(Float kira) {
        this.kira = kira;
    }

    public Float getKredi_karti() {
        return kredi_karti;
    }

    public void setKredi_karti(Float kredi_karti) {
        this.kredi_karti = kredi_karti;
    }

    public Float getDiger() {
        return diger;
    }

    public void setDiger(Float diger) {
        this.diger = diger;
    }

    public String getDiger_aciklama() {
        return diger_aciklama;
    }

    public void setDiger_aciklama(String diger_aciklama) {
        this.diger_aciklama = diger_aciklama;
    }

    public Date getGuncelleme_tarihi() {
        return guncelleme_tarihi;
    }

    public void setGuncelleme_tarihi(Date guncelleme_tarihi) {
        this.guncelleme_tarihi = guncelleme_tarihi;
    }
}
