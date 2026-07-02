package utils;

public class Validator {

    public static boolean kosong(String teks) {
        return teks == null || teks.trim().isEmpty();
    }

}