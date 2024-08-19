package Entity;

import java.util.Date;

public class KisiYakinlarStatu {

    private Integer ozel_statu_id;
    private String ozel_statu;
    private Integer aktif;
    private Date kayit_tarihi;
    private Date guncelleme_tarihi;

    public Integer getOzel_statu_id() {
        return ozel_statu_id;
    }

    public void setOzel_statu_id(Integer ozel_statu_id) {
        this.ozel_statu_id = ozel_statu_id;
    }

    public String getOzel_statu() {
        return ozel_statu;
    }

    public void setOzel_statu(String ozel_statu) {
        this.ozel_statu = ozel_statu;
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

    public Date getGuncelleme_tarihi() {
        return guncelleme_tarihi;
    }

    public void setGuncelleme_tarihi(Date guncelleme_tarihi) {
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public KisiYakinlarStatu(String ozel_statu, Integer aktif, Date kayit_tarihi, Date guncelleme_tarihi) {
        this.ozel_statu = ozel_statu;
        this.aktif = aktif;
        this.kayit_tarihi = kayit_tarihi;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public KisiYakinlarStatu() {
    }

}
