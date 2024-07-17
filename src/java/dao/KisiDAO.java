package dao;

import Entity.Kisi;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KisiDAO extends DBConnection {

    private Connection db;

    private boolean yabancı_kimlik_mi;
    private boolean misafir_mi;

    private Integer adresId = null;
    private Integer iletisimId = null;
    private Integer yakinlarId = null;
    private static Integer kisi_temel_id = null;

    public void Create(Kisi kisi) {
        try {
            Connection conn = this.getDb();
            
            // misafir ve yabancı kimlik ataması
            char ayarlama;
            ayarlama = yabancı_kimlik_mi ? 'E' : 'H';
            kisi.setYabanci_kimlik(ayarlama);

            ayarlama = misafir_mi ? 'E' : 'H';
            kisi.setMisafir(ayarlama);

            // KISI_YAKINLAR
            String insertQueryYakınlar = "INSERT INTO KISI_YAKINLAR (BABA_ISIM, ANNE_ISIM,  ES_ISIM, ES_SOYISIM) VALUES ( ?, ?, ?, ?)";
            PreparedStatement psYakınlar = conn.prepareStatement(insertQueryYakınlar, Statement.RETURN_GENERATED_KEYS);
            psYakınlar.setString(2, kisi.getBaba_isim());
            psYakınlar.setString(1, kisi.getAnne_isim());
            psYakınlar.setString(3, kisi.getEs_isim());
            psYakınlar.setString(4, kisi.getEs_soyisim());
            psYakınlar.executeUpdate();
            ResultSet generatedKeys = psYakınlar.getGeneratedKeys();
            if (generatedKeys.next()) {
                yakinlarId = generatedKeys.getInt(1);
            }

            // KISI_ADRES
            String insertQueryAdres = "INSERT INTO KISI_ADRES (ILCE, KISI_ADRES_MAHALLE_ID, CADDE_SOKAK, TARIF, SITE, KAPI_NO, DAIRE_NO, ADRES_NO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement psAdres = conn.prepareStatement(insertQueryAdres, Statement.RETURN_GENERATED_KEYS);
            psAdres.setString(1, kisi.getIlce());
            psAdres.setInt(2, kisi.getMahalle_id());
            psAdres.setString(3, kisi.getCadde_sokak());
            psAdres.setString(4, kisi.getTarif());
            psAdres.setString(5, kisi.getSite());
            psAdres.setInt(6, kisi.getKapi_no());
            psAdres.setInt(7, kisi.getDaire_no());
            psAdres.setInt(8, kisi.getAdres_no());
            psAdres.executeUpdate();
            generatedKeys = psAdres.getGeneratedKeys();
            if (generatedKeys.next()) {
                adresId = generatedKeys.getInt(1);
            }

            // KISI_ILETISIM
            String insertQueryIletisim = "INSERT INTO KISI_ILETISIM (EV_TELEFON, CEP_TELEFON, EPOSTA) VALUES (?, ?, ?)";
            PreparedStatement psIletisim = conn.prepareStatement(insertQueryIletisim, Statement.RETURN_GENERATED_KEYS);
            psIletisim.setObject(1, kisi.getEv_telefon());  // Assuming ev_telefon is of type BigInteger
            psIletisim.setObject(2, kisi.getCep_telefon()); // Assuming cep_telefon is of type BigInteger
            psIletisim.setString(3, kisi.getEposta());
            psIletisim.executeUpdate();
            generatedKeys = psIletisim.getGeneratedKeys();
            if (generatedKeys.next()) {
                iletisimId = generatedKeys.getInt(1);
            }

            // KISI
            String insertQueryKisi = "INSERT INTO KISI (KIMLIK_NO, ISIM, SOYISIM, CINSIYET, MEDENI_DURUM_ID, YABANCI_KIMLIK, MISAFIR, CILT_NO, AILE_SIRA_NO, SIRA_NO, DOGUM_TARIHI, KISI_ILETISIM_ID, KISI_ADRES_ID, KISI_YAKINLAR_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement psKisi = conn.prepareStatement(insertQueryKisi, Statement.RETURN_GENERATED_KEYS);
            psKisi.setObject(1, kisi.getKimlik_no());  // Assuming kimlik_no is of type BigInteger
            psKisi.setString(2, kisi.getIsim());
            psKisi.setString(3, kisi.getSoyisim());
            psKisi.setString(4, String.valueOf(kisi.getCinsiyet()));
            psKisi.setInt(5, kisi.getMedeni_durum_id());
            psKisi.setString(6, String.valueOf(kisi.getYabanci_kimlik()));
            psKisi.setString(7, String.valueOf(kisi.getMisafir()));
            psKisi.setString(8, kisi.getCilt_no());
            psKisi.setInt(9, kisi.getAile_sıra_no());
            psKisi.setInt(10, kisi.getSıra_no());
            psKisi.setDate(11, new java.sql.Date(kisi.getDogum_tarihi().getTime()));
            psKisi.setInt(12, iletisimId);
            psKisi.setInt(13, adresId);
            psKisi.setInt(14, yakinlarId);
            psKisi.executeUpdate();
            generatedKeys = psKisi.getGeneratedKeys();
            if (generatedKeys.next()) {
                kisi_temel_id = generatedKeys.getInt(1);
            }

        } catch (Exception ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
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

    public Integer getAdresId() {
        return adresId;
    }

    public void setAdresId(Integer adresId) {
        this.adresId = adresId;
    }

    public Integer getIletisimId() {
        return iletisimId;
    }

    public void setIletisimId(Integer iletisimId) {
        this.iletisimId = iletisimId;
    }

    public Integer getYakinlarId() {
        return yakinlarId;
    }

    public void setYakinlarId(Integer yakinlarId) {
        this.yakinlarId = yakinlarId;
    }

    public Integer getKisi_temel_id() {
        return kisi_temel_id;
    }

    public void setKisi_temel_id(Integer kisi_temel_id) {
        this.kisi_temel_id = kisi_temel_id;
    }
}
