package Controller;

import Entity.Yakinlik;
import dao.YakinlikDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "yakinlikBean")
@ViewScoped
public class YakinlikBean implements Serializable {

    private Yakinlik entity;
    private YakinlikDAO dao;
    private List<Yakinlik> list;
    private List<SelectItem> yakinlikList;

    public void yakinlikEkle() {
        this.getDao().YakinlikEkle(getEntity());
    }

    public void yakinlikSil(int yakinlikId) {
        this.getDao().YakinlikSil(yakinlikId);
    }

    public void yakinlikMesajTemizle() {
        this.getDao().YakinlikMesajTemizle();
    }

    public Yakinlik getEntity() {
        if (this.entity == null) {
            this.entity = new Yakinlik();
        }
        return this.entity;
    }

    public void setEntity(Yakinlik entity) {
        this.entity = entity;
    }

    public YakinlikDAO getDao() {
        if (this.dao == null) {
            this.dao = new YakinlikDAO();
            dao.setMesaj(null);
        }
        return this.dao;
    }

    public void setDao(YakinlikDAO dao) {
        this.dao = dao;
    }

    public List<Yakinlik> getList() {
        this.list = this.getDao().YakinlikListesi();
        return this.list;
    }

    public void listeYenile() {
        this.list = this.getDao().YakinlikListesi();
    }

    public void setList(List<Yakinlik> list) {
        this.list = list;
    }

    public List<SelectItem> getYakinlikList() {
        yakinlikList = getDao().YakinlikGetir();
        return yakinlikList;
    }

    public void setYakinlikList(List<SelectItem> yakinlikList) {
        this.yakinlikList = yakinlikList;
    }

    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // Sayfa yüklendiğinde mesajı sıfırlar
    }

    public YakinlikBean() {
    }
}
