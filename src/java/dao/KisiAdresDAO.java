package dao;

import Entity.Kisi;
import Entity.KisiAdres;
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

    public void KisiEkle(KisiAdres kisiAdres) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_KISI_ADRES(?, ?, ?, ?, ?, ?, ?, ?,)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setString(1, kisiAdres.getTarif());
            cs.setString(2, kisiAdres.getSite());
            cs.setInt(3, kisiAdres.getKapi_no());
            cs.setInt(4, kisiAdres.getDaire_no());
            cs.setString(5, kisiAdres.getKisi_adres_mahalle_isim());
            cs.setString(6, kisiAdres.getKisi_mahalle_sokak_isim());
            java.util.Date kayitTarihiUtil = kisiAdres.getKayit_tarihi();
            java.sql.Date kayitTarihiSql = new java.sql.Date(kayitTarihiUtil.getTime());
            cs.setDate(7, kayitTarihiSql);
            cs.setInt(8, kisiAdres.getAktif());

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
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

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
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

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                kisiAdresList.add(new KisiAdres(
                        rs.getString("TARIF"),
                        rs.getString("SITE"),
                        rs.getInt("DAIRE_NO"),
                        rs.getInt("KAPI_NO"),
                        rs.getString("KISI_ADRES_MAHALLE_ID"),
                        rs.getString("KISI_MAHALLE_SOKAK_ID"),
                        new java.util.Date(rs.getDate("KAYIT_TARIHI").getTime()),
                        rs.getInt("AKTIF")
                ));
            }

            this.mesaj = "işlem başarılı";

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

    }

    public List<SelectItem> MahalleGetir() {
        List<SelectItem> MahalleList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT KISI_ADRES_MAHALLE_ID, MAHALLE FROM KISI_ADRES_MAHALLE";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                MahalleList.add(new SelectItem(rs.getInt("KISI_ADRES_MAHALLE_ID"), rs.getString("MAHALLE")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return MahalleList;
    }

    public List<SelectItem> SokakGetir(int selectedmahalleid) {
        List<SelectItem> MahalleList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT SOKAK_ID, SOKAK_ISIM FROM KISI_MAHALLE_SOKAK WHERE MAHALLE_ID = " + selectedmahalleid;
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {

                MahalleList.add(new SelectItem(rs.getInt("SOKAK_ID"), rs.getString("SOKAK_ISIM")));
            }

        } catch (Exception ex) {
            DetectError(ex);
        }
        return MahalleList;
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
}
