package Entity;

import java.util.Date;

public class TutanakSosyalGuvence {

    private Integer sosyal_guvence_id;
    private Integer guvence_var_mi = 0;
    private Integer guvence_id;
    private Integer birim_id;
    private String birim_aciklama;
    private Date guncelleme_tarihi;

    public TutanakSosyalGuvence() {
    }

    public TutanakSosyalGuvence(Integer sosyal_guvence_id, Integer guvence_var_mi, Integer guvence_id, Integer birim_id, String birim_aciklama, Date guncelleme_tarihi) {
        this.sosyal_guvence_id = sosyal_guvence_id;
        this.guvence_var_mi = guvence_var_mi;
        this.guvence_id = guvence_id;
        this.birim_id = birim_id;
        this.birim_aciklama = birim_aciklama;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public Integer getSosyal_guvence_id() {
        return sosyal_guvence_id;
    }

    public void setSosyal_guvence_id(Integer sosyal_guvence_id) {
        this.sosyal_guvence_id = sosyal_guvence_id;
    }

    public Integer getGuvence_var_mi() {
        return guvence_var_mi;
    }

    public void setGuvence_var_mi(Integer guvence_var_mi) {
        this.guvence_var_mi = guvence_var_mi;
    }

    public Integer getGuvence_id() {
        return guvence_id;
    }

    public void setGuvence_id(Integer guvence_id) {
        this.guvence_id = guvence_id;
    }

    public Integer getBirim_id() {
        return birim_id;
    }

    public void setBirim_id(Integer birim_id) {
        this.birim_id = birim_id;
    }

    public String getBirim_aciklama() {
        return birim_aciklama;
    }

    public void setBirim_aciklama(String birim_aciklama) {
        this.birim_aciklama = birim_aciklama;
    }

    public Date getGuncelleme_tarihi() {
        return guncelleme_tarihi;
    }

    public void setGuncelleme_tarihi(Date guncelleme_tarihi) {
        this.guncelleme_tarihi = guncelleme_tarihi;
    }
}
