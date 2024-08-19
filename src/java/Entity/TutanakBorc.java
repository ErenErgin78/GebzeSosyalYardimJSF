package Entity;

import java.util.Date;

public class TutanakBorc {

    private Integer tip_id;
    private String tip;
    private Integer aktif;
    private Date kayit_tarihi;

    public Integer getTip_id() {
        return tip_id;
    }

    public void setTip_id(Integer tip_id) {
        this.tip_id = tip_id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

    public Date getKayit_tarihi() {
        return kayit_tarihi;
    }

    public void setKayit_tarihi(Date kayit_tarihi) {
        this.kayit_tarihi = kayit_tarihi;
    }

    public TutanakBorc(String tip, Integer aktif, Date kayit_tarihi) {
        this.tip = tip;
        this.aktif = aktif;
        this.kayit_tarihi = kayit_tarihi;
    }

    public TutanakBorc() {
    }

}
