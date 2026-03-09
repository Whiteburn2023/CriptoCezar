import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Bruteforce {
    @SneakyThrows
    public static void bruteforce() {
        ConsoleHelper.writeMessage("Введите путь к файлу для его расшифровки");
        String src = ConsoleHelper.readString();
        Path dst = ConsoleHelper.buildFileName(src, "_bruteforce");


        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(src));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                stringBuilder.append(string);

            }

            CaesarCipher caesarCipher = new CaesarCipher();
            for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
                String decrypt = caesarCipher.decrypt(stringBuilder.toString(), i);
                if (isValidateText(decrypt)) {
                    bufferedWriter.write(decrypt);
                    ConsoleHelper.writeMessage("Текст расшифрован, ключ шифрования равен: " + i);
                    break;
                }

            }
        }

    }

    private static boolean isValidateText(String text) {
        return false;
    }
}
