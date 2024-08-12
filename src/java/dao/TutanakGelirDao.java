/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.TutanakGelir;
import static Various.ErrorFinder.DetectError;
import util.DBConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

/**
 *
 * @author casper
 */
public class TutanakGelirDao extends DBConnection {

    private Connection db;
    private String mesaj;

    public void TutanakGelirEkle(TutanakGelir tutanakGelir) {
        try {
            Connection conn = this.getDb();
            String callQuery = "{call INSERT_TUTANAK_GELIR(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);

            cs.setInt(1, tutanakGelir.getYaslilik());
            cs.setInt(2, tutanakGelir.getEngelli());
            cs.setInt(3, tutanakGelir.getEngelli_yakini());
            cs.setInt(4, tutanakGelir.getYetim_ayligi());
            cs.setInt(5, tutanakGelir.getEmekli_maasi());
            cs.setInt(6, tutanakGelir.getEvde_bakim_parasi());
            cs.setInt(7, tutanakGelir.getDul_maasi());
            cs.setInt(8, tutanakGelir.getIssizlik_maasi());
            cs.setInt(9, tutanakGelir.getAsker_maasi());
            cs.setInt(10, tutanakGelir.getKira_maasi());
            cs.setInt(11, tutanakGelir.getKaymakamlik());
            cs.setInt(12, tutanakGelir.getSosyal_hizmetler());
            cs.setInt(13, tutanakGelir.getBuyuksehir());
            cs.setInt(14, tutanakGelir.getOzel_vakif());
            cs.setInt(15, tutanakGelir.getDiger());
            cs.setInt(16, tutanakGelir.getAktif());
            cs.setDate(17, new java.sql.Date(tutanakGelir.getKayit_tarihi().getTime()));
            cs.setDate(18, new java.sql.Date(tutanakGelir.getGuncelleme_tarihi().getTime()));

            cs.execute();
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public void TutanakGelirSil(int tutanakId) {
        String deleteQuery = "DELETE FROM TUTANAK_GELIR WHERE DURUM_ID = ?";
        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, tutanakId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public List<TutanakGelir> TutanakGelirListesi() {
        List<TutanakGelir> tutanakGelirList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT GELIR_ID, YASLILIK, ENGELLI, ENGELLI_YAKINI, YETIM_AYLIGI, EMEKLI_MAASI, ")
                    .append("EVDE_BAKIM_PARASI, DUL_MAASI, ISSIZLIK_MAASI, ASKER_MAASI, KIRA_MAASI, ")
                    .append("KAYMAKAMLIK, SOSYAL_HIZMETLER, BUYUKSEHIR, OZEL_VAKIF, DIGER, AKTIF, ")
                    .append("KAYIT_TARIHI, GUNCELLEME_TARIHI ")
                    .append("FROM TUTANAK_GELIR ")
                    .append("WHERE 1=1 ");

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                tutanakGelirList.add(new TutanakGelir(
                        rs.getInt("GELIR_ID"),
                        rs.getInt("YASLILIK"),
                        rs.getInt("ENGELLI"),
                        rs.getInt("ENGELLI_YAKINI"),
                        rs.getInt("YETIM_AYLIGI"),
                        rs.getInt("EMEKLI_MAASI"),
                        rs.getInt("EVDE_BAKIM_PARASI"),
                        rs.getInt("DUL_MAASI"),
                        rs.getInt("ISSIZLIK_MAASI"),
                        rs.getInt("ASKER_MAASI"),
                        rs.getInt("KIRA_MAASI"),
                        rs.getInt("KAYMAKAMLIK"),
                        rs.getInt("SOSYAL_HIZMETLER"),
                        rs.getInt("BUYUKSEHIR"),
                        rs.getInt("OZEL_VAKIF"),
                        rs.getInt("DIGER"),
                        rs.getInt("AKTIF"),
                        rs.getDate("KAYIT_TARIHI"),
                        rs.getDate("GUNCELLEME_TARIHI")
                ));
            }

            System.out.println("İşlem başarılı");

        } catch (Exception ex) {
            ex.printStackTrace(); // Hata yönetimi için gerekli kod
        }
        return tutanakGelirList;
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

}
