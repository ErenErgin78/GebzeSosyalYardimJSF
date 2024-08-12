package Entity;

import java.util.Date;

public class TutanakGelir {

    private Integer gelir_id;
    private Float yaslilik;
    private Float engelli;
    private Float engelli_yakini;
    private Float yetim_ayligi;
    private Float emekli_maasi;
    private Float evde_bakim_parasi;
    private Float dul_maasi;
    private Float issizlik_maasi;
    private Float asker_maasi;
    private Float kira_maasi;
    private Float kaymakamlik;
    private Float sosyal_hizmetler;
    private Float buyuksehir;
    private Float ozel_vakif;
    private Float diger;
    private Float diger_aciklama;
    private Integer aktif;
    private Date kayit_tarihi;
    private Date guncelleme_tarihi;

    public TutanakGelir(Integer gelir_id, Float yaslilik, Float engelli, Float engelli_yakini, Float yetim_ayligi, Float emekli_maasi, Float evde_bakim_parasi, Float dul_maasi, Float issizlik_maasi, Float asker_maasi, Float kira_maasi, Float kaymakamlik, Float sosyal_hizmetler, Float buyuksehir, Float ozel_vakif, Float diger, Float diger_aciklama, Integer aktif, Date kayit_tarihi, Date guncelleme_tarihi) {
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
        this.diger = diger_aciklama;
        this.aktif = aktif;
        this.kayit_tarihi = kayit_tarihi;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public TutanakGelir() {
    }

    public TutanakGelir(Float yaslilik, Float engelli, Float engelli_yakini, Float yetim_ayligi, Float emekli_maasi, Float evde_bakim_parasi, Float dul_maasi, Float issizlik_maasi, Float asker_maasi, Float kira_maasi, Float kaymakamlik, Float sosyal_hizmetler, Float buyuksehir, Float ozel_vakif, Float diger, Float diger_aciklama, Integer aktif) {
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
        this.diger = diger_aciklama;
        this.aktif = aktif;
    }

    public Integer getGelir_id() {
        return gelir_id;
    }

    public void setGelir_id(Integer gelir_id) {
        this.gelir_id = gelir_id;
    }

    public Float getYaslilik() {
        return yaslilik;
    }

    public void setYaslilik(Float yaslilik) {
        this.yaslilik = yaslilik;
    }

    public Float getEngelli() {
        return engelli;
    }

    public void setEngelli(Float engelli) {
        this.engelli = engelli;
    }

    public Float getEngelli_yakini() {
        return engelli_yakini;
    }

    public void setEngelli_yakini(Float engelli_yakini) {
        this.engelli_yakini = engelli_yakini;
    }

    public Float getYetim_ayligi() {
        return yetim_ayligi;
    }

    public void setYetim_ayligi(Float yetim_ayligi) {
        this.yetim_ayligi = yetim_ayligi;
    }

    public Float getEmekli_maasi() {
        return emekli_maasi;
    }

    public void setEmekli_maasi(Float emekli_maasi) {
        this.emekli_maasi = emekli_maasi;
    }

    public Float getEvde_bakim_parasi() {
        return evde_bakim_parasi;
    }

    public void setEvde_bakim_parasi(Float evde_bakim_parasi) {
        this.evde_bakim_parasi = evde_bakim_parasi;
    }

    public Float getDul_maasi() {
        return dul_maasi;
    }

    public void setDul_maasi(Float dul_maasi) {
        this.dul_maasi = dul_maasi;
    }

    public Float getIssizlik_maasi() {
        return issizlik_maasi;
    }

    public void setIssizlik_maasi(Float issizlik_maasi) {
        this.issizlik_maasi = issizlik_maasi;
    }

    public Float getAsker_maasi() {
        return asker_maasi;
    }

    public void setAsker_maasi(Float asker_maasi) {
        this.asker_maasi = asker_maasi;
    }

    public Float getKira_maasi() {
        return kira_maasi;
    }

    public void setKira_maasi(Float kira_maasi) {
        this.kira_maasi = kira_maasi;
    }

    public Float getKaymakamlik() {
        return kaymakamlik;
    }

    public void setKaymakamlik(Float kaymakamlik) {
        this.kaymakamlik = kaymakamlik;
    }

    public Float getSosyal_hizmetler() {
        return sosyal_hizmetler;
    }

    public void setSosyal_hizmetler(Float sosyal_hizmetler) {
        this.sosyal_hizmetler = sosyal_hizmetler;
    }

    public Float getBuyuksehir() {
        return buyuksehir;
    }

    public void setBuyuksehir(Float buyuksehir) {
        this.buyuksehir = buyuksehir;
    }

    public Float getOzel_vakif() {
        return ozel_vakif;
    }

    public void setOzel_vakif(Float ozel_vakif) {
        this.ozel_vakif = ozel_vakif;
    }

    public Float getDiger() {
        return diger;
    }

    public void setDiger(Float diger) {
        this.diger = diger;
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

    public Float getDiger_aciklama() {
        return diger_aciklama;
    }

    public void setDiger_aciklama(Float diger_aciklama) {
        this.diger_aciklama = diger_aciklama;
    }
    
}
