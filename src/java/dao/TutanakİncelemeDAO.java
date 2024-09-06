package dao;

import Entity.Tutanakİnceleme;
import static Various.ErrorFinder.DetectError;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import util.DBConnection;

public class TutanakİncelemeDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;

    public void TutanakİncelemeEkle(Tutanakİnceleme tutanakinceleme) throws SQLException {
        Connection conn = null;
        CallableStatement csTutanakİnceleme = null;
        try {
            conn = this.getDb(); // Bağlantıyı aç
            String callQuery = "{call INSERT_TUTANAK_INCELEME(?,?)}";
            csTutanakİnceleme = conn.prepareCall(callQuery);

            csTutanakİnceleme.setString(1, tutanakinceleme.getTutanak_basvuru());
            csTutanakİnceleme.setString(2, tutanakinceleme.getTutanak_inceleme());

            csTutanakİnceleme.execute();
            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.islemBasariliMesaj = DetectError(ex);
            throw ex;
        } finally {
            // Bağlantıyı kapatma işlemini burada manuel olarak yap
            if (csTutanakİnceleme != null) {
                try {
                    csTutanakİnceleme.close(); // CallableStatement kapat
                } catch (SQLException ex) {
                    this.islemBasariliMesaj = DetectError(ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close(); // Bağlantıyı kapat
                } catch (SQLException ex) {
                    this.islemBasariliMesaj = DetectError(ex);
                }
            }
        }
    }

    public Connection getDb() {
        if (this.db == null || isConnectionClosed(db)) {
            this.db = this.connect();
        }
        return db;
    }

    private boolean isConnectionClosed(Connection conn) {
        try {
            return conn == null || conn.isClosed();
        } catch (SQLException e) {
            return true; // Eğer bir hata olursa bağlantıyı kapalı kabul et
        }
    }

    public String getIslemBasariliMesaj() {
        return islemBasariliMesaj;
    }

    public void setIslemBasariliMesaj(String islemBasariliMesaj) {
        this.islemBasariliMesaj = islemBasariliMesaj;
    }
}
