/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Eren
 */
public class YardimTalep {

    private Integer yardim_talep_id;
    private String yardim_talep;
    private Integer aktiflik;

    public YardimTalep(Integer yardim_talep_id, String yardim_talep, Integer aktiflik) {
        this.yardim_talep_id = yardim_talep_id;
        this.yardim_talep = yardim_talep;
        this.aktiflik = aktiflik;
    }

    public YardimTalep(String yardim_talep, Integer aktiflik) {
        this.yardim_talep = yardim_talep;
        this.aktiflik = aktiflik;
    }

    public YardimTalep() {
    }

    public Integer getYardim_talep_id() {
        return yardim_talep_id;
    }

    public void setYardim_talep_id(Integer yardim_talep_id) {
        this.yardim_talep_id = yardim_talep_id;
    }

    public String getYardim_talep() {
        return yardim_talep;
    }

    public void setYardim_talep(String yardim_talep) {
        this.yardim_talep = yardim_talep;
    }

    public Integer getAktiflik() {
        return aktiflik;
    }

    public void setAktiflik(Integer aktiflik) {
        this.aktiflik = aktiflik;
    }

}
