package dao;

import Entity.Engel;
import Entity.Kisi;
import Entity.KisiYakinlar;
import static Filters.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KisiYakinlarDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    public void KisiYakinlarEkle(KisiYakinlar kisiyakinlar) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_KISI_YAKINLAR(?,?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(callQuery);

            cs.setString(1, kisiyakinlar.getKisiYakinlar_tip());
            cs.setString(2, kisiyakinlar.getAnne_isim());
            cs.setString(3, kisiyakinlar.getBaba_isim());
            cs.setString(4, kisiyakinlar.getEs_isim());
            cs.setString(5, kisiyakinlar.getEs_soyisim());

            cs.execute();

        } catch (Exception ex) {
            DetectError(ex);
        }

    }

    public void KisiYakinlarSil(int engelTipId) {
        String deleteQuery = "DELETE FROM KISI_YAKINLAR WHERE KISI_YAKINLAR_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, engelTipId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public List<KisiYakinlar> KisiYakinlarListesi() {
        List<KisiYakinlar> kisiyakinlarList = new ArrayList<>();
        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT KISI_YAKINLAR_ID, ANNE_ISIM, BABA_ISIM, ES_ISIM, ES_SOYISIM, ES_DURUM_ID FROM KISI_YAKINLAR");

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                kisiyakinlarList.add(new KisiYakinlar(
                        rs.getString("ANNE_ISIM"),
                        rs.getString("BABA_ISIM"),
                        rs.getString("ES_ISIM"),
                        rs.getString("ES_SOYISIM"),
                        rs.getString("ES_DURUM_ISIM")
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return kisiyakinlarList;
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

    public List<SelectItem> KisiYakinlarGetir(int selectedKisiYakinlarId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<SelectItem> kisiyakinlarGetir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void Sorgula(Kisi kisi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<KisiYakinlar> GetList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void DeleteKisi(int KisiID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void Create(KisiYakinlar entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
