/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Muracaat;
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
public class MuracaatDAO extends DBConnection {

    private Connection db;
    private Integer muracaat_bilgi_id;

    private String mesaj;

    public Integer MuracaatEkle(Muracaat muracaat, Integer KisiID) {
        try {
            Connection conn = this.getDb();

            String callQueryMuracaatBilgi = "{call INSERT_MURACAAT_BILGI(?, ?, ?, ?, ?)}";
            CallableStatement csMuracaatBilgi = conn.prepareCall(callQueryMuracaatBilgi);
            csMuracaatBilgi.setInt(1, muracaat.getArsiv_dosya_no());
            csMuracaatBilgi.setString(3, muracaat.getAciklama());
            csMuracaatBilgi.setDate(4, new java.sql.Date(muracaat.getMuracaat_tarihi().getTime()));
            csMuracaatBilgi.registerOutParameter(5, java.sql.Types.INTEGER);
            csMuracaatBilgi.execute();
            int muracaatBilgiId = csMuracaatBilgi.getInt(5);

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public List<Muracaat> GetList() {

        List<Muracaat> UserList = new ArrayList<>();

        try {

            Statement statement = getDb().createStatement();

            String Selectquery = "SELECT \n"
                    + "JOIN KULLANICI_DURUM D ON K.kullanici_durum_id = D.kullanici_durum_id\n"
                    + "JOIN KULLANICI_UNVAN U ON K.kullanici_unvan_id = U.kullanici_unvan_id";

            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {

            }

        } catch (Exception ex) {
            DetectError(ex);
        }
        return UserList;
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

}
