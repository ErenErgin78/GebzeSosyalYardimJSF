/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Engel;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.Statement;
import java.sql.Connection;
import util.DBConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EngelDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    private String isim = "";

    public void EngelEkle(Engel engel) {
        try {
            Connection conn = this.getDb();

            if (engel.getAktif() == null) {
                engel.setAktif(1);
            }

            String callQuery = "{call INSERT_ENGELLI_TIP(?)}";
            CallableStatement cs = conn.prepareCall(callQuery);

            cs.setString(1, engel.getEngel_tip());

            cs.execute();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
        }

    }

    public void EngelSil(int engelTipId) {
        String deleteQuery = "DELETE FROM ENGELLI_TIP WHERE TIP_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, engelTipId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
        }
    }

    public List<Engel> EngelListesi() {
        List<Engel> engelList = new ArrayList<>();
        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT TIP_ID, TIP_ISIM FROM ENGELLI_TIP WHERE 1=1");

            if (isim != null && !isim.isEmpty()) {
                queryBuilder.append("AND TIP_ISIM LIKE '%").append(isim).append("%' ");
            }

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                engelList.add(new Engel(
                        rs.getInt("TIP_ID"),
                        rs.getString("TIP_ISIM")
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return engelList;
    }

    public List<SelectItem> EngelGetir() {
        List<SelectItem> TipList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT TIP_ID , TIP_ISIM FROM ENGELLI_TIP";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("TIP_ID"), rs.getString("TIP_ISIM")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return TipList;

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

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

}
