package Entity;

import java.math.BigDecimal;
import java.util.Date;

public class Kisi {

    private Integer kisi_id;
    private BigDecimal kimlik_no;
    private String isim;
    private String soyisim;
    private String cinsiyet;
    private Integer cilt_no;
    private Integer aile_sira_no;
    private Integer sira_no;
    private Date dogum_tarihi;
    private Integer medeni_durum_id;
    private Integer mahalle_id;
    private Integer sokak_id;
    private String site;
    private String adres_tarifi;
    private Integer kapi_no;
    private Integer daire_no;
    private String ev_telefon;
    private String cep_telefon;
    private String eposta;
    private Date kayit_tarihi;
    private Integer aktif;

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

    public Integer getMahalle_id() {
        return (mahalle_id != null) ? mahalle_id : 20; // Varsayılan olarak 0 değerini döndür
    }

    public void setMahalle_id(Integer mahalle_id) {
        this.mahalle_id = mahalle_id;
    }

    public Integer getSokak_id() {
        return (sokak_id !=null) ? sokak_id:1;
    }

    public void setSokak_id(Integer sokak_id) {
        this.sokak_id = sokak_id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAdres_tarifi() {
        return adres_tarifi;
    }

    public void setAdres_tarifi(String adres_tarifi) {
        this.adres_tarifi = adres_tarifi;
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

    public String getEv_telefon() {
        return ev_telefon;
    }

    public void setEv_telefon(String ev_telefon) {
        this.ev_telefon = ev_telefon;
    }

    public String getCep_telefon() {
        return cep_telefon;
    }

    public void setCep_telefon(String cep_telefon) {
        this.cep_telefon = cep_telefon;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
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

    public Kisi(BigDecimal kimlik_no, String isim, String soyisim, String cinsiyet, int cilt_no, int aile_sira_no, int sira_no, Date dogum_tarihi, int medeni_durum_id, int mahalle_id, int sokak_id, String ilce, String site, String adres_tarifi, int daire_no, int kapi_no, String ev_telefon, String cep_telefon, String eposta, Date kayit_tarihi) {
        this.kisi_id = kisi_id;
        this.kimlik_no = kimlik_no;
        this.isim = isim;
        this.soyisim = soyisim;
        this.cinsiyet = cinsiyet;
        this.cilt_no = cilt_no;
        this.aile_sira_no = aile_sira_no;
        this.sira_no = sira_no;
        this.dogum_tarihi = dogum_tarihi;
        this.medeni_durum_id = medeni_durum_id;
        this.mahalle_id = mahalle_id;
        this.sokak_id = sokak_id;
        this.site = site;
        this.adres_tarifi = adres_tarifi;
        this.kapi_no = kapi_no;
        this.daire_no = daire_no;
        this.ev_telefon = ev_telefon;
        this.cep_telefon = cep_telefon;
        this.eposta = eposta;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
    }

    public Kisi() {
    }

}