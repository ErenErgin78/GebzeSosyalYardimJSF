package dao;

import Entity.Kisi;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.math.BigDecimal;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KisiDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    private String isim = "";

    // Kisi ekleme metodu
    public Integer KisiEkle(Kisi kisi) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_KISI_TEMEL(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setObject(1, kisi.getKimlik_no());
            cs.setString(2, kisi.getIsim());
            cs.setString(3, kisi.getSoyisim());
            cs.setString(4, kisi.getCinsiyet());
            cs.setInt(5, kisi.getMedeni_durum_id());
            cs.setInt(6, kisi.getCilt_no());
            cs.setInt(7, kisi.getAile_sira_no());
            cs.setInt(8, kisi.getSira_no());
            cs.setDate(9, new java.sql.Date(kisi.getDogum_tarihi().getTime()));
            cs.registerOutParameter(10, java.sql.Types.INTEGER);
            cs.execute();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

            return cs.getInt(10);

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
            return null;
        }
    }

    public Integer KisiEkle(Kisi kisi, Integer detayId) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_KISI_TEMEL_2(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setObject(1, kisi.getKimlik_no());
            cs.setString(2, kisi.getIsim());
            cs.setString(3, kisi.getSoyisim());
            cs.setString(4, kisi.getCinsiyet());
            cs.setInt(5, kisi.getMedeni_durum_id());
            cs.setInt(6, kisi.getCilt_no());
            cs.setInt(7, kisi.getAile_sira_no());
            cs.setInt(8, kisi.getSira_no());
            cs.setDate(9, new java.sql.Date(kisi.getDogum_tarihi().getTime()));
            cs.setInt(10, detayId);
            cs.registerOutParameter(11, java.sql.Types.INTEGER);
            cs.execute();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

            return cs.getInt(11);

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
            return null;
        }
    }

    public Integer KisiMuracaatEkle(Kisi kisi, Integer detayId) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_MURACAAT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setObject(1, kisi.getKimlik_no());
            cs.setString(2, kisi.getIsim());
            cs.setString(3, kisi.getSoyisim());
            cs.setString(4, kisi.getCinsiyet());
            cs.setInt(5, kisi.getMedeni_durum_id());
            cs.setInt(6, kisi.getCilt_no());
            cs.setInt(7, kisi.getAile_sira_no());
            cs.setInt(8, kisi.getSira_no());
            cs.setDate(9, new java.sql.Date(kisi.getDogum_tarihi().getTime()));
            cs.setInt(10, kisi.getMahalle_id());
            cs.setInt(11, kisi.getSokak_id());
            cs.setString(12, kisi.getSite());
            cs.setString(13, kisi.getAdres_tarifi());
            cs.setInt(14, kisi.getKapi_no());
            cs.setInt(15, kisi.getDaire_no());
            cs.setString(16, kisi.getEv_telefon());
            cs.setString(17, kisi.getCep_telefon());
            cs.setString(18, kisi.getEposta());
            cs.setDate(19, new java.sql.Date(kisi.getKayit_tarihi().getTime()));
            cs.setInt(20, detayId);  // "p_aktif" parametresini doğru şekilde ayarladık
            cs.registerOutParameter(21, java.sql.Types.INTEGER);  // Çıkış parametresi "p_muracaat_id"
            cs.execute();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

            return cs.getInt(21);  // Çıkış parametresini doğru şekilde alıyoruz

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
            return null;
        }
    }

    // Kisi silme metodu
    public void KisiSil(int kisiId) {
        String deleteQuery = "DELETE FROM KISI_TEMEL WHERE KISI_ID = ?";
        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, kisiId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
    }

    public Kisi KisiBul(BigDecimal tcNumarasi) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append("kt.KIMLIK_NO, kt.DOGUM_TARIHI, kt.ISIM, kt.SOYISIM, kt.CINSIYET, kt.MEDENI_DURUM_ID,kt.KAYIT_TARIHI,kt.AKTIF, ");
        query.append("kt.AILE_SIRA_NO, kt.SIRA_NO, kt.CILT_NO, kam.mahalle, kam.KISI_ADRES_MAHALLE_ID, ");
        query.append("kms.SOKAK_ID, ka.ILCE, ka.SITE, ka.TARIF, ka.KAPI_NO, ka.DAIRE_NO, ");
        query.append("ki.EV_TELEFON, ki.CEP_TELEFON, ki.EPOSTA ");
        query.append("FROM KISI_TEMEL kt ");
        query.append("JOIN KISI_DETAY kd ON kt.KISI_ID = kd.KISI_ID ");
        query.append("JOIN KISI_ILETISIM ki ON kd.KISI_ILETISIM_ID = ki.KISI_ILETISIM_ID ");
        query.append("JOIN KISI_ADRES ka ON kd.KISI_ADRES_ID = ka.KISI_ADRES_ID ");
        query.append("JOIN KISI_ADRES_MAHALLE kam ON kam.KISI_ADRES_MAHALLE_ID = ka.KISI_ADRES_MAHALLE_ID ");
        query.append("JOIN KISI_MAHALLE_SOKAK kms ON kms.sokak_ıd = ka.KISI_MAHALLE_SOKAK_ID ");
        query.append("WHERE kt.KIMLIK_NO = ?");

        try {
            PreparedStatement ps = getDb().prepareStatement(query.toString());
            ps.setBigDecimal(1, tcNumarasi);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Kisi(
                        rs.getBigDecimal("KIMLIK_NO"),
                        rs.getString("ISIM"),
                        rs.getString("SOYISIM"),
                        rs.getString("CINSIYET"),
                        rs.getInt("CILT_NO"),
                        rs.getInt("AILE_SIRA_NO"),
                        rs.getInt("SIRA_NO"),
                        rs.getDate("DOGUM_TARIHI"),
                        rs.getInt("MEDENI_DURUM_ID"),
                        rs.getInt("KISI_ADRES_MAHALLE_ID"),
                        rs.getInt("SOKAK_ID"),
                        rs.getString("ILCE"),
                        rs.getString("SITE"),
                        rs.getString("TARIF"),
                        rs.getInt("DAIRE_NO"),
                        rs.getInt("KAPI_NO"),
                        rs.getString("EV_TELEFON"),
                        rs.getString("CEP_TELEFON"),
                        rs.getString("EPOSTA"),
                        rs.getDate("KAYIT_TARIHI")
                );
            }

        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
        return null;
    }

    // Kisi listesini çekme metodu
    public List<Kisi> KisiListesi() {
        List<Kisi> kisiList = new ArrayList<>();

        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT KT.KISI_ID, KT.KIMLIK_NO, KT.ISIM, KT.SOYISIM, KT.CINSIYET, ");
            queryBuilder.append("KT.CILT_NO, KT.AILE_SIRA_NO, KT.SIRA_NO, KT.DOGUM_TARIHI, ");
            queryBuilder.append("MD.MEDENI_DURUM_ISIM, KT.KAYIT_TARIHI, KT.AKTIF ");
            queryBuilder.append("FROM KISI_TEMEL KT ");
            queryBuilder.append("JOIN KISI_MEDENI_DURUM MD ON KT.MEDENI_DURUM_ID = MD.MEDENI_DURUM_ID ");
            queryBuilder.append("WHERE 1=1");

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                kisiList.add(new Kisi(
                        rs.getBigDecimal("KIMLIK_NO"),
                        rs.getString("ISIM"),
                        rs.getString("SOYISIM"),
                        rs.getString("CINSIYET"),
                        rs.getInt("CILT_NO"),
                        rs.getInt("AILE_SIRA_NO"),
                        rs.getInt("SIRA_NO"),
                        rs.getDate("DOGUM_TARIHI"),
                        rs.getInt("MEDENI_DURUM_ID"),
                        rs.getInt("KISI_ADRES_MAHALLE_ID"),
                        rs.getInt("SOKAK_ID"),
                        rs.getString("ILCE"),
                        rs.getString("SITE"),
                        rs.getString("ADRES_TARIFI"),
                        rs.getInt("DAIRE_NO"),
                        rs.getInt("DAIRE_NO"),
                        rs.getString("EV_TELEFON"),
                        rs.getString("CEP_TELEFON"),
                        rs.getString("EPOSTA"),
                        rs.getDate("KAYIT_TARIHI")
                ));
            }

            mesaj = "İşlem başarılı"; // Operation successful

        } catch (Exception ex) {
            DetectError(ex); // Error handling
        }
        return kisiList;
    }

    public List<SelectItem> kisiGetir() {
        List<SelectItem> kisiList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT MEDENI_DURUM_ID,MEDENI_DURUM  FROM KISI_MEDENI_DURUM";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                kisiList.add(new SelectItem(rs.getInt("MEDENI_DURUM_ID"), rs.getString("MEDENI_DURUM")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return kisiList;
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

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

}