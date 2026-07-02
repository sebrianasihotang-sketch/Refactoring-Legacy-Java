CREATE DATABASE IF NOT EXISTS db_mahasiswa;

USE db_mahasiswa;

DROP TABLE IF EXISTS mahasiswa;

CREATE TABLE mahasiswa(
    nim VARCHAR(20) PRIMARY KEY,
    nama VARCHAR(100),
    jurusan VARCHAR(100)
);

INSERT INTO mahasiswa VALUES
('25781023','sebriana','Manajemen Informatika'),
('220002','Budi','Sistem Informasi'),
('220003','Citra','Teknik Komputer');