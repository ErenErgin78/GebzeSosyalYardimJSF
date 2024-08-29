package Entity;

import java.util.Date;

public class YardimTur {

    private Integer tur_id;
    private String tur;
    private Date kayit_tarihi;
    private Integer aktif;

    public Integer getTur_id() {
        return tur_id;
    }

    public void setTur_id(Integer tur_id) {
        this.tur_id = tur_id;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
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

    public YardimTur(Integer tur_id, String tur, Date kayit_tarihi, Integer aktif) {
        this.tur_id = tur_id;
        this.tur = tur;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
    }

    public YardimTur() {
    }
}
