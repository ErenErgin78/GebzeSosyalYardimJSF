package dao;

import Entity.Kisi;
import Entity.KisiAdres;
import Entity.KurumAlt;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KisiAdresDAO extends DBConnection {

    private Connection db;
    private String mesaj; // Başarı mesajı için değişken

    private Integer aktif = 2; // Varsayılan filtre değeri
    private String isim = "";  // Varsayılan isim filtresi

    public void KisiEkle(Kisi kisi) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_KISI_ADRES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setInt(1, kisi.getKisi_adres_id());
            cs.setString(2, kisi.getİlce());
            cs.setString(3, kisi.getTarif());
            cs.setString(4, kisi.getSite());
            cs.setInt(5, kisi.getKapi_no());
            cs.setInt(6, kisi.getDaire_no());
            cs.setInt(7, kisi.getKisi_adres_mahalle_id());
            cs.setInt(8, kisi.getKisi_mahalle_sokak_id());
            cs.setDate(9, kisi.getKayit_tarihi());
            cs.setInt(10, kisi.getAktif());

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (Exception ex) {
            DetectError(ex);
        }

    }

    public void KisiAdresSil(int kisiAdresid) {
        String deleteQuery = "DELETE FROM KISI_ADRES WHERE KISI_ADRES_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, kisiAdresid);
            int rowsDeleted = ps.executeUpdate();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public List<KisiAdres> KisiAdresListesi() {
        List<KisiAdres> kisiAdresList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT KA.KISI_ADRES_ID, KA.ILCE, KA.TARIF, KA.SITE, KA.KAPI_NO, KA.KISI_ADRES_MAHALLE_ID, KMS.SOKAK_ISIM, KA.KAYIT_TARIHI, KA.AKTIF FROM");
            queryBuilder.append("KISI_ADRES KA JOIN KISI_ADRES_MAHALLE M ON M.KISI_ADRES_MAHALLE_ID = KA.KISI_ADRES_MAHALLE_ID");
            queryBuilder.append("JOIN KISI_MAHALLE_SOKAK KMS ON KMS.MAHALLE_ID = M.KISI_ADRES_MAHALLE_ID WHERE 1=1");
            if (id != 0) {
                queryBuilder.append("AND ").append(id).append(" ");
            }

            if (!isim.isEmpty()) {
                queryBuilder.append("AND  '%").append(isim).append("%' ");
            }

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                kisiAdresList.add(new KisiAdres(
                        rs.getInt("KISI_ADRES_ID"),
                        rs.getString("ILCE"),
                        rs.getString("TARIF"),
                        rs.getString("SITE"),
                        rs.getInt("KAPI_NO"),
                        rs.getInt("ADRES_NO"),
                        rs.getInt("KISI_ADRES_MAHALLE_ID"),
                        rs.getInt("KISI_MAHALLE_SOKAK_ID"),
                        rs.getDate("KAYIT_TARIHI"),
                        rs.getInt("AKTIF")
                ));
            }

            this.islemBasariliMesaj = "işlem başarılı";

        } catch (Exception ex) {
            DetectError(ex);
        }
        return kisiAdresList;
    }

    public List<SelectItem> KisiAdresGetir() {
        List<SelectItem> TipList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT KISI_ADRES_ID, KISI_ADRES_ISIM FROM KISI_ADRES";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("KISI_ADRES_ID"), rs.getString("KISI_ADRES_ISIM")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return TipList;


    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }
}
