package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/db_mahasiswa",
                        "root",
                        ""
                );

                System.out.println("KONEKSI BERHASIL");
            }
        } catch (Exception e) {
            System.out.println("KONEKSI GAGAL");
            e.printStackTrace();
        }

        return conn;
    }
}
