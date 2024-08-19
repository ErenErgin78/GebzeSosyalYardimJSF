package Controller;

import Entity.KisiIletisim;
import dao.KisiIletisimDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "kisiIletisimBean")
@ViewScoped
public class KisiIletisimBean implements Serializable {

    private KisiIletisim entity;
    private KisiIletisimDAO dao;
    private List<KisiIletisim> list;

    @PostConstruct
    public void init() {
        entity = new KisiIletisim();
    }

    public Integer ekle() {

        return this.getDao().KisiIletisimEkle(getEntity());
    }

    public void kisiiletisimTemizle() {
        this.getDao().KisiIletisimTemizle();
    }

    public void KisiIletisimSil(int kisiID) {
        this.getDao().KisiIletisimSil(kisiID);
        this.list = this.getDao().KisiIletisimListesi(); // Silme işleminden sonra listeyi güncelle
    }

    public KisiIletisim getEntity() {
        if (entity == null) {
            entity = new KisiIletisim();
        }
        return entity;
    }

    public void setEntity(KisiIletisim entity) {
        this.entity = entity;
    }

    public KisiIletisimDAO getDao() {
        if (dao == null) {
            dao = new KisiIletisimDAO();
        }
        return dao;
    }

    public void setDao(KisiIletisimDAO dao) {
        this.dao = dao;
    }

    public List<KisiIletisim> getList() {
        return list;
    }

    public void setList(List<KisiIletisim> list) {
        this.list = list;
    }

}
