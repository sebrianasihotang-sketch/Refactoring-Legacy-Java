package utils;

public class Validator {

    public static boolean isKosong(String text) {

        return text == null || text.trim().isEmpty();

    }

    public static boolean isAngka(String text) {

        return text.matches("[0-9]+");

    }

}