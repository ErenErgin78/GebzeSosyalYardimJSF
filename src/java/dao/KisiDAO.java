package dao;

import Entity.Kisi;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.math.BigDecimal;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KisiDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    // Kisi ekleme metodu
    public Integer KisiEkle(Kisi kisi) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_KISI_TEMEL(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setObject(1, kisi.getKimlik_no());
            cs.setString(2, kisi.getIsim());
            cs.setString(3, kisi.getSoyisim());
            cs.setString(4, kisi.getCinsiyet());
            cs.setInt(5, kisi.getMedeni_durum_id());
            cs.setInt(6, kisi.getCilt_no());
            cs.setInt(7, kisi.getAile_sira_no());
            cs.setInt(8, kisi.getSira_no());
            cs.setDate(9, new java.sql.Date(kisi.getDogum_tarihi().getTime()));
            cs.registerOutParameter(10, java.sql.Types.INTEGER);
            cs.execute();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

            return cs.getInt(10);

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
            return null;
        }
    }

    public Integer KisiEkle(Kisi kisi, Integer detayId) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_KISI_TEMEL_2(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setObject(1, kisi.getKimlik_no());
            cs.setString(2, kisi.getIsim());
            cs.setString(3, kisi.getSoyisim());
            cs.setString(4, kisi.getCinsiyet());
            cs.setInt(5, kisi.getMedeni_durum_id());
            cs.setInt(6, kisi.getCilt_no());
            cs.setInt(7, kisi.getAile_sira_no());
            cs.setInt(8, kisi.getSira_no());
            cs.setDate(9, new java.sql.Date(kisi.getDogum_tarihi().getTime()));
            cs.setInt(10, detayId);
            cs.registerOutParameter(11, java.sql.Types.INTEGER);
            cs.execute();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

            return cs.getInt(11);

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
            return null;
        }
    }

    // Kisi silme metodu
    public void KisiSil(int kisiId) {
        String deleteQuery = "DELETE FROM KISI_TEMEL WHERE KISI_ID = ?";
        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, kisiId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
    }
    
    public Kisi KisiBul(BigDecimal tcNumarasi) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM KISI_TEMEL KT");
        query.append(" JOIN KISI_MEDENI_DURUM M ON M.MEDENI_DURUM_ID = KT.MEDENI_DURUM_ID");
        query.append(" JOIN KISI_DETAY KD ON KT.KISI_DETAY_ID = KD.DETAY_ID");
        query.append(" JOIN KISI_ILETISIM KI ON KD.KISI_ILETISIM_ID = KI.KISI_ILETISIM_ID");
        
        query.append(" WHERE KIMLIK_NO = ?");
        try {
            PreparedStatement ps = getDb().prepareStatement(query.toString());
            ps.setBigDecimal(1, tcNumarasi);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Kisi(
                        rs.getBigDecimal("KIMLIK_NO"), // BigDecimal kullanmak genellikle büyük kimlik numaraları için tercih edilir
                        rs.getString("ISIM"),
                        rs.getString("SOYISIM"),
                        rs.getString("CINSIYET"),
                        rs.getInt("CILT_NO"),
                        rs.getInt("AILE_SIRA_NO"),
                        rs.getInt("SIRA_NO"),
                        rs.getDate("DOGUM_TARIHI"),
                        rs.getString("MEDENI_DURUM"),
                        rs.getDate("KAYIT_TARIHI"),
                        rs.getInt("AKTIF")
                );
            }
            // sonuç bulunamadı
            
        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
        return null;
        
    }

    // Kisi listesini çekme metodu
    public List<Kisi> KisiListesi() {
        List<Kisi> kisiList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT KISI_ID, KIMLIK_NO, ISIM, SOYISIM, CINSIYET, CILT_NO, AILE_SIRA_NO, SIRA_NO, DOGUM_TARIHI, MEDENI_DURUM_ID, KAYIT_TARIHI, AKTIF FROM KISI_TEMEL KT ");
            queryBuilder.append("JOIN KISI_MEDENI_DURUM M ON M.MEDENI_DURUM_ID = KT.MEDENI_DURUM_ID WHERE 1=1");

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                kisiList.add(new Kisi(
                        rs.getBigDecimal("KIMLIK_NO"), // BigDecimal kullanmak genellikle büyük kimlik numaraları için tercih edilir
                        rs.getString("ISIM"),
                        rs.getString("SOYISIM"),
                        rs.getString("CINSIYET"),
                        rs.getInt("CILT_NO"),
                        rs.getInt("AILE_SIRA_NO"),
                        rs.getInt("SIRA_NO"),
                        rs.getDate("DOGUM_TARIHI"),
                        rs.getString("MEDENI_DURUM_ISIM"),
                        rs.getDate("KAYIT_TARIHI"),
                        rs.getInt("AKTIF")
                ));
            }

            mesaj = "İşlem başarılı";

        } catch (Exception ex) {
            DetectError(ex);
        }
        return kisiList;
    }

    public List<SelectItem> kisiGetir() {
        List<SelectItem> kisiList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT MEDENI_DURUM_ID,MEDENI_DURUM  FROM KISI_MEDENI_DURUM";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                kisiList.add(new SelectItem(rs.getInt("MEDENI_DURUM_ID"), rs.getString("MEDENI_DURUM")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return kisiList;
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
