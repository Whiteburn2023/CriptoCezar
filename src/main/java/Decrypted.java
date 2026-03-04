import java.io.*;
import java.util.Scanner;

public class Decrypted {

    public static void decrypted() throws IOException {
        //System.out.println("Введите путь к файлу для его расшифровки");
        Scanner scanner = new Scanner(System.in);
        //String src = scanner.nextLine();
        String src = "C:\\OTUS\\2.txt";
        System.out.println("введите ключ шифрования");
        int key = scanner.nextInt();

//        System.out.println("Введите путь к файлу куда записать результат");
//        String dst = scanner.nextLine();
        String dst = "C:\\OTUS\\3.txt";
        CaesarCipher caesarCipher = new CaesarCipher();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(dst);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String line, lineDecrypt;
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                lineDecrypt = caesarCipher.decrypt(line, key);

                System.out.println(lineDecrypt);

                bufferedWriter.write(lineDecrypt);
            }


        }
        System.out.println("файл расшифрован");

    }
}
