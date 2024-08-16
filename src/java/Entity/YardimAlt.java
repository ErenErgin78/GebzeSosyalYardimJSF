/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Eren
 */
public class YardimAlt {

    private Integer alt_tip_id;
    private Integer tip_id;
    private String alt_tip;
    private String tip_isim;
    private Integer aktif;

    public YardimAlt(Integer alt_tip_id, String alt_tip, String tip_isim, Integer aktif) {
        this.alt_tip_id = alt_tip_id;
        this.alt_tip = alt_tip;
        this.tip_isim = tip_isim;
        this.aktif = aktif;
    }

    public YardimAlt(Integer alt_tip_id, String alt_tip, String tip_isim) {
        this.alt_tip_id = alt_tip_id;
        this.alt_tip = alt_tip;
        this.tip_isim = tip_isim;
    }

    public YardimAlt(Integer alt_tip_id, Integer tip_id, String alt_tip) {
        this.alt_tip_id = alt_tip_id;
        this.tip_id = tip_id;
        this.alt_tip = alt_tip;
    }

    public YardimAlt(Integer tip_id, String alt_tip) {
        this.tip_id = tip_id;
        this.alt_tip = alt_tip;
    }

    public YardimAlt() {
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

    public Integer getTip_id() {
        return tip_id;
    }

    public void setTip_id(Integer tip_id) {
        this.tip_id = tip_id;
    }

    public String getAlt_tip() {
        return alt_tip;
    }

    public void setAlt_tip(String alt_tip) {
        this.alt_tip = alt_tip;
    }

    public String getTip_isim() {
        return tip_isim;
    }

    public void setTip_isim(String tip_isim) {
        this.tip_isim = tip_isim;
    }

}
