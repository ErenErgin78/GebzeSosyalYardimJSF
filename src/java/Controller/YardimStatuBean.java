package Controller;

import Entity.YardimStatu;
import dao.YardimStatuDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "yardimStatuBean")
@ViewScoped
public class YardimStatuBean implements Serializable {

    private YardimStatu entity;
    private YardimStatuDAO dao;
    private List<YardimStatu> list;

    @PostConstruct
    public void init() {
        entity = new YardimStatu();
    }

    public void ekle() {

        this.getDao().YardimStatuEkle(getEntity());
    }

    public void YardimStatuSil(int kisiID) {
        this.getDao().YardimStatuSil(kisiID);
        this.list = this.getDao().YardimStatuListesi(); // Silme işleminden sonra listeyi güncelle
    }

    public YardimStatuBean() {
    }

    public YardimStatu getEntity() {
        return entity;
    }

    public void setEntity(YardimStatu entity) {
        this.entity = entity;
    }

    public YardimStatuDAO getDao() {
        return dao;
    }

    public void setDao(YardimStatuDAO dao) {
        this.dao = dao;
    }

    public List<YardimStatu> getList() {
        return list;
    }

    public void setList(List<YardimStatu> list) {
        this.list = list;
    }

}
