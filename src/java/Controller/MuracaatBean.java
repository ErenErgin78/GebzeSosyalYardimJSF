package Controller;

import Entity.Muracaat;
import dao.MuracaatDAO;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import java.util.List;

@Named(value = "muracaatBean")
@Dependent
public class MuracaatBean {

    private Muracaat entity;
    private MuracaatDAO dao;
    private List<Muracaat> list;

    public void create() {
        // Ensure entity is initialized before passing it to the DAO
        if (this.entity == null) {
            this.entity = new Muracaat();
        }
        this.getDao().Create(this.entity);
        this.entity = new Muracaat();
        // Refresh the list to include the newly created entity
        this.list = this.getDao().GetList();
    }

    public void delete(int MuracaatID) {
        this.getDao().Delete(MuracaatID);
        this.list = this.getDao().GetList(); // Refresh the list after deletion
    }

    public void edit(Muracaat muracaat) {
        this.entity = muracaat;
    }

    public Muracaat getEntity() {
        if (this.entity == null) {
            this.entity = new Muracaat();
        }
        return this.entity;
    }

    public void setEntity(Muracaat entity) {
        this.entity = entity;
    }

    public MuracaatDAO getDao() {
        if (this.dao == null) {
            this.dao = new MuracaatDAO();
        }
        return this.dao;
    }

    public void setDao(MuracaatDAO dao) {
        this.dao = dao;
    }

    public List<Muracaat> getList() {
        if (this.list == null) {
            this.list = this.getDao().GetList();
        }
        return this.list;
    }

    public void setList(List<Muracaat> list) {
        this.list = list;
    }
}
