package Entity;

import java.math.BigInteger;

public class EngelliBilgi {

    private Integer muracaat_no;
    private String muracaat_eden_kisi;
    private Integer kisi_iletisim_id;
    private BigInteger ev_tel;
    private BigInteger cep_tel;
    private Integer kimlik_no;
    private String isim;
    private String soyisim;

    private String engelli_tip_isim;
    private String engelli_alt_tip_isim;
    private Integer engelli_tip_id;
    private Integer engelli_alt_tip_id;

    private Integer mahalle_id;
    private Integer mahalle_sokak_id;
    private String mahalle_isim;
    private String mahalle_sokak_isim;

    private String site;
    private Integer kapi_no;
    private Integer daire_no;

    private Integer egitim_durum_id;
    private String egitim_durum_isim;
    private Integer derece;
    private String engel_baslangic;

    public Integer getMuracaat_no() {
        return muracaat_no;
    }

    public void setMuracaat_no(Integer muracaat_no) {
        this.muracaat_no = muracaat_no;
    }

    public String getMuracaat_eden_kisi() {
        return muracaat_eden_kisi;
    }

    public void setMuracaat_eden_kisi(String muracaat_eden_kisi) {
        this.muracaat_eden_kisi = muracaat_eden_kisi;
    }

    public Integer getKisi_iletisim_id() {
        return kisi_iletisim_id;
    }

    public void setKisi_iletisim_id(Integer kisi_iletisim_id) {
        this.kisi_iletisim_id = kisi_iletisim_id;
    }

    public BigInteger getEv_tel() {
        return ev_tel;
    }

    public void setEv_tel(BigInteger ev_tel) {
        this.ev_tel = ev_tel;
    }

    public BigInteger getCep_tel() {
        return cep_tel;
    }

    public void setCep_tel(BigInteger cep_tel) {
        this.cep_tel = cep_tel;
    }

    public Integer getKimlik_no() {
        return kimlik_no;
    }

    public void setKimlik_no(Integer kimlik_no) {
        this.kimlik_no = kimlik_no;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getEngelli_tip_isim() {
        return engelli_tip_isim;
    }

    public void setEngelli_tip_isim(String engelli_tip_isim) {
        this.engelli_tip_isim = engelli_tip_isim;
    }

    public String getEngelli_alt_tip_isim() {
        return engelli_alt_tip_isim;
    }

    public void setEngelli_alt_tip_isim(String engelli_alt_tip_isim) {
        this.engelli_alt_tip_isim = engelli_alt_tip_isim;
    }

    public Integer getEngelli_tip_id() {
        return engelli_tip_id;
    }

    public void setEngelli_tip_id(Integer engelli_tip_id) {
        this.engelli_tip_id = engelli_tip_id;
    }

    public Integer getEngelli_alt_tip_id() {
        return engelli_alt_tip_id;
    }

    public void setEngelli_alt_tip_id(Integer engelli_alt_tip_id) {
        this.engelli_alt_tip_id = engelli_alt_tip_id;
    }

    public Integer getMahalle_id() {
        return mahalle_id;
    }

    public void setMahalle_id(Integer mahalle_id) {
        this.mahalle_id = mahalle_id;
    }

    public Integer getMahalle_sokak_id() {
        return mahalle_sokak_id;
    }

    public void setMahalle_sokak_id(Integer mahalle_sokak_id) {
        this.mahalle_sokak_id = mahalle_sokak_id;
    }

    public String getMahalle_isim() {
        return mahalle_isim;
    }

    public void setMahalle_isim(String mahalle_isim) {
        this.mahalle_isim = mahalle_isim;
    }

    public String getMahalle_sokak_isim() {
        return mahalle_sokak_isim;
    }

    public void setMahalle_sokak_isim(String mahalle_sokak_isim) {
        this.mahalle_sokak_isim = mahalle_sokak_isim;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Integer getKapi_no() {
        return kapi_no;
    }

    public void setKapi_no(Integer kapi_no) {
        this.kapi_no = kapi_no;
    }

    public Integer getDaire_no() {
        return daire_no;
    }

    public void setDaire_no(Integer daire_no) {
        this.daire_no = daire_no;
    }

    public Integer getEgitim_durum_id() {
        return egitim_durum_id;
    }

    public void setEgitim_durum_id(Integer egitim_durum_id) {
        this.egitim_durum_id = egitim_durum_id;
    }

    public String getEgitim_durum_isim() {
        return egitim_durum_isim;
    }

    public void setEgitim_durum_isim(String egitim_durum_isim) {
        this.egitim_durum_isim = egitim_durum_isim;
    }

    public Integer getDerece() {
        return derece;
    }

    public void setDerece(Integer derece) {
        this.derece = derece;
    }

    public String getEngel_baslangic() {
        return engel_baslangic;
    }

    public void setEngel_baslangic(String engel_baslangic) {
        this.engel_baslangic = engel_baslangic;
    }

    public EngelliBilgi(Integer muracaat_no, String muracaat_eden_kisi, BigInteger ev_tel, BigInteger cep_tel, Integer kimlik_no, String isim, String soyisim, String engelli_tip_isim, String engelli_alt_tip_isim, String mahalle_isim, String mahalle_sokak_isim, String site, Integer kapi_no, Integer daire_no, String egitim_durum_isim, Integer derece, String engel_baslangic) {
        this.muracaat_no = muracaat_no;
        this.muracaat_eden_kisi = muracaat_eden_kisi;
        this.ev_tel = ev_tel;
        this.cep_tel = cep_tel;
        this.kimlik_no = kimlik_no;
        this.isim = isim;
        this.soyisim = soyisim;
        this.engelli_tip_isim = engelli_tip_isim;
        this.engelli_alt_tip_isim = engelli_alt_tip_isim;
        this.mahalle_isim = mahalle_isim;
        this.mahalle_sokak_isim = mahalle_sokak_isim;
        this.site = site;
        this.kapi_no = kapi_no;
        this.daire_no = daire_no;
        this.egitim_durum_isim = egitim_durum_isim;
        this.derece = derece;
        this.engel_baslangic = engel_baslangic;
    }

    public EngelliBilgi() {
    }

}
