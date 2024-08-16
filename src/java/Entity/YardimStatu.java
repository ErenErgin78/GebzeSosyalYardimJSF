package Entity;

import java.util.Date;

public class YardimStatu {

    private Integer statu_id;
    private String statu_isim;
    private Date kayit_tarihi;
    private Integer aktif;
    private Date guncelleme_tarihi;

    public Integer getStatu_id() {
        return statu_id;
    }

    public void setStatu_id(Integer statu_id) {
        this.statu_id = statu_id;
    }

    public String getStatu_isim() {
        return statu_isim;
    }

    public void setStatu_isim(String statu_isim) {
        this.statu_isim = statu_isim;
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

    public YardimStatu(String statu_isim, Date kayit_tarihi, Integer aktif, Date guncelleme_tarihi) {
        this.statu_isim = statu_isim;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public YardimStatu() {
    }

}
