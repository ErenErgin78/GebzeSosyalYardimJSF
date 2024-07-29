/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Eren
 */
public class Yakinlik {

    private Integer yakinlik_id;
    private String yakinlik_isim;
    private Integer aktiflik;

    public Yakinlik(Integer yakinlik_id, String yakinlik_isim, Integer aktiflik) {
        this.yakinlik_id = yakinlik_id;
        this.yakinlik_isim = yakinlik_isim;
        this.aktiflik = aktiflik;
    }

    public Yakinlik(String yakinlik_isim, Integer aktiflik) {
        this.yakinlik_isim = yakinlik_isim;
        this.aktiflik = aktiflik;
    }

    public Yakinlik() {
    }

    public Integer getYakinlik_id() {
        return yakinlik_id;
    }

    public void setYakinlik_id(Integer yakinlik_id) {
        this.yakinlik_id = yakinlik_id;
    }

    public String getYakinlik_isim() {
        return yakinlik_isim;
    }

    public void setYakinlik_isim(String yakinlik_isim) {
        this.yakinlik_isim = yakinlik_isim;
    }

    public Integer getAktiflik() {
        return aktiflik;
    }

    public void setAktiflik(Integer aktiflik) {
        this.aktiflik = aktiflik;
    }

}
