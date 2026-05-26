package service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class StatisticalAnalysisService {
    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static void decrypt(String inputPath, String outputPath) throws Exception {
        String encrypted = Files.readString(Path.of(inputPath));
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : encrypted.toLowerCase().toCharArray()) {
            if (ALPHABET.indexOf(ch) != -1) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        char mostPopular = 'о';
        int max = 0;

        for (char ch : map.keySet()) {
            if (map.get(ch) > max) {
                max = map.get(ch);
                mostPopular = ch;
            }
        }

        int key = ALPHABET.indexOf(mostPopular) - ALPHABET.indexOf('о');
        FileService.processFile(inputPath, outputPath, -key);
    }
}
