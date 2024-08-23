/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.User;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * UsersDAO, kullanıcı veritabanı işlemlerini gerçekleştiren sınıftır. Bu sınıf,
 * kullanıcı ekleme, silme, listeleme ve giriş işlemlerini yönetir. Ayrıca,
 * veritabanı bağlantısını yönetmek ve hata tespiti yapmak için yardımcı
 * metodlar içerir.
 *
 * @author Eren
 */
public class UsersDAO extends DBConnection {

    // Veritabanı bağlantısı için kullanılacak Connection nesnesi.
    private Connection db;

    // Kullanıcı adı, şifre ve diğer kullanıcı bilgileri
    private String kullanici_adi;
    private String sifre;

    // İşlemler sırasında kullanılacak mesajlar ve durumlar.
    private String mesaj;
    private Integer aktif = 0;
    private String isim = "";
    private String kullanici = "";
    private String telefon = ""; // String olarak değiştirildi
    private String sicil = "";

    /**
     * UserEkle metodu, yeni bir kullanıcıyı veritabanına ekler.
     */
    public void UserEkle(User user) {
        try {
            String insertQuery = "INSERT INTO KULLANICI (kullanici_unvan, kullanici_durum_id, kullanici_kullanici_adi, kullanici_isim, kullanici_adres, kullanici_sicil_no, kullanici_telefon, kullanici_cinsiyet, sifre) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            if (user.getKullanici_durum_id() == null) {
                user.setKullanici_durum_id(1);
            }
            user.setKullanici_durum_id(Integer.parseInt(user.getKullanici_durum()));

            PreparedStatement preparedStatement = this.getDb().prepareStatement(insertQuery);
            preparedStatement.setString(1, user.getKullanici_unvan());
            preparedStatement.setInt(2, user.getKullanici_durum_id());
            preparedStatement.setString(3, user.getKullanici_kullanici_adi());
            preparedStatement.setString(4, user.getKullanici_isim());
            preparedStatement.setString(5, user.getKullanici_adres());
            preparedStatement.setObject(6, user.getKullanici_sicil_no());
            preparedStatement.setObject(7, user.getKullanici_telefon());
            preparedStatement.setString(8, String.valueOf(user.getKullanici_cinsiyet()));
            preparedStatement.setString(9, user.getSifre());

            int r = preparedStatement.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            DetectError(ex);

        }

    }

    /**
     * UserListesi metodu, veritabanındaki tüm kullanıcıları listeler.
     */
    public List<User> UserListesi() {
        List<User> userList = new ArrayList<>();
        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT kullanici_id, kullanici_kullanici_adi, kullanici_unvan, D.kullanici_durum_id,D.kullanici_durum, ")
                    .append("kullanici_isim, kullanici_adres, kullanici_sicil_no, kullanici_telefon, ")
                    .append("kullanici_cinsiyet, kullanici_kayit_tarih FROM KULLANICI K ")
                    .append("JOIN KULLANICI_DURUM D ON K.kullanici_durum_id = D.kullanici_durum_id ")
                    .append("WHERE 1=1 "); // Tüm kayıtları getirmek için

            if (aktif != 0) {
                queryBuilder.append("AND D.kullanici_durum_id= ").append(aktif).append(" ");
            }

            if (!isim.isEmpty()) {
                queryBuilder.append("AND kullanici_isim LIKE '%").append(isim).append("%' ");
            }
            if (!kullanici.isEmpty()) {
                queryBuilder.append("AND kullanici_kullanici_adi LIKE '%").append(kullanici).append("%' ");
            }
            if (!telefon.isEmpty()) {
                queryBuilder.append("AND TO_CHAR(kullanici_telefon) LIKE '%").append(telefon).append("%' ");
            }
            if (!sicil.isEmpty()) {
                queryBuilder.append("AND TO_CHAR(kullanici_sicil_no) LIKE '%").append(sicil).append("%' ");
            }

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                userList.add(new User(
                        rs.getInt("kullanici_id"),
                        rs.getString("kullanici_isim"),
                        rs.getString("kullanici_adres"),
                        rs.getBigDecimal("kullanici_sicil_no").toBigInteger(),
                        rs.getBigDecimal("kullanici_telefon").toBigInteger(),
                        rs.getString("kullanici_cinsiyet").charAt(0),
                        rs.getDate("kullanici_kayit_tarih"),
                        rs.getString("kullanici_unvan"),
                        rs.getString("kullanici_durum"),
                        rs.getString("kullanici_kullanici_adi"))
                );
            }

        } catch (Exception ex) {
            DetectError(ex);
        }
        return userList;
    }

    /**
     * UserSil metodu, belirtilen kullanıcıyı veritabanından siler.
     *
     * @param kullaniciId Silinecek kullanıcının ID'si.
     */
    public void UserSil(int kullaniciId) {
        String deleteQuery = "DELETE FROM KULLANICI WHERE kullanici_id = ?";

        try {
            Connection connection = this.getDb(); // assuming getDb() returns a Connection
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.setInt(1, kullaniciId);

            int rowsDeleted = statement.executeUpdate();
            System.out.println(rowsDeleted + " kullanıcı silindi.");

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public boolean KullaniciGiris(String kullaniciAdi, String sifre) {
        boolean Girisbasarili = false;
        try {
            PreparedStatement preparedStatement = getDb().prepareStatement("SELECT * FROM KULLANICI WHERE KULLANICI_KULLANICI_ADI = ? AND SIFRE = ?");
            preparedStatement.setString(1, kullaniciAdi);
            preparedStatement.setString(2, sifre);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Girisbasarili = true;
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException ex) {
            DetectError(ex);
        }
        this.sifre = null;
        return Girisbasarili;
    }

    /**
     * DetectError metodu, yakalanan hataları tespit eder ve mesaj olarak
     * kullanıcıya bildirir.
     *
     * @param ex Yakalanan istisna.
     */
    private void DetectError(Exception ex) {
        //Hatayı yakalamak için
        FacesContext context = FacesContext.getCurrentInstance();
        StringBuilder errorMessage = new StringBuilder(ex.getMessage());
        StackTraceElement[] stackTrace = ex.getStackTrace();

        //Hatanın hangi satırda olduğunu görmek için
        for (StackTraceElement element : stackTrace) {
            if (element.getClassName().startsWith("dao")) {
                errorMessage.append(" (at ").append(element.getFileName())
                        .append(":").append(element.getLineNumber()).append(")");
                break;
            }
        }
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage.toString(), null));

    }

    /**
     * UsersMesajTemizle metodu, mesaj değişkenini sıfırlar.
     */
    public void UsersMesajTemizle() {
        this.mesaj = null;
    }

    /**
     * Veritabanı bağlantısını sağlar.
     *
     * @return Veritabanı bağlantısını döner.
     */
    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getMessage() {
        return mesaj;
    }

    public void setMessage(String message) {
        this.mesaj = message;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getSicil() {
        return sicil;
    }

    public void setSicil(String sicil) {
        this.sicil = sicil;
    }

}
