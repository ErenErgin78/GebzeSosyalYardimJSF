package Controller;

import Entity.Kisi;
import dao.KisiDAO;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.model.SelectItem;
import jakarta.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "kisiBean")
@SessionScoped
public class KisiBean implements Serializable {

    private Kisi entity;
    private KisiDAO dao;
    private List<Kisi> list;
    private List<SelectItem> MedeniList;
    private List<SelectItem> sokakList;

    @Inject
    private KisiBean kisiBean;

    @PostConstruct
    public void init() {
        // Bean'in başlatma işlemlerini gerçekleştirir
        entity = new Kisi();
    }

    // Yeni bir kişi ekler ve ID'yi döner
    public Integer ekle() {
        return this.getDao().KisiEkle(getEntity());
    }

    public Integer kisiMuracaatEkle() {
         return this.getDao().KisiMuracaatEkle(entity, 1);  // 1 örnek olarak verildi, uygun bir `ekleyenKullaniciId` ile değiştirin
    }

    // Belirtilen detay ID ile yeni bir kişi ekler ve ID'yi döner
    public Integer ekle(Integer detayId) {
        return this.getDao().KisiEkle(getEntity(), detayId);
    }

    // Belirtilen ID'ye sahip kişiyi siler
    public void KisiSil(int kisiID) {
        this.getDao().KisiSil(kisiID);
        this.list = this.getDao().KisiListesi();
    }

    // Düzenleme yapmak için seçilen kişiyi belirler
    public void edit(Kisi kisi) {
        this.entity = kisi;
    }

    // Kimlik numarasına göre kişi bulur ve varlık alanlarını doldurur
    public Kisi KisiBul() {
        if (entity.getKimlik_no() == null) {
            return null;
        }

        Kisi bulunanKisi = dao.KisiBul(entity.getKimlik_no());

        if (bulunanKisi != null) {
            entity.setIsim(bulunanKisi.getIsim());
            entity.setSoyisim(bulunanKisi.getSoyisim());
            entity.setCinsiyet(bulunanKisi.getCinsiyet());
            entity.setCilt_no(bulunanKisi.getCilt_no());
            entity.setAile_sira_no(bulunanKisi.getAile_sira_no());
            entity.setSira_no(bulunanKisi.getSira_no());
            entity.setDogum_tarihi(bulunanKisi.getDogum_tarihi());
            entity.setMedeni_durum_id(bulunanKisi.getMedeni_durum_id());
            entity.setMahalle_id(bulunanKisi.getMahalle_id());
            entity.setSokak_id(bulunanKisi.getSokak_id());
            entity.setSite(bulunanKisi.getSite());
            entity.setAdres_tarifi(bulunanKisi.getAdres_tarifi());
            entity.setKapi_no(bulunanKisi.getKapi_no());
            entity.setDaire_no(bulunanKisi.getDaire_no());
            entity.setEv_telefon(bulunanKisi.getEv_telefon());
            entity.setCep_telefon(bulunanKisi.getCep_telefon());
            entity.setEposta(bulunanKisi.getEposta());
            entity.setKayit_tarihi(bulunanKisi.getKayit_tarihi());
            entity.setAktif(bulunanKisi.getAktif());
        }

        return bulunanKisi;
    }

    // Sokak ekleme işlemi
    public void sokakekle() {
        this.getDao().SokakEkle(getEntity());
    }

    // Sokak silme işlemi
    public void sokaksil(int SokakId) {
        this.getDao().SokakSil(SokakId);
        this.list = this.getDao().SokakListesi();
    }

    // Sokak mesaj temizleme işlemi
    public void sokakMesajTemizle() {
        this.getDao().SokakMesajTemizle();
    }

    // Sokak listesi getir
    public List<SelectItem> sokakgetir() {
        return this.getDao().SokakGetir(kisiBean.getEntity().getMahalle_id());
    }

    // Sokak yükleme işlemi
    public void sokakyukle(AjaxBehaviorEvent event) {
        sokakList = new ArrayList<>();
        if (kisiBean.getEntity().getMahalle_id() != 0) {
            sokakList = this.getDao().SokakGetir(kisiBean.getEntity().getMahalle_id());
        }
    }

    // Varlık nesnesini getirir
    public Kisi getEntity() {
        if (this.entity == null) {
            this.entity = new Kisi();
        }
        return this.entity;
    }

    // Varlık nesnesini ayarlar
    public void setEntity(Kisi entity) {
        this.entity = entity;
    }

    // DAO nesnesini getirir
    public KisiDAO getDao() {
        if (this.dao == null) {
            this.dao = new KisiDAO();
        }
        return this.dao;
    }

    // DAO nesnesini ayarlar
    public void setDao(KisiDAO dao) {
        this.dao = dao;
    }

    // Kişi listesini getirir
    public List<Kisi> getList() {
        if (this.list == null) {
            this.list = this.getDao().KisiListesi();
        }
        return this.list;
    }

    // Kişi listesini ayarlar
    public void setList(List<Kisi> list) {
        this.list = list;
    }

    // Medeni durum listesi getirir
    public List<SelectItem> getMedeniList() {
        MedeniList = getDao().kisiGetir();
        return MedeniList;
    }

    // Medeni durum listesini ayarlar
    public void setMedeniList(List<SelectItem> MedeniList) {
        this.MedeniList = MedeniList;
    }

    // Sokak listesi getirir
    public List<SelectItem> getSokakList() {
        return sokakList;
    }

    // Sokak listesini ayarlar
    public void setSokakList(List<SelectItem> sokakList) {
        this.sokakList = sokakList;
    }
}
