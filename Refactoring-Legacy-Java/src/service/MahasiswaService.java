package service;

import entity.Mahasiswa;
import repository.MahasiswaRepository;

import java.util.ArrayList;

public class MahasiswaService {

    private MahasiswaRepository repo;

    public MahasiswaService(MahasiswaRepository repo) {
        this.repo = repo;
    }

    public boolean simpan(String nim, String nama, String jurusan) {
        return repo.insert(new Mahasiswa(nim, nama, jurusan));
    }

public boolean update(String nim, String nama, String jurusan) {
    return repo.update(new Mahasiswa(nim, nama, jurusan));
}

    public boolean hapus(String nim) {
        return repo.delete(nim);
    }

    public ArrayList<Mahasiswa> getAll() {
        return repo.getAll();
    }
}