package controller;

import entity.Mahasiswa;
import service.MahasiswaService;

import java.util.ArrayList;

public class MahasiswaController {

    private MahasiswaService service = new MahasiswaService();

    public boolean simpan(String nim, String nama, String jurusan) {

        return service.simpan(nim, nama, jurusan);

    }

    public boolean ubah(String nim, String nama, String jurusan) {

        return service.ubah(nim, nama, jurusan);

    }

    public boolean hapus(String nim) {

        return service.hapus(nim);

    }

    public ArrayList<Mahasiswa> getData() {

        return service.getData();

    }

    public Mahasiswa cari(String nim) {

        return service.cari(nim);

    }

}