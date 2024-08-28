package Controller;

import Entity.KisiAdres;
import dao.KisiAdresDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "kisiAdresBean")
@ViewScoped
public class KisiAdresBean implements Serializable {

    private KisiAdres entity;
    private KisiAdresDAO dao;
    private List<KisiAdres> list;

    @PostConstruct
    public void init() {
        entity = new KisiAdres();
    }

    public Integer ekle() {
        return this.getDao().KisiAdresEkle(getEntity());
    }

    public void KisiAdresSil(int kisiID) {
        this.getDao().KisiAdresSil(kisiID);
        this.list = this.getDao().KisiAdresListesi(); // Silme işleminden sonra listeyi güncelle
    }

    public void edit(KisiAdres kisiAdres) {
        this.entity = kisiAdres;
    }

    public KisiAdres getEntity() {
        if (entity == null) {
            entity = new KisiAdres();
        }
        return entity;
    }

    public void setEntity(KisiAdres entity) {
        this.entity = entity;
    }

    public KisiAdresDAO getDao() {
        if (dao == null) {
            dao = new KisiAdresDAO();
        }
        return dao;
    }

    public void setDao(KisiAdresDAO dao) {
        this.dao = dao;
    }

    public List<KisiAdres> getList() {
        list = getDao().KisiAdresListesi();
        return list;
    }

    public void setList(List<KisiAdres> list) {
        this.list = list;
    }

    public KisiAdresBean() {
    }

}
