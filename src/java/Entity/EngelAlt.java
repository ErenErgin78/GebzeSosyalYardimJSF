/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Eren
 */
public class EngelAlt {

    private Integer alt_tip_id;
    private Integer engelli_tip_id;
    private String alt_tip_isim;
    private String engelli_tip_isim;
    private Integer aktif;

    public EngelAlt(String alt_tip_isim, String engelli_tip_isim, Integer aktif) {
        this.alt_tip_isim = alt_tip_isim;
        this.engelli_tip_isim = engelli_tip_isim;
        this.aktif = aktif;
    }

    public EngelAlt(Integer alt_tip_id, String alt_tip_isim, String engelli_tip_isim) {
        this.alt_tip_id = alt_tip_id;
        this.alt_tip_isim = alt_tip_isim;
        this.engelli_tip_isim = engelli_tip_isim;
    }

    public EngelAlt(Integer alt_tip_id, Integer engelli_tip_id, String alt_tip_isim) {
        this.alt_tip_id = alt_tip_id;
        this.engelli_tip_id = engelli_tip_id;
        this.alt_tip_isim = alt_tip_isim;
    }

    public EngelAlt() {
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

    public Integer getAlt_tip_id() {
        return alt_tip_id;
    }

    public void setAlt_tip_id(Integer alt_tip_id) {
        this.alt_tip_id = alt_tip_id;
    }

    public Integer getEngelli_tip_id() {
        return engelli_tip_id;
    }

    public void setEngelli_tip_id(Integer engelli_tip_id) {
        this.engelli_tip_id = engelli_tip_id;
    }

    public String getAlt_tip_isim() {
        return alt_tip_isim;
    }

    public void setAlt_tip_isim(String alt_tip_isim) {
        this.alt_tip_isim = alt_tip_isim;
    }

    public String getEngelli_tip_isim() {
        return engelli_tip_isim;
    }

    public void setEngelli_tip_isim(String engelli_tip_isim) {
        this.engelli_tip_isim = engelli_tip_isim;
    }

}
