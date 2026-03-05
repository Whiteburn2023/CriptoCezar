import java.io.*;
import java.util.Scanner;

public class Encrypted {

    public static void encrypted(boolean flag) throws IOException {
        Scanner scanner = new Scanner(System.in);
        if (flag){
            System.out.println("Введите путь к файлу для его зашифровки");
        } else {
            System.out.println("Введите путь к файлу для его расшифровки");
        }
        String src = scanner.nextLine();
        System.out.println("введите ключ шифрования");
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите путь к файлу куда записать результат");
        String dst = scanner.nextLine();
        CaesarCipher caesarCipher = new CaesarCipher();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(dst);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String lineEncrypt = caesarCipher.encrypt(line, key);
                bufferedWriter.write(lineEncrypt);
                bufferedWriter.newLine();
            }
        }
        if (flag){
            System.out.println("файл зашифрован");
        } else {
            System.out.println("файл расшифрован");
        }

    }
}
