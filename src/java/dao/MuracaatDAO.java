/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.KisiDAO;
import Entity.Muracaat;
import util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eren
 */
public class MuracaatDAO extends DBConnection {

    private Connection db;

    private Integer muracaat_bilgi_id;

    public void Create(Muracaat muracaat) {

        ResultSet generatedKeys = null;
        try {
            // MURACAAT_BILGI:
            String insertQueryMuracaatBilgi = "INSERT INTO MURACAAT_BILGI (ARSIV_DOSYA_NO, MURACAAT_TIP_ID, BOLGE, ACIKLAMA, MURACAAT_TARIHI) VALUES (" +
                    muracaat.getArsiv_dosya_no() + ", " + muracaat.getMuracaat_tip_id() + ", " + muracaat.getBolge() + ", '" + muracaat.getAciklama() + "', '" + new java.sql.Date(muracaat.getMuracaat_tarihi().getTime()) + "')";
            Statement statement = getDb().createStatement();
            statement.executeUpdate(insertQueryMuracaatBilgi, Statement.RETURN_GENERATED_KEYS);
            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                muracaat_bilgi_id = generatedKeys.getInt(1);
            }

            // MURACAAT:

            // KISI_TEMEL'den id almak ve atamak
            String Selectquery = "SELECT KISI_ID FROM KISI_TEMEL";
            ResultSet rs = statement.executeQuery(Selectquery);
            if (rs.next()) {
                muracaat.setKisi_temel_id(rs.getInt("KISI_ID"));
            }

            String insertQueryMuracaat = "INSERT INTO MURACAAT (KISI_TEMEL_ID, MURACAAT_BILGI_ID) VALUES ("
                    + muracaat.getKisi_temel_id() +"," + muracaat_bilgi_id + ")";
            statement.executeUpdate(insertQueryMuracaat);
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Muracaat> GetList() {

        List<Muracaat> KisiList = new ArrayList<>();

        try {

            Statement statement = getDb().createStatement();

            String Selectquery = "SELECT * FROM MURACAAT";

            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                KisiList.add(new Muracaat());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return KisiList;
    }

    public void Delete(int kullaniciId) {
        String deleteQuery = "DELETE FROM MURACAAT WHERE kullanici_id = " + kullaniciId;

        try {
            Statement statement = getDb().createStatement();

            int rowsDeleted = statement.executeUpdate(deleteQuery);
            System.out.println(rowsDeleted + " kisi silindi.");

        } catch (SQLException ex) {
            System.out.println("Veritabanı hatası: " + ex.getMessage());
        }
    }

    public Connection getDb() {
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

    public Integer getMuracaat_bilgi_id() {
        return muracaat_bilgi_id;
    }

    public void setMuracaat_bilgi_id(Integer muracaat_bilgi_id) {
        this.muracaat_bilgi_id = muracaat_bilgi_id;
    }

}
