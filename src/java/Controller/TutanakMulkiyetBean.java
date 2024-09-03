package Controller;

import Entity.TutanakMulkiyet;
import dao.TutanakMulkiyetDAO;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "tutanakMulkiyetBean")
@SessionScoped
public class TutanakMulkiyetBean implements Serializable {

    private TutanakMulkiyet entity;
    private TutanakMulkiyetDAO dao;
    private List<TutanakMulkiyet> list;

    // Yeni bir TutanakMulkiyet ekleme metodu
    public void tutanakMulkiyetEkle() {
        this.getDao().TutanakMulkiyetEkle(getEntity());
    }

    // Belirli bir TutanakMulkiyet'i silme metodu
    public void tutanakMulkiyetSil(int tutanakMulkiyetId) {
        this.getDao().TutanakMulkiyetSil(tutanakMulkiyetId);
    }

    public void tutanakMulkiyetMesajTemizle() {
        this.getDao().TutanakMulkiyetMesajTemizle();
    }

    // TutanakMulkiyet verilerini listeleme metodu
    public List<TutanakMulkiyet> getList() {
        if (this.list == null) {
            this.list = this.getDao().TutanakMulkiyetListesi();
        }
        return this.list;
    }

    // Listeyi yenileme metodu
    public void listeYenile() {
        this.list = this.getDao().TutanakMulkiyetListesi();
    }

    // Entity getter ve setter
    public TutanakMulkiyet getEntity() {
        if (this.entity == null) {
            this.entity = new TutanakMulkiyet();
        }
        return this.entity;
    }

    public void setEntity(TutanakMulkiyet entity) {
        this.entity = entity;
    }

    // DAO getter ve setter
    public TutanakMulkiyetDAO getDao() {
        if (this.dao == null) {
            this.dao = new TutanakMulkiyetDAO();
        }
        return this.dao;
    }

    public void setDao(TutanakMulkiyetDAO dao) {
        this.dao = dao;
    }

    // Constructor
    public TutanakMulkiyetBean() {
    }
}
