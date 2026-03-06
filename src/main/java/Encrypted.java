import java.io.*;
import java.util.Scanner;

public class Encrypted {

    public static void encrypted(boolean flag) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println( flag ?
                "Введите путь к файлу для его зашифровки" :
                "Введите путь к файлу для его расшифровки");
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
                bufferedWriter.write(flag ?
                        caesarCipher.encrypt(bufferedReader.readLine(), key) :
                        caesarCipher.decrypt(bufferedReader.readLine(), key));
                bufferedWriter.newLine();
            }
        }
        System.out.println(flag ? "файл зашифрован" : "файл расшифрован");
    }
}
