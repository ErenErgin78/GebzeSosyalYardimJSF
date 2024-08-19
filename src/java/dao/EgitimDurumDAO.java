/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Eren
 */
public class EgitimDurumDAO extends DBConnection {

    private Connection db;

    public List<SelectItem> EgitimDurumGetir() {
        List<SelectItem> TipList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT EGITIM_DURUM_ID ,EGITIM_DURUM FROM KISI_EGITIM_DURUM";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("EGITIM_DURUM_ID"), rs.getString("EGITIM_DURUM")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return TipList;

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

}
