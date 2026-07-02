package repository;

import java.sql.*;
import java.util.ArrayList;
import entity.Mahasiswa;

public class MahasiswaRepository {

    private Connection conn;

    public MahasiswaRepository(Connection conn) {
        this.conn = conn;
    }

    // SIMPAN
    public boolean insert(Mahasiswa m) {
        String sql = "INSERT INTO mahasiswa (nim, nama, jurusan) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, m.getNim());
            ps.setString(2, m.getNama());
            ps.setString(3, m.getJurusan());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE
public boolean update(Mahasiswa m) {
    String sql = "UPDATE mahasiswa SET nama=?, jurusan=? WHERE nim=?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, m.getNama());
        ps.setString(2, m.getJurusan());
        ps.setString(3, m.getNim());

        return ps.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    // DELETE
    public boolean delete(String nim) {
        String sql = "DELETE FROM mahasiswa WHERE nim=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nim);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // GET ALL
    public ArrayList<Mahasiswa> getAll() {
        ArrayList<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                list.add(new Mahasiswa(
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getString("jurusan")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}