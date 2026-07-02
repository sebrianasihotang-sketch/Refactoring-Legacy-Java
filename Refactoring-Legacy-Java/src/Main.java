import repository.MahasiswaRepository;
import service.MahasiswaService;
import view.MainFrame;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_mahasiswa",
                    "root",
                    ""
            );

            MahasiswaRepository repo = new MahasiswaRepository(conn);
            MahasiswaService service = new MahasiswaService(repo);

            java.awt.EventQueue.invokeLater(() -> {
                new MainFrame(service).setVisible(true);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}