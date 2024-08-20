package Controller;

import Entity.Kisi;
import static Various.ErrorFinder.DetectError;
import dao.KisiDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.model.SelectItem;
import java.io.Serializable;
import java.util.List;

@Named(value = "kisiBean")
@SessionScoped
public class KisiBean implements Serializable {

    private Kisi entity;
    private KisiDAO dao;
    private List<Kisi> list;
    private List<SelectItem> MedeniList;

    @PostConstruct
    public void init() {
        entity = new Kisi();
    }

    public Integer ekle() {

        return this.getDao().KisiEkle(getEntity());
    }

    public Integer ekle(Integer detayId) {

        return this.getDao().KisiEkle(getEntity(), detayId);
    }

    public void KisiSil(int kisiID) {
        this.getDao().KisiSil(kisiID);
        this.list = this.getDao().KisiListesi();
    }

    public void edit(Kisi kisi) {
        this.entity = kisi;
    }
    
    public Kisi KisiBul() {
        if (entity.getKimlik_no() == null) {
            return null;
        }
        Kisi bulunanKisi = dao.KisiBul(entity.getKimlik_no());        
        
        entity.setIsim(bulunanKisi.getIsim());
        entity.setSoyisim(bulunanKisi.getSoyisim());
        entity.setCinsiyet(bulunanKisi.getCinsiyet());
        entity.setCilt_no(bulunanKisi.getCilt_no());
        entity.setAile_sira_no(bulunanKisi.getAile_sira_no());
        entity.setSira_no(bulunanKisi.getSira_no());
        entity.setDogum_tarihi(entity.getDogum_tarihi());
        entity.setMedeni_durum_id(entity.getMedeni_durum_id());
        entity.setMedeni_durum_isim(entity.getMedeni_durum_isim());
        entity.setKayit_tarihi(entity.getKayit_tarihi());
        entity.setAktif(entity.getAktif());
        
        
        
        return bulunanKisi;
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
            this.list = this.getDao().KisiListesi();
        }
        return this.list;
    }

    public void setList(List<Kisi> list) {
        this.list = list;
    }

    public List<SelectItem> getMedeniList() {
        MedeniList = getDao().kisiGetir();
        return MedeniList;
    }

    public void setMedeniList(List<SelectItem> MedeniList) {
        this.MedeniList = MedeniList;
    }

}
