/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Tutanakİnceleme;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author emirh
 */
public class TutanakİncelemeDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;
    private String mesaj;

    private final String isim = "";

    public void TutanakİncelemeEkle(Tutanakİnceleme tutanakinceleme) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_TUTANAK_INCELEME(?,?)}";
            CallableStatement csTutanakİnceleme = conn.prepareCall(callQuery);
            csTutanakİnceleme.setInt(1, tutanakinceleme.getInceleme_beyan_id());
            csTutanakİnceleme.setString(2, tutanakinceleme.getTutanak_inceleme());

            csTutanakİnceleme.execute();
            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (SQLException ex) {
            this.islemBasariliMesaj = DetectError(ex);
        }
    }

    public List<SelectItem> TutanakİncelemeGetir() {
        List<SelectItem> TutanakİncelemeList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT TUTANAK_İNCELEME, TUTANAK_İNCELEME_ISIM FROM  TUTANAK_İNCELEME";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TutanakİncelemeList.add(new SelectItem(rs.getInt("TUTANAK_İNCELEME_ID"), rs.getString("TUTANAKü_İNCELEME_ISIM")));
            }
        } catch (Exception ex) {
            mesaj = DetectError(ex);
        }
        return TutanakİncelemeList;

    }

    private Connection getDb() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
