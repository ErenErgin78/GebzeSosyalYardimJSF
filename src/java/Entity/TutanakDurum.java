/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Eren
 */
public class TutanakDurum {

    private Integer tutanak_id;
    private String tutanak_isim;
    private Integer aktiflik;

    public TutanakDurum(Integer tutanak_id, String tutanak_isim, Integer aktiflik) {
        this.tutanak_id = tutanak_id;
        this.tutanak_isim = tutanak_isim;
        this.aktiflik = aktiflik;
    }

    public TutanakDurum(String tutanak_isim, Integer aktiflik) {
        this.tutanak_isim = tutanak_isim;
        this.aktiflik = aktiflik;
    }

    public TutanakDurum() {
    }

    public Integer getTutanak_id() {
        return tutanak_id;
    }

    public void setTutanak_id(Integer tutanak_id) {
        this.tutanak_id = tutanak_id;
    }

    public String getTutanak_isim() {
        return tutanak_isim;
    }

    public void setTutanak_isim(String tutanak_isim) {
        this.tutanak_isim = tutanak_isim;
    }

    public Integer getAktiflik() {
        return aktiflik;
    }

    public void setAktiflik(Integer aktiflik) {
        this.aktiflik = aktiflik;
    }

}
