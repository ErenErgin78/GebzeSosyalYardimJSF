package Entity;

import java.util.Date;

public class TutanakEvTip {

    private Integer tutanak_ev_tip_id;
    private String ev_tip_isim;
    private Date kayit_tarihi;
    private Integer aktif;
    private Date guncelleme_tarihi;

    public Integer getTutanak_ev_tip_id() {
        return tutanak_ev_tip_id;
    }

    public void setTutanak_ev_tip_id(Integer tutanak_ev_tip_id) {
        this.tutanak_ev_tip_id = tutanak_ev_tip_id;
    }

    public String getEv_tip_isim() {
        return ev_tip_isim;
    }

    public void setEv_tip_isim(String ev_tip_isim) {
        this.ev_tip_isim = ev_tip_isim;
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

    public TutanakEvTip(String ev_tip_isim, Date kayit_tarihi, Integer aktif, Date guncelleme_tarihi) {
        this.ev_tip_isim = ev_tip_isim;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public TutanakEvTip() {
    }

}
