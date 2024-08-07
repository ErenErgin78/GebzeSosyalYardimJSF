package Entity;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Eren
 */
public class Kisi {
//kişi temel
    private Integer kisi_id;
    private BigInteger kimlik_no;
    private String isim;
    private String soyisim;
    private char cinsiyet;
    private Integer medeni_durum_id;
    private Integer egitim_durum_id;
    private String cilt_no;
    private Integer aile_sira_no;
    private Integer sira_no;
    private Date dogum_tarihi;
//kişi iletişim
    private Integer kisi_iletisim_id;
    private BigInteger ev_telefon;
    private BigInteger cep_telefon;
    private String eposta;
//kişi adres
    private Integer kisi_adres_id;
    private String ilce;
    private Integer mahalle_id;
    private String tarif;
    private String site;
    private Integer kapi_no;
    private Integer daire_no;
    private Integer adres_no;
    private Integer evdeki_kisi_sayisi;
    private Integer mahalle_sokak_id;
//kişi yakınlar
    private Integer kisi_yakinlar_id;
    private String anne_isim;
    private String baba_isim;
    private String es_isim;
    private String es_soyisim;
    private Integer es_durum_id;

    public Kisi(BigInteger kimlik_no, String isim, String soyisim, char cinsiyet, Integer medeni_durum_id, Integer egitim_durum_id, char yabanci_kimlik, char misafir, String cilt_no, Integer aile_sıra_no, Integer sıra_no, Date dogum_tarihi, Integer kisi_iletisim_id, BigInteger ev_telefon, BigInteger cep_telefon, String eposta, Integer kisi_adres_id, String ilce, Integer mahalle, Integer cadde_sokak, String tarif, String site, Integer kapi_no, Integer daire_no, Integer adres_no, Integer evdeki_kisi_sayısı, Integer kisi_yakinlar_id, String anne_isim, String baba_isim, String es_isim, String es_soyisim, Integer es_durum_id) {
        this.kimlik_no = kimlik_no;
        this.isim = isim;
        this.soyisim = soyisim;
        this.cinsiyet = cinsiyet;
        this.medeni_durum_id = medeni_durum_id;
        this.egitim_durum_id = egitim_durum_id;
        this.cilt_no = cilt_no;
        this.aile_sira_no = aile_sıra_no;
        this.sira_no = sıra_no;
        this.dogum_tarihi = dogum_tarihi;
        this.kisi_iletisim_id = kisi_iletisim_id;
        this.ev_telefon = ev_telefon;
        this.cep_telefon = cep_telefon;
        this.eposta = eposta;
        this.kisi_adres_id = kisi_adres_id;
        this.ilce = ilce;
        this.mahalle_id = mahalle;
        this.mahalle_sokak_id = cadde_sokak;
        this.tarif = tarif;
        this.site = site;
        this.kapi_no = kapi_no;
        this.daire_no = daire_no;
        this.adres_no = adres_no;
        this.evdeki_kisi_sayisi = evdeki_kisi_sayısı;
        this.kisi_yakinlar_id = kisi_yakinlar_id;
        this.anne_isim = anne_isim;
        this.baba_isim = baba_isim;
        this.es_isim = es_isim;
        this.es_soyisim = es_soyisim;
        this.es_durum_id = es_durum_id;
    }

    public Kisi(Integer kisi_id, BigInteger kimlik_no, String isim, String soyisim, char cinsiyet, Integer medeni_durum_id, Integer egitim_durum_id, char yabanci_kimlik, char misafir, String cilt_no, Integer aile_sıra_no, Integer sıra_no, Date dogum_tarihi, Integer kisi_iletisim_id, BigInteger ev_telefon, BigInteger cep_telefon, String eposta, Integer kisi_adres_id, String ilce, Integer mahalle, Integer cadde_sokak, String tarif, String site, Integer kapi_no, Integer daire_no, Integer adres_no, Integer evdeki_kisi_sayısı, Integer kisi_yakinlar_id, String anne_isim, String baba_isim, String es_isim, String es_soyisim, Integer es_durum_id) {
        this.kisi_id = kisi_id;
        this.kimlik_no = kimlik_no;
        this.isim = isim;
        this.soyisim = soyisim;
        this.cinsiyet = cinsiyet;
        this.medeni_durum_id = medeni_durum_id;
        this.egitim_durum_id = egitim_durum_id;
        this.cilt_no = cilt_no;
        this.aile_sira_no = aile_sıra_no;
        this.sira_no = sıra_no;
        this.dogum_tarihi = dogum_tarihi;
        this.kisi_iletisim_id = kisi_iletisim_id;
        this.ev_telefon = ev_telefon;
        this.cep_telefon = cep_telefon;
        this.eposta = eposta;
        this.kisi_adres_id = kisi_adres_id;
        this.ilce = ilce;
        this.mahalle_id = mahalle;
        this.mahalle_sokak_id = cadde_sokak;
        this.tarif = tarif;
        this.site = site;
        this.kapi_no = kapi_no;
        this.daire_no = daire_no;
        this.adres_no = adres_no;
        this.evdeki_kisi_sayisi = evdeki_kisi_sayısı;
        this.kisi_yakinlar_id = kisi_yakinlar_id;
        this.anne_isim = anne_isim;
        this.baba_isim = baba_isim;
        this.es_isim = es_isim;
        this.es_soyisim = es_soyisim;
        this.es_durum_id = es_durum_id;
    }

    public Kisi() {
    }

    public Integer getKisi_id() {
        return kisi_id;
    }

    public void setKisi_id(Integer kisi_id) {
        this.kisi_id = kisi_id;
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

    public Integer getMedeni_durum_id() {
        return medeni_durum_id;
    }

    public void setMedeni_durum_id(Integer medeni_durum_id) {
        this.medeni_durum_id = medeni_durum_id;
    }

    public Integer getEgitim_durum_id() {
        return egitim_durum_id;
    }

    public void setEgitim_durum_id(Integer egitim_durum_id) {
        this.egitim_durum_id = egitim_durum_id;
    }

    public String getCilt_no() {
        return cilt_no;
    }

    public void setCilt_no(String cilt_no) {
        this.cilt_no = cilt_no;
    }

    public Integer getAile_sira_no() {
        return aile_sira_no;
    }

    public void setAile_sira_no(Integer aile_sıra_no) {
        this.aile_sira_no = aile_sıra_no;
    }

    public Integer getSira_no() {
        return sira_no;
    }

    public void setSira_no(Integer sıra_no) {
        this.sira_no = sıra_no;
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

    public void setEvdeki_kisi_sayisi(Integer evdeki_kisi_sayısı) {
        this.evdeki_kisi_sayisi = evdeki_kisi_sayısı;
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

    public Integer getEs_durum_id() {
        return es_durum_id;
    }

    public void setEs_durum(Integer es_durum_id) {
        this.es_durum_id = es_durum_id;
    }

}
