import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Bruteforce {
    @SneakyThrows
    public static void bruteforce() {
        ConsoleHelper.writeMessage("Введите путь к файлу для его расшифровки");
        String src = ConsoleHelper.readString();
        Path dst = ConsoleHelper.buildFileName(src, "_bruteforce");

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(src));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {
            StringBuilder stringBuilder = new StringBuilder();
            List<String> list = new ArrayList<>();
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                list.add(string);
                stringBuilder.append(string);
            }

            CaesarCipher caesarCipher = new CaesarCipher();
            for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
                String decrypt = caesarCipher.decrypt(stringBuilder.toString(), i);
                if (isValidateText(decrypt)) {
                    for (String string : list) {
                        String str = caesarCipher.decrypt(string, i);
                        bufferedWriter.write(str);
                        bufferedWriter.newLine();
                    }
                    ConsoleHelper.writeMessage("Текст расшифрован, ключ шифрования равен: " + i);
                    break;
                }
            }
        }
    }

    private static boolean isValidateText(String text) {
        int maxLengthWord = 28;
        for (String word : text.split(" ")) {
            if (word.length() > maxLengthWord) {
                return false;
            }
        }
        boolean isValidate = false;
        if (text.contains(". ")) {
            isValidate = true;
        }
        int maxVisibleLength = 1000;
        while (isValidate) {
            ConsoleHelper.writeMessage(text.length() > maxVisibleLength ? text.substring(0, maxVisibleLength) : text);
            ConsoleHelper.writeMessage("текст можно прочесть? введите Y/N");
            String answer = ConsoleHelper.readString();
            if (answer.equalsIgnoreCase("Y")) {
                return true;
            } else if (answer.equalsIgnoreCase("N")) {
                isValidate = false;
            } else {
                ConsoleHelper.writeMessage("Введите только Y или N");
            }
        }
        return false;
    }
}
