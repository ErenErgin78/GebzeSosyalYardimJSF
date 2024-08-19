package dao;

import java.sql.Connection;
import Entity.TutanakGelir;
import static Various.ErrorFinder.DetectError;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class TutanakGelirDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    private String isim = "";
    private Integer aktif = 2;

    public void TutanakEkle(TutanakGelir tutanak) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_TUTANAK_GELIR(?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setString(1, tutanak.getTip());
            cs.setInt(2, tutanak.getAktif());

            cs.execute();
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
        }
    }

    public void TutanakSil(int tutanakId) {
        String deleteQuery = "DELETE FROM TUTANAK_GELIR WHERE TIP_ID = ?";
        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, tutanakId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
    }

    public List<TutanakGelir> TutanakListesi() {
        List<TutanakGelir> tutanakList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT TIP, AKTIF, KAYIT_TARIHI FROM TUTANAK_GELIR");

            if (!isim.isEmpty()) {
                queryBuilder.append("AND TIP_ISIM LIKE '%").append(isim).append("%' ");
            }

            if (aktif != 2) {
                queryBuilder.append("AND AKTIFLIK = ").append(aktif).append(" ");
            }

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                tutanakList.add(new TutanakGelir(
                        rs.getString("TIP"),
                        rs.getInt("AKTIFLIK"),
                        rs.getDate("KAYIT_TARIHI")
                ));
            }

            mesaj = "işlem başarılı";

        } catch (Exception ex) {
            DetectError(ex);
        }
        return tutanakList;
    }

    public void TutanakGelırMesajTemizle() {
        this.mesaj = null;
    }

    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

}
