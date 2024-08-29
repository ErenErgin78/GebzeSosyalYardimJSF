package dao;

import Entity.KisiDetay;
import static Various.ErrorFinder.DetectError;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KisiDetayDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;

    // KisiDetay ekleme metodu
    public Integer Create(KisiDetay detay) {
        try {
            Connection conn = this.getDb();

            if (detay.getKisi_engel_id() == null) {
                detay.setKisi_engel_id(0);
            }
            
            String callQueryDetay = "{call INSERT_KISI_DETAY(?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement csDetay = conn.prepareCall(callQueryDetay);
            csDetay.setInt(1, detay.getKisi_iletisim_id());
            csDetay.setInt(2, detay.getKisi_adres_id());
            csDetay.setInt(3, detay.getKisi_egitim_id());
            csDetay.setInt(4, detay.getKisi_engel_id());
            csDetay.setInt(5, detay.getMeslek_id());
            csDetay.setInt(6, detay.getAskerlik_id());
            csDetay.registerOutParameter(7, java.sql.Types.INTEGER);
            csDetay.execute();

            int detayId = csDetay.getInt(7);
            detay.setDetay_id(detayId);

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
            return detayId;

        } catch (SQLException ex) {
            islemBasariliMesaj = DetectError(ex);
            return null;
        }
    }

    public Integer CreateMuracaat(KisiDetay detay, Integer iletisim_id, Integer adres_id) {
        try {
            Connection conn = this.getDb();

            String callQueryDetay = "{call INSERT_KISI_DETAY_2(?, ?, ?, ?)}";
            CallableStatement csDetay = conn.prepareCall(callQueryDetay);
            csDetay.setInt(1, iletisim_id);
            csDetay.setInt(2, adres_id);
            csDetay.setInt(3, detay.getKisi_egitim_id());
            csDetay.registerOutParameter(4, java.sql.Types.INTEGER);
            csDetay.execute();

            int detayId = csDetay.getInt(4);
            detay.setDetay_id(detayId);

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
            return detayId;

        } catch (SQLException ex) {
            islemBasariliMesaj = DetectError(ex);
            return null;
        }
    }
    
    public Integer Create(KisiDetay detay, Integer iletisim_id, Integer adres_id) {
        try {
            Connection conn = this.getDb();

            String callQueryDetay = "{call INSERT_KISI_DETAY(?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement csDetay = conn.prepareCall(callQueryDetay);
            csDetay.setInt(1, iletisim_id);
            csDetay.setInt(2, adres_id);
            csDetay.setInt(3, detay.getKisi_egitim_id());
            csDetay.setInt(4, detay.getKisi_engel_id());
            csDetay.setInt(5, detay.getMeslek_id());
            csDetay.setInt(6, detay.getAskerlik_id());
            csDetay.registerOutParameter(7, java.sql.Types.INTEGER);
            csDetay.execute();

            int detayId = csDetay.getInt(7);
            detay.setDetay_id(detayId);

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
            return detayId;

        } catch (SQLException ex) {
            islemBasariliMesaj = DetectError(ex);
            return null;
        }
    }

    // KisiDetay listeleme metodu
    public List<KisiDetay> GetList() {

        List<KisiDetay> detayList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();

            String selectQuery = "SELECT * FROM KISIDETAY";

            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()) {
                KisiDetay detay = new KisiDetay();
                detay.setDetay_id(rs.getInt("DETAY_ID"));
                detay.setKisi_iletisim_id(rs.getInt("KISI_ILETISIM_ID"));
                detay.setKisi_adres_id(rs.getInt("KISI_ADRES_ID"));
                detay.setKisi_egitim_id(rs.getInt("KISI_EGITIM_ID"));
                detay.setKisi_engel_id(rs.getInt("KISI_ENGEL_ID"));
                detay.setMeslek_id(rs.getInt("MESLEK_ID"));
                detay.setGuncelleme_tarihi(rs.getTimestamp("GUNCELLEME_TARIHI"));
                detay.setAskerlik_id(rs.getInt("ASKERLIK_ID"));

                detayList.add(detay);
            }
            this.islemBasariliMesaj = "İşlem başarılı";

        } catch (SQLException ex) {
            islemBasariliMesaj = DetectError(ex);
        }
        return detayList;
    }

    // KisiDetay silme metodu
    public void Delete(int detayId) {
        String deleteQuery = "DELETE FROM KISIDETAY WHERE DETAY_ID = " + detayId;

        try {
            Statement statement = getDb().createStatement();
            int rowsDeleted = statement.executeUpdate(deleteQuery);
            System.out.println(rowsDeleted + " detay kaydı silindi.");

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (SQLException ex) {
            islemBasariliMesaj = DetectError(ex);
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

    public String getIslemBasariliMesaj() {
        return islemBasariliMesaj;
    }

    public void setIslemBasariliMesaj(String islemBasariliMesaj) {
        this.islemBasariliMesaj = islemBasariliMesaj;
    }
}