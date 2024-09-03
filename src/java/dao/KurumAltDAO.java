package dao;

import Entity.KurumAlt;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KurumAltDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;

    private Integer id = 0;

    public void KurumAltEkle(KurumAlt kurumAlt) {

        try {
            Connection conn = this.getDb();

            if (kurumAlt.getAktif() == null) {
                kurumAlt.setAktif(1);
            }

            String callQueryAdres = "{call INSERT_KURUM_ALT_TIP(?, ?)}";
            CallableStatement csAdres = conn.prepareCall(callQueryAdres);
            csAdres.setInt(1, kurumAlt.getTip_id());
            csAdres.setString(2, kurumAlt.getAlt_tip());
            csAdres.execute();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            this.islemBasariliMesaj = DetectError(ex);
        }
    }

    public void KurumAltSil(int yardimAltid) {
        String deleteQuery = "DELETE FROM KURUM_ALT WHERE ALT_KURUM_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, yardimAltid);
            int rowsDeleted = ps.executeUpdate();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.islemBasariliMesaj = DetectError(ex);
        }
    }

   public List<KurumAlt> KurumAltListesi(String kurumAltTipiAdi) {
    List<KurumAlt> kurumAltList = new ArrayList<>();
    try {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT YA.ALT_KURUM_ID, YA.KURUM_ID, YA.ALT_KURUM_ISIM, Y.KURUM_ISIM ")
                    .append("FROM KURUM_ALT YA ")
                    .append("JOIN KURUM Y ON YA.KURUM_ID = Y.KURUM_ID WHERE 1=1 ");

        // ID'ye göre filtreleme
        if (id != 0) {
            queryBuilder.append("AND YA.KURUM_ID = ? ");
        }

        // Kurum Alt Tipi Adına göre filtreleme
        if (kurumAltTipiAdi != null && !kurumAltTipiAdi.isEmpty()) {
            queryBuilder.append("AND YA.ALT_KURUM_ISIM LIKE ? ");
        }

        PreparedStatement ps = getDb().prepareStatement(queryBuilder.toString());
        
        int index = 1;

        // Eğer ID filtresi varsa, PreparedStatement için ekle
        if (id != 0) {
            ps.setInt(index++, id);
        }

        // Eğer kurumAltTipiAdi filtresi varsa, PreparedStatement için ekle
        if (kurumAltTipiAdi != null && !kurumAltTipiAdi.isEmpty()) {
            ps.setString(index++, "%" + kurumAltTipiAdi + "%");
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            kurumAltList.add(new KurumAlt(
                rs.getInt("ALT_KURUM_ID"),
                rs.getString("ALT_KURUM_ISIM"),
                rs.getString("KURUM_ISIM")
            ));
        }

        this.islemBasariliMesaj = "İşlem başarılı";

    } catch (Exception ex) {
        DetectError(ex);
    }
    return kurumAltList;
}


    public List<SelectItem> KurumTipGetir() {
        List<SelectItem> TipList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT KURUM_ID, KURUM_ISIM FROM KURUM ";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {

                TipList.add(new SelectItem(rs.getInt("KURUM_ID"), rs.getString("KURUM_ISIM")));
            }

        } catch (Exception ex) {
            DetectError(ex);
        }
        return TipList;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

    public void KurumAltMesajTemizle() {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}