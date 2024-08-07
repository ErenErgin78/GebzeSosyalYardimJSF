package dao;

import Entity.KisiAdres;
import static Filters.ErrorFinder.DetectError;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KisiAdresDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    public void addKisiAdres(KisiAdres kisiAdres) {
        try {
            Connection conn = this.getDb();
            String callQueryAdres = "{call INSERT_KISI_ADRES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement csAdres = conn.prepareCall(callQueryAdres);
            csAdres.setString(1, kisiAdres.getIlce());
            csAdres.setInt(2, kisiAdres.getMahalle_id());
            csAdres.setString(3, kisiAdres.getTarif());
            csAdres.setString(4, kisiAdres.getSite());
            csAdres.setInt(5, kisiAdres.getKapi_no());
            csAdres.setInt(6, kisiAdres.getDaire_no());
            csAdres.setInt(7, kisiAdres.getAdres_no());
            csAdres.setInt(8, kisiAdres.getEvdeki_kisi_sayisi());
            csAdres.setInt(9, kisiAdres.getMahalle_sokak_id());
            csAdres.setInt(10, kisiAdres.getKisi_adres_id());
            csAdres.execute();

        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public void deleteKisiAdres(int adresId) {
        String deleteQuery = "DELETE FROM KISI_ADRES WHERE KISI_ADRES_ID = ?";

        try (Connection conn = getDb(); PreparedStatement ps = conn.prepareStatement(deleteQuery)) {

            ps.setInt(1, adresId);
            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                this.mesaj = "İşlem başarıyla gerçekleşti.";
            } else {
                this.mesaj = "Silinecek kayıt bulunamadı.";
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public List<KisiAdres> getKisiAdresList() {
        List<KisiAdres> kisiAdresList = new ArrayList<>();
        String query = "SELECT KISI_ADRES_ID, FROM KISI_ADRES";

        try (Connection conn = getDb(); Statement statement = conn.createStatement(); ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                kisiAdresList.add(new KisiAdres(
                        rs.getString("ILCE"),
                        rs.getString("TARIF"),
                        rs.getString("SITE"),
                        rs.getInt("KAPI_NO"),
                        rs.getInt("DAIRE_NO"),
                        rs.getInt("ADRES_NO"),
                        rs.getInt("EVDE_KISI_SAYISI"),
                        rs.getString("MAHALLE_ISIM"),
                        rs.getString("MAHALLE_SOKAK_ISIM")
         ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return kisiAdresList;
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
