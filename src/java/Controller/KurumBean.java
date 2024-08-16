package Controller;

import Entity.Kurum;
import dao.KurumDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "kurumBean")
@ViewScoped
public class KurumBean implements Serializable {

    private Kurum entity;
    private KurumDAO dao;
    private List<Kurum> list;
    private List<SelectItem> kurumList;

    @PostConstruct
    public void init() {
        this.getDao().setIslemBasariliMesaj(null); // Sayfa yüklendiğinde mesajı sıfırlar
    }

    public void kurumEkle() {
        this.getDao().KurumEkle(getEntity());
        this.list = this.getDao().KurumListesi(); // Ekleme işleminden sonra listeyi güncelle
    }

    public void kurumSil(int kurumID) {
        this.getDao().KurumSil(kurumID);
        this.list = this.getDao().KurumListesi(); // Silme işleminden sonra listeyi güncelle
    }

    public List<SelectItem> kurumGetir() {
        return this.getDao().KurumGetir();
    }

    public Kurum getEntity() {
        if (this.entity == null) {
            this.entity = new Kurum();
        }
        return this.entity;
    }

    public void setEntity(Kurum entity) {
        this.entity = entity;
    }

    public KurumDAO getDao() {
        if (this.dao == null) {
            this.dao = new KurumDAO();
        }
        return this.dao;
    }

    public void setDao(KurumDAO dao) {
        this.dao = dao;
    }

    public List<Kurum> getList() {
        if (this.list == null) {
            this.list = this.getDao().KurumListesi();
        }
        return this.list;
    }

    public void setList(List<Kurum> list) {
        this.list = list;
    }

    public List<SelectItem> getKurumList() {
        if (this.kurumList == null) {
            this.kurumList = kurumGetir();
        }
        return kurumList;
    }

    public void setKurumList(List<SelectItem> kurumList) {
        this.kurumList = kurumList;
    }
}
