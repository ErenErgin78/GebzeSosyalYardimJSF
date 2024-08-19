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
 * @author emirh
 */
public class MuracaatDurumDAO extends DBConnection {

    private Connection db;

    public List<SelectItem> MuracaatDurumGetir() {
        List<SelectItem> TipList = new ArrayList<>();
        try {
            Statement statement;
            statement = getDb().createStatement();
            String Selectquery = "SELECT DURUM_ID , DURUM FROM MURACAAT_DURUM";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("DURUM_ID"), rs.getString("DURUM")));
            }
            return TipList;
        } catch (Exception ex) {
            DetectError(ex);
        }
        return TipList;

    }

    public Connection getDb() {
        if (this.db == null) {
            this.db =  this.connect();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

 

}
