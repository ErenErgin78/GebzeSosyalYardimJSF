/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author emirh
 */
public class MuracaatDurum {

    private Integer durum_Id;
    private String durum;
    private Integer aktif;
    private Date kayit_tarihi;
    private Integer ekleyen_kisi_Id;

    public MuracaatDurum() {
    }

    public Integer getDurum_Id() {
        return durum_Id;
    }

    public void setDurum_Id(Integer durum_Id) {
        this.durum_Id = durum_Id;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
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

    public Integer getEkleyen_kisi_Id() {
        return ekleyen_kisi_Id;
    }

    public void setEkleyen_kisi_Id(Integer ekleyen_kisi_Id) {
        this.ekleyen_kisi_Id = ekleyen_kisi_Id;
    }

}
