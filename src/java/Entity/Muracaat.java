package Entity;

/**
 *
 * @author Eren
 */
public class Muracaat {
    private Integer muracaat_id;
    private Integer kisi_temel_id;

    public Muracaat(Integer muracaat_id, Integer kisi_temel_id) {
        this.muracaat_id = muracaat_id;
        this.kisi_temel_id = kisi_temel_id;
    }

    public Muracaat(Integer kisi_temel_id) {
        this.kisi_temel_id = kisi_temel_id;
    }
    
    
    public Integer getMuracaat_id() {
        return muracaat_id;
    }

    public void setMuracaat_id(Integer muracaat_id) {
        this.muracaat_id = muracaat_id;
    }

    public Integer getKisi_temel_id() {
        return kisi_temel_id;
    }

    public void setKisi_temel_id(Integer kisi_temel_id) {
        this.kisi_temel_id = kisi_temel_id;
    }
    
}
