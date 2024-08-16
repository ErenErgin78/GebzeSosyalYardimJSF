package dao;

import Entity.TutanakMulkiyet;
import static Various.ErrorFinder.DetectError;
import util.DBConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class TutanakMulkiyetDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    // Mulkiyet Ekleme Metodu
    public void TutanakMulkiyetEkle(TutanakMulkiyet tutanakMulkiyet) {
        try {
            Connection conn = this.getDb();
            String callQuery = "{call INSERT_MULKIYET(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);

            cs.setInt(1, tutanakMulkiyet.getMulkiyet_sira_no());
            cs.setInt(2, tutanakMulkiyet.getEv_durum_id());
            cs.setFloat(3, tutanakMulkiyet.getKira_miktar());
            cs.setInt(4, tutanakMulkiyet.getYakacak_tip_id());
            cs.setInt(5, tutanakMulkiyet.getKirada_ev_sayisi());
            cs.setInt(6, tutanakMulkiyet.getAraba_var_mi());
            cs.setString(7, tutanakMulkiyet.getAraba_model());
            cs.setInt(8, tutanakMulkiyet.getGayrimenkul_var_mi());
            cs.setString(9, tutanakMulkiyet.getGayrimenkul_tur());
            cs.setInt(10, tutanakMulkiyet.getEv_tip_id());
            cs.setTimestamp(11, new java.sql.Timestamp(tutanakMulkiyet.getGuncelleme_tarihi().getTime()));

            cs.execute();
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
        }
    }

    // Mulkiyet Silme Metodu
    public void TutanakMulkiyetSil(int TutanakMulkiyetId) {
        String deleteQuery = "DELETE FROM MULKIYET WHERE MULKIYET_ID = ?";
        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, TutanakMulkiyetId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
    }

    // Mulkiyet Listeleme Metodu
    public List<TutanakMulkiyet> TutanakMulkiyetListesi() {
        List<TutanakMulkiyet> TutanakMulkiyetList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT MULKIYET_ID, MULKIYET_SIRA_NO, EV_DURUM_ID, KIRA_MIKTAR, YAKACAK_TIP_ID, ")
                    .append("KIRADA_EV_SAYISI, ARABA_VAR_MI, ARABA_MODEL, GAYRIMENKUL_VAR_MI, GAYRIMENKUL_TUR, EV_TIP_ID, ")
                    .append("GUNCELLEME_TARIHI ")
                    .append("FROM MULKIYET ")
                    .append("WHERE 1=1 ");

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                TutanakMulkiyetList.add(new TutanakMulkiyet(
                        rs.getInt("MULKIYET_ID"),
                        rs.getInt("MULKIYET_SIRA_NO"),
                        rs.getInt("EV_DURUM_ID"),
                        rs.getFloat("KIRA_MIKTAR"),
                        rs.getInt("YAKACAK_TIP_ID"),
                        rs.getInt("KIRADA_EV_SAYISI"),
                        rs.getInt("ARABA_VAR_MI"),
                        rs.getString("ARABA_MODEL"),
                        rs.getInt("GAYRIMENKUL_VAR_MI"),
                        rs.getString("GAYRIMENKUL_TUR"),
                        rs.getInt("EV_TIP_ID"),
                        rs.getTimestamp("GUNCELLEME_TARIHI")
                ));
            }

            System.out.println("İşlem başarılı");

        } catch (Exception ex) {
            ex.printStackTrace(); // Hata yönetimi için gerekli kod
        }
        return TutanakMulkiyetList;
    }

    public void TutanakMulkiyetMesajTemizle() {
        this.mesaj = null;
    }

    // Veritabanı Bağlantısı Almak İçin Metod
    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public void setDb(java.sql.Connection db) {
        this.db = db;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
}
