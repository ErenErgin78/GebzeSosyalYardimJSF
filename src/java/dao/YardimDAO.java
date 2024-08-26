package dao;

import Entity.Yardim;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class YardimDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;

    public void YardimEkle(Yardim yardim) {

        try {
            Connection conn = this.getDb();

            if (yardim.getAktif() == null) {
                yardim.setAktif(1);
            }

            String callQuery = "{call INSERT_YARDIM_TIP(?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setString(1, yardim.getYardim_tip());
            cs.setInt(2, yardim.getYardim_tur_id());
            cs.execute();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            this.islemBasariliMesaj = DetectError(ex);
        }
    }

    public void YardimSil(int yardimTipId) {
        String deleteQuery = "DELETE FROM YARDIM_TIP WHERE YARDIM_TIP_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, yardimTipId);
            int rowsDeleted = ps.executeUpdate();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.islemBasariliMesaj = DetectError(ex);
        }
    }

    public List<Yardim> YardimListesi(String yardimTipiAdi, Integer yardimTurId) {
        List<Yardim> yardimList = new ArrayList<>();
        try {
            StringBuilder query = new StringBuilder("SELECT YARDIM_TIP_ID, YARDIM_TIP, YARDIM_TUR_ID FROM YARDIM_TIP WHERE 1=1");

            if (yardimTipiAdi != null && !yardimTipiAdi.isEmpty()) {
                query.append(" AND YARDIM_TIP LIKE ?"); // Yardım tipi adı kriteri
            }
            if (yardimTurId != null) {
                query.append(" AND YARDIM_TUR_ID = ?"); // Yardım türü kriteri
            }

            PreparedStatement ps = getDb().prepareStatement(query.toString());

            int index = 1;
            if (yardimTipiAdi != null && !yardimTipiAdi.isEmpty()) {
                ps.setString(index++, "%" + yardimTipiAdi + "%");
            }
            if (yardimTurId != null) {
                ps.setInt(index++, yardimTurId);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                yardimList.add(new Yardim(
                        rs.getInt("YARDIM_TIP_ID"),
                        rs.getString("YARDIM_TIP"),
                        rs.getInt("YARDIM_TUR_ID")
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return yardimList;
    }

public List<SelectItem> yardimTurGetir() {
    List<SelectItem> TurList = new ArrayList<>();

    try {
        Statement statement = getDb().createStatement();
        String selectQuery = "SELECT TUR_ID, TUR FROM YARDIM_TUR";
        ResultSet rs = statement.executeQuery(selectQuery);

        while (rs.next()) {
            TurList.add(new SelectItem(rs.getInt("TUR_ID"), rs.getString("TUR")));
        }
    } catch (Exception ex) {
        DetectError(ex);
    }
    return TurList;
}


    

    public void setDb(Connection db) {
        this.db = db;
    }

    public void YardimMesajTemizle() {
        this.islemBasariliMesaj = null;
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
}
