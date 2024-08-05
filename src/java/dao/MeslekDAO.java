/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import Entity.Meslek;
import static Filters.ErrorFinder.DetectError;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Eren
 */
public class MeslekDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    private Integer aktif = 0;
    private String isim = null;

    public void MeslekEkle(Meslek meslek) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_MESLEK(?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setString(1, meslek.getMeslek_isim());
            cs.setInt(2, meslek.getAktiflik());

            cs.execute();
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public void MeslekSil(int meslekId) {
        String deleteQuery = "DELETE FROM MESLEK WHERE MESLEK_ID = ?";
        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, meslekId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public List<Meslek> MeslekListesi() {
        List<Meslek> meslekList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT MESLEK_ID, MESLEK_ISIM, AKTIFLIK FROM MESLEK WHERE 1=1 ");

            // Eğer filtreleme koşulları varsa ekleyin
            if (aktif != 2) {
                queryBuilder.append("AND AKTIFLIK = ").append(aktif).append(" ");
            }

                if (isim != null || isim.equals("")) {
                queryBuilder.append("AND ISIM = ").append(aktif).append(" ");

            }

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                meslekList.add(new Meslek(
                        rs.getInt("MESLEK_ID"),
                        rs.getString("MESLEK_ISIM"),
                        rs.getInt("AKTIFLIK")
                ));
            }

            mesaj = "işlem başarılı";

        } catch (Exception ex) {
            DetectError(ex);
        }
        return meslekList;
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

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

}
