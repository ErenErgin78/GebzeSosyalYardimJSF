package dao;

import Entity.TutanakSosyalGuvence;
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

public class TutanakSosyalGuvenceDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    // TutanakSosyalGuvence Ekleme Metodu
    public void TutanakSosyalGuvenceEkle(TutanakSosyalGuvence tutanakSosyalGuvence) {
        try {
            Connection conn = this.getDb();
            String callQuery = "{call INSERT_TUTANAK_SOSYAL_GUVENCE(?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);

            cs.setInt(1, tutanakSosyalGuvence.getGuvence_var_mi());
            cs.setInt(2, tutanakSosyalGuvence.getGuvence_id());
            cs.setInt(3, tutanakSosyalGuvence.getBirim_id());
            cs.setString(4, tutanakSosyalGuvence.getBirim_aciklama());
            cs.setTimestamp(5, new java.sql.Timestamp(tutanakSosyalGuvence.getGuncelleme_tarihi().getTime()));

            cs.execute();
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
        }
    }

    // TutanakSosyalGuvence Silme Metodu
    public void TutanakSosyalGuvenceSil(int tutanakSosyalGuvenceId) {
        String deleteQuery = "DELETE FROM TUTANAK_SOSYAL_GUVENCE WHERE SOSYAL_GUVENCE_ID = ?";
        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, tutanakSosyalGuvenceId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
    }

    // TutanakSosyalGuvence Listeleme Metodu
    public List<TutanakSosyalGuvence> TutanakSosyalGuvenceListesi() {
        List<TutanakSosyalGuvence> tutanakSosyalGuvenceList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT SOSYAL_GUVENCE_ID, GUVENCE_VAR_MI, GUVENCE_ID, BIRIM_ID, BIRIM_ACIKLAMA, GUNCELLEME_TARIHI ")
                        .append("FROM TUTANAK_SOSYAL_GUVENCE ")
                        .append("WHERE 1=1 ");

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                tutanakSosyalGuvenceList.add(new TutanakSosyalGuvence(
                        rs.getInt("SOSYAL_GUVENCE_ID"),
                        rs.getInt("GUVENCE_VAR_MI"),
                        rs.getInt("GUVENCE_ID"),
                        rs.getInt("BIRIM_ID"),
                        rs.getString("BIRIM_ACIKLAMA"),
                        rs.getTimestamp("GUNCELLEME_TARIHI")
                ));
            }

            System.out.println("İşlem başarılı");

        } catch (Exception ex) {
            ex.printStackTrace(); // Hata yönetimi için gerekli kod
        }
        return tutanakSosyalGuvenceList;
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
