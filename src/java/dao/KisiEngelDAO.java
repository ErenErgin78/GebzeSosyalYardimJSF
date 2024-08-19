/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.KisiEngel;
import static Various.ErrorFinder.DetectError;
import java.sql.CallableStatement;
import util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class KisiEngelDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;

    private Integer id = 0;
    private String isim = "";

    public Integer KisiEngelEkle(KisiEngel engel) {
        try {
            Connection conn = this.getDb();
            Statement statement = getDb().createStatement();
            String KurumAltquery = "SELECT KURUM_ID FROM KURUM_ALT WHERE ALT_KURUM_ID =" + engel.getAlt_kurum_id();
            ResultSet rs = statement.executeQuery(KurumAltquery);

            while (rs.next()) {
                engel.setKurum_id(rs.getInt("KURUM_ID"));
            }
        
            Statement statement2 = getDb().createStatement();
            String engelAltQuery = "SELECT ENGELLI_TIP_ID FROM ENGELLI_ALT_TIP WHERE ALT_TIP_ID =" + engel.getEngelli_alt_tip_id();
            ResultSet rs2 = statement2.executeQuery(engelAltQuery);

            while (rs2.next()) {
                engel.setEngelli_tip_id(rs.getInt("ENGELLI_TIP_ID"));
            }

            String callQueryEngel = "{call INSERT_KISI_ENGEL(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement csEngel = conn.prepareCall(callQueryEngel);
            csEngel.setInt(1, engel.getEngelli_tip_id());
            csEngel.setInt(2, engel.getEngelli_alt_tip_id());
            csEngel.setInt(3, engel.getKurum_id());
            csEngel.setInt(4, engel.getAlt_kurum_id());
            csEngel.setFloat(5, engel.getDerece());
            csEngel.setString(6, engel.getEngel_baslangic());
            csEngel.setInt(7, engel.getAktif());
            csEngel.setString(8, engel.getHastalik());
            csEngel.registerOutParameter(9, java.sql.Types.INTEGER);
            csEngel.execute();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
            return csEngel.getInt(9);

        } catch (Exception ex) {
            this.islemBasariliMesaj = DetectError(ex);
            return null;
        }
    }

    public List<KisiEngel> GetList() {
        List<KisiEngel> engelList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();

            String selectQuery = "SELECT * FROM KISI_ENGEL";

            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()) {
                KisiEngel engel = new KisiEngel();
                engel.setKisi_engel_id(rs.getInt("KISI_ENGEL_ID"));
                engel.setEngelli_tip_id(rs.getInt("ENGELLI_TIP_ID"));
                engel.setEngelli_alt_tip_id(rs.getInt("ENGELLI_ALT_TIP_ID"));
                engel.setKurum_id(rs.getInt("KURUM_ID"));
                engel.setAlt_kurum_id(rs.getInt("ALT_KURUM_ID"));
                engel.setDerece(rs.getFloat("DERECE"));
                engel.setEngel_baslangic(rs.getString("ENGEL_BASLANGIC"));
                engel.setKayit_tarihi(rs.getDate("KAYIT_TARIHI"));
                engel.setAktif(rs.getInt("AKTIF"));
                engel.setHastalik(rs.getString("HASTALIK"));
                engel.setGuncelleme_tarihi(rs.getDate("GUNCELLEME_TARIHI"));

                engelList.add(engel);
            }
            this.islemBasariliMesaj = "İşlem başarılı";

        } catch (SQLException ex) {
            DetectError(ex);
        }
        return engelList;
    }

    public void KisiEngelSil(int kisiEngelId) {
        String deleteQuery = "DELETE FROM KISI_ENGEL WHERE KISI_ENGEL_ID = " + kisiEngelId;

        try {
            Statement statement = getDb().createStatement();
            int rowsDeleted = statement.executeUpdate(deleteQuery);
            System.out.println(rowsDeleted + " engel kaydı silindi.");

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (SQLException ex) {
          this.islemBasariliMesaj = DetectError(ex);
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getIslemBasariliMesaj() {
        return islemBasariliMesaj;
    }

    public void setIslemBasariliMesaj(String islemBasariliMesaj) {
        this.islemBasariliMesaj = islemBasariliMesaj;
    }

}
