package dao;

import Entity.YardimStatu;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class YardimStatuDAO extends DBConnection {

    private Connection db;
    private String mesaj; // Başarı mesajı için değişken

    public void YardimStatuEkle(YardimStatu yardimStatu) {
        try {
            Connection conn = (Connection) this.getDb();

            if (yardimStatu.getAktif() == null) {
                yardimStatu.setAktif(1);
            }

            String callQuery = "{call INSERT_YARDIM_STATU(?, ?, ?, ?, ? )}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setInt(1, yardimStatu.getStatu_id());
            cs.setString(2, yardimStatu.getStatu_isim());
            cs.setDate(3, (Date) yardimStatu.getKayit_tarihi());
            cs.setInt(4, yardimStatu.getAktif());
            cs.setDate(5, (Date) yardimStatu.getGuncelleme_tarihi());

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (Exception ex) {
            DetectError(ex);
        }

    }

    public void YardimStatuSil(int yardimStatuid) {
        String deleteQuery = "DELETE FROM YARDIM_STATU WHERE YARDIM_STATU_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, yardimStatuid);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public List<YardimStatu> YardimStatuListesi() {
        List<YardimStatu> yardimStatuList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT STATU_ID, STATU_ISIM, KAYIT_TARIHI, AKTIF, GUNCELLEME_TARIHI FROM YARDIM_STATU");

            Statement statement = (Statement) getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                yardimStatuList.add(new YardimStatu(
                        rs.getString("STATU_ISIM"),
                        rs.getDate("KAYIT_TARIHI"),
                        rs.getInt("AKTIF"),
                        rs.getDate("GUNCELLEME_TARIHI")
                ));
            }

            this.mesaj = "işlem başarılı";

        } catch (Exception ex) {
            DetectError(ex);
        }
        return yardimStatuList;
    }

    public List<SelectItem> YardimStatuGetir() {
        List<SelectItem> TipList = new ArrayList<>();

        try {
            Statement statement = (Statement) getDb().createStatement();
            String Selectquery = "SELECT YARDIM_STATU_ID, YARDIM_STATU_ISIM FROM YARDIM_STATU";
            java.sql.ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("YARDIM_STATU_ID"), rs.getString("YARDIM_STATU_ISIM")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return TipList;

    }

    public void YardimStatuMesajTemizle() {
        this.mesaj = null;
    }

    public java.sql.Connection getDb() {
        if (this.db == null) {
            this.db = (Connection) this.connect();
        }
        return (java.sql.Connection) db;
    }

    public void setDb(Connection db) {
        this.db = (Connection) db;
    }
}
