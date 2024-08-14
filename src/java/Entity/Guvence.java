package Entity;

import java.util.Date;

public class Guvence {

    private Integer guvence_id;
    private String guvence;
    private Date kayit_tarihi;
    private Integer aktif;
    private Date guncelleme_tarihi;

    public Integer getGuvence_id() {
        return guvence_id;
    }

    public void setGuvence_id(Integer guvence_id) {
        this.guvence_id = guvence_id;
    }

    public String getGuvence() {
        return guvence;
    }

    public void setGuvence(String guvence) {
        this.guvence = guvence;
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

    public Guvence(String guvence, Date kayit_tarihi, Integer aktif, Date guncelleme_tarihi) {
        this.guvence = guvence;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public Guvence() {
    }

}
