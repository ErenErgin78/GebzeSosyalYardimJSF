package dao;

import Entity.Kisi;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.model.SelectItem;
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

    private String adresId = null;
    private String iletisimId = null;
    private String yakinlarId = null;
    private Integer kisi_temel_id = null;

    public void Sorgula(Kisi kisi) {

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT KT.DOGUM_TARIHI, KT.ISIM, KT.SOYISIM, KT.CINSIYET, KT.AILE_SIRA_NO,"
                    + " KT.CILT_NO, KT.MEDENI_DURUM_ID,\n"
                    + "KT.SIRA_NO, KY.ANNE_ISIM, KY.BABA_ISIM, KY.ES_ISIM, KY.ES_SOYISIM,\n"
                    + "KA.ILCE, KA.TARIF, KA.SITE, KA.KAPI_NO, KA.DAIRE_NO, ADRES_NO, KISI_ADRES_MAHALLE_ID,\n"
                    + "KI.EV_TELEFON, KI.CEP_TELEFON, KI.EPOSTA\n"
                    + "FROM KISI_TEMEL KT \n"
                    + "\n"
                    + "JOIN KISI_ILETISIM KI ON KT.KISI_ILETISIM_ID = KT.KISI_ILETISIM_ID\n"
                    + "JOIN KISI_YAKINLAR KY ON KT.KISI_YAKINLAR_ID = KY.KISI_YAKINLAR_ID\n"
                    + "JOIN KISI_ADRES KA ON KT.KISI_ADRES_ID = KA.KISI_ADRES_ID\n"
                    + "WHERE KIMLIK_NO =" + kisi.getKimlik_no();
            ResultSet rs = statement.executeQuery(Selectquery);

            if (rs.next()) {
                kisi.setDogum_tarihi(rs.getDate("DOGUM_TARIHI"));
                kisi.setIsim(rs.getString("ISIM"));
                kisi.setSoyisim(rs.getString("SOYISIM"));
                kisi.setCinsiyet(rs.getString("CINSIYET").charAt(0)); // Assuming CINSIYET is a single character
                kisi.setAile_sira_no(rs.getInt("AILE_SIRA_NO"));
                kisi.setCilt_no(rs.getString("CILT_NO"));
                kisi.setMedeni_durum_id(rs.getInt("MEDENI_DURUM_ID"));
                kisi.setSira_no(rs.getInt("SIRA_NO"));
                kisi.setAnne_isim(rs.getString("ANNE_ISIM"));
                kisi.setBaba_isim(rs.getString("BABA_ISIM"));
                kisi.setEs_isim(rs.getString("ES_ISIM"));
                kisi.setEs_soyisim(rs.getString("ES_SOYISIM"));
                kisi.setIlce(rs.getString("ILCE"));
                kisi.setTarif(rs.getString("TARIF"));
                kisi.setSite(rs.getString("SITE"));
                kisi.setKapi_no(rs.getInt("KAPI_NO"));
                kisi.setDaire_no(rs.getInt("DAIRE_NO"));
                kisi.setAdres_no(rs.getInt("ADRES_NO"));
                kisi.setMahalle_id(rs.getInt("KISI_ADRES_MAHALLE_ID"));
                kisi.setEv_telefon(rs.getBigDecimal("EV_TELEFON").toBigInteger());
                kisi.setCep_telefon(rs.getBigDecimal("CEP_TELEFON").toBigInteger());
                kisi.setEposta(rs.getString("EPOSTA"));
            }

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

    public void Delete(int kullaniciId) {
        String deleteQuery = "DELETE FROM KULLANICI WHERE kullanici_id = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, kullaniciId);
            int rowsDeleted = ps.executeUpdate();
            System.out.println(rowsDeleted + " kisi silindi.");

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

            int x = 1;
            while (rs.next()) {

                MahalleList.add(new SelectItem(rs.getInt("KISI_ADRES_MAHALLE_ID"), rs.getString("MAHALLE")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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

    public void MahalleEkle(Kisi kisi) {
      
        try{Connection conn = this.getDb();

        String callQueryAdres = "{call INSERT_KISI_ADRES_MAHALLE(?)}";
        CallableStatement csAdres = conn.prepareCall(callQueryAdres);
        csAdres.setString(1, kisi.getMahalle());
        csAdres.execute();
        }
        catch(Exception ex){ DetectError(ex);}
    }

    public void DetectError(Exception ex) {
        //Hatayı yakalamak için
        FacesContext context = FacesContext.getCurrentInstance();
        StringBuilder errorMessage = new StringBuilder(ex.getMessage());
        StackTraceElement[] stackTrace = ex.getStackTrace();

        //Hatanın hangi satırda olduğunu görmek için
        for (StackTraceElement element : stackTrace) {
            if (element.getClassName().startsWith("dao")) {
                errorMessage.append(" (at ").append(element.getFileName())
                        .append(":").append(element.getLineNumber()).append(")");
                break;
            }

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage.toString(), null));
        }

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

}
