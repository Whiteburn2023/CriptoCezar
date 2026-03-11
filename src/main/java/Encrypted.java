import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Encrypted {

    public static void encrypted(boolean flag) throws IOException {

        ConsoleHelper.writeMessage("Введите путь к файлу для его " + (flag ? "зашифровки" : "расшифровки"));
        String src = ConsoleHelper.readString();
        Path dst = ConsoleHelper.dstFilename(src, flag, "");
        ConsoleHelper.writeMessage("введите ключ шифрования");
        int key = ConsoleHelper.readInt();
        ConsoleHelper.writeMessage("Файл сохранен в папку \n" + dst);

        CaesarCipher caesarCipher = new CaesarCipher();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(src));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                bufferedWriter.write(flag ?
                        caesarCipher.encrypt(string, key) :
                        caesarCipher.decrypt(string, key));
                bufferedWriter.newLine();
            }
        }
        System.out.println(flag ? "файл зашифрован" : "файл расшифрован");
    }
}
