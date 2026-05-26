package controller;

import service.BruteForceService;
import service.FileService;
import service.StatisticalAnalysisService;

import java.util.Scanner;

public class MenuController {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("""
                    
                    ===== ШИФР ЦЕЗАРЯ =====
                    1. Шифрование
                    2. Расшифровка
                    3. Brute Force
                    4. Статистический анализ
                    5. Выход
                    """);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> encrypt();
                case "2" -> decrypt();
                case "3" -> bruteForce();
                case "4" -> statisticalAnalysis();
                case "5" -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный пункт");
            }
        }
    }

    private void encrypt() {
        try {
            System.out.print("Введите входной файл: ");
            String input = scanner.nextLine();
            System.out.print("Введите выходной файл: ");
            String output = scanner.nextLine();
            System.out.print("Введите ключ: ");
            int key = Integer.parseInt(scanner.nextLine());
            FileService.processFile(input, output, key);
            System.out.println("Файл зашифрован");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void decrypt() {
        try {
            System.out.print("Введите входной файл: ");
            String input = scanner.nextLine();
            System.out.print("Введите выходной файл: ");
            String output = scanner.nextLine();
            System.out.print("Введите ключ: ");
            int key = Integer.parseInt(scanner.nextLine());
            FileService.processFile(input, output, -key);
            System.out.println("Файл расшифрован");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void bruteForce() {
        try {
            System.out.print("Введите входной файл: ");
            String input = scanner.nextLine();
            System.out.print("Введите выходной файл: ");
            String output = scanner.nextLine();
            BruteForceService.decrypt(input, output);
            System.out.println("Brute force завершён");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void statisticalAnalysis() {
        try {
            System.out.print("Введите входной файл: ");
            String input = scanner.nextLine();
            System.out.print("Введите выходной файл: ");
            String output = scanner.nextLine();
            StatisticalAnalysisService.decrypt(input, output);
            System.out.println("Статистический анализ завершён");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
