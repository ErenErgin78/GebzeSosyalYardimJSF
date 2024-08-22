package dao;

import Entity.TutanakGelir;
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

public class TutanakGelirDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    public void TutanakGelirEkle(TutanakGelir tutanakGelir) {
        try {
            Connection conn = this.getDb();
            String callQuery = "{call INSERT_TUTANAK_GELIR(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);

            cs.setFloat(1, tutanakGelir.getYaslilik());
            cs.setFloat(2, tutanakGelir.getEngelli());
            cs.setFloat(3, tutanakGelir.getEngelli_yakini());
            cs.setFloat(4, tutanakGelir.getYetim_ayligi());
            cs.setFloat(5, tutanakGelir.getEmekli_maasi());
            cs.setFloat(6, tutanakGelir.getEvde_bakim_parasi());
            cs.setFloat(7, tutanakGelir.getDul_maasi());
            cs.setFloat(8, tutanakGelir.getIssizlik_maasi());
            cs.setFloat(9, tutanakGelir.getAsker_maasi());
            cs.setFloat(10, tutanakGelir.getKira_maasi());
            cs.setFloat(11, tutanakGelir.getKaymakamlik());
            cs.setFloat(12, tutanakGelir.getSosyal_hizmetler());
            cs.setFloat(13, tutanakGelir.getBuyuksehir());
            cs.setFloat(14, tutanakGelir.getOzel_vakif());
            cs.setFloat(15, tutanakGelir.getDiger());
            cs.setString(16, tutanakGelir.getDiger_aciklama());
            cs.setInt(17, tutanakGelir.getAktif());
            cs.registerOutParameter(18, java.sql.Types.INTEGER);

            cs.execute();
            tutanakGelir.setGelir_id(cs.getInt(18));

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
        }
    }

    public void TutanakGelirSil(int tutanakId) {
        String deleteQuery = "DELETE FROM TUTANAK_GELIR WHERE GELIR_ID = ?";
        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, tutanakId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
            this.mesaj = ex.getMessage();
        }
    }

    public List<TutanakGelir> TutanakGelirListesi() {
        List<TutanakGelir> tutanakGelirList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT GELIR_ID, YASLILIK, ENGELLI, ENGELLI_YAKINI, YETIM_AYLIGI, EMEKLI_MAASI, ")
                    .append("EVDE_BAKIM_PARASI, DUL_MAASI, ISSIZLIK_MAASI, ASKER_MAASI, KIRA_MAASI, ")
                    .append("KAYMAKAMLIK, SOSYAL_HIZMETLER, BUYUKSEHIR, OZEL_VAKIF, DIGER, DIGER_ACIKLAMA, AKTIF, ")
                    .append("KAYIT_TARIHI, GUNCELLEME_TARIHI ")
                    .append("FROM TUTANAK_GELIR ")
                    .append("WHERE 1=1 ");

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                tutanakGelirList.add(new TutanakGelir(
                        rs.getFloat("YASLILIK"),
                        rs.getFloat("ENGELLI"),
                        rs.getFloat("ENGELLI_YAKINI"),
                        rs.getFloat("YETIM_AYLIGI"),
                        rs.getFloat("EMEKLI_MAASI"),
                        rs.getFloat("EVDE_BAKIM_PARASI"),
                        rs.getFloat("DUL_MAASI"),
                        rs.getFloat("ISSIZLIK_MAASI"),
                        rs.getFloat("ASKER_MAASI"),
                        rs.getFloat("KIRA_MAASI"),
                        rs.getFloat("KAYMAKAMLIK"),
                        rs.getFloat("SOSYAL_HIZMETLER"),
                        rs.getFloat("BUYUKSEHIR"),
                        rs.getFloat("OZEL_VAKIF"),
                        rs.getFloat("DIGER"),
                        rs.getString("DIGER_ACIKLAMA"),
                        rs.getInt("AKTIF"),
                        rs.getDate("KAYIT_TARIHI"),
                        rs.getDate("GUNCELLEME_TARIHI")
                ));
            }

        } catch (Exception ex) {
            DetectError(ex);
            mesaj = ex.getMessage();
        }
        return tutanakGelirList;
    }

    public void TutanakGelirMesajTemizle() {
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