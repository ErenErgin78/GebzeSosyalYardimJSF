package dao;

import Entity.Okul;
import static Various.ErrorFinder.DetectError;
import util.DBConnection;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OkulDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;
    private String mesaj;

    private Integer tip = 0;
    private Integer tur = 0;
    private Integer aktif = 2;

    public void OkulEkle(Okul okul) {
        try {
            Connection conn = this.getDb();

            if (okul.getOkul_aktif() == null) {
                okul.setOkul_aktif(1);
            }

            String callQuery = "{call INSERT_OKUL(?, ?, ?, ?)}";
            CallableStatement csOkul = conn.prepareCall(callQuery);

            csOkul.setString(1, okul.getOkul_isim());
            csOkul.setInt(2, okul.getOkul_tip_id());
            csOkul.setInt(3, okul.getOkul_tur_id());
            csOkul.setInt(4, okul.getOkul_aktif());

            csOkul.execute();
            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (SQLException ex) {
            this.islemBasariliMesaj = DetectError(ex);
        }

    }

    public List<Okul> OkulListesi() {
        List<Okul> OkulList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT O.OKUL_ID, O.OKUL_ISIM, O.OKUL_TIP_ID, OTI.OKUL_TIP_ISIM, O.OKUL_TUR_ID, OTU.OKUL_TUR_ISIM, O.OKUL_AKTIF ")
                    .append("FROM OKUL O ")
                    .append("JOIN OKUL_TIP OTI ON O.OKUL_TIP_ID = OTI.OKUL_TIP_ID ")
                    .append("JOIN OKUL_TUR OTU ON O.OKUL_TUR_ID = OTU.OKUL_TUR_ID ")
                    .append("WHERE 1=1 ");

            if (tip != 0) {
                queryBuilder.append("AND O.OKUL_TIP_ID = ").append(tip).append(" ");
            }
            if (tur != 0) {
                queryBuilder.append("AND O.OKUL_TUR_ID = ").append(tur).append(" ");
            }
            if (aktif != 2) {
                queryBuilder.append("AND O.OKUL_AKTIF = ").append(aktif).append(" ");
            }

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                OkulList.add(new Okul(
                        rs.getInt("OKUL_ID"),
                        rs.getString("OKUL_ISIM"),
                        rs.getInt("OKUL_TIP_ID"),
                        rs.getInt("OKUL_TUR_ID"),
                        rs.getInt("OKUL_AKTIF"),
                        rs.getString("OKUL_TIP_ISIM"),
                        rs.getString("OKUL_TUR_ISIM")
                ));
            }

            this.islemBasariliMesaj = "işlem başarılı";

        } catch (Exception ex) {
            DetectError(ex);
        }
        return OkulList;
    }

    public void OkulSil(int sokakid) {
        String deleteQuery = "DELETE FROM OKUL WHERE OKUL_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, sokakid);
            int rowsDeleted = ps.executeUpdate();

            mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
    }

    public void OkulMesajTemizle() {
        this.mesaj = null;
    }

    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public String getIslemBasariliMesaj() {
        return islemBasariliMesaj;
    }

    public void setIslemBasariliMesaj(String islemBasariliMesaj) {
        this.islemBasariliMesaj = islemBasariliMesaj;
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

    public Integer getTip() {
        return tip;
    }

    public void setTip(Integer tip) {
        this.tip = tip;
    }

    public Integer getTur() {
        return tur;
    }

    public void setTur(Integer tur) {
        this.tur = tur;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

}
