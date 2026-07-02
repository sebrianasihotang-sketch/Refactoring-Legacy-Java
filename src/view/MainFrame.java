package view;

import controller.MahasiswaController;
import entity.Mahasiswa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    JLabel lblNim = new JLabel("NIM");
    JLabel lblNama = new JLabel("Nama");
    JLabel lblJurusan = new JLabel("Jurusan");

    JTextField txtNim = new JTextField();
    JTextField txtNama = new JTextField();
    JTextField txtJurusan = new JTextField();

    JButton btnSimpan = new JButton("Simpan");
    JButton btnUbah = new JButton("Ubah");
    JButton btnHapus = new JButton("Hapus");
    JButton btnReset = new JButton("Reset");

    JTable tabel = new JTable();
    JScrollPane scroll = new JScrollPane(tabel);

    DefaultTableModel model;

    MahasiswaController controller = new MahasiswaController();

    public MainFrame() {

        setTitle("Data Mahasiswa");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        lblNim.setBounds(20,20,80,25);
        txtNim.setBounds(100,20,180,25);

        lblNama.setBounds(20,60,80,25);
        txtNama.setBounds(100,60,180,25);

        lblJurusan.setBounds(20,100,80,25);
        txtJurusan.setBounds(100,100,180,25);

        btnSimpan.setBounds(320,20,100,30);
        btnUbah.setBounds(430,20,100,30);
        btnHapus.setBounds(320,60,100,30);
        btnReset.setBounds(430,60,100,30);

        scroll.setBounds(20,160,640,270);

        add(lblNim);
        add(txtNim);

        add(lblNama);
        add(txtNama);

        add(lblJurusan);
        add(txtJurusan);

        add(btnSimpan);
        add(btnUbah);
        add(btnHapus);
        add(btnReset);

        add(scroll);

        model = new DefaultTableModel();
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Jurusan");

        tabel.setModel(model);

        tampilData();

        btnSimpan.addActionListener(e -> simpanData());

        btnUbah.addActionListener(e -> ubahData());

        btnHapus.addActionListener(e -> hapusData());

        btnReset.addActionListener(e -> resetForm());

        tabel.getSelectionModel().addListSelectionListener(e -> {

            int baris = tabel.getSelectedRow();

            if(baris!=-1){

                txtNim.setText(model.getValueAt(baris,0).toString());

                txtNama.setText(model.getValueAt(baris,1).toString());

                txtJurusan.setText(model.getValueAt(baris,2).toString());

                

            }

        });

    }

       private void simpanData() {

        boolean hasil = controller.simpan(
                txtNim.getText(),
                txtNama.getText(),
                txtJurusan.getText());

        if (hasil) {

            JOptionPane.showMessageDialog(this, "Data berhasil disimpan");

            tampilData();

            resetForm();

        } else {

            JOptionPane.showMessageDialog(this, "Data gagal disimpan");

        }

    }

    private void ubahData() {

        boolean hasil = controller.ubah(
                txtNim.getText(),
                txtNama.getText(),
                txtJurusan.getText());

        if (hasil) {

            JOptionPane.showMessageDialog(this, "Data berhasil diubah");

            tampilData();

            resetForm();

        } else {

            JOptionPane.showMessageDialog(this, "Data gagal diubah");

        }

    }

    private void hapusData() {

        boolean hasil = controller.hapus(txtNim.getText());

        if (hasil) {

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");

            tampilData();

            resetForm();

        } else {

            JOptionPane.showMessageDialog(this, "Data gagal dihapus");

        }

    }

    private void tampilData() {

        model.setRowCount(0);

        ArrayList<Mahasiswa> list = controller.getData();

        for (Mahasiswa m : list) {

            model.addRow(new Object[]{
                    m.getNim(),
                    m.getNama(),
                    m.getJurusan()
            });

        }

    }

    private void resetForm() {

        txtNim.setText("");

        txtNama.setText("");

        txtJurusan.setText("");

        txtNim.requestFocus();

    } 
        public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new MainFrame().setVisible(true);

        });

    }

}