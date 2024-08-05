/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

public class Sokak {

    private Integer sokak_id;
    private Integer mahalle_id;
    private String sokak;
    private Integer aktif;

    public Sokak() {
    }

    public Sokak(Integer sokak_id, Integer mahalle_id, String sokak, Integer aktif) {
        this.sokak_id = sokak_id;
        this.mahalle_id = mahalle_id;
        this.sokak = sokak;
        this.aktif = aktif;
    }

    public Sokak(Integer mahalle_id, String sokak, Integer aktif) {
        this.mahalle_id = mahalle_id;
        this.sokak = sokak;
        this.aktif = aktif;
    }

    public Integer getSokak_id() {
        return sokak_id;
    }

    public void setSokak_id(Integer sokak_id) {
        this.sokak_id = sokak_id;
    }

    public String getSokak() {
        return sokak;
    }

    public void setSokak(String sokak) {
        this.sokak = sokak;
    }

    public Integer getMahalle_id() {
        return mahalle_id;
    }

    public void setMahalle_id(Integer mahalle_id) {
        this.mahalle_id = mahalle_id;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

}