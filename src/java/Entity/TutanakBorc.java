/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

public class TutanakBorc {

    private Integer borc_id;
    private Integer elektrik;
    private Integer su;
    private Integer dogalgaz;
    private Integer kira;
    private Integer kredi_karti;
    private Integer diger;
    private String diger_aciklama;
    private Date guncelleme_tarihi;

    // Boş constructor
    public TutanakBorc() {
    }

    // Tüm alanları alan constructor
    public TutanakBorc(Integer borc_id, Integer elektrik, Integer su, Integer dogalgaz, Integer kira, 
                Integer kredi_karti, Integer diger, String diger_aciklama, Date guncelleme_tarihi) {
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
    public TutanakBorc(Integer elektrik, Integer su, Integer dogalgaz, Integer kira, 
                Integer kredi_karti, Integer diger, String diger_aciklama, Date guncelleme_tarihi) {
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

    public Integer getElektrik() {
        return elektrik;
    }

    public void setElektrik(Integer elektrik) {
        this.elektrik = elektrik;
    }

    public Integer getSu() {
        return su;
    }

    public void setSu(Integer su) {
        this.su = su;
    }

    public Integer getDogalgaz() {
        return dogalgaz;
    }

    public void setDogalgaz(Integer dogalgaz) {
        this.dogalgaz = dogalgaz;
    }

    public Integer getKira() {
        return kira;
    }

    public void setKira(Integer kira) {
        this.kira = kira;
    }

    public Integer getKredi_karti() {
        return kredi_karti;
    }

    public void setKredi_karti(Integer kredi_karti) {
        this.kredi_karti = kredi_karti;
    }

    public Integer getDiger() {
        return diger;
    }

    public void setDiger(Integer diger) {
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
