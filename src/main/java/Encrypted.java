import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Encrypted {

    public static void encrypted(boolean flag) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу для его " + (flag ? "зашифровки" : "расшифровки"));
        String src = scanner.nextLine();
        System.out.println("введите ключ шифрования");
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите путь к файлу куда записать результат");
        String dst = scanner.nextLine();
        CaesarCipher caesarCipher = new CaesarCipher();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(src));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(dst))) {
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
