/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.math.BigInteger;
import java.util.Date;

/**
 * Bu sınıf, kullanıcı bilgilerini temsil eden bir User varlığıdır. Kullanıcının
 * ID'si, adı, adresi, telefon numarası, cinsiyeti, kayıt tarihi ve daha
 * fazlasını içerir.
 */
public class User {

    // Kullanıcının temel bilgilerini temsil eden alanlar
    private int kullanici_id;
    private Integer kullanici_durum_id;
    private String kullanici_isim;
    private String kullanici_adres;
    private BigInteger kullanici_sicil_no;
    private BigInteger kullanici_telefon;
    private char kullanici_cinsiyet;
    private Date kullanici_kayit_tarih;
    private Integer kullanici_profil_id;
    private String kullannici_eposta;
    private String sifre;

    // Kullanıcının ek bilgilerini temsil eden alanlar
    private String kullanici_profil;
    private String kullanici_unvan;
    private String kullanici_durum;

    // Kullanıcının kullanıcı adını temsil eden alan
    private String kullanici_kullanici_adi;

    public User(int kullanici_id, String kullanici_isim, String kullanici_adres, BigInteger kullanici_sicil_no, BigInteger kullanici_telefon, char kullanici_cinsiyet, Date kullanici_kayit_tarih, String kullanici_unvan, String kullanici_durum, String kullanici_kullanici_adi) {
        this.kullanici_id = kullanici_id;
        this.kullanici_isim = kullanici_isim;
        this.kullanici_adres = kullanici_adres;
        this.kullanici_sicil_no = kullanici_sicil_no;
        this.kullanici_telefon = kullanici_telefon;
        this.kullanici_cinsiyet = kullanici_cinsiyet;
        this.kullanici_kayit_tarih = kullanici_kayit_tarih;
        this.kullanici_unvan = kullanici_unvan;
        this.kullanici_durum = kullanici_durum;
        this.kullanici_kullanici_adi = kullanici_kullanici_adi;
    }

    public User(int kullanici_id, String kullanici_isim, String kullanici_adres, BigInteger kullanici_sicil_no, BigInteger kullanici_telefon, char kullanici_cinsiyet, Date kullanici_kayit_tarih, String kullanici_profil, String kullanici_unvan, String kullanici_durum, String kullanici_kullanici_adi) {
        this.kullanici_id = kullanici_id;
        this.kullanici_isim = kullanici_isim;
        this.kullanici_adres = kullanici_adres;
        this.kullanici_sicil_no = kullanici_sicil_no;
        this.kullanici_telefon = kullanici_telefon;
        this.kullanici_cinsiyet = kullanici_cinsiyet;
        this.kullanici_kayit_tarih = kullanici_kayit_tarih;
        this.kullanici_profil = kullanici_profil;
        this.kullanici_unvan = kullanici_unvan;
        this.kullanici_durum = kullanici_durum;
        this.kullanici_kullanici_adi = kullanici_kullanici_adi;
    }

    public User(Integer kullanici_durum_id, String kullanici_isim, String kullanici_adres, BigInteger kullanici_sicil_no, BigInteger kullanici_telefon, char kullanici_cinsiyet, String kullannici_eposta, String sifre, String kullanici_kullanici_adi) {
        this.kullanici_durum_id = kullanici_durum_id;
        this.kullanici_isim = kullanici_isim;
        this.kullanici_adres = kullanici_adres;
        this.kullanici_sicil_no = kullanici_sicil_no;
        this.kullanici_telefon = kullanici_telefon;
        this.kullanici_cinsiyet = kullanici_cinsiyet;
        this.kullannici_eposta = kullannici_eposta;
        this.sifre = sifre;
        this.kullanici_kullanici_adi = kullanici_kullanici_adi;
    }

    // Getter ve setter metodları
    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getKullannici_eposta() {
        return kullannici_eposta;
    }

