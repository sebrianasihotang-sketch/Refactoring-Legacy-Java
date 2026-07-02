package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    private static Connection koneksi;

    public static Connection getConnection() {

        if (koneksi == null) {

            try {

                String url = "jdbc:mysql://localhost:3306/db_mahasiswa";
                String user = "root";
                String password = "";

                koneksi = DriverManager.getConnection(url, user, password);

                System.out.println("Koneksi berhasil");

            } catch (SQLException e) {

                System.out.println("Koneksi gagal : " + e.getMessage());

            }

        }

        return koneksi;

    }

}