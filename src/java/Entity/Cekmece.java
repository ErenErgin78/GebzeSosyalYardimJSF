/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author casper
 */
public class Cekmece {

    private Integer cekmece_id;
    private String cekmece;
    private Integer aktif;

    public Cekmece(Integer cekmece_id, String cekmece, Integer aktif) {
        this.cekmece_id = cekmece_id;
        this.cekmece = cekmece;
        this.aktif = aktif;
    }

    public Cekmece(String cekmece, Integer aktif) {
        this.cekmece = cekmece;
        this.aktif = aktif;
    }

    public Cekmece() {
    }

    public Integer getCekmece_id() {
        return cekmece_id;
    }

    public void setCekmece_id(Integer cekmece_id) {
        this.cekmece_id = cekmece_id;
    }

    public String getCekmece() {
        return cekmece;
    }

    public void setCekmece(String cekmece) {
        this.cekmece = cekmece;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

}
