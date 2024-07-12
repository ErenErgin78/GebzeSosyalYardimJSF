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
public class MuracaatDAO extends DBConnection{
    
    private Connection db;
    
    public void CreateMuracaat(){
    
      try {
            Statement statement = this.getDb().createStatement();

            String Insertquery = "INSERT INTO";
            int r = statement.executeUpdate(Insertquery);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    
    }

    public Connection getDb() {
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }
    
}
