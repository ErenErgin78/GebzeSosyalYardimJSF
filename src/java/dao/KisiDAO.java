package dao;

import Entity.Kisi;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
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

    private boolean yabancı_kimlik_mi;
    private boolean misafir_mi;

    private String adresId = null;
    private String iletisimId = null;
    private String yakinlarId = null;
    private Integer kisi_temel_id = null;

    public void Create(Kisi kisi) {
        try {
            Connection conn = this.getDb();

            // misafir ve yabancı kimlik ataması
            char ayarlama;
            ayarlama = yabancı_kimlik_mi ? 'E' : 'H';
            kisi.setYabanci_kimlik(ayarlama);

            ayarlama = misafir_mi ? 'E' : 'H';
            kisi.setMisafir(ayarlama);

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
            csAdres.setString(3, kisi.getCadde_sokak());
            csAdres.setString(4, kisi.getTarif());
            csAdres.setString(5, kisi.getSite());
            csAdres.setInt(6, kisi.getKapi_no());
            csAdres.setInt(7, kisi.getDaire_no());
            csAdres.setInt(8, kisi.getAdres_no());
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
            String callableQueryKisi = "{call INSERT_KISI_TEMEL(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement csKisi = conn.prepareCall(callableQueryKisi);
            csKisi.setObject(1, kisi.getKimlik_no());
            csKisi.setString(2, kisi.getIsim());
            csKisi.setString(3, kisi.getSoyisim());
            csKisi.setString(4, String.valueOf(kisi.getCinsiyet()));
            csKisi.setInt(5, kisi.getMedeni_durum_id());
            csKisi.setString(6, String.valueOf(kisi.getYabanci_kimlik()));
            csKisi.setString(7, String.valueOf(kisi.getMisafir()));
            csKisi.setString(8, kisi.getCilt_no());
            csKisi.setInt(9, kisi.getAile_sıra_no());
            csKisi.setInt(10, kisi.getSıra_no());
            csKisi.setDate(11, new java.sql.Date(kisi.getDogum_tarihi().getTime()));
            csKisi.setInt(12, Integer.parseInt(iletisimId));
            csKisi.setInt(13, Integer.parseInt(adresId));
            csKisi.setInt(14, Integer.parseInt(yakinlarId));
            csKisi.executeUpdate();

        } catch (Exception ex) {
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
            }
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage.toString(), null));
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

    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

    public boolean isYabancı_kimlik_mi() {
        return yabancı_kimlik_mi;
    }

    public void setYabancı_kimlik_mi(boolean yabancı_kimlik_mi) {
        this.yabancı_kimlik_mi = yabancı_kimlik_mi;
    }

    public boolean isMisafir_mi() {
        return misafir_mi;
    }

    public void setMisafir_mi(boolean misafir_mi) {
        this.misafir_mi = misafir_mi;
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
