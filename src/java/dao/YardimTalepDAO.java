/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.YardimTalep;
import static Filters.ErrorFinder.DetectError;
import util.DBConnection;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class YardimTalepDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    public void YardimTalepEkle(YardimTalep yardimTalep) {
        try {
            Connection conn = this.getDb();
            String callQuery = "{call INSERT_YARDIM_TALEP(?, ?)}";
            CallableStatement csYardimTalep = conn.prepareCall(callQuery);

            csYardimTalep.setString(1, yardimTalep.getYardim_talep());
            csYardimTalep.setInt(2, yardimTalep.getAktiflik());

            csYardimTalep.execute();
            String mesaj = "İşlem başarıyla gerçekleşmiştir";

        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public void YardimTalepSil(int yardimTalepId) {
        String deleteQuery = "DELETE FROM YARDIM_TALEP WHERE YARDIM_TALEP_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, yardimTalepId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public List<YardimTalep> YardimTalepListesi() {
        List<YardimTalep> YardimTalepList = new ArrayList<>();
        try {
            String selectQuery = "SELECT YARDIM_TALEP_ID, YARDIM_TALEP, AKTIFLIK FROM YARDIM_TALEP";

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()) {
                YardimTalepList.add(new YardimTalep(
                        rs.getInt("YARDIM_TALEP_ID"),
                        rs.getString("YARDIM_TALEP"),
                        rs.getInt("AKTIFLIK")
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return YardimTalepList;
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
