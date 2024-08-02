package dao;

import Entity.EngelAlt;
import static Filters.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class EngelAltDAO extends DBConnection {
    
    private Connection db;
    private String islemBasariliMesaj;
    
    public void EngelAltEkle(EngelAlt engelAlt) {
        
        try {
            Connection conn = this.getDb();
            
            String callQueryAdres = "{call INSERT_ENGEL_ALT_TIP(?, ?)}";
            CallableStatement csAdres = conn.prepareCall(callQueryAdres);
            csAdres.setInt(1, engelAlt.getEngelli_tip_id());
            csAdres.setString(2, engelAlt.getAlt_tip_isim());
            csAdres.execute();
            
            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
            
        } catch (Exception ex) {
            DetectError(ex);
        }
    }
    
    public void EngelAltSil(int engelAltid) {
        String deleteQuery = "DELETE FROM ENGELLI_ALT_TIP WHERE ALT_TIP_ID = ?";
        
        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, engelAltid);
            int rowsDeleted = ps.executeUpdate();
            
            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
    }
    
    public List<EngelAlt> EngelAltListesi() {
        List<EngelAlt> engelAltList = new ArrayList<>();
        try {
            Statement statement = getDb().createStatement();
            String selectQuery = "SELECT EA.ALT_TIP_ID, EA.ENGELLI_TIP_ID, EA.ALT_TIP_ISIM, E.TIP_ISIM FROM ENGELLI_ALT_TIP EA"
                    + " JOIN ENGELLI_TIP E ON EA.ENGELLI_TIP_ID = E.TIP_ID";
            ResultSet rs = statement.executeQuery(selectQuery);
            
            while (rs.next()) {
                engelAltList.add(new EngelAlt(
                        rs.getInt("ALT_TIP_ID"),
                        rs.getString("ALT_TIP_ISIM"),
                        rs.getString("TIP_ISIM")
                        ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return engelAltList;
    }
    
    public List<SelectItem> EngelliTipGetir() {
        List<SelectItem> TipList = new ArrayList<>();
        
        try {
            Statement statement = getDb().createStatement();
            String selectQuery = "SELECT TIP_ID, TIP_ISIM FROM ENGELLI_TIP";
            ResultSet rs = statement.executeQuery(selectQuery);
            
            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("TIP_ID"), rs.getString("TIP_ISIM")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return TipList;
    }
    
    public void setDb(Connection db) {
        this.db = db;
    }
    
    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }
    
    public String getIslemBasariliMesaj() {
        return islemBasariliMesaj;
    }
    
    public void setIslemBasariliMesaj(String islemBasariliMesaj) {
        this.islemBasariliMesaj = islemBasariliMesaj;
    }
}