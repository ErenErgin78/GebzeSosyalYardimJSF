package dao;

import Entity.TutanakSosyalGuvence;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
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

    public void TutanakSosyalGuvenceEkle(TutanakSosyalGuvence tutanakSosyalGuvence) {
        try {
            Connection conn = this.getDb();
            String callQuery = "{call INSERT_TUTANAK_SOSYAL_GUVENCE(?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);

            cs.setInt(1, tutanakSosyalGuvence.getGuvence_var_mi());
            cs.setInt(2, tutanakSosyalGuvence.getGuvence_id());
            cs.setInt(3, tutanakSosyalGuvence.getBirim_id());
            cs.setString(4, tutanakSosyalGuvence.getBirim_aciklama());
            cs.registerOutParameter(5, java.sql.Types.INTEGER);

            cs.execute();
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
        }
    }

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

        } catch (Exception ex) {
            mesaj = DetectError(ex);
        }
        return tutanakSosyalGuvenceList;
    }

    public List<SelectItem> GuvenceGetir() {
        List<SelectItem> GuvenceList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT GUVENCE_ID,  GUVENCE FROM GUVENCE";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                GuvenceList.add(new SelectItem(rs.getInt("GUVENCE_ID"), rs.getString("GUVENCE")));
            }
        } catch (Exception ex) {
            mesaj = DetectError(ex);
        }
        return GuvenceList;
    }

    public List<SelectItem> BirimGetir() {
        List<SelectItem> BirimList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT BIRIM_ID,  BIRIM_ISIM FROM GUVENCE_BIRIM";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                BirimList.add(new SelectItem(rs.getInt("BIRIM_ID"), rs.getString("BIRIM_ISIM")));
            }
        } catch (Exception ex) {
            mesaj = DetectError(ex);
        }
        return BirimList;
    }

    public void TutanakSosyalGuvenceMesajTemizle() {
        this.mesaj = null;
    }

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
