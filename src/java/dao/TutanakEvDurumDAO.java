package dao;

import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class TutanakEvDurumDAO extends DBConnection {

    private Connection db;

    public List<SelectItem> TutanakEvDurumGetir() {
        List<SelectItem> TipList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = ("SELECT EV_DURUM_ID, DURUM FROM TUTANAK_EV_DURUM");
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("TUTANAK_EV_DURUM_ID"), rs.getString("DURUM")));
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
