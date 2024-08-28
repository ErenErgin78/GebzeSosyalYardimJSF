package dao;

import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class GuvenceDAO extends DBConnection {

    private Connection db;

    public List<SelectItem> GuvenceGetir() {
        List<SelectItem> TipList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT GUVENCE_ID , GUVENCE FROM GUVENCE_TIP";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("GUVENCE_ID"), rs.getString("GUVENCE")));
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
