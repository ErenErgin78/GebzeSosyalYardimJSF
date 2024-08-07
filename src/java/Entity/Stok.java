package Entity;

public class Stok {

    private Integer stok_id;
    private Integer yardım_tip_id;
    private Integer yardım_alt_tıp_id;
    private String stok_tanım;
    private Integer guncel_miktar;
    private Float guncel_fiyat;
    private String yardım_tıp_isim;
    private String yardım_alt_tıp_isim;

    public Integer getStok_id() {
        return stok_id;
    }

    public void setStok_id(Integer stok_id) {
        this.stok_id = stok_id;
    }

    public Integer getYardım_tip_id() {
        return yardım_tip_id;
    }

    public void setYardım_tip_id(Integer yardım_tip_id) {
        this.yardım_tip_id = yardım_tip_id;
    }

    public Integer getYardım_alt_tıp_id() {
        return yardım_alt_tıp_id;
    }

    public void setYardım_alt_tıp_id(Integer yardım_alt_tıp_id) {
        this.yardım_alt_tıp_id = yardım_alt_tıp_id;
    }

    public String getStok_tanım() {
        return stok_tanım;
    }

    public void setStok_tanım(String stok_tanım) {
        this.stok_tanım = stok_tanım;
    }

    public Integer getGuncel_miktar() {
        return guncel_miktar;
    }

    public void setGuncel_miktar(Integer guncel_miktar) {
        this.guncel_miktar = guncel_miktar;
    }

    public Float getGuncel_fiyat() {
        return guncel_fiyat;
    }

    public void setGuncel_fiyat(Float guncel_fiyat) {
        this.guncel_fiyat = guncel_fiyat;
    }

    public String getYardım_tıp_isim() {
        return yardım_tıp_isim;
    }

    public void setYardım_tıp_isim(String yardım_tıp_isim) {
        this.yardım_tıp_isim = yardım_tıp_isim;
    }

    public String getYardım_alt_tıp_isim() {
        return yardım_alt_tıp_isim;
    }

    public void setYardım_alt_tıp_isim(String yardım_alt_tıp_isim) {
        this.yardım_alt_tıp_isim = yardım_alt_tıp_isim;
    }

    public Stok(Integer stok_id, String stok_tanım, Integer guncel_miktar, Float guncel_fiyat, String yardım_tıp_isim, String yardım_alt_tıp_isim) {
        this.stok_id = stok_id;
        this.stok_tanım = stok_tanım;
        this.guncel_miktar = guncel_miktar;
        this.guncel_fiyat = guncel_fiyat;
        this.yardım_tıp_isim = yardım_tıp_isim;
        this.yardım_alt_tıp_isim = yardım_alt_tıp_isim;
    }

    public Stok() {
    }



}
