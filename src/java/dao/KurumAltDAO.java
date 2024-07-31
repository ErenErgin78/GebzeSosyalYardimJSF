package dao;

import Entity.KurumAlt;
import Entity.YardimAlt;
import static Filters.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KurumAltDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;

    public void KurumAltEkle(KurumAlt yardimAlt) {

        try {
            Connection conn = this.getDb();

            String callQueryAdres = "{call INSERT_KURUM_ALT_TIP(?, ?)}";
            CallableStatement csAdres = conn.prepareCall(callQueryAdres);
            csAdres.setInt(1, yardimAlt.getTip_id());
            csAdres.setString(2, yardimAlt.getAlt_tip());
            csAdres.execute();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public void KurumAltSil(int yardimAltid) {
        String deleteQuery = "DELETE FROM KURUM_ALT WHERE ALT_KURUM_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, yardimAltid);
            int rowsDeleted = ps.executeUpdate();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public List<KurumAlt> KurumAltListesi() {
        List<KurumAlt> kurumAltList = new ArrayList<>();
        try {
            Statement statement = getDb().createStatement();
            String selectQuery = "SELECT YA.ALT_KURUM_ID, YA.KURUM_ID, YA.ALT_KURUM_ISIM, Y.KURUM_ISIM FROM KURUM_ALT YA"
                    + " JOIN KURUM Y ON YA.KURUM_ID = Y.KURUM_ID";
            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()) {
                kurumAltList.add(new KurumAlt(
                        rs.getInt("ALT_KURUM_ID"),
                        rs.getString("ALT_KURUM_ISIM"),
                        rs.getString("KURUM_ISIM")
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return kurumAltList;
    }

    public List<SelectItem> KurumTipGetir() {
        List<SelectItem> TipList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT KURUM_ID, KURUM_ISIM FROM KURUM";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("KURUM_ID"), rs.getString("KURUM_ISIM")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return TipList;
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

    public void KurumEkle(KurumAlt entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
