/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Mahalle;
import static Various.ErrorFinder.DetectError;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Eren
 */
public class MahalleDAO extends DBConnection {
    
    private Connection db;
    private String islemBasariliMesaj;
    
    public void MahalleEkle(Mahalle mahalle) {
        
        try {
            Connection conn = this.getDb();
            
            String callQueryAdres = "{call INSERT_KISI_ADRES_MAHALLE(?, ?)}";
            CallableStatement csAdres = conn.prepareCall(callQueryAdres);
            csAdres.setString(1, mahalle.getMahalle());
            csAdres.setInt(2, mahalle.getMahalle_aktif());
            csAdres.execute();
            
            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
            
        } catch (Exception ex) {
            DetectError(ex);
        }
    }
    
    public void MahalleSil(int mahalleid) {
        String deleteSokakQuery = "DELETE FROM KISI_MAHALLE_SOKAK WHERE MAHALLE_ID = ?";
        String deleteQuery = "DELETE FROM KISI_ADRES_MAHALLE  WHERE KISI_ADRES_MAHALLE_ID = ?";
        
        try {
            PreparedStatement ps1 = getDb().prepareStatement(deleteSokakQuery);
            ps1.setInt(1, mahalleid);
            int rowsDeleted = ps1.executeUpdate();
            
            PreparedStatement ps2 = getDb().prepareStatement(deleteQuery);
            ps2.setInt(1, mahalleid);
            rowsDeleted = ps2.executeUpdate();
            
            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public List<Mahalle> MahalleListesi() {
        List<Mahalle> MahalleList = new ArrayList<>();
        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT KISI_ADRES_MAHALLE_ID ID, MAHALLE, AKTIF FROM KISI_ADRES_MAHALLE";
            ResultSet rs = statement.executeQuery(Selectquery);
            
            while (rs.next()) {
                MahalleList.add(new Mahalle(
                        rs.getInt("ID"),
                        rs.getString("MAHALLE"),
                        rs.getInt("AKTIF")
                ));
            }
            
        } catch (Exception ex) {
            DetectError(ex);
        }
        return MahalleList;
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
