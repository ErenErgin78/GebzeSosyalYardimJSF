package dao;

import Entity.MuracaatDurum;
import Entity.MuracaatYardimTalep;
import static Various.ErrorFinder.DetectError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import jakarta.faces.model.SelectItem;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class MuracaatYardimTalepDAO {
    
    private Connection conn;
    private String mesaj;
    
    public List<SelectItem> MuracaatYardimTalepGetir() {
        List<SelectItem> list = new ArrayList<>();
        try {
            String sql = "SELECT kt.KISI_ID, m.MURACAAT_ID, myt.TALEP_ID, yt.YARDIM_TIP_ID, yt.YARDIM_TIP, ytur.TUR_ID, ytur.TUR " +
                         "FROM KISI_TEMEL kt " +
                         "JOIN MURACAAT m ON kt.KISI_ID = m.KISI_TEMEL_ID " +
                         "JOIN MURACAAT_YARDIM_TALEP myt ON m.MURACAAT_ID = myt.MURACAAT_ID " +
                         "JOIN YARDIM_TIP yt ON myt.YARDIM_TIP = yt.YARDIM_TIP_ID " +
                         "JOIN YARDIM_TUR ytur ON yt.YARDIM_TUR_ID = ytur.TUR_ID " +
                         "WHERE m.MURACAAT_ID = ?";

            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setInt(1, 1); // MURACAAT_ID yerine dinamik bir değer atanabilir.
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                SelectItem item = new SelectItem(rs.getInt("TUR_ID"), rs.getString("TUR"));
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Integer MuracaatDurumEkle(MuracaatDurum muracaatDurum) {
        try {

            String callQueryMuracaatDurum = "{call INSERT_MURACAAT_DURUM(?, ?, ?)}";
            CallableStatement csMuracaatDurum = conn.prepareCall(callQueryMuracaatDurum);
            csMuracaatDurum.setString(1, muracaatDurum.getDurum());
            csMuracaatDurum.setInt(2, muracaatDurum.getAktif());
            csMuracaatDurum.registerOutParameter(3, java.sql.Types.INTEGER);
            csMuracaatDurum.execute();

            int muracaatDurumId = csMuracaatDurum.getInt(3);
            this.mesaj = "Durum başarıyla eklenmiştir.";
            return muracaatDurumId;

        } catch (SQLException ex) {
            mesaj = DetectError(ex);
            return null;
        }
    }
}