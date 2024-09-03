/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

public class KisiEngel {

    private Integer kisi_engel_id;
    private Integer engelli_tip_id;
    private Integer engelli_alt_tip_id;
    private Integer kurum_id;
    private Integer alt_kurum_id;
    private float derece = 0;
    private String engel_baslangic = "";
    private Date kayit_tarihi;
    private Integer aktif = 0;
    private String hastalik = "";
    private Date guncelleme_tarihi;

    // Boş constructor
    public KisiEngel() {
    }

    // Tüm alanları alan constructor
    public KisiEngel(Integer kisi_engel_id, Integer engelli_tip_id, Integer engelli_alt_tip_id, Integer kurum_id, 
                     Integer alt_kurum_id, float derece, String engel_baslangic, Date kayit_tarihi, Integer aktif, 
                     String hastalik, Date guncelleme_tarihi) {
        this.kisi_engel_id = kisi_engel_id;
        this.engelli_tip_id = engelli_tip_id;
        this.engelli_alt_tip_id = engelli_alt_tip_id;
        this.kurum_id = kurum_id;
        this.alt_kurum_id = alt_kurum_id;
        this.derece = derece;
        this.engel_baslangic = engel_baslangic;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
        this.hastalik = hastalik;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    // ID'siz constructor
    public KisiEngel(Integer engelli_tip_id, Integer engelli_alt_tip_id, Integer kurum_id, Integer alt_kurum_id,
                     float derece, String engel_baslangic, Date kayit_tarihi, Integer aktif, String hastalik, 
                     Date guncelleme_tarihi) {
        this.engelli_tip_id = engelli_tip_id;
        this.engelli_alt_tip_id = engelli_alt_tip_id;
        this.kurum_id = kurum_id;
        this.alt_kurum_id = alt_kurum_id;
        this.derece = derece;
        this.engel_baslangic = engel_baslangic;
        this.kayit_tarihi = kayit_tarihi;
        this.aktif = aktif;
        this.hastalik = hastalik;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    // Getter ve Setter metodları
    public Integer getKisi_engel_id() {
        return kisi_engel_id;
    }

    public void setKisi_engel_id(Integer kisi_engel_id) {
        this.kisi_engel_id = kisi_engel_id;
    }

    public Integer getEngelli_tip_id() {
        return engelli_tip_id;
    }

    public void setEngelli_tip_id(Integer engelli_tip_id) {
        this.engelli_tip_id = engelli_tip_id;
    }

    public Integer getEngelli_alt_tip_id() {
        return engelli_alt_tip_id;
    }

    public void setEngelli_alt_tip_id(Integer engelli_alt_tip_id) {
        this.engelli_alt_tip_id = engelli_alt_tip_id;
    }

    public Integer getKurum_id() {
        return kurum_id;
    }

    public void setKurum_id(Integer kurum_id) {
        this.kurum_id = kurum_id;
    }

    public Integer getAlt_kurum_id() {
        return alt_kurum_id;
    }

    public void setAlt_kurum_id(Integer alt_kurum_id) {
        this.alt_kurum_id = alt_kurum_id;
    }

    public float getDerece() {
        return derece;
    }

    public void setDerece(float derece) {
        this.derece = derece;
    }

    public String getEngel_baslangic() {
        return engel_baslangic;
    }

    public void setEngel_baslangic(String engel_baslangic) {
        this.engel_baslangic = engel_baslangic;
    }

    public Date getKayit_tarihi() {
        return kayit_tarihi;
    }

    public void setKayit_tarihi(Date kayit_tarihi) {
        this.kayit_tarihi = kayit_tarihi;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

    public String getHastalik() {
        return hastalik;
    }

    public void setHastalik(String hastalik) {
        this.hastalik = hastalik;
    }

    public Date getGuncelleme_tarihi() {
        return guncelleme_tarihi;
    }

    public void setGuncelleme_tarihi(Date guncelleme_tarihi) {
        this.guncelleme_tarihi = guncelleme_tarihi;
    }
}
