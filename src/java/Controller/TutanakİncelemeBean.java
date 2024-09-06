package Controller;

import jakarta.inject.Named;
import Entity.Tutanakİnceleme;
import jakarta.annotation.PostConstruct;
import dao.TutanakİncelemeDAO;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;

@Named(value = "tutanakİncelemeBean")
@ViewScoped
public class TutanakİncelemeBean implements Serializable {

    private Tutanakİnceleme entity;
    private TutanakİncelemeDAO dao;

    public void tutanakİncelemeEkle() {
        try {
            this.getDao().TutanakİncelemeEkle(getEntity());

            // Başarılı mesaj
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Başarılı", "Tutanak inceleme başarıyla kaydedildi."));
        } catch (Exception e) {
            // Hata mesajı
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hata", "Tutanak kaydedilirken bir hata oluştu."));
        }
    }

    public Tutanakİnceleme getEntity() {
        if (this.entity == null) {
            this.entity = new Tutanakİnceleme();
        }
        return this.entity;
    }

    public void setEntity(Tutanakİnceleme entity) {
        this.entity = entity;
    }

    public TutanakİncelemeDAO getDao() {
        if (this.dao == null) {
            this.dao = new TutanakİncelemeDAO();
        }

        return this.dao;
    }

    public void setDao(TutanakİncelemeDAO dao) {
        this.dao = dao;
    }

    public TutanakİncelemeBean() {
    }

    @PostConstruct
    public void init() {
        getDao().setIslemBasariliMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
    }

}
