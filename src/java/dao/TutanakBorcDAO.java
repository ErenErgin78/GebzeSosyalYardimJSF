/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.TutanakBorc;
import static Various.ErrorFinder.DetectError;
import java.sql.CallableStatement;
import util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class TutanakBorcDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;

    private Integer id = 0;
    private String isim = "";

    public void TutanakBorcEkle(TutanakBorc borc) {
        try {
            Connection conn = this.getDb();

            String callQueryBorc = "{call INSERT_TUTANAK_BORC(?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement csBorc = conn.prepareCall(callQueryBorc);
            csBorc.setFloat(1, borc.getElektrik());
            csBorc.setFloat(2, borc.getSu());
            csBorc.setFloat(3, borc.getDogalgaz());
            csBorc.setFloat(4, borc.getKira());
            csBorc.setFloat(5, borc.getKredi_karti());
            csBorc.setFloat(6, borc.getDiger());
            csBorc.setString(7, borc.getDiger_aciklama());
            csBorc.registerOutParameter(8, java.sql.Types.INTEGER);
            csBorc.execute();
            borc.setBorc_id(csBorc.getInt(8));

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (SQLException ex) {

            this.islemBasariliMesaj = DetectError(ex);

        }
    }

    public List<TutanakBorc> GetList() {

        List<TutanakBorc> BorcList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();

            String Selectquery = "SELECT * FROM BORC";

            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TutanakBorc borc = new TutanakBorc();
                borc.setBorc_id(rs.getInt("BORC_ID"));
                borc.setElektrik(rs.getFloat("ELEKTRIK"));
                borc.setSu(rs.getFloat("SU"));
                borc.setDogalgaz(rs.getFloat("DOGALGAZ"));
                borc.setKira(rs.getFloat("KIRA"));
                borc.setKredi_karti(rs.getFloat("KREDI_KARTI"));
                borc.setDiger(rs.getFloat("DIGER"));

                borc.setDiger_aciklama(rs.getString("DIGER_ACIKLAMA"));
                borc.setGuncelleme_tarihi(rs.getDate("GUNCELLEME_TARIHI"));

                BorcList.add(borc);
            }
            this.islemBasariliMesaj = "işlem başarılı";

        } catch (SQLException ex) {
            DetectError(ex);
        }
        return BorcList;
    }

    public void TutanakBorcSil(int borcId) {
        String deleteQuery = "DELETE FROM BORC WHERE BORC_ID = " + borcId;

        try {
            Statement statement = getDb().createStatement();
            int rowsDeleted = statement.executeUpdate(deleteQuery);
            System.out.println(rowsDeleted + " borc kaydı silindi.");

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public void TutanakBorcMesajTemizle() {
        this.islemBasariliMesaj = null;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getIslemBasariliMesaj() {
        return islemBasariliMesaj;
    }

    public void setIslemBasariliMesaj(String islemBasariliMesaj) {
        this.islemBasariliMesaj = islemBasariliMesaj;
    }

}