package dao;

import Entity.Stok;
import static Filters.ErrorFinder.DetectError;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StokDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    public void StokEkle(Stok stok) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_STOK(?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setInt(1, stok.getYardım_tip_id());
            cs.setInt(2, stok.getYardım_alt_tıp_id());
            cs.setString(3, stok.getStok_tanım());
            cs.setInt(4, stok.getGuncel_miktar());
            cs.setFloat(5, stok.getGuncel_fiyat());

            cs.execute();
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public void StokSil(int stokId) {
        String deleteQuery = "DELETE FROM STOK WHERE STOK_ID = ?";
        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, stokId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public List<Stok> StokListesi() {
        List<Stok> stokList = new ArrayList<>();
        try {
            Statement statement = getDb().createStatement();
            String selectQuery = "SELECT S.STOK_ID, S.STOK_TANIM, S.GUNCEL_MIKTAR, S.GUNCEL_FIYAT, YT.YARDIM_TIP, YAT.YARDIM_ALT_TIP ,"
                    + "YT.YARDIM_TIP"
                    + "FROM STOK S"
                    + "JOIN YARDIM_TIP YT ON S.YARDIM_TIP_ID=YT.YARDIM_TIP_ID"
                    + "JOIN YARDIM_ALT_TIP YAT ON S.YARDIM_ALT_TIP_ID=YAT.YARDIM_ALT_TIP_ID";

            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()) {
                stokList.add(new Stok(
                        rs.getInt("STOK_ID"),
                        rs.getString("STOK_TANIM"),
                        rs.getInt("GUNCEL_MIKTAR"),
                        rs.getFloat("GUNCEL_FIYAT"),
                        rs.getString("YARDIM_TIP_ISIM"),
                        rs.getString("YARDIM_ALT_TIP_ISIM")
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return stokList;
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
