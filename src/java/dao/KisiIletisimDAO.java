package dao;


import Entity.KisiIletisim;
import static Filters.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KisiIletisimDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    public void addKisiIletisim(KisiIletisim kisiIletisim) {
        try {
            Connection conn = this.getDb();
            String callQueryIletisim = "{call INSERT_KISI_ILETISIM(?, ?, ?, ?)}";
            CallableStatement csIletisim = conn.prepareCall(callQueryIletisim);
            csIletisim.setObject(1, kisiIletisim.getEv_telefon());
            csIletisim.setObject(2, kisiIletisim.getCep_telefon());
            csIletisim.setString(3, kisiIletisim.getEposta());
            csIletisim.registerOutParameter(4, java.sql.Types.INTEGER);
            csIletisim.execute();

        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public void deleteKisiIletisim(int iletisimId) {
        String deleteQuery = "DELETE FROM KISI_ILETISIM WHERE KISI_ILETISIM_ID = ?";

        try (Connection conn = getDb(); PreparedStatement ps = conn.prepareStatement(deleteQuery)) {

            ps.setInt(1, iletisimId);
            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                this.mesaj = "İşlem başarıyla gerçekleşti.";
            } else {
                this.mesaj = "Silinecek kayıt bulunamadı.";
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public List<KisiIletisim> getKisiIletisimList() {
        List<KisiIletisim> kisiIletisimList = new ArrayList<>();
        String query = "SELECT KISI_ILETISIM_ID, EV_TELEFON, CEP_TELEFON, EPOSTA FROM KISI_ILETISIM";

        try (Connection conn = getDb(); Statement statement = conn.createStatement(); ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                kisiIletisimList.add(new KisiIletisim(
                        rs.getBigDecimal("EV_TELEFON").toBigInteger(),
                        rs.getBigDecimal("CEP_TELEFON").toBigInteger(),
                        rs.getString("EPOSTA")
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return kisiIletisimList;
    }

    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
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

}
