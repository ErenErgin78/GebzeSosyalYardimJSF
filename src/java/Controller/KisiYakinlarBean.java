package Controller;

import Entity.KisiYakinlar;
import dao.KisiYakinlarDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "kisiYakinlarBean")
@SessionScoped
public class KisiYakinlarBean implements Serializable {

    private KisiYakinlar entity;
    private KisiYakinlarDAO dao;

    @PostConstruct
    public void init() {
        entity = new KisiYakinlar();
    }

    public Integer ekle() {
        return this.getDao().KisiYakinlarEkle(getEntity());
    }

    public Integer ekle(Integer kisiId) {
        return this.getDao().KisiYakinlarEkle(getEntity(), kisiId);
    }

    public Integer ekleMuracaat(Integer kisiId) {
        return this.getDao().KisiYakinlarEkleMuracaat(getEntity(), kisiId);
    }

    public void KisiYakinlarSil(int yakinlarID) {
        this.getDao().KisiYakinlarSil(yakinlarID);

    }

    public void edit(KisiYakinlar yakinlik) {
        this.entity = yakinlik;
    }

    public KisiYakinlar getEntity() {
        if (this.entity == null) {
            this.entity = new KisiYakinlar();
        }
        return this.entity;
    }

    public void setEntity(KisiYakinlar entity) {
        this.entity = entity;
    }

    public KisiYakinlarDAO getDao() {
        if (this.dao == null) {
            this.dao = new KisiYakinlarDAO();
        }
        return this.dao;
    }

    public void setDao(KisiYakinlarDAO dao) {
        this.dao = dao;
    }

}
