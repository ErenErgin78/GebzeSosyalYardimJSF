package dao;

import Entity.Sorgula;
import static Various.ErrorFinder.DetectError;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBConnection;

public class SorgulaDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    // Kisi bulma metodu
    public Sorgula SorgulaBul(BigDecimal tcNumarasi) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM KISI_TEMEL KT");
        query.append(" JOIN KISI_MEDENI_DURUM M ON M.MEDENI_DURUM_ID = KT.MEDENI_DURUM_ID");
        query.append(" JOIN KISI_DETAY KD ON KT.KISI_DETAY_ID = KD.DETAY_ID");
        query.append(" JOIN KISI_ILETISIM KI ON KD.KISI_ILETISIM_ID = KI.KISI_ILETISIM_ID");
        
        query.append(" WHERE KIMLIK_NO = ?");
        try {
            PreparedStatement ps = getDb().prepareStatement(query.toString());
            ps.setBigDecimal(1, tcNumarasi);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                       return new Sorgula(
                        rs.getInt("KISI_ID"),
                        rs.getBigDecimal("KIMLIK_NO"),
                        rs.getString("ISIM"),
                        rs.getString("SOYISIM"),
                        rs.getString("CINSIYET"),
                        rs.getInt("CILT_NO"),
                        rs.getInt("AILE_SIRA_NO"),
                        rs.getInt("SIRA_NO"),
                        rs.getInt("MEDENI_DURUM_ID"),
                        rs.getString("MEDENI_DURUM_ISIM"),
                        rs.getInt("KISI_ILETISIM_ID"),
                        rs.getBigDecimal("EV_TELEFON").toBigInteger(),
                        rs.getBigDecimal("CEP_TELEFON").toBigInteger(),
                        rs.getString("EPOSTA"),
                        rs.getInt("KISI_ADRES_ID"),
                        rs.getString("TARIF"),
                        rs.getString("SITE"),
                        rs.getInt("KAPI_NO"),
                        rs.getInt("DAIRE_NO"),
                        rs.getInt("KISI_ADRES_MAHALLE_ID"),
                        rs.getString("KISI_ADRES_MAHALLE_ISIM"),
                        rs.getInt("KISI_MAHALLE_SOKAK_ID"),
                        rs.getString("KISI_MAHALLE_SOKAK_ISIM")
                );
            }
            // sonuç bulunamadı
            
        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
        return null;
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
