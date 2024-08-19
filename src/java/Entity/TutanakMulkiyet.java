package Entity;

import java.util.Date;

public class TutanakMulkiyet {

    private Integer mulkiyet_id;
    private Integer mulkiyet_sira_no;
    private Integer ev_durum_id;
    private Float kira_miktar;
    private Integer yakacak_tip_id;
    private Integer kirada_ev_sayisi;
    private Integer araba_var_mi = 0;
    private String araba_model;
    private Integer gayrimenkul_var_mi = 0;
    private String gayrimenkul_tur;
    private Integer ev_tip_id;
    private Date guncelleme_tarihi;

    public TutanakMulkiyet(Integer mulkiyet_id, Integer mulkiyet_sira_no, Integer ev_durum_id, Float kira_miktar, Integer yakacak_tip_id, Integer kirada_ev_sayisi, Integer araba_var_mi, String araba_model, Integer gayrimenkul_var_mi, String gayrimenkul_tur, Integer ev_tip_id, Date guncelleme_tarihi) {
        this.mulkiyet_id = mulkiyet_id;
        this.mulkiyet_sira_no = mulkiyet_sira_no;
        this.ev_durum_id = ev_durum_id;
        this.kira_miktar = kira_miktar;
        this.yakacak_tip_id = yakacak_tip_id;
        this.kirada_ev_sayisi = kirada_ev_sayisi;
        this.araba_var_mi = araba_var_mi;
        this.araba_model = araba_model;
        this.gayrimenkul_var_mi = gayrimenkul_var_mi;
        this.gayrimenkul_tur = gayrimenkul_tur;
        this.ev_tip_id = ev_tip_id;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    public TutanakMulkiyet() {
    }

    public Integer getMulkiyet_id() {
        return mulkiyet_id;
    }

    public void setMulkiyet_id(Integer mulkiyet_id) {
        this.mulkiyet_id = mulkiyet_id;
    }

    public Integer getMulkiyet_sira_no() {
        return mulkiyet_sira_no;
    }

    public void setMulkiyet_sira_no(Integer mulkiyet_sira_no) {
        this.mulkiyet_sira_no = mulkiyet_sira_no;
    }

    public Integer getEv_durum_id() {
        return ev_durum_id;
    }

    public void setEv_durum_id(Integer ev_durum_id) {
        this.ev_durum_id = ev_durum_id;
    }

    public Float getKira_miktar() {
        return kira_miktar;
    }

    public void setKira_miktar(Float kira_miktar) {
        this.kira_miktar = kira_miktar;
    }

    public Integer getYakacak_tip_id() {
        return yakacak_tip_id;
    }

    public void setYakacak_tip_id(Integer yakacak_tip_id) {
        this.yakacak_tip_id = yakacak_tip_id;
    }

    public Integer getKirada_ev_sayisi() {
        return kirada_ev_sayisi;
    }

    public void setKirada_ev_sayisi(Integer kirada_ev_sayisi) {
        this.kirada_ev_sayisi = kirada_ev_sayisi;
    }

    public Integer getAraba_var_mi() {
        return araba_var_mi;
    }

    public void setAraba_var_mi(Integer araba_var_mi) {
        this.araba_var_mi = araba_var_mi;
    }

    public String getAraba_model() {
        return araba_model;
    }

    public void setAraba_model(String araba_model) {
        this.araba_model = araba_model;
    }

    public Integer getGayrimenkul_var_mi() {
        return gayrimenkul_var_mi;
    }

    public void setGayrimenkul_var_mi(Integer gayrimenkul_var_mi) {
        this.gayrimenkul_var_mi = gayrimenkul_var_mi;
    }

    public String getGayrimenkul_tur() {
        return gayrimenkul_tur;
    }

    public void setGayrimenkul_tur(String gayrimenkul_tur) {
        this.gayrimenkul_tur = gayrimenkul_tur;
    }

    public Integer getEv_tip_id() {
        return ev_tip_id;
    }

    public void setEv_tip_id(Integer ev_tip_id) {
        this.ev_tip_id = ev_tip_id;
    }

    public Date getGuncelleme_tarihi() {
        return guncelleme_tarihi;
    }

    public void setGuncelleme_tarihi(Date guncelleme_tarihi) {
        this.guncelleme_tarihi = guncelleme_tarihi;
    }
}
