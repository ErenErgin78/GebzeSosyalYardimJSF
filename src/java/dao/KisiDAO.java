/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Kisi;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eren
 */
public class KisiDAO {

    private Connection db;

    private boolean yabancı_kimlik_mi;
    private boolean misafir_mi;

    // ID'LER
    private Integer adresId = null;
    private Integer iletisimId = null;
    private Integer yakinlarId = null;
    private static Integer kisi_temel_id = null;

    public void Create(Kisi kisi) {
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            // misafir ve yabancı kimlik ataması
            char ayarlama;
            ayarlama = yabancı_kimlik_mi ? 'E' : 'H';
            kisi.setYabanci_kimlik(ayarlama);

            ayarlama = misafir_mi ? 'E' : 'H';
            kisi.setMisafir(ayarlama);

            // KISI_YAKINLAR
            String insertQueryYakınlar = "INSERT INTO KISI_YAKINLAR (ANNE_ISIM, BABA_ISIM, ES_ISIM, ES_SOYISIM, ES_DURUM_ID) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = db.prepareStatement(insertQueryYakınlar, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, kisi.getAnne_isim());
            preparedStatement.setString(2, kisi.getBaba_isim());
            preparedStatement.setString(3, kisi.getEs_isim());
            preparedStatement.setString(4, kisi.getEs_soyisim());
            preparedStatement.setInt(5, kisi.getEs_durum_id());
            preparedStatement.executeUpdate();
            generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                yakinlarId = generatedKeys.getInt(1);
            }
            preparedStatement.close();

            // KISI_ADRES
            String insertQueryAdres = "INSERT INTO KISI_ADRES (ILCE, KISI_ADRES_MAHALLE_ID, CADDE_SOKAK, TARIF, SITE, KAPI_NO, DAIRE_NO, ADRES_NO, EVDEKI_KISI_SAYISI) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = db.prepareStatement(insertQueryAdres, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, kisi.getIlce());
            preparedStatement.setInt(2, kisi.getMahalle_id());
            preparedStatement.setString(3, kisi.getCadde_sokak());
            preparedStatement.setString(4, kisi.getTarif());
            preparedStatement.setString(5, kisi.getSite());
            preparedStatement.setInt(6, kisi.getKapi_no());
            preparedStatement.setInt(7, kisi.getDaire_no());
            preparedStatement.setInt(8, kisi.getAdres_no());
            preparedStatement.setInt(9, kisi.getEvdeki_kisi_sayisi());
            preparedStatement.executeUpdate();
            generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                adresId = generatedKeys.getInt(1);
            }
            preparedStatement.close();

            // KISI_ILETISIM
            String insertQueryIletisim = "INSERT INTO KISI_ILETISIM (EV_TELEFON, CEP_TELEFON, EPOSTA) VALUES (?, ?, ?)";
            preparedStatement = db.prepareStatement(insertQueryIletisim, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setBigDecimal(1, new java.math.BigDecimal(kisi.getEv_telefon()));
            preparedStatement.setBigDecimal(2, new java.math.BigDecimal(kisi.getCep_telefon()));
            preparedStatement.setString(3, kisi.getEposta());
            preparedStatement.executeUpdate();
            generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                iletisimId = generatedKeys.getInt(1);
            }
            preparedStatement.close();

            // KISI
            String insertQueryKisi = "INSERT INTO KISI (KIMLIK_NO, ISIM, SOYISIM, CINSIYET, MEDENI_DURUM_ID, YABANCI_KIMLIK, MISAFIR, CILT_NO, AILE_SIRA_NO, SIRA_NO, DOGUM_TARIHI, KISI_ILETISIM_ID, KISI_ADRES_ID, KISI_YAKINLAR_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = db.prepareStatement(insertQueryKisi, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, kisi.getKimlik_no().toString());
            preparedStatement.setString(2, kisi.getIsim());
            preparedStatement.setString(3, kisi.getSoyisim());
            preparedStatement.setString(4, String.valueOf(kisi.getCinsiyet()));
            preparedStatement.setInt(5, kisi.getMedeni_durum_id());
            preparedStatement.setString(6, String.valueOf(kisi.getYabanci_kimlik()));
            preparedStatement.setString(7, String.valueOf(kisi.getMisafir()));
            preparedStatement.setString(8, kisi.getCilt_no());
            preparedStatement.setInt(9, kisi.getAile_sıra_no());
            preparedStatement.setInt(10, kisi.getSıra_no());
            preparedStatement.setDate(11, new java.sql.Date(kisi.getDogum_tarihi().getTime()));
            preparedStatement.setInt(12, iletisimId);
            preparedStatement.setInt(13, adresId);
            preparedStatement.setInt(14, yakinlarId);
            preparedStatement.executeUpdate();
            generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                kisi_temel_id = generatedKeys.getInt(1);
            }
            preparedStatement.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            // Kaynakları kapat
            try {
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            Connection connection = this.getDb();
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.setInt(1, kullaniciId);

            int rowsDeleted = statement.executeUpdate();
            System.out.println(rowsDeleted + " kisi silindi.");

        } catch (SQLException ex) {
            System.out.println("Veritabanı hatası: " + ex.getMessage());
        }
    }

    public Connection getDb() {
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
