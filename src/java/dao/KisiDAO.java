/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Kisi;
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

    public void Create(Kisi kisi) {
        try {
            Statement statement = this.getDb().createStatement();

            // KISI_YAKINLAR:
            String insertQueryYakınlar = "INSERT INTO KISI_YAKINLAR (ANNE_ISIM, BABA_ISIM, ES_ISIM, ES_SOYISIM, ES_DURUM_ID) VALUES ('"
                    + kisi.getAnne_isim() + "', '"
                    + kisi.getBaba_isim() + "', '"
                    + kisi.getEs_isim() + "', '"
                    + kisi.getEs_soyisim() + "', "
                    + kisi.getEs_durum_id() + ")";
            int rYakınlar = statement.executeUpdate(insertQueryYakınlar);

            // KISI_ADRES:
            String insertQueryAdres = "INSERT INTO KISI_ADRES ( ILCE, MAHALLE, CADDE_SOKAK, TARIF, SITE, KAPI_NO, DAIRE_NO, ADRES_NO, EVDEKI_KISI_SAYISI) VALUES ("
                    + kisi.getIlce() + "', '"
                    + kisi.getMahalle() + "', '"
                    + kisi.getCadde_sokak() + "', '"
                    + kisi.getTarif() + "', '"
                    + kisi.getSite() + "', "
                    + kisi.getKapi_no() + ", "
                    + kisi.getDaire_no() + ", "
                    + kisi.getAdres_no() + ", "
                    + kisi.getEvdeki_kisi_sayisi() + ")";
            int rAdres = statement.executeUpdate(insertQueryAdres);

            String insertQueryIletisim = "INSERT INTO KISI_ILETISIM (EV_TELEFON, CEP_TELEFON, EPOSTA) VALUES ('"
                    + kisi.getEv_telefon() + "', '"
                    + kisi.getCep_telefon() + "', '"
                    + kisi.getEposta() + "')";
            int rIletisim = statement.executeUpdate(insertQueryIletisim);

            // KISI:
            String insertQueryKisi = "INSERT INTO KISI (KIMLIK_NO, ISIM, SOYISIM, CINSIYET, MEDENI_DURUM_ID, EGITIM_DURUM_ID, YABANCI_KIMLIK, MISAFIR, CILT_NO, AILE_SIRA_NO, SIRA_NO, DOGUM_TARIHI) VALUES ('"
                    + kisi.getKimlik_no().toString() + "', '"
                    + kisi.getIsim() + "', '"
                    + kisi.getSoyisim() + "', '"
                    + kisi.getCinsiyet() + "', "
                    + kisi.getMedeni_durum_id() + ", "
                    + kisi.getEgitim_durum_id() + ", '"
                    + kisi.getYabanci_kimlik() + "', '"
                    + kisi.getMisafir() + "', '"
                    + kisi.getCilt_no() + "', "
                    + kisi.getAile_sıra_no() + ", "
                    + kisi.getSıra_no() + ", '"
                    + new java.sql.Date(kisi.getDogum_tarihi().getTime()) + "')";
            int rKisi = statement.executeUpdate(insertQueryKisi);

            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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

}
