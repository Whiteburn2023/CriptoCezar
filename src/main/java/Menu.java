
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("""
                    Выберите действие введя его  номер
                    1 зашифровать текст в файле
                    2 расшифровать текст в файле
                    3 подобрать ключ к зашифрованному тексту в файле
                    4 расшифровать текст в файле методом синтаксического перебора
                    5 выйти из программы""");
            String answer = scanner.nextLine();
            switch (answer) {
                case "1" -> Encrypted.encrypted();
                case "2" -> Decrypted.decrypted();
                case "3" -> System.out.println("3");
                case "4" -> System.out.println("4");
                case "5" -> {
                    return;
                }
            }
        }




    }

}
