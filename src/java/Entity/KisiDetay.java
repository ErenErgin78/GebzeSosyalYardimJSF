package Entity;

import java.util.Date;

public class KisiDetay {

    private Integer detay_id;
    private Integer kisi_iletisim_id;
    private Integer kisi_adres_id;
    private Integer kisi_egitim_id;
    private Integer kisi_engel_id;
    private Integer meslek_id;
    private Date guncelleme_tarihi;
    private Integer askerlik_id;

    // Boş constructor
    public KisiDetay() {
    }

    // Tüm alanları alan constructor
    public KisiDetay(Integer detay_id, Integer kisi_iletisim_id, Integer kisi_adres_id,
            Integer kisi_egitim_id, Integer kisi_engel_id, Integer meslek_id,
            Date guncelleme_tarihi, Integer askerlik_id) {
        this.detay_id = detay_id;
        this.kisi_iletisim_id = kisi_iletisim_id;
        this.kisi_adres_id = kisi_adres_id;
        this.kisi_egitim_id = kisi_egitim_id;
        this.kisi_engel_id = kisi_engel_id;
        this.meslek_id = meslek_id;
        this.guncelleme_tarihi = guncelleme_tarihi;
        this.askerlik_id = askerlik_id;
    }

    // ID'siz constructor
    public KisiDetay(Integer kisi_iletisim_id, Integer kisi_adres_id, Integer kisi_egitim_id,
            Integer kisi_engel_id, Integer meslek_id, Date guncelleme_tarihi, Integer askerlik_id) {
        this.kisi_iletisim_id = kisi_iletisim_id;
        this.kisi_adres_id = kisi_adres_id;
        this.kisi_egitim_id = kisi_egitim_id;
        this.kisi_engel_id = kisi_engel_id;
        this.meslek_id = meslek_id;
        this.guncelleme_tarihi = guncelleme_tarihi;
        this.askerlik_id = askerlik_id;
    }

    // Getter ve Setter metodları
    public Integer getDetay_id() {
        return detay_id;
    }

    public void setDetay_id(Integer detay_id) {
        this.detay_id = detay_id;
    }

    public Integer getKisi_iletisim_id() {
        return kisi_iletisim_id;
    }

    public void setKisi_iletisim_id(Integer kisi_iletisim_id) {
        this.kisi_iletisim_id = kisi_iletisim_id;
    }

    public Integer getKisi_adres_id() {
        return kisi_adres_id;
    }

    public void setKisi_adres_id(Integer kisi_adres_id) {
        this.kisi_adres_id = kisi_adres_id;
    }

    public Integer getKisi_egitim_id() {
        return kisi_egitim_id;
    }

    public void setKisi_egitim_id(Integer kisi_egitim_id) {
        this.kisi_egitim_id = kisi_egitim_id;
    }

    public Integer getKisi_engel_id() {
        return kisi_engel_id;
    }

    public void setKisi_engel_id(Integer kisi_engel_id) {
        this.kisi_engel_id = kisi_engel_id;
    }

    public Integer getMeslek_id() {
        return meslek_id;
    }

    public void setMeslek_id(Integer meslek_id) {
        this.meslek_id = meslek_id;
    }

    public Date getGuncelleme_tarihi() {
        return guncelleme_tarihi;
    }

    public void setGuncelleme_tarihi(Date guncelleme_tarihi) {
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public Integer getAskerlik_id() {
        return askerlik_id;
    }

    public void setAskerlik_id(Integer askerlik_id) {
        this.askerlik_id = askerlik_id;
    }
}
