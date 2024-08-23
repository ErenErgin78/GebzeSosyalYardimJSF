/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Eren
 */
public class Mahalle {

    private Integer mahalle_id;
    private String mahalle;
    private Integer mahalle_aktif;

    public Mahalle() {
    }

    public Mahalle(Integer mahalle_id, String mahalle, Integer mahalle_aktif) {
        this.mahalle_id = mahalle_id;
        this.mahalle = mahalle;
        this.mahalle_aktif = mahalle_aktif;
    }

    public Mahalle(String mahalle, Integer mahalle_aktif) {
        this.mahalle = mahalle;
        this.mahalle_aktif = mahalle_aktif;
    }

    public Integer getMahalle_id() {
        return mahalle_id;
    }

    public void setMahalle_id(Integer mahalle_id) {
        this.mahalle_id = mahalle_id;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    public Integer getMahalle_aktif() {
        return mahalle_aktif;
    }

    public void setMahalle_aktif(Integer mahalle_aktif) {
        this.mahalle_aktif = mahalle_aktif;
    }


}