/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Muracaat;
import util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eren
 */
public class MuracaatDAO extends DBConnection {

    private Connection db;

    public void Create(Muracaat muracaat) {

        try {
            Statement statement = this.getDb().createStatement();

            //Muracaat bilgi tablosu
            String Insertquery = "INSERT INTO MURACAAT ()";
            int r = statement.executeUpdate(Insertquery);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Muracaat> GetList() {

        List<Muracaat> KisiList = new ArrayList<>();

        try {

            Statement statement = getDb().createStatement();

            String Selectquery = "SELECT * FROM MURACAAT";

            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                KisiList.add(new Muracaat());
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
