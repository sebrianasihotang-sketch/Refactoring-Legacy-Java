package view;

import service.MahasiswaService;
import entity.Mahasiswa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private JTextField txtNim = new JTextField();
    private JTextField txtNama = new JTextField();
    private JTextField txtJurusan = new JTextField();

    private JButton btnSimpan = new JButton("Simpan");
    private JButton btnUpdate = new JButton("Update");
    private JButton btnHapus = new JButton("Hapus");

    private JTable table;
    private DefaultTableModel model;

    private MahasiswaService service;

    public MainFrame(MahasiswaService service) {
        this.service = service;

        setTitle("CRUD Mahasiswa");
        setSize(650, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
        loadTable();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // ===== FORM =====
        JPanel form = new JPanel(new GridLayout(3, 2));

        form.add(new JLabel("NIM"));
        form.add(txtNim);

        form.add(new JLabel("Nama"));
        form.add(txtNama);

        form.add(new JLabel("Jurusan"));
        form.add(txtJurusan);

        add(form, BorderLayout.NORTH);

        // ===== BUTTON =====
        JPanel panelBtn = new JPanel();

        panelBtn.add(btnSimpan);
        panelBtn.add(btnUpdate);
        panelBtn.add(btnHapus);

        add(panelBtn, BorderLayout.CENTER);

        // ===== TABLE =====
        model = new DefaultTableModel(new String[]{"NIM", "Nama", "Jurusan"}, 0);
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.SOUTH);

        // ===== EVENT SIMPAN =====
        btnSimpan.addActionListener(e -> {
            service.simpan(
                    txtNim.getText(),
                    txtNama.getText(),
                    txtJurusan.getText()
            );

            loadTable();
            clearForm();
        });

        // ===== EVENT UPDATE (FIX UTAMA) =====
        btnUpdate.addActionListener(e -> {

            String nim = txtNim.getText();

            if (nim.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pilih data dari tabel dulu!");
                return;
            }

            boolean result = service.update(
                    nim,
                    txtNama.getText(),
                    txtJurusan.getText()
            );

            if (result) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate");
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal diupdate");
            }

            loadTable();
            clearForm();
        });

        // ===== EVENT DELETE (FIX UTAMA) =====
        btnHapus.addActionListener(e -> {

            String nim = txtNim.getText();

            if (nim.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pilih data dulu!");
                return;
            }

            boolean result = service.hapus(nim);

            if (result) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal dihapus");
            }

            loadTable();
            clearForm();
        });

        // ===== KLIK TABLE (PENTING BANGET) =====
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();

            if (row != -1) {
                txtNim.setText(model.getValueAt(row, 0).toString());
                txtNama.setText(model.getValueAt(row, 1).toString());
                txtJurusan.setText(model.getValueAt(row, 2).toString());
            }
        });
    }

    // ===== LOAD DATA =====
    private void loadTable() {
        model.setRowCount(0);

        ArrayList<Mahasiswa> list = service.getAll();

        for (Mahasiswa m : list) {
            model.addRow(new Object[]{
                    m.getNim(),
                    m.getNama(),
                    m.getJurusan()
            });
        }
    }

    // ===== CLEAR FORM =====
    private void clearForm() {
        txtNim.setText("");
        txtNama.setText("");
        txtJurusan.setText("");
    }
}