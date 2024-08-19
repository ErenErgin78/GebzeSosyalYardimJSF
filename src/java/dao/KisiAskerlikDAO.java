/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.KisiAskerlik;
import static Various.ErrorFinder.DetectError;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KisiAskerlikDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;


    public Integer AskerlikEkle(KisiAskerlik askerlik) {
        try {
            Connection conn = this.getDb();

            // KISIASKERLIK stored procedure çağırma (Örnek, değiştirilebilir)
            String callQueryAskerlik = "{call INSERT_KISI_ASKERLIK( ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement csAskerlik = conn.prepareCall(callQueryAskerlik);
            csAskerlik.setInt(1, askerlik.getAsker_hukumlu());
            csAskerlik.setInt(2, askerlik.getSure());
            csAskerlik.setString(3, askerlik.getAciklama());
            csAskerlik.setDate(4, new java.sql.Date(askerlik.getBaslangic_tarihi().getTime()));
            csAskerlik.setDate(5, new java.sql.Date(askerlik.getBitis_tarihi().getTime()));
            csAskerlik.setInt(6, askerlik.getAktif());
            csAskerlik.registerOutParameter(7, java.sql.Types.INTEGER);
            csAskerlik.execute();

            int askerlikId = csAskerlik.getInt(7);
            askerlik.setAskerlik_id(askerlikId);
            
            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
            return askerlikId;

        } catch (SQLException ex) {
            islemBasariliMesaj = DetectError(ex);
            return null;
        }
    }

    public List<KisiAskerlik> KisiAskerlikListesi() {

        List<KisiAskerlik> askerlikList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();

            String selectQuery = "SELECT * FROM KISIASKERLIK";

            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()) {
                KisiAskerlik askerlik = new KisiAskerlik();
                askerlik.setAskerlik_id(rs.getInt("ASKERLIK_ID"));
                askerlik.setAsker_hukumlu(rs.getInt("ASKER_HUKUMLU"));
                askerlik.setSure(rs.getInt("SURE"));
                askerlik.setAciklama(rs.getString("ACIKLAMA"));
                askerlik.setBaslangic_tarihi(rs.getDate("BASLANGIC_TARIHI"));
                askerlik.setBitis_tarihi(rs.getDate("BITIS_TARIHI"));
                askerlik.setAktif(rs.getInt("AKTIF"));
                askerlik.setKayit_tarihi(rs.getDate("KAYIT_TARIHI"));
                askerlik.setGuncelleme_tarihi(rs.getDate("GUNCELLEME_TARIHI"));

                askerlikList.add(askerlik);
            }
            this.islemBasariliMesaj = "İşlem başarılı";

        } catch (SQLException ex) {
           islemBasariliMesaj = DetectError(ex);
        }
        return askerlikList;
    }

    public void AskerlikSil(int askerlikId) {
        String deleteQuery = "DELETE FROM KISIASKERLIK WHERE ASKERLIK_ID = " + askerlikId;

        try {
            Statement statement = getDb().createStatement();
            int rowsDeleted = statement.executeUpdate(deleteQuery);
            System.out.println(rowsDeleted + " askerlik kaydı silindi.");

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (SQLException ex) {
          islemBasariliMesaj = DetectError(ex);
        }
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

    public String getIslemBasariliMesaj() {
        return islemBasariliMesaj;
    }

    public void setIslemBasariliMesaj(String islemBasariliMesaj) {
        this.islemBasariliMesaj = islemBasariliMesaj;
    }
}
