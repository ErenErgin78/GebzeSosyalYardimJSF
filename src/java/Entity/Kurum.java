/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

public class Kurum {

    private Integer kurum_id;
    private String kurum_isim;
    private Integer aktif;

    public Kurum(String kurum_isim, Integer aktif) {
        this.kurum_isim = kurum_isim;
        this.aktif = aktif;
    }

    public Kurum(Integer kurum_id, String kurum_isim) {
        this.kurum_id = kurum_id;
        this.kurum_isim = kurum_isim;
    }

    public Kurum(String kurum_isim) {
        this.kurum_isim = kurum_isim;
    }

    public Kurum() {
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

    public Integer getKurum_id() {
        return kurum_id;
    }

    public void setKurum_id(Integer kurum_id) {
        this.kurum_id = kurum_id;
    }

    public String getKurum_isim() {
        return kurum_isim;
    }

    public void setKurum_isim(String kurum_isim) {
        this.kurum_isim = kurum_isim;
    }

}
