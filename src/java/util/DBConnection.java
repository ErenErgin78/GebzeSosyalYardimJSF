/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Eren
 */
public abstract  class DBConnection {

    /**
     *
     * @return
     */
    public Connection connect() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/GebzeWeb.bel.tr", "GebzeAdmin", "123");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            return connection;
        }
    }
}
