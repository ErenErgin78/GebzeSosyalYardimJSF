package Entity;

import java.util.Date;

public class KisiAdres {

    private Integer kisi_adres_id;
    private String kisi_adres_isim;
    private String ilce;
    private String tarif;
    private String site;
    private Integer kapi_no;
    private Integer daire_no;
    private Integer kisi_adres_mahalle_id;
    private String kisi_adres_mahalle_isim;
    private Integer kisi_mahalle_sokak_id;
    private String kisi_mahalle_sokak_isim;
    private Date kayit_tarihi;
    private Integer aktif;

    public Integer getKisi_adres_id() {
        return kisi_adres_id;
    }

    public void setKisi_adres_id(Integer kisi_adres_id) {
        this.kisi_adres_id = kisi_adres_id;
    }

    public String getKisi_adres_isim() {
        return kisi_adres_isim;
    }

    public void setKisi_adres_isim(String kisi_adres_isim) {
        this.kisi_adres_isim = kisi_adres_isim;
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

    public KisiAdres(String kisi_adres_isim, String ilce, String tarif, String site, String kisi_adres_mahalle_isim, String kisi_mahalle_sokak_isim, Date kayit_tarihi, Integer aktif) {
        this.kisi_adres_isim = kisi_adres_isim;
        this.ilce = ilce;
        this.tarif = tarif;
        this.site = site;
        this.kisi_adres_mahalle_isim = kisi_adres_mahalle_isim;
        this.kisi_mahalle_sokak_isim = kisi_mahalle_sokak_isim;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
    }

    public KisiAdres() {
    }

}
