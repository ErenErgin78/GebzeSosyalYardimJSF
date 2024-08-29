package Controller;

import Entity.Meslek;
import dao.MeslekDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "meslekBean")
@ViewScoped
public class MeslekBean implements Serializable {

    private Meslek entity;
    private MeslekDAO dao;
    private List<Meslek> list;
    private List<SelectItem> meslekList;

    public void meslekekle() {
        this.getDao().MeslekEkle(getEntity());
    }

    public void mesleksil(int meslekId) {
        this.getDao().MeslekSil(meslekId);
    }

    public Meslek getEntity() {
        if (this.entity == null) {
            this.entity = new Meslek();
        }
        return this.entity;
    }

    public void setEntity(Meslek entity) {
        this.entity = entity;
    }

    public MeslekDAO getDao() {
        if (this.dao == null) {
            this.dao = new MeslekDAO();
            dao.setMesaj(null);
        }
        return this.dao;
    }

    public void setDao(MeslekDAO dao) {
        this.dao = dao;
    }

    public List<Meslek> getList() {
        this.list = this.getDao().MeslekListesi();
        return this.list;
    }

    public void listeyenile() {
        this.list = this.getDao().MeslekListesi();
    }

    public void setList(List<Meslek> list) {
        this.list = list;
    }

    public List<SelectItem> getMeslekList() {
        meslekList = getDao().MeslekGetir();
        return meslekList;
    }

    public void setMeslekList(List<SelectItem> meslekList) {
        this.meslekList = meslekList;
    }

    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

    public MeslekBean() {
    }
}