    public void setKullannici_eposta(String kullannici_eposta) {
        this.kullannici_eposta = kullannici_eposta;
    }

    public String getKullanici_kullanici_adi() {
        return kullanici_kullanici_adi;
    }

    public void setKullanici_kullanici_adi(String kullanici_kullanici_adi) {
        this.kullanici_kullanici_adi = kullanici_kullanici_adi;
    }

    public String getKullanici_profil() {
        return kullanici_profil;
    }

    public void setKullanici_profil(String kullanici_profil) {
        this.kullanici_profil = kullanici_profil;
    }

    public String getKullanici_unvan() {
        return kullanici_unvan;
    }

    public void setKullanici_unvan(String kullanici_unvan) {
        this.kullanici_unvan = kullanici_unvan;
    }

    public String getKullanici_durum() {
        return kullanici_durum;
    }

    public void setKullanici_durum(String kullanici_durum) {
        this.kullanici_durum = kullanici_durum;
    }

    public User() {
    }

    public Integer getKullanici_profil_id() {
        return kullanici_profil_id;
    }

    public void setKullanici_profil_id(Integer kullanici_profil_id) {
        this.kullanici_profil_id = kullanici_profil_id;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public Integer getKullanici_durum_id() {
        return kullanici_durum_id;
    }

    public void setKullanici_durum_id(Integer kullanici_durum_id) {
        this.kullanici_durum_id = kullanici_durum_id;
    }

    public String getKullanici_isim() {
        return kullanici_isim;
    }

    public void setKullanici_isim(String kullanici_isim) {
        this.kullanici_isim = kullanici_isim;
    }

    public String getKullanici_adres() {
        return kullanici_adres;
    }

    public void setKullanici_adres(String kullanici_adres) {
        this.kullanici_adres = kullanici_adres;
    }

    public BigInteger getKullanici_sicil_no() {
        if (kullanici_sicil_no == null) {
            kullanici_sicil_no = BigInteger.ZERO;
        }
        return kullanici_sicil_no;
    }

    public void setKullanici_sicil_no(BigInteger kullanici_sicil_no) {
        this.kullanici_sicil_no = kullanici_sicil_no;
    }

    public BigInteger getKullanici_telefon() {
        if (kullanici_telefon == null) {
            kullanici_telefon = BigInteger.ZERO;
        }
        return kullanici_telefon;
    }

    public void setKullanici_telefon(BigInteger kullanici_telefon) {
        this.kullanici_telefon = kullanici_telefon;
    }

    public char getKullanici_cinsiyet() {
        return kullanici_cinsiyet;
    }

    public void setKullanici_cinsiyet(char kullanici_cinsiyet) {
        this.kullanici_cinsiyet = kullanici_cinsiyet;
    }

    public Date getKullanici_kayit_tarih() {
        return kullanici_kayit_tarih;
    }

    public void setKullanici_kayit_tarih(Date kullanici_kayit_tarih) {
        this.kullanici_kayit_tarih = kullanici_kayit_tarih;
    }

    @Override
    public String toString() {
        return "User{" + "kullanici_id=" + kullanici_id + ", kullanici_durum_id=" + kullanici_durum_id + ", kullanici_isim=" + kullanici_isim + ", kullanici_adres=" + kullanici_adres + ", kullanici_sicil_no=" + kullanici_sicil_no + ", kullanici_telefon=" + kullanici_telefon + ", kullanici_cinsiyet=" + kullanici_cinsiyet + ", kullanici_kayit_tarih=" + kullanici_kayit_tarih + ", kullanici_profil_id=" + kullanici_profil_id + ", kullannici_eposta=" + kullannici_eposta + ", sifre=" + sifre + ", kullanici_profil=" + kullanici_profil + ", kullanici_unvan=" + kullanici_unvan + ", kullanici_durum=" + kullanici_durum + ", kullanici_kullanici_adi=" + kullanici_kullanici_adi + '}';
    }

}
