package service;

import entity.Mahasiswa;
import repository.MahasiswaRepository;

import java.util.ArrayList;

public class MahasiswaService {

    private MahasiswaRepository repository = new MahasiswaRepository();

    public boolean simpan(String nim, String nama, String jurusan) {

        if (nim.isEmpty() || nama.isEmpty() || jurusan.isEmpty()) {
            return false;
        }

        Mahasiswa m = new Mahasiswa();
        m.setNim(nim);
        m.setNama(nama);
        m.setJurusan(jurusan);

        return repository.simpan(m);

    }

    public boolean ubah(String nim, String nama, String jurusan) {

        if (nim.isEmpty() || nama.isEmpty() || jurusan.isEmpty()) {
            return false;
        }

        Mahasiswa m = new Mahasiswa();
        m.setNim(nim);
        m.setNama(nama);
        m.setJurusan(jurusan);

        return repository.ubah(m);

    }

    public boolean hapus(String nim) {

        if (nim.isEmpty()) {
            return false;
        }

        return repository.hapus(nim);

    }

    public ArrayList<Mahasiswa> getData() {

        return repository.getData();

    }

    public Mahasiswa cari(String nim) {

        return repository.cari(nim);

    }

}