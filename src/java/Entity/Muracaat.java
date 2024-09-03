/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Eren
 */
public class Muracaat {

    private Integer muracaat_id;
    private Integer kisi_temel_id;
    private Integer muracaat_bilgi_id;
    private Date kayit_tarihi;
    private Integer aktif;
    private Date guncelleme_tarihi;

    private BigInteger kimlik_no;
    private String kisi_isim;
    private String kisi_soyisim;

    private Integer arsiv_dosya_no;
    private Date muracaat_tarihi;

    private String mahalle;
    private String sokak;
    
    private Integer muracaat_durum_Id;

    public Muracaat(Integer kisi_temel_id, Integer muracaat_bilgi_id, Integer aktif) {
        this.kisi_temel_id = kisi_temel_id;
        this.muracaat_bilgi_id = muracaat_bilgi_id;
        this.aktif = aktif;
    }

    public Muracaat(Date kayit_tarihi, Integer aktif, Date guncelleme_tarihi, BigInteger kimlik_no, String kisi_isim, String kisi_soyisim, Integer arsiv_dosya_no, Date muracaat_tarihi, String mahalle, String sokak) {
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
        this.guncelleme_tarihi = guncelleme_tarihi;
        this.kimlik_no = kimlik_no;
        this.kisi_isim = kisi_isim;
        this.kisi_soyisim = kisi_soyisim;
        this.arsiv_dosya_no = arsiv_dosya_no;
        this.muracaat_tarihi = muracaat_tarihi;
        this.mahalle = mahalle;
        this.sokak = sokak;
    }

    public Muracaat() {
    }

    public Integer getMuracaat_id() {
        return muracaat_id;
    }

    public void setMuracaat_id(Integer muracaat_id) {
        this.muracaat_id = muracaat_id;
    }

    public Integer getKisi_temel_id() {
        return kisi_temel_id;
    }

    public void setKisi_temel_id(Integer kisi_temel_id) {
        this.kisi_temel_id = kisi_temel_id;
    }

    public Integer getMuracaat_bilgi_id() {
        return muracaat_bilgi_id;
    }

    public void setMuracaat_bilgi_id(Integer muracaat_bilgi_id) {
        this.muracaat_bilgi_id = muracaat_bilgi_id;
    }

    public Date getKayit_tarihi() {
        return kayit_tarihi;
    }

    public void setKayit_tarihi(Date kayit_tarihi) {
        this.kayit_tarihi = kayit_tarihi;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

    public Date getGuncelleme_tarihi() {
        return guncelleme_tarihi;
    }

    public void setGuncelleme_tarihi(Date guncelleme_tarihi) {
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public BigInteger getKimlik_no() {
        return kimlik_no;
    }

    public void setKimlik_no(BigInteger kimlik_no) {
        this.kimlik_no = kimlik_no;
    }

    public String getKisi_isim() {
        return kisi_isim;
    }

    public void setKisi_isim(String kisi_isim) {
        this.kisi_isim = kisi_isim;
    }

    public String getKisi_soyisim() {
        return kisi_soyisim;
    }

    public void setKisi_soyisim(String kisi_soyisim) {
        this.kisi_soyisim = kisi_soyisim;
    }

    public Integer getArsiv_dosya_no() {
        return arsiv_dosya_no;
    }

    public void setArsiv_dosya_no(Integer arsiv_dosya_no) {
        this.arsiv_dosya_no = arsiv_dosya_no;
    }

    public Date getMuracaat_tarihi() {
        return muracaat_tarihi;
    }

    public void setMuracaat_tarihi(Date muracaat_tarihi) {
        this.muracaat_tarihi = muracaat_tarihi;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    public String getSokak() {
        return sokak;
    }

    public void setSokak(String sokak) {
        this.sokak = sokak;
    }

    public Integer getMuracaat_durum_Id() {
        return muracaat_durum_Id;
    }

    public void setMuracaat_durum_Id(Integer muracaat_durum_Id) {
        this.muracaat_durum_Id = muracaat_durum_Id;
    }
    

}
