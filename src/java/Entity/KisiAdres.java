package Entity;

import java.math.BigInteger;
import java.util.Date;

public class KisiAdres {

    private Integer kisi_adres_id;
    private String ilce;
    private String tarif;
    private String site;
    private Integer kapi_no;
    private Integer daire_no;
    private Integer adres_no;
    private Integer evdeki_kisi_sayisi;
    private Integer mahalle_id;
    private Integer mahalle_sokak_id;
    private String mahalle_isim;
    private String mahalle_sokak_isim;

    public Integer getKisi_adres_id() {
        return kisi_adres_id;
    }

    public void setKisi_adres_id(Integer kisi_adres_id) {
        this.kisi_adres_id = kisi_adres_id;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
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

    public Integer getAdres_no() {
        return adres_no;
    }

    public void setAdres_no(Integer adres_no) {
        this.adres_no = adres_no;
    }

    public Integer getEvdeki_kisi_sayisi() {
        return evdeki_kisi_sayisi;
    }

    public void setEvdeki_kisi_sayisi(Integer evdeki_kisi_sayisi) {
        this.evdeki_kisi_sayisi = evdeki_kisi_sayisi;
    }

    public Integer getMahalle_id() {
        return mahalle_id;
    }

    public void setMahalle_id(Integer mahalle_id) {
        this.mahalle_id = mahalle_id;
    }

    public Integer getMahalle_sokak_id() {
        return mahalle_sokak_id;
    }

    public void setMahalle_sokak_id(Integer mahalle_sokak_id) {
        this.mahalle_sokak_id = mahalle_sokak_id;
    }

    public String getMahalle_isim() {
        return mahalle_isim;
    }

    public void setMahalle_isim(String mahalle_isim) {
        this.mahalle_isim = mahalle_isim;
    }

    public String getMahalle_sokak_isim() {
        return mahalle_sokak_isim;
    }

    public void setMahalle_sokak_isim(String mahalle_sokak_isim) {
        this.mahalle_sokak_isim = mahalle_sokak_isim;
    }

    public KisiAdres(String ilce, String tarif, String site, Integer kapi_no, Integer daire_no, Integer adres_no, Integer evdeki_kisi_sayisi, String mahalle_isim, String mahalle_sokak_isim) {
        this.ilce = ilce;
        this.tarif = tarif;
        this.site = site;
        this.kapi_no = kapi_no;
        this.daire_no = daire_no;
        this.adres_no = adres_no;
        this.evdeki_kisi_sayisi = evdeki_kisi_sayisi;
        this.mahalle_isim = mahalle_isim;
        this.mahalle_sokak_isim = mahalle_sokak_isim;
    }

    public KisiAdres() {
    }

}
