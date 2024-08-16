package dao;

import Entity.TutanakEvEsyalari;
import static Various.ErrorFinder.DetectError;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class TutanakEvEsyalariDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    private String isim = "";
    private Integer aktif = 2;

    public void TutanakEvEsyalariEkle(TutanakEvEsyalari tutanakEvEsyalari) {
        try {
            Connection conn = this.getDb();

            String callQuery = "{call INSERT_TUTANAK_EV_ESYALARİ(?, ?)}";
            CallableStatement cs = conn.prepareCall(callQuery);
            cs.setInt(1, tutanakEvEsyalari.getEsyalar_id());
            cs.setInt(2, tutanakEvEsyalari.getKisi_id());
            cs.setInt(3, tutanakEvEsyalari.getEsya_id());  // Hatalı: Prosedürün parametre sayısı uyumsuz.
            cs.setDate(4, (Date) tutanakEvEsyalari.getGuncelleme_tarihi());  // Hatalı: Prosedürde böyle bir parametre yok.
            cs.setInt(5, tutanakEvEsyalari.getAktiflik());

            cs.execute();
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (Exception ex) {
            DetectError(ex);
        }
    }

    public void TutanakEvEsyalariSil(int tutanakEvEsyalariId) {
        String deleteQuery = "DELETE FROM TUTANAK_EV_ESYALARİ WHERE TUTANAK_ID = ?";
        try {
            PreparedStatement ps = getDb().prepareStatement(deleteQuery);
            ps.setInt(1, tutanakEvEsyalariId);
            int rowsDeleted = ps.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            DetectError(ex);
        }
    }

    public List<TutanakEvEsyalari> TutanakEvEsyalariListesi() {
        List<TutanakEvEsyalari> tutanakEvEsyalariList = new ArrayList<>();

        try {
            StringBuilder query = new StringBuilder();
            query.append("SELECT ESYALAR_ID, KISI_ID, ESYA_ID, GUNCELLEME_TARIHI, AKTIFLIK, K.ISIM FROM TUTANAK_EV_ESYALARI");
            query.append("JOIN KISI_TEMEL K ON K.KISI_ID = K.KISI_ID WHERE 1=1");
            Statement statement = getDb().createStatement();
            ResultSet rs = statement.executeQuery(query.toString());

            while (rs.next()) {
                tutanakEvEsyalariList.add(new TutanakEvEsyalari(
                        rs.getString("KISI_ISIM"),
                        rs.getString("ESYA_ISIM"),
                        rs.getTimestamp("GUNCELLEME_TARIHI"), // GUNCELLEME_TARIHI için getTimestamp kullanıldı.
                        rs.getInt("AKTIFLIK") // AKTIFLIK değerini boolean olarak kontrol edebilirsiniz.
                ));
            }
        } catch (Exception ex) {
            DetectError(ex);
        }
        return tutanakEvEsyalariList;
    }

    public void TutanakEvEsyalariMesajTemizle() {
        this.mesaj = null;
    }

    public Connection getDb() {
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

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Integer getAktif() {
        return aktif;
    }

    public void setAktif(Integer aktif) {
        this.aktif = aktif;
    }

}
