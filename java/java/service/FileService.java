package service;

import validator.Validator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileService {
    public static void processFile(String inputPath, String outputPath, int key) throws Exception {
        Validator.validate(inputPath);
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

        int symbol;

        while ((symbol = reader.read()) != -1) {
            char encrypted = CaesarCipher.encrypt((char) symbol, key);
            writer.write(encrypted);
        }

        reader.close();
        writer.close();
    }
}
