/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Eren
 */
public class Okul {

    private Integer okul_id;
    private String okul_isim;
    private Integer okul_tip_id;
    private Integer okul_tur_id;
    private Integer okul_aktif;

    public Okul(Integer okul_id, String okul_isim, Integer okul_tip_id, Integer okul_tur_id, Integer okul_aktif) {
        this.okul_id = okul_id;
        this.okul_isim = okul_isim;
        this.okul_tip_id = okul_tip_id;
        this.okul_tur_id = okul_tur_id;
        this.okul_aktif = okul_aktif;
    }

    public Integer getOkul_id() {
        return okul_id;
    }

    public void setOkul_id(Integer okul_id) {
        this.okul_id = okul_id;
    }

    public String getOkul_isim() {
        return okul_isim;
    }

    public void setOkul_isim(String okul_isim) {
        this.okul_isim = okul_isim;
    }

    public Integer getOkul_tip_id() {
        return okul_tip_id;
    }

    public void setOkul_tip_id(Integer okul_tip_id) {
        this.okul_tip_id = okul_tip_id;
    }

    public Integer getOkul_tur_id() {
        return okul_tur_id;
    }

    public void setOkul_tur_id(Integer okul_tur_id) {
        this.okul_tur_id = okul_tur_id;
    }

    public Integer getOkul_aktif() {
        return okul_aktif;
    }

    public void setOkul_aktif(Integer okul_aktif) {
        this.okul_aktif = okul_aktif;
    }

}
