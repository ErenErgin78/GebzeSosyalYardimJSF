package Entity;

import java.util.Date;

/**
 *
 * @author Eren
 */
public class MuracaatYardimTalep {

    private Integer talep_id;
    private Integer muracaat_id;
    private Integer yardim_tip;
    private Date guncelleme_tarihi;

    // Parametresiz Constructor
    public MuracaatYardimTalep() {
    }

    // Parametreli Constructor
    public MuracaatYardimTalep(Integer muracaat_id, Integer yardim_tip, Date guncelleme_tarihi) {
        this.muracaat_id = muracaat_id;
        this.yardim_tip = yardim_tip;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    // Getters and Setters
    public Integer getTalep_id() {
        return talep_id;
    }

    public void setTalep_id(Integer talep_id) {
        this.talep_id = talep_id;
    }

    public Integer getMuracaat_id() {
        return muracaat_id;
    }

    public void setMuracaat_id(Integer muracaat_id) {
        this.muracaat_id = muracaat_id;
    }

    public Integer getYardim_tip() {
        return yardim_tip;
    }

    public void setYardim_tip(Integer yardim_tip) {
        this.yardim_tip = yardim_tip;
    }

    public Date getGuncelleme_tarihi() {
        return guncelleme_tarihi;
    }

    public void setGuncelleme_tarihi(Date guncelleme_tarihi) {
        this.guncelleme_tarihi = guncelleme_tarihi;
    }
}
