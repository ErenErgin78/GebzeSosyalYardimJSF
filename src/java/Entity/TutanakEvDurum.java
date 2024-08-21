package Entity;

import java.util.Date;

public class TutanakEvDurum {

    private Integer ev_durum_id;
    private String durum;
    private Date kayit_tarihi;
    private Integer aktif;
    private Integer ekleyen_kisi_id;

    public Integer getEv_durum_id() {
        return ev_durum_id;
    }

    public void setEv_durum_id(Integer ev_durum_id) {
        this.ev_durum_id = ev_durum_id;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
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

    public Integer getEkleyen_kisi_id() {
        return ekleyen_kisi_id;
    }

    public void setEkleyen_kisi_id(Integer ekleyen_kisi_id) {
        this.ekleyen_kisi_id = ekleyen_kisi_id;
    }

    public TutanakEvDurum(String durum, Date kayit_tarihi, Integer aktif) {
        this.durum = durum;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
    }

    public TutanakEvDurum() {
    }

}
