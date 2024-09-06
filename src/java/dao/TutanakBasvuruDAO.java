/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.TutanakBasvuru;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emirh
 */
public class TutanakBasvuruDAO {
     private Connection db;
    private String islemBasariliMesaj;
    private String mesaj;

    private final String isim = "";

    public void TutanakBasvuruEkle(TutanakBasvuru tutanakbasvuru) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_TUTANAK_BEYAN(?,?)}";
            CallableStatement csTutanakBasvuru = conn.prepareCall(callQuery);
            csTutanakBasvuru.setInt(1, tutanakbasvuru.getBasvuru_beyan_id());
            csTutanakBasvuru.setString(2, tutanakbasvuru.getTutanak_basvuru());

            csTutanakBasvuru.execute();
            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (SQLException ex) {
            this.islemBasariliMesaj = DetectError(ex);
        }
    }

    public List<SelectItem> TutanakBasvuruGetir() {
        List<SelectItem> TutanakBasvuruList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT TUTANAK_BEYAN, TUTANAK_BEYAN FROM  TUTANAK_BEYAN";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TutanakBasvuruList.add(new SelectItem(rs.getInt("TUTANAK_İNCELEME_ID"), rs.getString("TUTANAKü_İNCELEME_ISIM")));
            }
        } catch (Exception ex) {
            mesaj = DetectError(ex);
        }
        return TutanakBasvuruList;

    }

    private Connection getDb() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void TutanakİncelemeEkle(TutanakBasvuru entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void TutanakİncelemeSil(int TutanakİncelemeId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void TutanakİncelemeMesajTemizle() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<TutanakBasvuru> TutanakListesi() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setMesaj(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void TutanakBasvuruMesajTemizle() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void TutanakBasvuruSil(int TutanakBasvuruId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

