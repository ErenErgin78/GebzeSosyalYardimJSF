package dao;

import Entity.Kisi;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
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
    private String mesaj; // Başarı mesajı için değişken

    // Kisi ekleme metodu
    public void KisiEkle(Kisi kisi) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_KISI_TEMEL(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setObject(1, kisi.getKimlik_no());
            cs.setString(2, kisi.getIsim());
            cs.setString(3, kisi.getSoyisim());
            cs.setString(4, kisi.getCinsiyet());
            cs.setInt(5, kisi.getCilt_no());
            cs.setInt(6, kisi.getAile_sira_no());
            cs.setInt(7, kisi.getSira_no());
            cs.setInt(8, kisi.getDoğum_tarihi());
            cs.setInt(9, kisi.getMedeni_durum_id());
            cs.setInt(10, kisi.getAktif());

            cs.execute();
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            DetectError(ex);
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
            DetectError(ex);
        }
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
                        rs.getBigDecimal("KIMLIK_NO").toBigInteger(), // BigDecimal kullanmak genellikle büyük kimlik numaraları için tercih edilir
                        rs.getString("ISIM"),
                        rs.getString("SOYISIM"),
                        rs.getString("CINSIYET"),
                        rs.getInt("CILT_NO"),
                        rs.getInt("AILE_SIRA_NO"),
                        rs.getInt("SIRA_NO"),
                        rs.getInt("DOGUM_TARIHI"),
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
