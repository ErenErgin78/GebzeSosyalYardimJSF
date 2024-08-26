package dao;

import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class YardimTurDAO extends DBConnection {

    private Connection db;

    public List<SelectItem> YardimTurGetir() {
        List<SelectItem> TurList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT TUR_ID, TUR FROM YARDIM_TUR";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TurList.add(new SelectItem(rs.getInt("TUR_ID"), rs.getString("TUR")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return TurList;
    }
public String getTurById(int turId) {
    String tur = null;
    try {
        Statement statement = getDb().createStatement();
        String query = "SELECT TUR FROM YARDIM_TUR WHERE TUR_ID = " + turId;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            tur = rs.getString("TUR");
        }
    } catch (Exception ex) {
        DetectError(ex);
    }
    return tur;
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
