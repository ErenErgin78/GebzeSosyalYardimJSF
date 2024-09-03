package Entity;

import java.util.Date;

public class GuvenceBirim {

    private Integer birim_id;
    private String birim_isim;
    private Date guncelleme_tarihi;

    public Integer getBirim_id() {
        return birim_id;
    }

    public void setBirim_id(Integer birim_id) {
        this.birim_id = birim_id;
    }

    public String getBirim_isim() {
        return birim_isim;
    }

    public void setBirim_isim(String birim_isim) {
        this.birim_isim = birim_isim;
    }

    public Date getGuncelleme_tarihi() {
        return guncelleme_tarihi;
    }

    public void setGuncelleme_tarihi(Date guncelleme_tarihi) {
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public GuvenceBirim(String birim_isim, Date guncelleme_tarihi) {
        this.birim_isim = birim_isim;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public GuvenceBirim() {
    }

}
