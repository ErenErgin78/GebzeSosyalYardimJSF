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
 * @author Hamza
 */
public class OkulTurDAO extends DBConnection{
    
    private Connection db;

    public List<SelectItem> OkulTurGetir() {
        List<SelectItem> TipList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT OKUL_TUR_ID , OKUL_TUR_ISIM FROM OKUL_TUR";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("OKUL_TUR_ID"), rs.getString("OKUL_TUR_ISIM")));
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

