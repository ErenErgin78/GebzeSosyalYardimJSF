package Entity;

import java.util.Date;

public class MedeniDurum {

    private Integer medeni_durum_id;
    private String medeni_durum;
    private Date kayit_tarihi;
    private Integer aktif;
    private Date guncelleme_tarihi;

    public Integer getMedeni_durum_id() {
        return medeni_durum_id;
    }

    public void setMedeni_durum_id(Integer medeni_durum_id) {
        this.medeni_durum_id = medeni_durum_id;
    }

    public String getMedeni_durum() {
        return medeni_durum;
    }

    public void setMedeni_durum(String medeni_durum) {
        this.medeni_durum = medeni_durum;
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

    public MedeniDurum(String medeni_durum, Date kayit_tarihi, Integer aktif, Date guncelleme_tarihi) {
        this.medeni_durum = medeni_durum;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public MedeniDurum() {
    }

}
