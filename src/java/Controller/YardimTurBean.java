package Controller;

import Entity.YardimTur;
import dao.YardimTurDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "yardimTurBean")
@ViewScoped
public class YardimTurBean implements Serializable {

    private YardimTur entity;
    private YardimTurDAO dao;
    private List<YardimTur> list;
    private List<SelectItem> yardimTurList;

    public YardimTur getEntity() {
        if (this.entity == null) {
            this.entity = new YardimTur();
        }
        return this.entity;
    }

    public void setEntity(YardimTur entity) {
        this.entity = entity;
    }

    public YardimTurDAO getDao() {
        if (this.dao == null) {
            this.dao = new YardimTurDAO();
        }
        return this.dao;
    }

    public void setDao(YardimTurDAO dao) {
        this.dao = dao;
    }

    public List<YardimTur> getList() {
        return list;
    }

    public void setList(List<YardimTur> list) {
        this.list = list;
    }

    public List<SelectItem> getYardimTurList() {
        yardimTurList = getDao().YardimTurGetir();
        return yardimTurList;
    }

    public void setYardimTurList(List<SelectItem> yardimTurList) {
        this.yardimTurList = yardimTurList;
    }

    @PostConstruct
    public void init() {
    }

    public YardimTurBean() {
    }
}
