/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Hamza
 */
public class Hastalik {

    private Integer hastalik_id;
    private String hastalik;
    private Integer aktif;
    private Date kayit_tarihi;

    public Integer getHastalik_id() {
        return hastalik_id;
    }

    public void setHastalik_id(Integer hastalik_id) {
        this.hastalik_id = hastalik_id;
    }

    public String getHastalik() {
        return hastalik;
    }

    public void setHastalik(String hastalik) {
        this.hastalik = hastalik;
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

    public Hastalik(String hastalik, Integer aktif, Date kayit_tarihi) {
        this.hastalik = hastalik;
        this.aktif = aktif;
        this.kayit_tarihi = kayit_tarihi;
    }

    public Hastalik() {
    }

}
