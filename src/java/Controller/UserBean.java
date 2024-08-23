package Controller;

import Entity.User;
import dao.UsersDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import jakarta.servlet.http.HttpSession;
import java.util.Date;

@Named("userBean")
@SessionScoped
public class UserBean implements Serializable {

    private User entity;
    private UsersDAO dao;
    private List<User> list;

    private Date tarih;

    // Yeni kullanıcı oluşturur
    public void create() {
        this.getDao().UserEkle(getEntity());
    }

    // Kullanıcıyı siler
    public void delete(int UserID) {
        this.getDao().UserSil(UserID);
        this.list = this.getDao().UserListesi();
    }

    // Kullanıcı mesajlarını temizler
    public void userMesajTemizle() {
        this.getDao().UsersMesajTemizle();
    }

    // Kullanıcı girişini gerçekleştirir
    public void giris() {
        boolean basarili = this.getDao().KullaniciGiris(this.getDao().getKullanici_adi(), this.getDao().getSifre());

        FacesContext context = FacesContext.getCurrentInstance();
        if (basarili) {
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            session.setAttribute("user", this.getDao().getKullanici_adi()); // Kullanıcı bilgisini oturumda sakla

            try {
                context.getExternalContext().redirect("index.xhtml");
                context.addMessage(null, null);
            } catch (IOException e) {
                // Yönlendirme hatası durumunda yakalar
            }
        } else {
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kullanıcı adı veya şifre hatalıdır", null));
        }

    }

    // Kullanıcı oturumunu sonlandırır
    public String cikis() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }

    // Kullanıcı düzenleme işlemi yapar
    public void edit(User user) {
        this.entity = user;
    }

    // Kullanıcı varlık nesnesini getirir
    public User getEntity() {
        if (this.entity == null) {
            this.entity = new User();
        }
        return entity;
    }

    // Kullanıcı varlık nesnesini ayarlar
    public void setEntity(User entity) {
        this.entity = entity;
    }

    // DAO nesnesini getirir
    public UsersDAO getDao() {
        if (this.dao == null) {
            this.dao = new UsersDAO();
            this.dao.setMesaj(null);
        }
        return this.dao;
    }

    // DAO nesnesini ayarlar
    public void setDao(UsersDAO dao) {
        this.dao = dao;
    }

    // Kullanıcı listesini getirir
    public List<User> getList() {
        this.list = this.getDao().UserListesi();
        return list;
    }

    // Kullanıcı listesini ayarlar
    public void setList(List<User> list) {
        this.list = list;
    }

    // Tarih değerini getirir
    public Date getTarih() {
        return tarih;
    }

    // Tarih değerini ayarlar
    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    // Bean nesnesi yüklendiğinde çalışacak başlangıç işlemleri
    @PostConstruct
    public void init() {
        getDao().setMesaj(null); // sayfa yüklendiğinde mesajı sıfırlar
        tarih = new Date();
    }

    public UserBean() {
    }
}
