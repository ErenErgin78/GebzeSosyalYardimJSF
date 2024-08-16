/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import java.util.Date;
/**
 *
 * @author Hamza
 */
public class OkulTip {
    private Integer okul_tip_id;
    private String okul_tip_isim;
    private Date kayit_tarihi;

    public Integer getOkul_tip_id() {
        return okul_tip_id;
    }

    public void setOkul_tip_id(Integer okul_tip_id) {
        this.okul_tip_id = okul_tip_id;
    }

    public String getOkul_tip_isim() {
        return okul_tip_isim;
    }

    public void setOkul_tip_isim(String okul_tip_isim) {
        this.okul_tip_isim = okul_tip_isim;
    }

    public Date getKayit_tarihi() {
        return kayit_tarihi;
    }

    public void setKayit_tarihi(Date kayit_tarihi) {
        this.kayit_tarihi = kayit_tarihi;
    }

    public OkulTip(Integer okul_tip_id, String okul_tip_isim, Date kayit_tarihi) {
        this.okul_tip_id = okul_tip_id;
        this.okul_tip_isim = okul_tip_isim;
        this.kayit_tarihi = kayit_tarihi;
    }

    public OkulTip() {
    }

   
}
