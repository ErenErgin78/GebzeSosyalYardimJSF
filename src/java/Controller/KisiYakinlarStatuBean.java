package Controller;

import Entity.KisiYakinlarStatu;
import dao.KisiYakinlarStatuDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.faces.model.SelectItem;
import java.util.List;

@Named(value = "kisiYakinlarStatuBean")
@Dependent
public class KisiYakinlarStatuBean {

    private KisiYakinlarStatu entity;
    private KisiYakinlarStatuDAO dao;
    private List<KisiYakinlarStatu> list;
    private List<SelectItem> kisiYakinlarStatulist;

    @PostConstruct
    public void init() {
    }

    public KisiYakinlarStatuBean() {
    }

    public KisiYakinlarStatu getEntity() {
        if (this.entity == null) {
            this.entity = new KisiYakinlarStatu();
        }
        return this.entity;
    }

    public void setEntity(KisiYakinlarStatu entity) {
        this.entity = entity;
    }

    public KisiYakinlarStatuDAO getDao() {
        if (this.dao == null) {
            this.dao = new KisiYakinlarStatuDAO();
        }
        return dao;
    }

    public void setDao(KisiYakinlarStatuDAO dao) {
        this.dao = dao;
    }

    public List<KisiYakinlarStatu> getList() {
        return list;
    }

    public void setList(List<KisiYakinlarStatu> list) {
        this.list = list;
    }

    public List<SelectItem> getKisiYakinlarStatulist() {
        kisiYakinlarStatulist = getDao().KisiYakinlarStatuGetir();
        return kisiYakinlarStatulist;
    }

    public void setKisiYakinlarStatulist(List<SelectItem> kisiYakinlarStatulist) {
        this.kisiYakinlarStatulist = kisiYakinlarStatulist;
    }

}
