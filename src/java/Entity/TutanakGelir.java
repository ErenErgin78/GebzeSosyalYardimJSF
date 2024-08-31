package Entity;

import java.util.Date;

public class TutanakGelir {

    private Integer gelir_id;
    private float yaslilik = 0;
    private float engelli = 0;
    private float engelli_yakini = 0;
    private float yetim_ayligi = 0;
    private float emekli_maasi = 0;
    private float evde_bakim_parasi = 0;
    private float dul_maasi = 0;
    private float issizlik_maasi = 0;
    private float asker_maasi = 0;
    private float kira_maasi = 0;
    private float kaymakamlik = 0;
    private float sosyal_hizmetler = 0;
    private float buyuksehir = 0;
    private float ozel_vakif = 0;
    private float diger = 0;
    private String diger_aciklama = "";
    private Integer aktif = 0;
    private Date kayit_tarihi;
    private Date guncelleme_tarihi;

    public TutanakGelir(Integer gelir_id, float yaslilik, float engelli, float engelli_yakini, float yetim_ayligi, float emekli_maasi, float evde_bakim_parasi, float dul_maasi, float issizlik_maasi, float asker_maasi, float kira_maasi, float kaymakamlik, float sosyal_hizmetler, float buyuksehir, float ozel_vakif, float diger, String diger_aciklama, Integer aktif, Date kayit_tarihi, Date guncelleme_tarihi) {
        this.gelir_id = gelir_id;
        this.yaslilik = yaslilik;
        this.engelli = engelli;
        this.engelli_yakini = engelli_yakini;
        this.yetim_ayligi = yetim_ayligi;
        this.emekli_maasi = emekli_maasi;
        this.evde_bakim_parasi = evde_bakim_parasi;
        this.dul_maasi = dul_maasi;
        this.issizlik_maasi = issizlik_maasi;
        this.asker_maasi = asker_maasi;
        this.kira_maasi = kira_maasi;
        this.kaymakamlik = kaymakamlik;
        this.sosyal_hizmetler = sosyal_hizmetler;
        this.buyuksehir = buyuksehir;
        this.ozel_vakif = ozel_vakif;
        this.diger = diger;
        this.diger_aciklama = diger_aciklama;
        this.aktif = aktif;
        this.kayit_tarihi = kayit_tarihi;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public TutanakGelir() {
    }

    public TutanakGelir(float yaslilik, float engelli, float engelli_yakini, float yetim_ayligi, float emekli_maasi, float evde_bakim_parasi, float dul_maasi, float issizlik_maasi, float asker_maasi, float kira_maasi, float kaymakamlik, float sosyal_hizmetler, float buyuksehir, float ozel_vakif, float diger, String diger_aciklama, Integer aktif, Date kayit_tarihi, Date guncelleme_tarihi) {
        this.yaslilik = yaslilik;
        this.engelli = engelli;
        this.engelli_yakini = engelli_yakini;
        this.yetim_ayligi = yetim_ayligi;
        this.emekli_maasi = emekli_maasi;
        this.evde_bakim_parasi = evde_bakim_parasi;
        this.dul_maasi = dul_maasi;
        this.issizlik_maasi = issizlik_maasi;
        this.asker_maasi = asker_maasi;
        this.kira_maasi = kira_maasi;
        this.kaymakamlik = kaymakamlik;
        this.sosyal_hizmetler = sosyal_hizmetler;
        this.buyuksehir = buyuksehir;
        this.ozel_vakif = ozel_vakif;
        this.diger = diger;
        this.diger_aciklama = diger_aciklama;
        this.aktif = aktif;
        this.kayit_tarihi = kayit_tarihi;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public Integer getGelir_id() {
        return gelir_id;
    }

    public void setGelir_id(Integer gelir_id) {
        this.gelir_id = gelir_id;
    }

    public float getYaslilik() {
        return yaslilik;
    }

    public void setYaslilik(float yaslilik) {
        this.yaslilik = yaslilik;
    }

    public float getEngelli() {
        return engelli;
    }

    public void setEngelli(float engelli) {
        this.engelli = engelli;
    }

    public float getEngelli_yakini() {
        return engelli_yakini;
    }

    public void setEngelli_yakini(float engelli_yakini) {
        this.engelli_yakini = engelli_yakini;
    }

    public float getYetim_ayligi() {
        return yetim_ayligi;
    }

    public void setYetim_ayligi(float yetim_ayligi) {
        this.yetim_ayligi = yetim_ayligi;
    }

    public float getEmekli_maasi() {
        return emekli_maasi;
    }

    public void setEmekli_maasi(float emekli_maasi) {
        this.emekli_maasi = emekli_maasi;
    }

    public float getEvde_bakim_parasi() {
        return evde_bakim_parasi;
    }

    public void setEvde_bakim_parasi(float evde_bakim_parasi) {
        this.evde_bakim_parasi = evde_bakim_parasi;
    }

    public float getDul_maasi() {
        return dul_maasi;
    }

    public void setDul_maasi(float dul_maasi) {
        this.dul_maasi = dul_maasi;
    }

    public float getIssizlik_maasi() {
        return issizlik_maasi;
    }

    public void setIssizlik_maasi(float issizlik_maasi) {
        this.issizlik_maasi = issizlik_maasi;
    }

    public float getAsker_maasi() {
        return asker_maasi;
    }

    public void setAsker_maasi(float asker_maasi) {
        this.asker_maasi = asker_maasi;
    }

    public float getKira_maasi() {
        return kira_maasi;
    }

    public void setKira_maasi(float kira_maasi) {
        this.kira_maasi = kira_maasi;
    }

    public float getKaymakamlik() {
        return kaymakamlik;
    }

    public void setKaymakamlik(float kaymakamlik) {
        this.kaymakamlik = kaymakamlik;
    }

    public float getSosyal_hizmetler() {
        return sosyal_hizmetler;
    }

    public void setSosyal_hizmetler(float sosyal_hizmetler) {
        this.sosyal_hizmetler = sosyal_hizmetler;
    }

    public float getBuyuksehir() {
        return buyuksehir;
    }

    public void setBuyuksehir(float buyuksehir) {
        this.buyuksehir = buyuksehir;
    }

    public float getOzel_vakif() {
        return ozel_vakif;
    }

    public void setOzel_vakif(float ozel_vakif) {
        this.ozel_vakif = ozel_vakif;
    }

    public float getDiger() {
        return diger;
    }

    public void setDiger(float diger) {
        this.diger = diger;
    }

    public String getDiger_aciklama() {
        return diger_aciklama;
    }

    public void setDiger_aciklama(String diger_aciklama) {
        this.diger_aciklama = diger_aciklama;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

    public Date getKayit_tarihi() {
        return kayit_tarihi;
    }

    public void setKayit_tarihi(Date kayit_tarihi) {
        this.kayit_tarihi = kayit_tarihi;
    }

    public Date getGuncelleme_tarihi() {
        return guncelleme_tarihi;
    }

    public void setGuncelleme_tarihi(Date guncelleme_tarihi) {
        this.guncelleme_tarihi = guncelleme_tarihi;
    }
}