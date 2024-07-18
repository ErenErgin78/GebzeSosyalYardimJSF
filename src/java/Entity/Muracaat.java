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
    private Integer bolge;
    private String aciklama;
    private Date muracaat_tarihi;

    public Muracaat() {
    }
    
    public Muracaat(Integer muracaat_id, Integer kisi_temel_id, Integer muracaat_bilgi_id, Integer arsiv_dosya_no, Integer muracaat_tip_id, Integer bolge, String aciklama, Date muracaat_tarihi) {
        this.muracaat_id = muracaat_id;
        this.kisi_temel_id = kisi_temel_id;
        this.muracaat_bilgi_id = muracaat_bilgi_id;
        this.arsiv_dosya_no = arsiv_dosya_no;
        this.muracaat_tip_id = muracaat_tip_id;
        this.bolge = bolge;
        this.aciklama = aciklama;
        this.muracaat_tarihi = muracaat_tarihi;
    }

    public Muracaat(Integer kisi_temel_id, Integer muracaat_bilgi_id, Integer arsiv_dosya_no, Integer muracaat_tip_id, Integer bolge, String aciklama, Date muracaat_tarihi) {
        this.kisi_temel_id = kisi_temel_id;
        this.muracaat_bilgi_id = muracaat_bilgi_id;
        this.arsiv_dosya_no = arsiv_dosya_no;
        this.muracaat_tip_id = muracaat_tip_id;
        this.bolge = bolge;
        this.aciklama = aciklama;
        this.muracaat_tarihi = muracaat_tarihi;
    }

    public Muracaat(Integer kisi_temel_id, Integer arsiv_dosya_no, Integer muracaat_tip_id, Integer bolge, String aciklama, Date muracaat_tarihi) {
        this.kisi_temel_id = kisi_temel_id;
        this.arsiv_dosya_no = arsiv_dosya_no;
        this.muracaat_tip_id = muracaat_tip_id;
        this.bolge = bolge;
        this.aciklama = aciklama;
        this.muracaat_tarihi = muracaat_tarihi;
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

    public Integer getBolge() {
        return bolge;
    }

    public void setBolge(Integer bolge) {
        this.bolge = bolge;
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

}
