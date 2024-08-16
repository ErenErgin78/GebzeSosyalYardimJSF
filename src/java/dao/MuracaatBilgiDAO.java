/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.MuracaatBilgi;
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
 * @author Eren
 */
public class MuracaatBilgiDAO extends DBConnection {

    private Connection db;
    private Integer muracaat_bilgi_id;

    private String mesaj;

    public Integer MuracaatBilgiEkle(MuracaatBilgi muracaatBilgi) {
        try {
            Connection conn = this.getDb();

            if (muracaatBilgi.getAktif() == null) {
                muracaatBilgi.setAktif(1);
            }

            String callQueryMuracaatBilgi = "{call INSERT_MURACAAT_BILGI(?, ?, ?, ?, ?)}";
            CallableStatement csMuracaatBilgi = conn.prepareCall(callQueryMuracaatBilgi);
            csMuracaatBilgi.setInt(1, muracaatBilgi.getArsiv_dosya_no());
            csMuracaatBilgi.setString(2, muracaatBilgi.getAciklama());
            csMuracaatBilgi.setDate(3, new java.sql.Date(muracaatBilgi.getMuracaat_tarihi().getTime()));
            csMuracaatBilgi.setInt(4, 1);
            csMuracaatBilgi.registerOutParameter(5, java.sql.Types.INTEGER);
            csMuracaatBilgi.execute();
            int muracaatBilgiId = csMuracaatBilgi.getInt(5);

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
            return muracaatBilgiId;

        } catch (SQLException ex) {
            mesaj = DetectError(ex);
            return null;
        }
    }

    public List<MuracaatBilgi> MuracaatBilgiListesi() {
        List<MuracaatBilgi> muracaatBilgiList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT MURACAAT_BILGI_ID, ARSIV_DOSYA_NO, ACIKLAMA, MURACAAT_TARIHI, KAYIT_TARIHI, AKTIF, GUNCELLEME_TARIHI FROM MURACAAT_BILGI WHERE 1=1 ");

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                muracaatBilgiList.add(new MuracaatBilgi(
                        rs.getInt("ARSIV_DOSYA_NO"),
                        rs.getString("ACIKLAMA"),
                        rs.getDate("MURACAAT_TARIHI"),
                        rs.getInt("AKTIF"),
                        rs.getTimestamp("KAYIT_TARIHI"),
                        rs.getTimestamp("GUNCELLEME_TARIHI")
                ));
            }
            mesaj = "İşlem başarılı";

        } catch (SQLException ex) {
            DetectError(ex);
        }
        return muracaatBilgiList;
    }

    public void Delete(int kullaniciId) {
        String deleteQuery = "DELETE FROM MURACAAT WHERE kullanici_id = " + kullaniciId;

        try {
            Statement statement = getDb().createStatement();

            int rowsDeleted = statement.executeUpdate(deleteQuery);
            System.out.println(rowsDeleted + " kisi silindi.");

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (SQLException ex) {
            DetectError(ex);
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

    public Integer getMuracaat_bilgi_id() {
        return muracaat_bilgi_id;
    }

    public void setMuracaat_bilgi_id(Integer muracaat_bilgi_id) {
        this.muracaat_bilgi_id = muracaat_bilgi_id;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

}
