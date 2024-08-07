package dao;

import java.sql.Connection;
import Entity.Tutanak;
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
public class TutanakDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    public void TutanakEkle(Tutanak tutanak) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_TUTANAK_DURUM(?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setString(1, tutanak.getTutanak_isim());
            cs.setInt(2, tutanak.getAktiflik());

            cs.execute();
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public void TutanakSil(int tutanakId) {
        String deleteQuery = "DELETE FROM TUTANAK_DURUM WHERE DURUM_ID = ?";
        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, tutanakId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public List<Tutanak> TutanakListesi() {
        List<Tutanak> tutanakList = new ArrayList<>();
        try {
            Statement statement = getDb().createStatement();
            String selectQuery = "SELECT DURUM_ID, DURUM_ISIM, AKTIFLIK FROM TUTANAK_DURUM";
            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()) {
                tutanakList.add(new Tutanak(
                        rs.getInt("DURUM_ID"),
                        rs.getString("DURUM_ISIM"),
                        rs.getInt("AKTIFLIK")
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return tutanakList;
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
