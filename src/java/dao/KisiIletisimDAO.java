package dao;

import Entity.KisiIletisim;
import static Various.ErrorFinder.DetectError;
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
    private String mesaj; // Başarı mesajı için değişken

    public Integer KisiIletisimEkle(KisiIletisim kisiIletisim) {
        try {
            Connection conn = (Connection) this.getDb();

            String callQuery = "{call INSERT_KISI_ILETISIM(?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setObject(1, kisiIletisim.getEv_telefon());
            cs.setObject(2, kisiIletisim.getCep_telefon());
            cs.setString(3, kisiIletisim.getEposta());
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.execute();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

            return cs.getInt(4);

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
            return null;
        }

    }

    public void KisiIletisimSil(int kisiIletisimid) {
        String deleteQuery = "DELETE FROM KISI_ILETISIM WHERE KISI_ILETISIM_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, kisiIletisimid);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
        }
    }

    public List<KisiIletisim> KisiIletisimListesi() {
        List<KisiIletisim> kisiIletisimList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT EV_TELEFON, CEP_TELEFON, EPOSTA, KAYIT_TARIHI, AKTIF, GUNCELLEME_TARIHI FROM KISI_ILETISIM");

            Statement statement = (Statement) getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                kisiIletisimList.add(new KisiIletisim(
                        rs.getBigDecimal("EV_TELEFON").toBigInteger(),
                        rs.getBigDecimal("CEP_TELEFON").toBigInteger(),
                        rs.getString("EPOSTA"),
                        new java.util.Date(rs.getDate("KAYIT_TARIHI").getTime()),
                        rs.getInt("AKTIF"),
                        new java.util.Date(rs.getDate("GUNCELLEME_TARIHI").getTime())
                ));
            }

            this.mesaj = "işlem başarılı";

        } catch (Exception ex) {
            DetectError(ex);
        }
        return kisiIletisimList;
    }

    public List<SelectItem> KisiIletisimGetir() {
        List<SelectItem> TipList = new ArrayList<>();

        try {
            Statement statement = (Statement) getDb().createStatement();
            String Selectquery = "SELECT KISI_ILETISIM_ID, KISI_ILETISIM_ISIM FROM KISI_ILETISIM";
            java.sql.ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("KISI_ILETISIM_ID"), rs.getString("KISI_ILETISIM_ISIM")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return TipList;

    }

    public void KisiIletisimTemizle() {
        this.mesaj = null;
    }

    public java.sql.Connection getDb() {
        if (this.db == null) {
            this.db = (Connection) this.connect();
        }
        return (java.sql.Connection) db;
    }

    public void setDb(java.sql.Connection db) {
        this.db = (Connection) db;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

}