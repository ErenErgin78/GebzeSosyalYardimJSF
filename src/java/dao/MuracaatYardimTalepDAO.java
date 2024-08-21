package dao;

import Entity.MuracaatYardimTalep;
import static Various.ErrorFinder.DetectError;
import jakarta.faces.model.SelectItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Eren
 */
public class MuracaatYardimTalepDAO extends DBConnection {

    private Connection db;

    public List<SelectItem> MuracaatYardimTalepGetir() {
        List<SelectItem> TalepList = new ArrayList<>();

        try {
            Statement statement = getDb().createStatement();
            String Selectquery = "SELECT MURACAAT_ID , YARDIM_TIP FROM MURACAAT_YARDIM_TALEP";
            ResultSet rs = statement.executeQuery(Selectquery);

            while (rs.next()) {
                TalepList.add(new SelectItem(rs.getInt("MURACAAT_ID"), rs.getString("YARDIM_TIP")));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return TalepList;
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
