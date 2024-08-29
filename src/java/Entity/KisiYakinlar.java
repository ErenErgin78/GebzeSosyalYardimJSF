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
public class KisiYakinlar {

    private Integer yakinlar_id;
    private Integer kisi_id;
    private Integer ozel_statu_id;
    private Date olum_tarihi;
    private Date kayit_tarihi;
    private Date guncelleme_tarihi;
    private Integer yakin_id;
    private Integer yakinlik_id;

    private String kisi_isim;
    private String ozel_statu_isim;
    private String yakin_isim;
    private String yakinlik_isim;

    public KisiYakinlar(Integer yakinlar_id, Integer kisi_id, Integer ozel_statu_id, Date olum_tarihi, Date kayit_tarihi, Date guncelleme_tarihi, Integer yakin_id, Integer yakinlik_id) {
        this.yakinlar_id = yakinlar_id;
        this.kisi_id = kisi_id;
        this.ozel_statu_id = ozel_statu_id;
        this.olum_tarihi = olum_tarihi;
        this.kayit_tarihi = kayit_tarihi;
        this.guncelleme_tarihi = guncelleme_tarihi;
        this.yakin_id = yakin_id;
        this.yakinlik_id = yakinlik_id;
    }

    public KisiYakinlar(Date olum_tarihi, Date kayit_tarihi, Date guncelleme_tarihi, String kisi_isim, String ozel_statu_isim, String yakin_isim, String yakinlik_isim) {
        this.olum_tarihi = olum_tarihi;
        this.kayit_tarihi = kayit_tarihi;
        this.guncelleme_tarihi = guncelleme_tarihi;
        this.kisi_isim = kisi_isim;
        this.ozel_statu_isim = ozel_statu_isim;
        this.yakin_isim = yakin_isim;
        this.yakinlik_isim = yakinlik_isim;
    }

    public KisiYakinlar() {
    }

    public Integer getYakinlar_id() {
        return yakinlar_id;
    }

    public void setYakinlar_id(Integer yakinlar_id) {
        this.yakinlar_id = yakinlar_id;
    }

    public Integer getKisi_id() {
        return kisi_id;
    }

    public void setKisi_id(Integer kisi_id) {
        this.kisi_id = kisi_id;
    }

    public Integer getOzel_statu_id() {
        return ozel_statu_id;
    }

    public void setOzel_statu_id(Integer ozel_statu_id) {
        this.ozel_statu_id = ozel_statu_id;
    }

    public Date getOlum_tarihi() {
        return olum_tarihi;
    }

    public void setOlum_tarihi(Date olum_tarihi) {
        this.olum_tarihi = olum_tarihi;
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

    public Integer getYakin_id() {
        return yakin_id;
    }

    public void setYakin_id(Integer yakin_id) {
        this.yakin_id = yakin_id;
    }

    public Integer getYakinlik_id() {
        return yakinlik_id;
    }

    public void setYakinlik_id(Integer yakinlik_id) {
        this.yakinlik_id = yakinlik_id;
    }

    public String getKisi_isim() {
        return kisi_isim;
    }

    public void setKisi_isim(String kisi_isim) {
        this.kisi_isim = kisi_isim;
    }

    public String getOzel_statu_isim() {
        return ozel_statu_isim;
    }

    public void setOzel_statu_isim(String ozel_statu_isim) {
        this.ozel_statu_isim = ozel_statu_isim;
    }

    public String getYakin_isim() {
        return yakin_isim;
    }

    public void setYakin_isim(String yakin_isim) {
        this.yakin_isim = yakin_isim;
    }

    public String getYakinlik_isim() {
        return yakinlik_isim;
    }

    public void setYakinlik_isim(String yakinlik_isim) {
        this.yakinlik_isim = yakinlik_isim;
    }

}
