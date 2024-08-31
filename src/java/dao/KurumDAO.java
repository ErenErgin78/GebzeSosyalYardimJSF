/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Kurum;
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

public class KurumDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;

    private String isim = "";

    public void KurumEkle(Kurum kurum) {
        try {
            Connection conn = this.getDb();

            if (kurum.getAktif() == null) {
                kurum.setAktif(1);
            }

            String callQuery = "{call INSERT_KURUM(?)}";
            CallableStatement cs = conn.prepareCall(callQuery);

            cs.setString(1, kurum.getKurum_isim());

            cs.execute();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            this.islemBasariliMesaj = DetectError(ex);
        }

    }

    public void KurumSil(int kurumId) {
        String deleteQuery = "DELETE FROM KURUM WHERE KURUM_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, kurumId);
            int rowsDeleted = ps.executeUpdate();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (Exception ex) {
            this.islemBasariliMesaj = DetectError(ex);
        }
    }

    public List<Kurum> KurumListesi() {
        List<Kurum> kurumList = new ArrayList<>();
        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT KURUM_ID, KURUM_ISIM FROM KURUM WHERE 1=1");

            if (isim != null && !isim.isEmpty()) {
                queryBuilder.append("AND KURUM_ISIM LIKE '%").append(isim).append("%' ");
            }

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                kurumList.add(new Kurum(
                        rs.getInt("KURUM_ID"),
                        rs.getString("KURUM_ISIM")
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return kurumList;
    }

    public List<SelectItem> KurumGetir() {
        List<SelectItem> kurumTipList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String selectQuery = "SELECT KURUM_ID, KURUM_ISIM FROM KURUM";
            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()) {
                kurumTipList.add(new SelectItem(rs.getInt("KURUM_ID"), rs.getString("KURUM_ISIM")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return kurumTipList;
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

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

}
