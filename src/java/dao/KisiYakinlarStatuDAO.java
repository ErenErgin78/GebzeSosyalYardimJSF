package dao;

import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KisiYakinlarStatuDAO extends DBConnection {

    private Connection db;

    public List<SelectItem> KisiYakinlarStatuGetir() {
        List<SelectItem> TipList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT KISI_YAKINLAR_STATU_ID , KISI_YAKINLAR_STATU_ISIM FROM KISI_YAKINLAR_STATU";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TipList.add(new SelectItem(rs.getInt("KISI_YAKINLAR_STATU_ID"), rs.getString("KISI_YAKINLAR_STATU")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return TipList;

    }

    public KisiYakinlarStatuDAO() {
    }

    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return (Connection) db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

}
