package Controller;

import Entity.Sorgula;
import dao.SorgulaDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named(value = "sorgulaBean")
@SessionScoped
public class SorgulaBean implements Serializable {
       private Sorgula entity;
    private SorgulaDAO dao;

    public Sorgula getEntity() {
        return entity;
    }

    public void setEntity(Sorgula entity) {
        this.entity = entity;
    }

    public SorgulaDAO getDao() {
        if (this.dao == null) {
            this.dao = new SorgulaDAO();
        }
        return dao;
    }

    public void setDao(SorgulaDAO dao) {
        this.dao = dao;
    }

    public Sorgula SorgulaBul() {
        if (entity.getKimlik_no() == null) {
            return null;
        }
        
        Sorgula bulunanKisi = dao.SorgulaBul(entity.getKimlik_no());
        
        if (bulunanKisi != null) {
            entity.setIsim(bulunanKisi.getIsim());
            entity.setSoyisim(bulunanKisi.getSoyisim());
            entity.setCinsiyet(bulunanKisi.getCinsiyet());
            entity.setCilt_no(bulunanKisi.getCilt_no());
            entity.setAile_sira_no(bulunanKisi.getAile_sira_no());
            entity.setSira_no(bulunanKisi.getSira_no());
            entity.setDogum_tarihi(bulunanKisi.getDogum_tarihi());
            entity.setMedeni_durum_id(bulunanKisi.getMedeni_durum_id());
            entity.setMedeni_durum_isim(bulunanKisi.getMedeni_durum_isim());
            entity.setKisi_iletisim_id(bulunanKisi.getKisi_iletisim_id());
            entity.setEv_telefon(bulunanKisi.getEv_telefon());
            entity.setCep_telefon(bulunanKisi.getCep_telefon());
            entity.setEposta(bulunanKisi.getEposta());
            entity.setKisi_adres_id(bulunanKisi.getKisi_adres_id());
            entity.setTarif(bulunanKisi.getTarif());
            entity.setSite(bulunanKisi.getSite());
            entity.setKapi_no(bulunanKisi.getKapi_no());
            entity.setDaire_no(bulunanKisi.getDaire_no());
            entity.setKisi_adres_mahalle_id(bulunanKisi.getKisi_adres_mahalle_id());
            entity.setKisi_adres_mahalle_isim(bulunanKisi.getKisi_adres_mahalle_isim());
            entity.setKisi_mahalle_sokak_id(bulunanKisi.getKisi_mahalle_sokak_id());
            entity.setKisi_mahalle_sokak_isim(bulunanKisi.getKisi_mahalle_sokak_isim());
        }
        
        return bulunanKisi;
    }
}
