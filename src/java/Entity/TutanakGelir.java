/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author casper
 */
public class TutanakGelir {

    private Integer gelir_id;
    private Integer yaslilik;
    private Integer Engelli;
    private Integer engelli_yakini;
    private Integer yetim_ayligi;
    private Integer emekli_maasi;
    private Integer evde_bakim_parasi;
    private Integer dul_maasi;
    private Integer issizlik_maasi;
    private Integer asker_maasi;
    private Integer kira_maasi;
    private Integer kaymakamlik;
    private Integer sosyal_hizmetler;
    private Integer buyuksehir;
    private Integer ozel_vakif;
    private Integer diger;
    private Integer aktif;
    private Date kayit_tarihi;
    private Date guncelleme_tarihi;

    public TutanakGelir(Integer gelir_id, Integer yaslilik, Integer Engelli, Integer engelli_yakini, Integer yetim_ayligi, Integer emekli_maasi, Integer evde_bakim_parasi, Integer dul_maasi, Integer issizlik_maasi, Integer asker_maasi, Integer kira_maasi, Integer kaymakamlik, Integer sosyal_hizmetler, Integer buyuksehir, Integer ozel_vakif, Integer diger, Integer aktif, Date kayit_tarihi, Date guncelleme_tarihi) {
        this.gelir_id = gelir_id;
        this.yaslilik = yaslilik;
        this.Engelli = Engelli;
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
        this.aktif = aktif;
        this.kayit_tarihi = kayit_tarihi;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public TutanakGelir() {
    }

    public TutanakGelir(Integer yaslilik, Integer Engelli, Integer engelli_yakini, Integer yetim_ayligi, Integer emekli_maasi, Integer evde_bakim_parasi, Integer dul_maasi, Integer issizlik_maasi, Integer asker_maasi, Integer kira_maasi, Integer kaymakamlik, Integer sosyal_hizmetler, Integer buyuksehir, Integer ozel_vakif, Integer diger, Integer aktif) {
        this.yaslilik = yaslilik;
        this.Engelli = Engelli;
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
        this.aktif = aktif;
    }

    public Integer getGelir_id() {
        return gelir_id;
    }

    public void setGelir_id(Integer gelir_id) {
        this.gelir_id = gelir_id;
    }

    public Integer getYaslilik() {
        return yaslilik;
    }

    public void setYaslilik(Integer yaslilik) {
        this.yaslilik = yaslilik;
    }

    public Integer getEngelli() {
        return Engelli;
    }

    public void setEngelli(Integer Engelli) {
        this.Engelli = Engelli;
    }

    public Integer getEngelli_yakini() {
        return engelli_yakini;
    }

    public void setEngelli_yakini(Integer engelli_yakini) {
        this.engelli_yakini = engelli_yakini;
    }

    public Integer getYetim_ayligi() {
        return yetim_ayligi;
    }

    public void setYetim_ayligi(Integer yetim_ayligi) {
        this.yetim_ayligi = yetim_ayligi;
    }

    public Integer getEmekli_maasi() {
        return emekli_maasi;
    }

    public void setEmekli_maasi(Integer emekli_maasi) {
        this.emekli_maasi = emekli_maasi;
    }

    public Integer getEvde_bakim_parasi() {
        return evde_bakim_parasi;
    }

    public void setEvde_bakim_parasi(Integer evde_bakim_parasi) {
        this.evde_bakim_parasi = evde_bakim_parasi;
    }

    public Integer getDul_maasi() {
        return dul_maasi;
    }

    public void setDul_maasi(Integer dul_maasi) {
        this.dul_maasi = dul_maasi;
    }

    public Integer getIssizlik_maasi() {
        return issizlik_maasi;
    }

    public void setIssizlik_maasi(Integer issizlik_maasi) {
        this.issizlik_maasi = issizlik_maasi;
    }

    public Integer getAsker_maasi() {
        return asker_maasi;
    }

    public void setAsker_maasi(Integer asker_maasi) {
        this.asker_maasi = asker_maasi;
    }

    public Integer getKira_maasi() {
        return kira_maasi;
    }

    public void setKira_maasi(Integer kira_maasi) {
        this.kira_maasi = kira_maasi;
    }

    public Integer getKaymakamlik() {
        return kaymakamlik;
    }

    public void setKaymakamlik(Integer kaymakamlik) {
        this.kaymakamlik = kaymakamlik;
    }

    public Integer getSosyal_hizmetler() {
        return sosyal_hizmetler;
    }

    public void setSosyal_hizmetler(Integer sosyal_hizmetler) {
        this.sosyal_hizmetler = sosyal_hizmetler;
    }

    public Integer getBuyuksehir() {
        return buyuksehir;
    }

    public void setBuyuksehir(Integer buyuksehir) {
        this.buyuksehir = buyuksehir;
    }

    public Integer getOzel_vakif() {
        return ozel_vakif;
    }

    public void setOzel_vakif(Integer ozel_vakif) {
        this.ozel_vakif = ozel_vakif;
    }

    public Integer getDiger() {
        return diger;
    }

    public void setDiger(Integer diger) {
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

}
