/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Eren
 */
public class Meslek {

    private Integer meslek_id;
    private String meslek_isim;
    private Integer aktiflik;

    public Meslek(Integer meslek_id, String meslek_isim, Integer aktiflik) {
        this.meslek_id = meslek_id;
        this.meslek_isim = meslek_isim;
        this.aktiflik = aktiflik;
    }

    public Meslek(String meslek_isim, Integer aktiflik) {
        this.meslek_isim = meslek_isim;
        this.aktiflik = aktiflik;
    }

    public Meslek() {
    }

    public Integer getMeslek_id() {
        return meslek_id;
    }

    public void setMeslek_id(Integer meslek_id) {
        this.meslek_id = meslek_id;
    }

    public String getMeslek_isim() {
        return meslek_isim;
    }

    public void setMeslek_isim(String meslek_isim) {
        this.meslek_isim = meslek_isim;
    }

    public Integer getAktiflik() {
        return aktiflik;
    }

    public void setAktiflik(Integer aktiflik) {
        this.aktiflik = aktiflik;
    }

}