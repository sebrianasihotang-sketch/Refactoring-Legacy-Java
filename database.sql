CREATE DATABASE IF NOT EXISTS db_mahasiswa;

USE db_mahasiswa;

CREATE TABLE mahasiswa (
    nim VARCHAR(15) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    jurusan VARCHAR(100) NOT NULL
);

INSERT INTO mahasiswa VALUES
('25781023','sebriana','Manajemen Informatika'),
('22002','Budi','Sistem Informasi'),
('22003','Citra','Teknik Komputer');