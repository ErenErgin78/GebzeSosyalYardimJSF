/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Engel;
import static Filters.ErrorFinder.DetectError;
import java.sql.Statement;
import java.sql.Connection;
import util.DBConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eren
 */
public class EngelDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    public void EngelEkle(Engel engel) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_ENGELLI_TIP(?)}";
            CallableStatement cs = conn.prepareCall(callQuery);

            cs.setString(1, engel.getEngel_tip());

            cs.execute();

        } catch (Exception ex) {
            DetectError(ex);
        }

    }

    public void EngelSil(int engelTipId) {
        String deleteQuery = "DELETE FROM ENGEL_TIP WHERE ENGEL_TIP_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, engelTipId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public List<Engel> EngelListesi() {
        List<Engel> engelList = new ArrayList<>();
        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT ENGEL_TIP_ID, ENGEL_TIP FROM ENGEL_TIP");

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                engelList.add(new Engel(
                        rs.getInt("ENGEL_TIP_ID"),
                        rs.getString("ENGEL_TIP")
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return engelList;
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