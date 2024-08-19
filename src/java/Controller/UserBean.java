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

    public void create() {
        this.getDao().UserEkle(getEntity());
    }

    public void delete(int UserID) {
        this.getDao().UserSil(UserID);
        this.list = this.getDao().UserListesi();
    }

    public void userMesajTemizle() {
        this.getDao().UsersMesajTemizle();
    }

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
            }
        } else {
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kullanıcı adı veya şifre hatalıdır", null));
        }

    }

    public String cikis() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }

    public void edit(User user) {
        this.entity = user;
    }

    public User getEntity() {
        if (this.entity == null) {
            this.entity = new User();
        }
        return entity;
    }

    public void setEntity(User entity) {
        this.entity = entity;
    }

    public UsersDAO getDao() {
        if (this.dao == null) {
            this.dao = new UsersDAO();
        }
        return dao;
    }

    public void setDao(UsersDAO dao) {
        this.dao = dao;
    }

    public List<User> getList() {
        this.list = this.getDao().UserListesi();
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    @PostConstruct
    public void init() {
        getDao().setMessage(null); // sayfa yüklendiğinde mesajı sıfırlar
        tarih = new Date();
    }
}
