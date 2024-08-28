/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Sokak;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.model.SelectItem;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class SokakDAO extends DBConnection {

    private Connection db;
    private String islemBasariliMesaj;

    private Integer mahalleid = 0;
    private Integer aktif = 2;

    public void SokakEkle(Sokak sokak) {

        try {
            Connection conn = this.getDb();

            if (sokak.getAktif() == null) {
                sokak.setAktif(1);
            }

            String callQueryAdres = "{call INSERT_ADRES_MAHALLE_SOKAK(?, ?, ?)}";
            CallableStatement csAdres = conn.prepareCall(callQueryAdres);
            csAdres.setInt(1, sokak.getMahalle_id());
            csAdres.setString(2, sokak.getSokak());
            csAdres.setInt(3, sokak.getAktif());
            csAdres.execute();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            this.islemBasariliMesaj = DetectError(ex);
        }
    }

    public void SokakSil(int sokakid) {
        String deleteQuery = "DELETE FROM KISI_MAHALLE_SOKAK WHERE SOKAK_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, sokakid);
            int rowsDeleted = ps.executeUpdate();

            this.islemBasariliMesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.islemBasariliMesaj = DetectError(ex);
        }
    }

    public List<Sokak> SokakListesi() {
        List<Sokak> SokakList = new ArrayList<>();
        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT SOKAK_ID, MAHALLE_ID, SOKAK_ISIM, AKTIF FROM KISI_MAHALLE_SOKAK WHERE 1=1 ");

            if (mahalleid != 0) {
                queryBuilder.append("AND MAHALLE_ID = ").append(mahalleid).append(" ");
            }
            if (aktif != 2) {
                queryBuilder.append("AND AKTIF = ").append(aktif).append(" ");
            }

            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                SokakList.add(new Sokak(
                        rs.getInt("SOKAK_ID"),
                        rs.getInt("MAHALLE_ID"),
                        rs.getString("SOKAK_ISIM"),
                        rs.getInt("AKTIF")
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return SokakList;
    }

    public List<SelectItem> SokakGetir(int selectedMahalleId) {
        List<SelectItem> MahalleList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT SOKAK_ID, SOKAK_ISIM FROM KISI_MAHALLE_SOKAK WHERE MAHALLE_ID = " + selectedMahalleId;
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {

                MahalleList.add(new SelectItem(rs.getInt("SOKAK_ID"), rs.getString("SOKAK_ISIM")));
            }

        } catch (Exception ex) {
            DetectError(ex);
        }
        return MahalleList;
    }

    public void SokakMesajTemizle() {
        this.islemBasariliMesaj = null;
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

    public String getIslemBasariliMesaj() {
        return islemBasariliMesaj;
    }

    public void setIslemBasariliMesaj(String islemBasariliMesaj) {
        this.islemBasariliMesaj = islemBasariliMesaj;
    }

    public Integer getMahalleid() {
        return mahalleid;
    }

    public void setMahalleid(Integer mahalleid) {
        this.mahalleid = mahalleid;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

    public void redirectToLogin() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        try {
            String path = externalContext.getRequestContextPath() + "/Adres/CaddeSokakGirisi.xhtml";
            externalContext.redirect(path);
        } catch (IOException e) {
            // Hata mesajını konsola yazdır

        }
    }

}
