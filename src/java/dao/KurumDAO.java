/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Kurum;
import Entity.Mahalle;
import static Filters.ErrorFinder.DetectError;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
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
 * @author korog
 */
public class KurumDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;

    public void KurumEkle(Kurum kurum) {

        try {
            Connection conn = this.getDb();

            String callQueryAdres = "{call INSERT_KURUM(?)}";
            CallableStatement csAdres = conn.prepareCall(callQueryAdres);
            csAdres.setString(1, kurum.getKurum());
            csAdres.execute();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public List<Kurum> KurumListesi() {
        List<Kurum> KurumList = new ArrayList<>();
        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT KURUM_ID, KURUM_ISIM FROM KURUM";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                KurumList.add(new Kurum(
                        rs.getInt("KURUM_ID"),
                        rs.getString("KURUM_ISIM")
                ));
            }

        } catch (Exception ex) {
            DetectError(ex);
        }
        return KurumList;
    }

    public void KurumSil(int kurumid) {
        String deleteQuery = "DELETE FROM KURUM WHERE KURUM_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, kurumid);
            int rowsDeleted = ps.executeUpdate();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
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
}
