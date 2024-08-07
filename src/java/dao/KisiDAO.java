package dao;

import Entity.Kisi;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KisiDAO extends DBConnection {

    private Connection db;

    private String adresId = null;
    private String iletisimId = null;
    private String yakinlarId = null;
    private Integer kisi_temel_id = null;

    private String islemBasariliMesaj;

    public void Sorgula(Kisi kisi) {

        String callQuery = "{call get_kisi_info(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try {
            Connection conn = this.getDb();
            CallableStatement csSorgula = conn.prepareCall(callQuery);
            csSorgula.setObject(1, kisi.getKimlik_no());

            int[] dateIndexes = {2};
            int[] varcharIndexes = {3, 4, 7, 10, 11, 12, 13, 14, 15, 16, 23};
            int[] charIndexes = {5};
            int[] integerIndexes = {6, 8, 9, 17, 18, 19, 20};
            int[] numericIndexes = {21, 22};

            // Tiplere göre atamalar
            for (int index : dateIndexes) {
                csSorgula.registerOutParameter(index, Types.DATE);
            }
            for (int index : varcharIndexes) {
                csSorgula.registerOutParameter(index, Types.VARCHAR);
            }
            for (int index : charIndexes) {
                csSorgula.registerOutParameter(index, Types.CHAR);
            }
            for (int index : integerIndexes) {
                csSorgula.registerOutParameter(index, Types.INTEGER);
            }
            for (int index : numericIndexes) {
                csSorgula.registerOutParameter(index, Types.NUMERIC);
            }

            csSorgula.execute();

            // Otomatik doldurulacak alanlar
            kisi.setDogum_tarihi(csSorgula.getDate(2));
            kisi.setIsim(csSorgula.getString(3));
            kisi.setSoyisim(csSorgula.getString(4));
            kisi.setCinsiyet(csSorgula.getString(5).charAt(0));
            kisi.setAile_sira_no(csSorgula.getInt(6));
            kisi.setCilt_no(csSorgula.getString(7));
            kisi.setMedeni_durum_id(csSorgula.getInt(8));
            kisi.setSira_no(csSorgula.getInt(9));
            kisi.setAnne_isim(csSorgula.getString(10));
            kisi.setBaba_isim(csSorgula.getString(11));
            kisi.setEs_isim(csSorgula.getString(12));
            kisi.setEs_soyisim(csSorgula.getString(13));
            kisi.setIlce(csSorgula.getString(14));
            kisi.setTarif(csSorgula.getString(15));
            kisi.setSite(csSorgula.getString(16));
            kisi.setKapi_no(csSorgula.getInt(17));
            kisi.setDaire_no(csSorgula.getInt(18));
            kisi.setAdres_no(csSorgula.getInt(19));
            kisi.setMahalle_id(csSorgula.getInt(20));
            kisi.setEv_telefon(csSorgula.getBigDecimal(21).toBigInteger());
            kisi.setCep_telefon(csSorgula.getBigDecimal(22).toBigInteger());
            kisi.setEposta(csSorgula.getString(23));

        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public void Create(Kisi kisi) {
        try {
            Connection conn = this.getDb();

            // KISI_YAKINLAR stored procedure çağırma
            String callQuery = "{call INSERT_KISI_YAKINLAR(?, ?, ?, ?, ?)}";
            CallableStatement csYakınlar = conn.prepareCall(callQuery);
            csYakınlar.setString(1, kisi.getBaba_isim());
            csYakınlar.setString(2, kisi.getAnne_isim());
            csYakınlar.setString(3, kisi.getEs_isim());
            csYakınlar.setString(4, kisi.getEs_soyisim());
            csYakınlar.registerOutParameter(5, java.sql.Types.VARCHAR);
            csYakınlar.execute();
            yakinlarId = csYakınlar.getString(5);

            // KISI_ADRES stored procedure çağırma
            String callQueryAdres = "{call INSERT_KISI_ADRES(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement csAdres = conn.prepareCall(callQueryAdres);
            csAdres.setString(1, kisi.getIlce());
            csAdres.setInt(2, kisi.getMahalle_id());
            csAdres.setString(3, kisi.getTarif());
            csAdres.setString(4, kisi.getSite());
            csAdres.setInt(5, kisi.getKapi_no());
            csAdres.setInt(6, kisi.getDaire_no());
            csAdres.setInt(7, kisi.getAdres_no());
            csAdres.setInt(8, kisi.getMahalle_sokak_id());
            csAdres.registerOutParameter(9, java.sql.Types.INTEGER);
            csAdres.execute();
            adresId = csAdres.getString(9);

            // KISI_ILETISIM saklı yordamı çağırma
            String callQueryIletisim = "{call INSERT_KISI_ILETISIM(?, ?, ?, ?)}";
            CallableStatement csIletisim = conn.prepareCall(callQueryIletisim);
            csIletisim.setObject(1, kisi.getEv_telefon());
            csIletisim.setObject(2, kisi.getCep_telefon());
            csIletisim.setString(3, kisi.getEposta());
            csIletisim.registerOutParameter(4, java.sql.Types.INTEGER);
            csIletisim.execute();
            iletisimId = csIletisim.getString(4);

            // KISI_TEMEL
            String callableQueryKisi = "{call INSERT_KISI_TEMEL(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement csKisi = conn.prepareCall(callableQueryKisi);
            csKisi.setObject(1, kisi.getKimlik_no());
            csKisi.setString(2, kisi.getIsim());
            csKisi.setString(3, kisi.getSoyisim());
            csKisi.setString(4, String.valueOf(kisi.getCinsiyet()));
            csKisi.setInt(5, kisi.getMedeni_durum_id());
            csKisi.setString(6, kisi.getCilt_no());
            csKisi.setInt(7, kisi.getAile_sira_no());
            csKisi.setInt(8, kisi.getSira_no());
            csKisi.setDate(9, new java.sql.Date(kisi.getDogum_tarihi().getTime()));
            csKisi.setInt(10, Integer.parseInt(iletisimId));
            csKisi.setInt(11, Integer.parseInt(adresId));
            csKisi.setInt(12, Integer.parseInt(yakinlarId));
            csKisi.executeUpdate();

        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public List<Kisi> GetList() {
        List<Kisi> KisiList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT * FROM KISI_TEMEL";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                KisiList.add(new Kisi());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return KisiList;
    }

    public void DeleteKisi(int KisiId) {
        String deleteQuery = "DELETE FROM KISI_TEMEL WHERE kullanici_id = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, KisiId);
            int rowsDeleted = ps.executeUpdate();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            System.out.println("Veritabanı hatası: " + ex.getMessage());
        }
    }

    public List<SelectItem> MahalleGetir() {
        List<SelectItem> MahalleList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT KISI_ADRES_MAHALLE_ID, MAHALLE FROM KISI_ADRES_MAHALLE";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                MahalleList.add(new SelectItem(rs.getInt("KISI_ADRES_MAHALLE_ID"), rs.getString("MAHALLE")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return MahalleList;
    }

    public List<SelectItem> SokakGetir(int selectedmahalleid) {
        List<SelectItem> MahalleList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT SOKAK_ID, SOKAK_ISIM FROM KISI_MAHALLE_SOKAK WHERE MAHALLE_ID = " + selectedmahalleid;
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {

                MahalleList.add(new SelectItem(rs.getInt("SOKAK_ID"), rs.getString("SOKAK_ISIM")));
            }

        } catch (Exception ex) {
            DetectError(ex);
        }
        return MahalleList;
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

    public String getAdresId() {
        return adresId;
    }

    public void setAdresId(String adresId) {
        this.adresId = adresId;
    }

    public String getIletisimId() {
        return iletisimId;
    }

    public void setIletisimId(String iletisimId) {
        this.iletisimId = iletisimId;
    }

    public String getYakinlarId() {
        return yakinlarId;
    }

    public void setYakinlarId(String yakinlarId) {
        this.yakinlarId = yakinlarId;
    }

    public Integer getKisi_temel_id() {
        return kisi_temel_id;
    }

    public void setKisi_temel_id(Integer kisi_temel_id) {
        this.kisi_temel_id = kisi_temel_id;
    }

    public String getIslemBasariliMesaj() {
        return islemBasariliMesaj;
    }

    public void setIslemBasariliMesaj(String islemBasariliMesaj) {
        this.islemBasariliMesaj = islemBasariliMesaj;
    }
    
    

}
