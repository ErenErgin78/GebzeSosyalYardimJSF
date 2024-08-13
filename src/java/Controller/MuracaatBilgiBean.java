package Controller;

import Entity.MuracaatBilgi;
import dao.MuracaatBilgiDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "muracaatBilgiBean")
@SessionScoped
public class MuracaatBilgiBean implements Serializable {

    private MuracaatBilgi entity;
    private MuracaatBilgiDAO dao;
    private List<MuracaatBilgi> list;

    public Integer ekle() {
        return this.getDao().MuracaatBilgiEkle(getEntity());
    }

    public void delete(int MuracaatID) {
        this.getDao().Delete(MuracaatID);
        this.list = this.getDao().MuracaatBilgiListesi(); 
    }

    public void edit(MuracaatBilgi muracaat) {
        this.entity = muracaat;
    }

    public MuracaatBilgi getEntity() {
        if (this.entity == null) {
            this.entity = new MuracaatBilgi();
        }
        return this.entity;
    }

    public void setEntity(MuracaatBilgi entity) {
        this.entity = entity;
    }

    public MuracaatBilgiDAO getDao() {
        if (this.dao == null) {
            this.dao = new MuracaatBilgiDAO();
        }
        return this.dao;
    }

    public void setDao(MuracaatBilgiDAO dao) {
        this.dao = dao;
    }

    public List<MuracaatBilgi> getList() {
        if (this.list == null) {
            this.list = this.getDao().MuracaatBilgiListesi();
        }
        return this.list;
    }

    public void setList(List<MuracaatBilgi> list) {
        this.list = list;
    }
}
