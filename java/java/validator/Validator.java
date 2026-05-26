package validator;

import java.io.File;
import java.io.IOException;

public class Validator {
    
    public static void validate(String path) throws IOException {
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("Путь к файлу не может быть пустым");
        }
        
        File file = new File(path);
        
        if (!file.exists()) {
            throw new IOException("Файл не найден: " + path);
        }
        
        if (!file.isFile()) {
            throw new IOException("Путь не указывает на файл: " + path);
        }
        
        if (!file.canRead()) {
            throw new IOException("Нет прав на чтение файла: " + path);
        }
        
        if (file.length() == 0) {
            throw new IOException("Файл пуст: " + path);
        }
    }
}
