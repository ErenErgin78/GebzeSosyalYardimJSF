package dao;

import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class TutanakEvTipDAO extends DBConnection {

    private Connection db;
    
    public List<SelectItem> TutanakEvTipGetir() {
        List<SelectItem> TipList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT TUTANAK_EV_TIP_ID, EV_TIP_ISIM FROM TUTANAK_EV_TIP";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("TUTANAK_EV_TIP_ID"), rs.getString("EV_TIP_ISIM")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return TipList;
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
