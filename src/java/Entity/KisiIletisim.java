package Entity;

import java.math.BigInteger;
import java.util.Date;

public class KisiIletisim {

    private Integer kisi_iletisim_id;
    private BigInteger ev_telefon;
    private BigInteger cep_telefon;
    private String eposta;
    private Date kayit_tarihi;
    private Integer aktif;
    private Date guncelleme_tarihi;

    public Integer getKisi_iletisim_id() {
        return kisi_iletisim_id;
    }

    public void setKisi_iletisim_id(Integer kisi_iletisim_id) {
        this.kisi_iletisim_id = kisi_iletisim_id;
    }

    public BigInteger getEv_telefon() {
        return ev_telefon;
    }

    public void setEv_telefon(BigInteger ev_telefon) {
        this.ev_telefon = ev_telefon;
    }

    public BigInteger getCep_telefon() {
        return cep_telefon;
    }

    public void setCep_telefon(BigInteger cep_telefon) {
        this.cep_telefon = cep_telefon;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
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

    public KisiIletisim(BigInteger ev_telefon, BigInteger cep_telefon, String eposta, Date kayit_tarihi, Integer aktif, Date guncelleme_tarihi) {
        this.ev_telefon = ev_telefon;
        this.cep_telefon = cep_telefon;
        this.eposta = eposta;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public KisiIletisim() {
    }

}
