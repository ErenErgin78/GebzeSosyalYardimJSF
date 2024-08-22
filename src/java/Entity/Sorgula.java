/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author casper
 */
public class Sorgula {

    private Integer kisi_id;
    private BigDecimal kimlik_no;
    private String isim;
    private String soyisim;
    private String cinsiyet;
    private Integer cilt_no;
    private Integer aile_sira_no;
    private Integer sira_no;
    private Date dogum_tarihi = new Date();
    private Integer medeni_durum_id;
    private String medeni_durum_isim;

    private Integer kisi_iletisim_id;
    private BigInteger ev_telefon;
    private BigInteger cep_telefon;
    private String eposta;

    private Integer kisi_adres_id;
    private String tarif;
    private String site;
    private Integer kapi_no;
    private Integer daire_no;
    private Integer kisi_adres_mahalle_id;
    private String kisi_adres_mahalle_isim;
    private Integer kisi_mahalle_sokak_id;
    private String kisi_mahalle_sokak_isim;

    public Sorgula(Integer kisi_id, BigDecimal kimlik_no, String isim, String soyisim, String cinsiyet, Integer cilt_no, Integer aile_sira_no, Integer sira_no, Integer medeni_durum_id, String medeni_durum_isim, Integer kisi_iletisim_id, BigInteger ev_telefon, BigInteger cep_telefon, String eposta, Integer kisi_adres_id, String tarif, String site, Integer kapi_no, Integer daire_no, Integer kisi_adres_mahalle_id, String kisi_adres_mahalle_isim, Integer kisi_mahalle_sokak_id, String kisi_mahalle_sokak_isim) {
        this.kisi_id = kisi_id;
        this.kimlik_no = kimlik_no;
        this.isim = isim;
        this.soyisim = soyisim;
        this.cinsiyet = cinsiyet;
        this.cilt_no = cilt_no;
        this.aile_sira_no = aile_sira_no;
        this.sira_no = sira_no;
        this.medeni_durum_id = medeni_durum_id;
        this.medeni_durum_isim = medeni_durum_isim;
    }
    
    

    public Integer getKisi_id() {
        return kisi_id;
    }

    public void setKisi_id(Integer kisi_id) {
        this.kisi_id = kisi_id;
    }

    public BigDecimal getKimlik_no() {
        return kimlik_no;
    }

    public void setKimlik_no(BigDecimal kimlik_no) {
        this.kimlik_no = kimlik_no;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public Integer getCilt_no() {
        return cilt_no;
    }

    public void setCilt_no(Integer cilt_no) {
        this.cilt_no = cilt_no;
    }

    public Integer getAile_sira_no() {
        return aile_sira_no;
    }

    public void setAile_sira_no(Integer aile_sira_no) {
        this.aile_sira_no = aile_sira_no;
    }

    public Integer getSira_no() {
        return sira_no;
    }

    public void setSira_no(Integer sira_no) {
        this.sira_no = sira_no;
    }

    public Date getDogum_tarihi() {
        return dogum_tarihi;
    }

    public void setDogum_tarihi(Date dogum_tarihi) {
        this.dogum_tarihi = dogum_tarihi;
    }

    public Integer getMedeni_durum_id() {
        return medeni_durum_id;
    }

    public void setMedeni_durum_id(Integer medeni_durum_id) {
        this.medeni_durum_id = medeni_durum_id;
    }

    public String getMedeni_durum_isim() {
        return medeni_durum_isim;
    }

    public void setMedeni_durum_isim(String medeni_durum_isim) {
        this.medeni_durum_isim = medeni_durum_isim;
    }

    public Integer getKisi_iletisim_id() {
        return kisi_iletisim_id;
    }

    public void setKisi_iletisim_id(Integer kisi_iletisim_id) {
        this.kisi_iletisim_id = kisi_iletisim_id;
    }

    public BigInteger getEv_telefon() {
        return ev_telefon;
    }

    public void setEv_telefon(BigInteger ev_telefon) {
        this.ev_telefon = ev_telefon;
    }

    public BigInteger getCep_telefon() {
        return cep_telefon;
    }

    public void setCep_telefon(BigInteger cep_telefon) {
        this.cep_telefon = cep_telefon;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public Integer getKisi_adres_id() {
        return kisi_adres_id;
    }

    public void setKisi_adres_id(Integer kisi_adres_id) {
        this.kisi_adres_id = kisi_adres_id;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Integer getKapi_no() {
        return kapi_no;
    }

    public void setKapi_no(Integer kapi_no) {
        this.kapi_no = kapi_no;
    }

    public Integer getDaire_no() {
        return daire_no;
    }

    public void setDaire_no(Integer daire_no) {
        this.daire_no = daire_no;
    }

    public Integer getKisi_adres_mahalle_id() {
        return kisi_adres_mahalle_id;
    }

    public void setKisi_adres_mahalle_id(Integer kisi_adres_mahalle_id) {
        this.kisi_adres_mahalle_id = kisi_adres_mahalle_id;
    }

    public String getKisi_adres_mahalle_isim() {
        return kisi_adres_mahalle_isim;
    }

    public void setKisi_adres_mahalle_isim(String kisi_adres_mahalle_isim) {
        this.kisi_adres_mahalle_isim = kisi_adres_mahalle_isim;
    }

    public Integer getKisi_mahalle_sokak_id() {
        return kisi_mahalle_sokak_id;
    }

    public void setKisi_mahalle_sokak_id(Integer kisi_mahalle_sokak_id) {
        this.kisi_mahalle_sokak_id = kisi_mahalle_sokak_id;
    }

    public String getKisi_mahalle_sokak_isim() {
        return kisi_mahalle_sokak_isim;
    }

    public void setKisi_mahalle_sokak_isim(String kisi_mahalle_sokak_isim) {
        this.kisi_mahalle_sokak_isim = kisi_mahalle_sokak_isim;
    }


    
    
    
    
}
