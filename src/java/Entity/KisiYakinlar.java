package Entity;

import java.math.BigInteger;
import java.util.Date;

public class KisiYakinlar {

    private Integer kisi_yakinlar_id;
    private String anne_isim;
    private String baba_isim;
    private String es_isim;
    private String es_soyisim;
    private Integer es_durum_id;
    private String es_durum_isim;

    public KisiYakinlar(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Integer getKisi_yakinlar_id() {
        return kisi_yakinlar_id;
    }

    public void setKisi_yakinlar_id(Integer kisi_yakinlar_id) {
        this.kisi_yakinlar_id = kisi_yakinlar_id;
    }

    public String getAnne_isim() {
        return anne_isim;
    }

    public void setAnne_isim(String anne_isim) {
        this.anne_isim = anne_isim;
    }

    public String getBaba_isim() {
        return baba_isim;
    }

    public void setBaba_isim(String baba_isim) {
        this.baba_isim = baba_isim;
    }

    public String getEs_isim() {
        return es_isim;
    }

    public void setEs_isim(String es_isim) {
        this.es_isim = es_isim;
    }

    public String getEs_soyisim() {
        return es_soyisim;
    }

    public void setEs_soyisim(String es_soyisim) {
        this.es_soyisim = es_soyisim;
    }

    public Integer getEs_durum_id() {
        return es_durum_id;
    }

    public void setEs_durum_id(Integer es_durum_id) {
        this.es_durum_id = es_durum_id;
    }

    public String getEs_durum_isim() {
        return es_durum_isim;
    }

    public void setEs_durum_isim(String es_durum_isim) {
        this.es_durum_isim = es_durum_isim;
    }

    public KisiYakinlar(String anne_isim, String baba_isim, String es_isim, String es_soyisim, String es_durum_isim) {
        this.anne_isim = anne_isim;
        this.baba_isim = baba_isim;
        this.es_isim = es_isim;
        this.es_soyisim = es_soyisim;
        this.es_durum_isim = es_durum_isim;
    }

    public KisiYakinlar() {
    }

    public String getKisiYakinlar_tip() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setKisiYakinlar_id(int selectedKisiYakinlarId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public BigInteger getKimlik_no() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
