/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

public class TutanakBorc {

    private Integer borc_id;
    private float elektrik = 0;
    private float su = 0;
    private float dogalgaz = 0;
    private float kira = 0;
    private float kredi_karti = 0;
    private float diger = 0;
    private String diger_aciklama = "";
    private Date guncelleme_tarihi;

    // Boş constructor
    public TutanakBorc() {
    }

    // Tüm alanları alan constructor
    public TutanakBorc(Integer borc_id, float elektrik, float su, float dogalgaz, float kira, 
               float kredi_karti, float diger, String diger_aciklama, Date guncelleme_tarihi) {
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
    public TutanakBorc(float elektrik, float su, float dogalgaz, float kira, 
                float kredi_karti, float diger, String diger_aciklama, Date guncelleme_tarihi) {
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

    public float getElektrik() {
        return elektrik;
    }

    public void setElektrik(float elektrik) {
        this.elektrik = elektrik;
    }

    public float getSu() {
        return su;
    }

    public void setSu(float su) {
        this.su = su;
    }

    public float getDogalgaz() {
        return dogalgaz;
    }

    public void setDogalgaz(float dogalgaz) {
        this.dogalgaz = dogalgaz;
    }

    public float getKira() {
        return kira;
    }

    public void setKira(float kira) {
        this.kira = kira;
    }

    public float getKredi_karti() {
        return kredi_karti;
    }

    public void setKredi_karti(float kredi_karti) {
        this.kredi_karti = kredi_karti;
    }

    public float getDiger() {
        return diger;
    }

    public void setDiger(float diger) {
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