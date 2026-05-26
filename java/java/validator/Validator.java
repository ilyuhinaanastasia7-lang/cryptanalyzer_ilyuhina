package validator;

import java.io.File;

public class Validator {
    public static void validate(String path) {
        File file = new File(path);

        if (!file.exists()) {
            throw new RuntimeException("Файл не найден");
        }

        if (!file.isFile()) {
            throw new RuntimeException("Это не файл");
        }
    }
}
