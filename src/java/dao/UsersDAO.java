/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.User;
import util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eren
 */
public class UsersDAO extends DBConnection {

    private Connection db;

    private String kullanici_adi;
    private String sifre;

    public void Create(User user) {
        try {
            Statement statement = this.getDb().createStatement();

            String Insertquery = "INSERT INTO KULLANICI (kullanici_unvan_id, kullanici_durum_id, kullanici_kullanici_adi  kullanici_isim, kullanici_adres, kullanici_sicil_no, kullanici_telefon, kullanici_cinsiyet, kullanici_profil_id) VALUES"
                    + "('" + user.getKullanici_unvan_id() + "','" + user.getKullanici_durum_id() + "','" + user.getKullanici_kullanici_adi() + "','" + user.getKullanici_isim() + "','" + user.getKullanici_adres() + "','" + user.getKullanici_sicil_no() + "','" + user.getKullanici_telefon() + "','" + user.getKullanici_cinsiyet() + "','" + user.getKullanici_profil_id() + "')";

            int r = statement.executeUpdate(Insertquery);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<User> GetList() {

        List<User> UserList = new ArrayList<>();

        try {

            Statement statement = getDb().createStatement();

            String Selectquery = "SELECT kullanici_id, kullanici_kullanici_adi, U.kullanici_unvan, D.kullanici_durum, kullanici_isim, kullanici_adres, kullanici_sicil_no,kullanici_telefon,kullanici_cinsiyet,kullanici_kayit_tarih FROM KULLANICI K\n"
                    + "JOIN KULLANICI_DURUM D ON K.kullanici_durum_id = D.kullanici_durum_id\n"
                    + "JOIN KULLANICI_UNVAN U ON K.kullanici_unvan_id = U.kullanici_unvan_id";

            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                UserList.add(new User(
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
            System.out.println(ex.getMessage());
        }
        return UserList;
    }

    public void Delete(int kullaniciId) {
        String deleteQuery = "DELETE FROM KULLANICI WHERE kullanici_id = ?";

        try {
            Connection connection = this.getDb(); // assuming getDb() returns a Connection
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.setInt(1, kullaniciId);

            int rowsDeleted = statement.executeUpdate();
            System.out.println(rowsDeleted + " kullanıcı silindi.");

        } catch (SQLException ex) {
            System.out.println("Veritabanı hatası: " + ex.getMessage());
        }
    }

    public boolean KullaniciGiris() {
        boolean Girisbasarili = false;
        try {

            PreparedStatement preparedStatement = getDb().prepareStatement("SELECT * FROM KULLANICI WHERE KULLANICI_KULLANICI_ADI = ? AND SIFRE = ?");
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, sifre);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Girisbasarili = true;
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException ex) {
            System.err.println("SQL Hatası: " + ex.getMessage());
            System.err.println("SQL Durum Kodu: " + ex.getSQLState());
            System.err.println("Hata Kodu: " + ex.getErrorCode());
        } finally {
            kullanici_adi = null;
            sifre = null;
        }
        return Girisbasarili;
    }

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


}
