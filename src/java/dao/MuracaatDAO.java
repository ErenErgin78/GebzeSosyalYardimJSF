/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Muracaat;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.sql.CallableStatement;
import util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
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

    private Integer muracaat_bilgi_id;

    public void Create(Muracaat muracaat) {
        try {
            Connection conn = this.getDb();

            // MURACAAT_BILGI stored procedure çağırma
            String callQueryMuracaatBilgi = "{call INSERT_MURACAAT_BILGI(?, ?, ?, ?, ?)}";
            CallableStatement csMuracaatBilgi = conn.prepareCall(callQueryMuracaatBilgi);
            csMuracaatBilgi.setInt(1, muracaat.getArsiv_dosya_no());
            csMuracaatBilgi.setInt(2, muracaat.getMuracaat_tip_id());
            csMuracaatBilgi.setString(3, muracaat.getAciklama());
            csMuracaatBilgi.setDate(4, new java.sql.Date(muracaat.getMuracaat_tarihi().getTime()));
            csMuracaatBilgi.registerOutParameter(5, java.sql.Types.INTEGER);
            csMuracaatBilgi.execute();
            int muracaatBilgiId = csMuracaatBilgi.getInt(5);

            // KISI_TEMEL'den id almak
            String selectQuery = "SELECT MAX(KISI_ID) ID FROM KISI_TEMEL";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(selectQuery);
            if (rs.next()) {
                muracaat.setKisi_temel_id(rs.getInt("ID"));

                // MURACAAT stored procedure çağırma
                String callQueryMuracaat = "{call INSERT_MURACAAT(?, ?)}";
                CallableStatement csMuracaat = conn.prepareCall(callQueryMuracaat);
                csMuracaat.setInt(1, muracaat.getKisi_temel_id());
                csMuracaat.setInt(2, muracaatBilgiId);
                csMuracaat.executeUpdate();

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "İşlemler başarıyla gerçekleşmiştir.", null));
            }

        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public List<Muracaat> GetList() {

        List<Muracaat> UserList = new ArrayList<>();

        try {

            Statement statement = getDb().createStatement();

            String Selectquery = "SELECT \n"
                    + "JOIN KULLANICI_DURUM D ON K.kullanici_durum_id = D.kullanici_durum_id\n"
                    + "JOIN KULLANICI_UNVAN U ON K.kullanici_unvan_id = U.kullanici_unvan_id";

            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {

            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "İşlemler başarıyla gerçekleşmiştir.", null));

        } catch (Exception ex) {
            DetectError(ex);
        }
        return UserList;
    }

    public void Delete(int kullaniciId) {
        String deleteQuery = "DELETE FROM MURACAAT WHERE kullanici_id = " + kullaniciId;

        try {
            Statement statement = getDb().createStatement();

            int rowsDeleted = statement.executeUpdate(deleteQuery);
            System.out.println(rowsDeleted + " kisi silindi.");

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "İşlemler başarıyla gerçekleşmiştir.", null));

        } catch (SQLException ex) {
            System.out.println("Veritabanı hatası: " + ex.getMessage());
        }
    }

    private void DetectError(Exception ex) {
        //Hatayı yakalamak için
        FacesContext context = FacesContext.getCurrentInstance();
        StringBuilder errorMessage = new StringBuilder(ex.getMessage());
        StackTraceElement[] stackTrace = ex.getStackTrace();

        //Hatanın hangi satırda olduğunu görmek için
        for (StackTraceElement element : stackTrace) {
            if (element.getClassName().startsWith("dao")) {
                errorMessage.append(" (at ").append(element.getFileName())
                        .append(":").append(element.getLineNumber()).append(")");
                break;
            }
        }
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage.toString(), null));

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

    public Integer getMuracaat_bilgi_id() {
        return muracaat_bilgi_id;
    }

    public void setMuracaat_bilgi_id(Integer muracaat_bilgi_id) {
        this.muracaat_bilgi_id = muracaat_bilgi_id;
    }

}
