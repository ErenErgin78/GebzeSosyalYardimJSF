/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Yardim;
import static Various.ErrorFinder.DetectError;
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
public class YardimDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    public void YardimEkle(Yardim yardim) {
        try {
            Connection conn = this.getDb();
            if(yardim.getAktif()==null){
              yardim.setAktif(1);
            }

            String callQuery = "{call insert_yardim_tip(?)}";
            CallableStatement cs = conn.prepareCall(callQuery);

            cs.setString(1, yardim.getYardim_tip());

            cs.execute();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (Exception ex) {
          this.mesaj =  DetectError(ex);
        }

    }

    public void YardimSil(int yardimTipId) {
        String deleteQuery = "DELETE FROM YARDIM_TIP WHERE YARDIM_TIP_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, yardimTipId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (Exception ex) {
           this.mesaj = DetectError(ex);
        }
    }

    public List<Yardim> YardimListesi() {
        List<Yardim> yardimList = new ArrayList<>();
        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT YARDIM_TIP_ID, YARDIM_TIP FROM YARDIM_TIP");

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                yardimList.add(new Yardim(
                        rs.getInt("YARDIM_TIP_ID"),
                        rs.getString("YARDIM_TIP")
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return yardimList;
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
