package Entity;

import java.util.Date;

public class KisiAdres {

    private Integer kisi_adres_id;
    private String tarif;
    private String site;
    private Integer kapi_no;
    private Integer daire_no;
    private Integer kisi_adres_mahalle_id;
    private String kisi_adres_mahalle_isim;
    private Integer kisi_mahalle_sokak_id;
    private String kisi_mahalle_sokak_isim;
    private Date kayit_tarihi;
    private Integer aktif = 1;

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

    public KisiAdres(String tarif, String site, Integer kapi_no, Integer daire_no, String kisi_adres_mahalle_isim, String kisi_mahalle_sokak_isim, Date kayit_tarihi, Integer aktif) {
        this.tarif = tarif;
        this.site = site;
        this.kapi_no = kapi_no;
        this.daire_no = daire_no;
        this.kisi_adres_mahalle_isim = kisi_adres_mahalle_isim;
        this.kisi_mahalle_sokak_isim = kisi_mahalle_sokak_isim;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
    }

    public KisiAdres() {
    }

}
