
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("""
                    Выберите действие введя его  номер
                    1 Зашифровать текст в файле
                    2 Расшифровать текст в файле
                    3 Подобрать ключ к зашифрованному тексту в файле
                    4 Засшифровать текст в файле методом синтаксического перебора
                    5 Выйти из программы""");
            String answer = scanner.nextLine();
            switch (answer) {
                case "1" -> Encrypted.encrypted(true);
                case "2" -> Encrypted.encrypted(false);
                case "3" -> Bruteforce.bruteforce();
                case "4" -> System.out.println("4");
                case "5" -> {
                    return;
                }
            }
        }
    }
}
