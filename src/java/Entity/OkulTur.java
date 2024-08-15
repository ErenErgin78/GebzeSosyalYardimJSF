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
public class OkulTur {
    private Integer okul_tur_id;
    private String okul_tur_isim;
    private Date kayit_tarihi;

    public Integer getOkul_tur_id() {
        return okul_tur_id;
    }

    public void setOkul_tur_id(Integer okul_tur_id) {
        this.okul_tur_id = okul_tur_id;
    }

    public String getOkul_tur_isim() {
        return okul_tur_isim;
    }

    public void setOkul_tur_isim(String okul_tur_isim) {
        this.okul_tur_isim = okul_tur_isim;
    }

    public Date getKayit_tarihi() {
        return kayit_tarihi;
    }

    public void setKayit_tarihi(Date kayit_tarihi) {
        this.kayit_tarihi = kayit_tarihi;
    }

    public OkulTur(Integer okul_tur_id, String okul_tur_isim, Date kayit_tarihi) {
        this.okul_tur_id = okul_tur_id;
        this.okul_tur_isim = okul_tur_isim;
        this.kayit_tarihi = kayit_tarihi;
    }

    public OkulTur() {
    }
    
    
    
}
