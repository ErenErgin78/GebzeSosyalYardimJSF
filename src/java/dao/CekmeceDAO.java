/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.Cekmece;
import static Various.ErrorFinder.DetectError;
import util.DBConnection;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author casper
 */
public class CekmeceDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    private Integer aktif = 2;
    private String isim = "";

    public void CekmeceEkle(Cekmece cekmece) {
        try {
            Connection conn = this.getDb();
            
            if(cekmece.getAktif()==null){
             cekmece.setAktif(1);
            }
            String callQuery = "{call INSERT_CEKMECE(?, ?)}";
            CallableStatement csCekmece = conn.prepareCall(callQuery);

            csCekmece.setString(1, cekmece.getCekmece());
            csCekmece.setInt(2, cekmece.getAktif());

            csCekmece.execute();
            this.mesaj = "İşlem başarıyla gerçekleşmiştir";

        } catch (Exception ex) {
            this.mesaj = DetectError(ex);
        }
    }

    public void CekmeceSil(int cekmeceId) {
        String deleteQuery = "DELETE FROM TUTANAK_CEKMECE WHERE TUTANAK_CEKMECE_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, cekmeceId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            this.mesaj = DetectError(ex);
        }
    }

    public List<Cekmece> CekmeceListesi() {
        List<Cekmece> CekmeceList = new ArrayList<>();
        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT TUTANAK_CEKMECE_ID, TUTANAK_CEKMECE_DURUM, CEKMECE_AKTIF FROM TUTANAK_CEKMECE WHERE 1=1");

            if (aktif != 2) {
                queryBuilder.append("AND CEKMECE_AKTIF = ").append(aktif).append(" ");
            }
            if (!isim.isEmpty()) {
                queryBuilder.append("AND TUTANAK_CEKMECE_DURUM LIKE '%").append(isim).append("%' ");
            }
            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            while (rs.next()) {
                CekmeceList.add(new Cekmece(
                        rs.getInt("TUTANAK_CEKMECE_ID"),
                        rs.getString("TUTANAK_CEKMECE_DURUM"),
                        rs.getInt("CEKMECE_AKTIF")
                ));
            }

            mesaj = "işlem başarılı";

        } catch (Exception ex) {
            DetectError(ex);
        }
        return CekmeceList;
    }

    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public void setDb(java.sql.Connection db) {
        this.db = db;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

}
