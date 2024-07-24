package dao;

import Entity.Okul;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import util.DBConnection;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class OkulDAO extends DBConnection {

    private Connection db;

    public void Create(Okul okul) {
        try {
            Connection conn = this.getDb();
            String callQuery = "{call INSERT_OKUL(?, ?, ?, ?)}";
            CallableStatement csOkul;

            csOkul = conn.prepareCall(callQuery);

            csOkul.setString(1, okul.getOkul_isim());
            csOkul.setInt(2, okul.getOkul_tip_id());
            csOkul.setInt(3, okul.getOkul_tur_id());
            csOkul.setInt(4, okul.getOkul_aktif());

            csOkul.execute();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "İşlemler başarıyla gerçekleşmiştir.", null));
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
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

}
