import java.io.*;
import java.util.Scanner;

public class Encrypted {

    public static void encrypted() throws IOException {
        //System.out.println("Введите путь к файлу для его зашифровки");
        Scanner scanner = new Scanner(System.in);
        //String src = scanner.nextLine();
        String src = "C:\\OTUS\\1.txt";
        System.out.println("введите ключ шифрования");
        int key = scanner.nextInt();

//        System.out.println("Введите путь к файлу куда записать результат");
//        String dst = scanner.nextLine();
        String dst = "C:\\OTUS\\2.txt";
        CaesarCipher caesarCipher = new CaesarCipher();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(dst);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String line, lineEncrypt;
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                lineEncrypt = caesarCipher.encrypt(line, key);

                System.out.println(lineEncrypt);

                bufferedWriter.write(lineEncrypt);
            }


        }
        System.out.println("файл зашифрован");

    }
}
