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
    private String isim = "";

    public void KurumAltEkle(KurumAlt kurumAlt) {

        try {
            Connection conn = this.getDb();
            if(kurumAlt.getAktif()==null){
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

 public List<KurumAlt> KurumAltListesi() {
    List<KurumAlt> kurumAltList = new ArrayList<>();
    try {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT YA.ALT_KURUM_ID, YA.ALT_KURUM_ISIM, YA.KURUM_ID , Y.KURUM_ISIM ")
                .append("FROM KURUM_ALT YA ")
                .append("JOIN KURUM Y ON YA.KURUM_ID = Y.KURUM_ID ")
                .append("WHERE 1=1 ");

        // ID'ye göre filtreleme
        if (id != 0) {
            queryBuilder.append("AND YA.KURUM_ID  = ? ");
        }

        // İsim'e göre filtreleme, null kontrolü
        if (isim != null && !isim.isEmpty()) {
            queryBuilder.append("AND YA.ALT_KURUM_ISIM LIKE ? ");
        }

        PreparedStatement statement = getDb().prepareStatement(queryBuilder.toString());
        int parameterIndex = 1;

        // ID parametresi ekle
        if (id != 0) {
            statement.setInt(parameterIndex++, id);
        }

        // İsim parametresi ekle
        if (isim != null && !isim.isEmpty()) {
            statement.setString(parameterIndex++, "%" + isim + "%");
        }

        ResultSet rs = statement.executeQuery();

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


   public List<SelectItem> KurumAltGetir(int selectedKurumid) {
        List<SelectItem> KurumAltList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT ALT_KURUM_ID, ALT_KURUM_ISIM FROM KURUM_ALT WHERE KURUM_ID = " + selectedKurumid;
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {

                KurumAltList.add(new SelectItem(rs.getInt("ALT_KURUM_ID"), rs.getString("ALT_KURUM_ISIM")));
            }

        } catch (Exception ex) {
            DetectError(ex);
        }
        return KurumAltList;
    }

    public void setDb(Connection db) {
        this.db = db;
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

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

}
