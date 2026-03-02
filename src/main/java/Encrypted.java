import java.io.*;
import java.util.Scanner;

public class Encrypted {

    public static void encrypted() throws IOException {
        System.out.println("Введите путь к файлу для его зашифровки");
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        System.out.println("введите ключ шифрования");
        int key = scanner.nextInt();
        System.out.println("Введите путь к файлу куда записать результат");
        String dst = scanner.nextLine();

        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(dst);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                CaesarCipher caesarCipher = new CaesarCipher();
                String lineEncrypt = caesarCipher.encrypt(line, key);
                bufferedWriter.write(lineEncrypt);

            }
        }
        System.out.println("файл зашифрован");

    }
}
