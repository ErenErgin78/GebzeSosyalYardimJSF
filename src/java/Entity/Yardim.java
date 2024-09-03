package Entity;

public class Yardim {

    private Integer yardim_tip_id;
    private String yardim_tip;
    private Integer yardim_tur_id;
    private Integer aktif;

    // Constructors
    public Yardim(Integer yardim_tip_id, String yardim_tip, Integer yardim_tur_id, Integer aktif) {
        this.yardim_tip_id = yardim_tip_id;
        this.yardim_tip = yardim_tip;
        this.yardim_tur_id = yardim_tur_id;
        this.aktif = aktif;
    }

    public Yardim(Integer yardim_tip_id, String yardim_tip, Integer yardim_tur_id) {
        this.yardim_tip_id = yardim_tip_id;
        this.yardim_tip = yardim_tip;
        this.yardim_tur_id = yardim_tur_id;
    }

    public Yardim(Integer yardim_tip_id, String yardim_tip) {
        this.yardim_tip_id = yardim_tip_id;
        this.yardim_tip = yardim_tip;
    }

    public Yardim(String yardim_tip, Integer yardim_tur_id) {
        this.yardim_tip = yardim_tip;
        this.yardim_tur_id = yardim_tur_id;
    }

    public Yardim() {
    }

    // Getters and Setters
    public Integer getYardim_tip_id() {
        return yardim_tip_id;
    }

    public void setYardim_tip_id(Integer yardim_tip_id) {
        this.yardim_tip_id = yardim_tip_id;
    }

    public String getYardim_tip() {
        return yardim_tip;
    }

    public void setYardim_tip(String yardim_tip) {
        this.yardim_tip = yardim_tip;
    }

    public Integer getYardim_tur_id() {
        return yardim_tur_id;
    }

    public void setYardim_tur_id(Integer yardim_tur_id) {
        this.yardim_tur_id = yardim_tur_id;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }
}
