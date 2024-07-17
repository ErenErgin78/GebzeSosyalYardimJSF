package Controller;

import Entity.Kisi;
import dao.KisiDAO;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import java.util.List;

@Named(value = "kisiBean")
@Dependent
public class KisiBean {

    private Kisi entity;
    private KisiDAO dao;
    private List<Kisi> list;

    public void create() {
        // Ensure entity is initialized before passing it to the DAO
        if (this.entity == null) {
            this.entity = new Kisi();
        }
        this.getDao().Create(this.entity);
        this.entity = new Kisi(); // Yeni bir Kisi nesnesi oluştur
        // Listeyi güncelle, yeni oluşturulan varlık dahil edilsin
        this.list = this.getDao().GetList();
    }

    public void delete(int KisiID) {
        this.getDao().Delete(KisiID);
        this.list = this.getDao().GetList(); // Silme işleminden sonra listeyi güncelle
    }

    public void edit(Kisi kisi) {
        this.entity = kisi;
    }

    public Kisi getEntity() {
        if (this.entity == null) {
            this.entity = new Kisi();
        }
        return this.entity;
    }

    public void setEntity(Kisi entity) {
        this.entity = entity;
    }

    public KisiDAO getDao() {
        if (this.dao == null) {
            this.dao = new KisiDAO();
        }
        return this.dao;
    }

    public void setDao(KisiDAO dao) {
        this.dao = dao;
    }

    public List<Kisi> getList() {
        if (this.list == null) {
            this.list = this.getDao().GetList();
        }
        return this.list;
    }

    public void setList(List<Kisi> list) {
        this.list = list;
    }
}
