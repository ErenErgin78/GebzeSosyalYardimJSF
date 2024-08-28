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
    private Date dogum_tarihi = new Date();
    private Integer medeni_durum_id;
    private String medeni_durum_isim;
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

    public String getMedeni_durum_isim() {
        return medeni_durum_isim;
    }

    public void setMedeni_durum_isim(String medeni_durum_isim) {
        this.medeni_durum_isim = medeni_durum_isim;
    }

    public Kisi(BigDecimal kimlik_no, String isim, String soyisim, String cinsiyet, Integer cilt_no, Integer aile_sira_no, Integer sira_no, Date dogum_tarihi, String medeni_durum_isim, Date kayit_tarihi, Integer aktif) {
        this.kimlik_no = kimlik_no;
        this.isim = isim;
        this.soyisim = soyisim;
        this.cinsiyet = cinsiyet;
        this.cilt_no = cilt_no;
        this.aile_sira_no = aile_sira_no;
        this.sira_no = sira_no;
        this.dogum_tarihi = dogum_tarihi;
        this.medeni_durum_isim = medeni_durum_isim;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
    }

    public Kisi() {
    }

}