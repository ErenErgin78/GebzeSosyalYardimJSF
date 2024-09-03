/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Eren
 */
public class EgitimDurum {
    
    private Integer egitim_durum_id;
    private String egitim_durum;
    private Date kayit_tarihi;
    private Integer Aktif;
    private Date guncelleme_tarihi;

    public Integer getEgitim_durum_id() {
        return egitim_durum_id;
    }

    public void setEgitim_durum_id(Integer egitim_durum_id) {
        this.egitim_durum_id = egitim_durum_id;
    }

    public String getEgitim_durum() {
        return egitim_durum;
    }

    public void setEgitim_durum(String egitim_durum) {
        this.egitim_durum = egitim_durum;
    }

    public Date getKayit_tarihi() {
        return kayit_tarihi;
    }

    public void setKayit_tarihi(Date kayit_tarihi) {
        this.kayit_tarihi = kayit_tarihi;
    }

    public Integer getAktif() {
        return Aktif;
    }

    public void setAktif(Integer Aktif) {
        this.Aktif = Aktif;
    }

    public Date getGuncelleme_tarihi() {
        return guncelleme_tarihi;
    }

    public void setGuncelleme_tarihi(Date guncelleme_tarihi) {
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public EgitimDurum() {
    }

    public EgitimDurum(String egitim_durum, Integer Aktif) {
        this.egitim_durum = egitim_durum;
        this.Aktif = Aktif;
    }
    
}
