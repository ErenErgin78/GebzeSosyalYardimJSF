package dao;

import Entity.Okul;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import util.DBConnection;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OkulDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    public void Create(Okul okul) {
        try {
            Connection conn = this.getDb();
            String callQuery = "{call INSERT_OKUL(?, ?, ?, ?)}";
            CallableStatement csOkul = conn.prepareCall(callQuery);

            csOkul.setString(1, okul.getOkul_isim());
            csOkul.setInt(2, okul.getOkul_tip_id());
            csOkul.setInt(3, okul.getOkul_tur_id());
            csOkul.setInt(4, okul.getOkul_aktif());

            csOkul.execute();
            mesaj = "işlem başarıyla gerçekleşmiştir";

        } catch (SQLException ex) {
            DetectError(ex);
        }

    }

    public List<Okul> OkulListesi() {
        List<Okul> OkulList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT O.OKUL_ID, O.OKUL_ISIM, O.OKUL_TIP_ID, OTI.OKUL_TIP_ISIM, O.OKUL_TUR_ID, OTU.OKUL_TUR_ISIM, O.OKUL_AKTIF FROM OKUL O\n"
                    + "JOIN OKUL_TIP OTI ON O.OKUL_TIP_ID = OTI.OKUL_TIP_ID\n"
                    + "JOIN OKUL_TUR OTU ON O.OKUL_TUR_ID = OTU.OKUL_TUR_ID";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                OkulList.add(new Okul(
                        rs.getInt("OKUL_ID"),
                        rs.getString("OKUL_ISIM"),
                        rs.getInt("OKUL_AKTIF"),
                        rs.getString("OKUL_TIP_ISIM"),
                        rs.getString("OKUL_TUR_ISIM")
                ));
            }
            mesaj = "işlem başarılı";

        } catch (Exception ex) {
            DetectError(ex);
        }
        return OkulList;
    }

    public void OkulSil(int sokakid) {
        String deleteQuery = "DELETE FROM OKUL WHERE OKUL_ID = ?";

        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, sokakid);
            int rowsDeleted = ps.executeUpdate();

            mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public void DetectError(Exception ex) {
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
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage.toString(), null));
        }

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

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

}
