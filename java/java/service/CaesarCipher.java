package service;

public class CaesarCipher {
    private static final String UPPER = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String LOWER = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static char encrypt(char ch, int key) {
        if (UPPER.indexOf(ch) != -1) {
            return shift(ch, key, UPPER);
        }
        if (LOWER.indexOf(ch) != -1) {
            return shift(ch, key, LOWER);
        }
        return ch;
    }

    private static char shift(char ch, int key, String alphabet) {
        int index = alphabet.indexOf(ch);
        int newIndex = (index + key + alphabet.length()) % alphabet.length();
        return alphabet.charAt(newIndex);
    }
}
