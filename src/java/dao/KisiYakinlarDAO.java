package dao;

import Entity.KisiYakinlar;
import static Various.ErrorFinder.DetectError;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class KisiYakinlarDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    // KisiYakinlik ekleme metodu
    public Integer KisiYakinlarEkle(KisiYakinlar yakinlik) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_KISI_YAKINLAR(?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setInt(1, yakinlik.getKisi_id());
            cs.setInt(2, yakinlik.getOzel_statu_id());
            cs.setDate(3, new java.sql.Date(yakinlik.getOlum_tarihi().getTime()));
            cs.setInt(4, yakinlik.getYakin_id());
            cs.setInt(5, yakinlik.getYakinlik_id());
            cs.registerOutParameter(6, java.sql.Types.INTEGER);
            cs.execute();
            
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

            return cs.getInt(6);
            
        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
            return null;
        }
    }
    
      public Integer KisiYakinlarEkle(KisiYakinlar yakinlik, Integer kisiId) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_KISI_YAKINLAR_2(?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setInt(1, kisiId);
            cs.setInt(2, yakinlik.getOzel_statu_id());
            cs.setInt(3, yakinlik.getYakin_id());
            cs.setInt(4, yakinlik.getYakinlik_id());
            cs.registerOutParameter(5, java.sql.Types.INTEGER);
            cs.execute();
            
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

            return cs.getInt(5);
            
        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
            return null;
        }
    }
      
       public Integer KisiYakinlarEkleMuracaat(KisiYakinlar yakinlik, Integer kisiId) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_KISI_YAKINLAR_2(?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setInt(1, kisiId);
            cs.setInt(2, yakinlik.getOzel_statu_id());
            cs.setInt(3, kisiId);
            cs.setInt(4, 1);
            cs.registerOutParameter(5, java.sql.Types.INTEGER);
            cs.execute();
            
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

            return cs.getInt(5);
            
        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
            return null;
        }
    }

    // KisiYakinlik silme metodu
    public void KisiYakinlarSil(int yakinlarId) {
        String deleteQuery = "DELETE FROM KISI_YAKINLIK WHERE YAKINLAR_ID = ?";
        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, yakinlarId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
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
