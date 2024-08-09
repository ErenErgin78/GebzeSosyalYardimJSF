package Entity;

import java.util.Date;

/**
 *
 * @author Eren
 */
public class Muracaat {

    private Integer muracaat_id;
    private Integer kisi_temel_id;

    private Integer muracaat_bilgi_id;
    private Integer arsiv_dosya_no;
    private Integer muracaat_tip_id;
    private String aciklama;
    private Date muracaat_tarihi;
    private Integer aktif;
    private Date kayit_tarih;
    private Date guncelleme_tarih;

    private String muracaat_tip_isim;

    public Muracaat() {
    }

    public Muracaat(Integer kisi_temel_id, Integer muracaat_bilgi_id, Integer arsiv_dosya_no, Integer muracaat_tip_id, String aciklama, Date muracaat_tarihi, Integer aktif, String muracaat_tip_isim) {
        this.kisi_temel_id = kisi_temel_id;
        this.muracaat_bilgi_id = muracaat_bilgi_id;
        this.arsiv_dosya_no = arsiv_dosya_no;
        this.muracaat_tip_id = muracaat_tip_id;
        this.aciklama = aciklama;
        this.muracaat_tarihi = muracaat_tarihi;
        this.aktif = aktif;
        this.muracaat_tip_isim = muracaat_tip_isim;
    }

    public Integer getMuracaat_id() {
        return muracaat_id;
    }

    public void setMuracaat_id(Integer muracaat_id) {
        this.muracaat_id = muracaat_id;
    }

    public Integer getKisi_temel_id() {
        return kisi_temel_id;
    }

    public void setKisi_temel_id(Integer kisi_temel_id) {
        this.kisi_temel_id = kisi_temel_id;
    }

    public Integer getMuracaat_bilgi_id() {
        return muracaat_bilgi_id;
    }

    public void setMuracaat_bilgi_id(Integer muracaat_bilgi_id) {
        this.muracaat_bilgi_id = muracaat_bilgi_id;
    }

    public Integer getArsiv_dosya_no() {
        return arsiv_dosya_no;
    }

    public void setArsiv_dosya_no(Integer arsiv_dosya_no) {
        this.arsiv_dosya_no = arsiv_dosya_no;
    }

    public Integer getMuracaat_tip_id() {
        return muracaat_tip_id;
    }

    public void setMuracaat_tip_id(Integer muracaat_tip_id) {
        this.muracaat_tip_id = muracaat_tip_id;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Date getMuracaat_tarihi() {
        return muracaat_tarihi;
    }

    public void setMuracaat_tarihi(Date muracaat_tarihi) {
        this.muracaat_tarihi = muracaat_tarihi;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

    public Date getKayit_tarih() {
        return kayit_tarih;
    }

    public void setKayit_tarih(Date kayit_tarih) {
        this.kayit_tarih = kayit_tarih;
    }

    public Date getGuncelleme_tarih() {
        return guncelleme_tarih;
    }

    public void setGuncelleme_tarih(Date guncelleme_tarih) {
        this.guncelleme_tarih = guncelleme_tarih;
    }

    public String getMuracaat_tip_isim() {
        return muracaat_tip_isim;
    }

    public void setMuracaat_tip_isim(String muracaat_tip_isim) {
        this.muracaat_tip_isim = muracaat_tip_isim;
    }

}
