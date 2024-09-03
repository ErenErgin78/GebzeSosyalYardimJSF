package dao;

import Entity.Muracaat;
import static Various.ErrorFinder.DetectError;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MuracaatDAO extends DBConnection {

    private Connection db;
    private String mesaj;

    public void MuracaatEkle(Muracaat muracaat) {
        String callQuery = "{call INSERT_MURACAAT(?, ?, ?)}";

        if (muracaat.getAktif() == null) {
            muracaat.setAktif(1);
        }

        try {
            CallableStatement cs = getDb().prepareCall(callQuery);
            cs.setInt(1, muracaat.getKisi_temel_id());
            cs.setInt(2, muracaat.getMuracaat_bilgi_id());
            cs.setInt(3, muracaat.getAktif());

            cs.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

        } catch (SQLException ex) {
            mesaj = DetectError(ex);
        }
    }

    public Integer MuracaatEkle(Muracaat muracaat, Integer kisiTemelId, Integer muracaatBilgiId) {
        String callQuery = "{call INSERT_MURACAAT(?, ?, ?, ?)}";

        if (muracaat.getAktif() == null) {
            muracaat.setAktif(1);
        }

        try {
            CallableStatement cs = getDb().prepareCall(callQuery);
            cs.setInt(1, kisiTemelId);
            cs.setInt(2, muracaatBilgiId);
            cs.setInt(3, muracaat.getAktif());
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.executeUpdate();

            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";

            return cs.getInt(4);

        } catch (SQLException ex) {
            mesaj = DetectError(ex);
            return null;
        }
    }

    // Delete Method
    public void MuracaatSil(int muracaatId) {
        String deleteQuery = "DELETE FROM MURACAAT WHERE MURACAAT_ID = ?";

        try (PreparedStatement ps = getDb().prepareStatement(deleteQuery)) {
            ps.setInt(1, muracaatId);
            int rowsDeleted = ps.executeUpdate();
            System.out.println(rowsDeleted + " müracaat silindi.");
            this.mesaj = "İşlemler başarıyla gerçekleşmiştir.";
        } catch (SQLException ex) {
            mesaj = DetectError(ex);
        }
    }

    public List<Muracaat> MuracaatBilgiListesi() {
        List<Muracaat> muracaatList = new ArrayList<>();
        String query = "SELECT "
                + "M.MURACAAT_ID, "
                + "KT.KIMLIK_NO, "
                + "KT.ISIM, "
                + "KT.SOYISIM, "
                + "MB.ARSIV_DOSYA_NO, "
                + "MB.MURACAAT_TARIHI, "
                + "KAM.MAHALLE, "
                + "KMS.SOKAK_ISIM, "
                + "M.KAYIT_TARIHI, "
                + "M.AKTIF, "
                + "M.GUNCELLEME_TARIHI "
                + "FROM MURACAAT M "
                + "JOIN MURACAAT_BILGI MB ON M.MURACAAT_BILGI_ID = MB.MURACAAT_BILGI_ID "
                + "JOIN KISI_TEMEL KT ON M.KISI_TEMEL_ID = KT.KISI_ID "
                + "JOIN KISI_DETAY KD ON KT.KISI_ID = KD.KISI_ID "
                + "JOIN KISI_ADRES KA ON KD.KISI_ADRES_ID = KA.KISI_ADRES_ID "
                + "JOIN KISI_ADRES_MAHALLE KAM ON KA.KISI_ADRES_MAHALLE_ID = KAM.KISI_ADRES_MAHALLE_ID "
                + "JOIN KISI_MAHALLE_SOKAK KMS ON KA.KISI_MAHALLE_SOKAK_ID = KMS.SOKAK_ID";

        try (PreparedStatement ps = getDb().prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Muracaat muracaat = new Muracaat(
                        rs.getDate("KAYIT_TARIHI"),
                        rs.getInt("AKTIF"),
                        rs.getDate("GUNCELLEME_TARIHI"),
                        rs.getBigDecimal("KIMLIK_NO").toBigInteger(),
                        rs.getString("ISIM"),
                        rs.getString("SOYISIM"),
                        rs.getInt("ARSIV_DOSYA_NO"),
                        rs.getDate("MURACAAT_TARIHI"),
                        rs.getString("MAHALLE"),
                        rs.getString("SOKAK_ISIM")
                );
                muracaat.setMuracaat_id(rs.getInt("MURACAAT_ID"));
                muracaatList.add(muracaat);
            }
            mesaj = "İşlem başarılı";
        } catch (SQLException ex) {
            mesaj = DetectError(ex);
        }
        return muracaatList;
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