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
    private Integer okul_tip;
    private Integer okul_tur;
    private Integer okul_aktif;

    public Okul(Integer okul_id, String okul_isim, Integer okul_tip, Integer okul_tur, Integer okul_aktif) {
        this.okul_id = okul_id;
        this.okul_isim = okul_isim;
        this.okul_tip = okul_tip;
        this.okul_tur = okul_tur;
        this.okul_aktif = okul_aktif;
    }

    public Okul() {
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

    public Integer getOkul_tip() {
        return okul_tip;
    }

    public void setOkul_tip(Integer okul_tip) {
        this.okul_tip = okul_tip;
    }

    public Integer getOkul_tur() {
        return okul_tur;
    }

    public void setOkul_tur(Integer okul_tur) {
        this.okul_tur = okul_tur;
    }

    public Integer getOkul_aktif() {
        return okul_aktif;
    }

    public void setOkul_aktif(Integer okul_aktif) {
        this.okul_aktif = okul_aktif;
    }
    
    
    
}
