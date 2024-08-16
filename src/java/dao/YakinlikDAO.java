/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Yakinlik;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import util.DBConnection;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class YakinlikDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    private String isim = "";
    private Integer aktif = 2;

    public void YakinlikEkle(Yakinlik yakinlik) {
        try {
            Connection conn = this.getDb();

            if (yakinlik.getAktiflik() == null) {
                yakinlik.setAktiflik(1);
            }

            String callQuery = "{call INSERT_YAKINLIK(?, ?)}";
            CallableStatement csYakinlik = conn.prepareCall(callQuery);

            csYakinlik.setString(1, yakinlik.getYakinlik_isim());
            csYakinlik.setInt(2, yakinlik.getAktiflik());

            csYakinlik.execute();
            this.mesaj = "İşlem başarıyla gerçekleşmiştir";

        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
    }

    public void YakinlikSil(int yakinlikId) {
        String deleteQuery = "DELETE FROM YAKINLIK WHERE YAKINLIK_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, yakinlikId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
    }

    public List<Yakinlik> YakinlikListesi() {
        List<Yakinlik> YakinlikList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT YAKINLIK_ID, YAKINLIK_ISIM, AKTIFLIK ")
                    .append("FROM YAKINLIK ")
                    .append("WHERE 1=1 ");

            // Add condition for AKTIFLIK field
            if (aktif != 2) {
                queryBuilder.append("AND AKTIFLIK = ").append(aktif).append(" ");
            }

            if (!isim.isEmpty()) {
                queryBuilder.append("AND YAKINLIK_ISIM LIKE '%").append(isim).append("%' ");
            }

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                YakinlikList.add(new Yakinlik(
                        rs.getInt("YAKINLIK_ID"),
                        rs.getString("YAKINLIK_ISIM"),
                        rs.getInt("AKTIFLIK")
                ));
            }

        } catch (Exception ex) {
            DetectError(ex);
        }
        return YakinlikList;
    }

    public List<SelectItem> YakinlikGetir() {
        List<SelectItem> YakinlikList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT YAKINLIK_ID , YAKINLIK_ISIM FROM YAKINLIK";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                YakinlikList.add(new SelectItem(rs.getInt("YAKINLIK_ID"), rs.getString("YAKINLIK_ISIM")));
            }
        } catch (Exception ex) {
            mesaj = DetectError(ex);
        }
        return YakinlikList;

    }

    public void YakinlikMesajTemizle() {
        this.mesaj = null;
    }

    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public void setDb(java.sql.Connection db) {
        this.db = db;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

}
