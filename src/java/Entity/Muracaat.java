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
    private BigInteger kimlik_no;
    private String isim;
    private String soyisim;
    private char cinsiyet;
    private String medeni_durum;
    private String egitim_durum;
    private char yabanci_kimlik;
    private char misafir;
    private String cilt_no;
    private Integer aile_sıra_no;
    private Integer sıra_no;
    private Date dogum_tarihi;
        
    private Integer kisi_iletisim_id;
    private BigInteger ev_telefon;
    private BigInteger cep_telefon;
    private String eposta;
    
    private Integer kisi_adres_id;
    private String ilce;
    private String mahalle;
    private String cadde_sokak;
    private String tarif;
    private String site;
    private Integer kapi_no;
    private Integer daire_no;
    private Integer adres_no;
    private Integer evdeki_kisi_sayısı;


    private Integer kisi_yakinlar_id;
    private String anne_isim;
    private String baba_isim;
    private String es_isim;
    private String es_soyisim;
    private String es_durum;

    public Muracaat(BigInteger kimlik_no, String isim, String soyisim, char cinsiyet, String medeni_durum, char yabanci_kimlik, char misafir, String cilt_no, Integer aile_sıra_no, Integer sıra_no, Date dogum_tarihi, BigInteger ev_telefon, BigInteger cep_telefon, String eposta, String ilce, String mahalle, String cadde_sokak, String tarif, String site, Integer kapi_no, Integer daire_no, Integer adres_no, String anne_isim, String baba_isim, String es_isim, String es_soyisim) {
        this.kimlik_no = kimlik_no;
        this.isim = isim;
        this.soyisim = soyisim;
        this.cinsiyet = cinsiyet;
        this.medeni_durum = medeni_durum;
        this.yabanci_kimlik = yabanci_kimlik;
        this.misafir = misafir;
        this.cilt_no = cilt_no;
        this.aile_sıra_no = aile_sıra_no;
        this.sıra_no = sıra_no;
        this.dogum_tarihi = dogum_tarihi;
        this.ev_telefon = ev_telefon;
        this.cep_telefon = cep_telefon;
        this.eposta = eposta;
        this.ilce = ilce;
        this.mahalle = mahalle;
        this.cadde_sokak = cadde_sokak;
        this.tarif = tarif;
        this.site = site;
        this.kapi_no = kapi_no;
        this.daire_no = daire_no;
        this.adres_no = adres_no;
        this.anne_isim = anne_isim;
        this.baba_isim = baba_isim;
        this.es_isim = es_isim;
        this.es_soyisim = es_soyisim;
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

    public BigInteger getKimlik_no() {
        return kimlik_no;
    }

    public void setKimlik_no(BigInteger kimlik_no) {
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

    public char getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(char cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getMedeni_durum() {
        return medeni_durum;
    }

    public void setMedeni_durum(String medeni_durum) {
        this.medeni_durum = medeni_durum;
    }

    public String getEgitim_durum() {
        return egitim_durum;
    }

    public void setEgitim_durum(String egitim_durum) {
        this.egitim_durum = egitim_durum;
    }

    public char getYabanci_kimlik() {
        return yabanci_kimlik;
    }

    public void setYabanci_kimlik(char yabanci_kimlik) {
        this.yabanci_kimlik = yabanci_kimlik;
    }

    public char getMisafir() {
        return misafir;
    }

    public void setMisafir(char misafir) {
        this.misafir = misafir;
    }

    public String getCilt_no() {
        return cilt_no;
    }

    public void setCilt_no(String cilt_no) {
        this.cilt_no = cilt_no;
    }

    public Integer getAile_sıra_no() {
        return aile_sıra_no;
    }

    public void setAile_sıra_no(Integer aile_sıra_no) {
        this.aile_sıra_no = aile_sıra_no;
    }

    public Integer getSıra_no() {
        return sıra_no;
    }

    public void setSıra_no(Integer sıra_no) {
        this.sıra_no = sıra_no;
    }

    public Date getDogum_tarihi() {
        return dogum_tarihi;
    }

    public void setDogum_tarihi(Date dogum_tarihi) {
        this.dogum_tarihi = dogum_tarihi;
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

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    public String getCadde_sokak() {
        return cadde_sokak;
    }

    public void setCadde_sokak(String cadde_sokak) {
        this.cadde_sokak = cadde_sokak;
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

    public Integer getEvdeki_kisi_sayısı() {
        return evdeki_kisi_sayısı;
    }

    public void setEvdeki_kisi_sayısı(Integer evdeki_kisi_sayısı) {
        this.evdeki_kisi_sayısı = evdeki_kisi_sayısı;
    }

    public Integer getKisi_yakinlar_id() {
        return kisi_yakinlar_id;
    }

    public void setKisi_yakinlar_id(Integer kisi_yakinlar_id) {
        this.kisi_yakinlar_id = kisi_yakinlar_id;
    }

    public String getAnne_isim() {
        return anne_isim;
    }

    public void setAnne_isim(String anne_isim) {
        this.anne_isim = anne_isim;
    }

    public String getBaba_isim() {
        return baba_isim;
    }

    public void setBaba_isim(String baba_isim) {
        this.baba_isim = baba_isim;
    }

    public String getEs_isim() {
        return es_isim;
    }

    public void setEs_isim(String es_isim) {
        this.es_isim = es_isim;
    }

    public String getEs_soyisim() {
        return es_soyisim;
    }

    public void setEs_soyisim(String es_soyisim) {
        this.es_soyisim = es_soyisim;
    }

    public String getEs_durum() {
        return es_durum;
    }

    public void setEs_durum(String es_durum) {
        this.es_durum = es_durum;
    }
    
}
