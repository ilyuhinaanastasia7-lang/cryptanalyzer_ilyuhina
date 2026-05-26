package service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class StatisticalAnalysisService {
    
    private static final String ABC = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    
    public static void decrypt(String input, String output) throws Exception {
        decrypt(input, output, 'о');
    }
    
    public static void decrypt(String input, String output, char expected) throws Exception {
        String text = Files.readString(Path.of(input));
        var freq = new HashMap<Character, Integer>();
        
        for (char ch : text.toLowerCase().toCharArray()) {
            if (ABC.indexOf(ch) != -1) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }
        }
        
        char most = ' ';
        int max = 0;
        for (var e : freq.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                most = e.getKey();
            }
        }
        
        int key = ABC.indexOf(most) - ABC.indexOf(expected);
        FileService.processFile(input, output, -key);
    }
}
