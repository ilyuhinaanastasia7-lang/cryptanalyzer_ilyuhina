package service;

import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForceService {
    public static void decrypt(String inputPath, String outputPath) throws Exception {
        String encrypted = Files.readString(Path.of(inputPath));
        String bestText = "";
        int bestScore = -1;

        for (int key = 0; key < 33; key++) {
            String decrypted = decryptText(encrypted, key);
            int score = checkText(decrypted);
            if (score > bestScore) {
                bestScore = score;
                bestText = decrypted;
            }
        }
        Files.writeString(Path.of(outputPath), bestText);
    }

    private static String decryptText(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            result.append(CaesarCipher.encrypt(ch, -key));
        }
        return result.toString();
    }

    private static int checkText(String text) {
        int score = 0;
        String lower = text.toLowerCase();

        if (lower.contains(" и ")) score++;
        if (lower.contains(" в ")) score++;
        if (lower.contains(" не ")) score++;
        if (lower.contains(" на ")) score++;
        if (lower.contains(" что ")) score++;
        // сюда можно добавить ещё осмысленные слова для анализа текста

        return score;
    }
}
