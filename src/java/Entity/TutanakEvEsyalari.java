package Entity;

import java.util.Date;

public class TutanakEvEsyalari {

    private Integer esyalar_id;
    private Integer kisi_id;
    private String kisi_isim;
    private Integer esya_id;
    private String esya_isim;
    private Date guncelleme_tarihi;
    private Integer aktiflik;

    public Integer getEsyalar_id() {
        return esyalar_id;
    }

    public void setEsyalar_id(Integer esyalar_id) {
        this.esyalar_id = esyalar_id;
    }

    public Integer getKisi_id() {
        return kisi_id;
    }

    public void setKisi_id(Integer kisi_id) {
        this.kisi_id = kisi_id;
    }

    public String getKisi_isim() {
        return kisi_isim;
    }

    public void setKisi_isim(String kisi_isim) {
        this.kisi_isim = kisi_isim;
    }

    public Integer getEsya_id() {
        return esya_id;
    }

    public void setEsya_id(Integer esya_id) {
        this.esya_id = esya_id;
    }

    public String getEsya_isim() {
        return esya_isim;
    }

    public void setEsya_isim(String esya_isim) {
        this.esya_isim = esya_isim;
    }

    public Date getGuncelleme_tarihi() {
        return guncelleme_tarihi;
    }

    public void setGuncelleme_tarihi(Date guncelleme_tarihi) {
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public Integer getAktiflik() {
        return aktiflik;
    }

    public void setAktiflik(Integer aktiflik) {
        this.aktiflik = aktiflik;
    }

    public TutanakEvEsyalari(String kisi_isim, String esya_isim, Date guncelleme_tarihi, Integer aktiflik) {
        this.kisi_isim = kisi_isim;
        this.esya_isim = esya_isim;
        this.guncelleme_tarihi = guncelleme_tarihi;
        this.aktiflik = aktiflik;
    }

    public TutanakEvEsyalari() {
    }

}
