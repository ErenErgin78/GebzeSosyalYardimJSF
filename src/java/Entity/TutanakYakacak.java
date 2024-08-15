package Entity;

import java.util.Date;

public class TutanakYakacak {

    private Integer tutanak_yakacak_tip_id;
    private String yakacak_tip_isim;
    private Date kayit_tarihi;
    private Integer aktif;
    private Date guncelleme_tarihi;

    public Integer getTutanak_yakacak_tip_id() {
        return tutanak_yakacak_tip_id;
    }

    public void setTutanak_yakacak_tip_id(Integer tutanak_yakacak_tip_id) {
        this.tutanak_yakacak_tip_id = tutanak_yakacak_tip_id;
    }

    public String getYakacak_tip_isim() {
        return yakacak_tip_isim;
    }

    public void setYakacak_tip_isim(String yakacak_tip_isim) {
        this.yakacak_tip_isim = yakacak_tip_isim;
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

    public TutanakYakacak(String yakacak_tip_isim, Date kayit_tarihi, Integer aktif, Date guncelleme_tarihi) {
        this.yakacak_tip_isim = yakacak_tip_isim;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public TutanakYakacak() {
    }

}
