package Controller;

import Entity.KisiDetay;
import dao.KisiDetayDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "kisiDetayBean")
@SessionScoped
public class KisiDetayBean implements Serializable {
    
    private KisiDetay entity;
    private KisiDetayDAO dao;
    private List<KisiDetay> list;
    
    @PostConstruct
    public void init() {
        entity = new KisiDetay();
    }
    
    public void onPreRenderView() {
        getDao().setIslemBasariliMesaj(null);
    }
    
    public Integer ekle() {
        return this.getDao().Create(getEntity());
    }
    
        public Integer ekleMuracaat(Integer iletisimId, Integer adresId) {
        return this.getDao().CreateMuracaat(getEntity(), iletisimId, adresId);
    }
    
    public void KisiDetaySil(int detayId) {
        this.getDao().Delete(detayId);
        this.list = this.getDao().GetList();
    }
    
    public void edit(KisiDetay detay) {
        this.entity = detay;
    }
    
    public KisiDetay getEntity() {
        if (this.entity == null) {
            this.entity = new KisiDetay();
        }
        return this.entity;
    }
    
    public void setEntity(KisiDetay entity) {
        this.entity = entity;
    }
    
    public KisiDetayDAO getDao() {
        if (this.dao == null) {
            this.dao = new KisiDetayDAO();
        }
        return this.dao;
    }
    
    public void setDao(KisiDetayDAO dao) {
        this.dao = dao;
    }
    
    public List<KisiDetay> getList() {
        if (this.list == null) {
            this.list = this.getDao().GetList();
        }
        return this.list;
    }
    
    public void setList(List<KisiDetay> list) {
        this.list = list;
    }
}
