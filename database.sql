CREATE DATABASE IF NOT EXISTS db_mahasiswa;

USE db_mahasiswa;

CREATE TABLE mahasiswa(
    nim VARCHAR(15) PRIMARY KEY,
    nama VARCHAR(100),
    jurusan VARCHAR(100)
);