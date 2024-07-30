package dao;

import Entity.YardimAlt;
import static Filters.ErrorFinder.DetectError;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class YardimAltDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;

    public void YardimAltEkle(YardimAlt yardimAlt) {

        try {
            Connection conn = this.getDb();

            String callQueryAdres = "{call INSERT_YARDIM_ALT_TIP(?, ?)}";
            CallableStatement csAdres = conn.prepareCall(callQueryAdres);
            csAdres.setInt(1, yardimAlt.getTip_id());
            csAdres.setString(2, yardimAlt.getAlt_tip());
            csAdres.execute();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public void YardimAltSil(int yardimAltid) {
        String deleteQuery = "DELETE FROM YARDIM_ALT_TIP WHERE YARDIM_ALT_TIP_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, yardimAltid);
            int rowsDeleted = ps.executeUpdate();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public List<YardimAlt> YardimAltListesi() {
        List<YardimAlt> yardimAltList = new ArrayList<>();
        try {
            Statement statement = getDb().createStatement();
            String selectQuery = "SELECT YARDIM_ALT_TIP_ID, YARDIM_TIP_ID,  YARDIM_ALT_ISIM FROM YARDIM_ALT_TIP";
            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()) {
                yardimAltList.add(new YardimAlt(
                        rs.getInt("YARDIM_ALT_TIP_ID"),
                        rs.getInt("YARDIM_TIP_ID"),
                        rs.getString("YARDIM_ALT_ISIM")
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return yardimAltList;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public String getIslemBasariliMesaj() {
        return islemBasariliMesaj;
    }

    public void setIslemBasariliMesaj(String islemBasariliMesaj) {
        this.islemBasariliMesaj = islemBasariliMesaj;
    }

}
