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
    private Integer yardim_tur_id;
    private Date guncelleme_tarihi;

    // Parametresiz Constructor
    public MuracaatYardimTalep() {
    }

    // Parametreli Constructor
    public MuracaatYardimTalep(Integer muracaat_id, Integer yardim_tip, Integer yardim_tur_id ,Date guncelleme_tarihi) {
        this.muracaat_id = muracaat_id;
        this.yardim_tip = yardim_tip;
        this.yardim_tur_id=yardim_tur_id;
        this.guncelleme_tarihi = guncelleme_tarihi;
    }

    // Getters and Setters
    public Integer getTalep_id() {
        return talep_id;
    }

    public void setTalep_id(Integer talep_id) {
        this.talep_id = talep_id;
    }

    public Integer getYardim_tur_id() {
        return yardim_tur_id;
    }

    public void setYardim_tur_id(Integer yardim_tur_id) {
        this.yardim_tur_id = yardim_tur_id;
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
