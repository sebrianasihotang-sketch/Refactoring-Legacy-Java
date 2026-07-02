package repository;

import database.Koneksi;
import entity.Mahasiswa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MahasiswaRepository {

    private Connection conn = Koneksi.getConnection();

    public boolean simpan(Mahasiswa m) {

        try {

            String sql = "INSERT INTO mahasiswa(nim,nama,jurusan) VALUES(?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, m.getNim());
            ps.setString(2, m.getNama());
            ps.setString(3, m.getJurusan());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;

        }

    }

    public boolean ubah(Mahasiswa m) {

        try {

            String sql = "UPDATE mahasiswa SET nama=?, jurusan=? WHERE nim=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, m.getNama());
            ps.setString(2, m.getJurusan());
            ps.setString(3, m.getNim());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;

        }

    }

    public boolean hapus(String nim) {

        try {

            String sql = "DELETE FROM mahasiswa WHERE nim=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nim);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;

        }

    }

    public ArrayList<Mahasiswa> getData() {

        ArrayList<Mahasiswa> list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM mahasiswa";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Mahasiswa m = new Mahasiswa();

                m.setNim(rs.getString("nim"));
                m.setNama(rs.getString("nama"));
                m.setJurusan(rs.getString("jurusan"));

                list.add(m);

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return list;

    }

    public Mahasiswa cari(String nim) {

        try {

            String sql = "SELECT * FROM mahasiswa WHERE nim=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nim);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Mahasiswa m = new Mahasiswa();

                m.setNim(rs.getString("nim"));
                m.setNama(rs.getString("nama"));
                m.setJurusan(rs.getString("jurusan"));

                return m;

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return null;

    }

}