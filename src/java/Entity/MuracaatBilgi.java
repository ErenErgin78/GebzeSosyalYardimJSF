package Entity;

import java.util.Date;

/**
 *
 * @author Eren
 */
public class MuracaatBilgi {

    private Integer muracaat_bilgi_id;
    private Integer arsiv_dosya_no;
    private String aciklama;
    private Date muracaat_tarihi = new Date();
    private Integer aktif;
    private Date kayit_tarih;
    private Date guncelleme_tarih;

    public MuracaatBilgi() {
    }

    public MuracaatBilgi(Integer arsiv_dosya_no, String aciklama, Date muracaat_tarihi, Integer aktif) {
        this.arsiv_dosya_no = arsiv_dosya_no;
        this.aciklama = aciklama;
        this.muracaat_tarihi = muracaat_tarihi;
        this.aktif = aktif;
    }

    public MuracaatBilgi(Integer arsiv_dosya_no, String aciklama, Date muracaat_tarihi, Integer aktif, Date kayit_tarih, Date guncelleme_tarih) {
        this.arsiv_dosya_no = arsiv_dosya_no;
        this.aciklama = aciklama;
        this.muracaat_tarihi = muracaat_tarihi;
        this.aktif = aktif;
        this.kayit_tarih = kayit_tarih;
        this.guncelleme_tarih = guncelleme_tarih;
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
}
