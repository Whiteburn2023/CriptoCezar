
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
/**
 * 1) добавляем к имени файла если есть расширение _е (расш) _d (дешифр) BuildFileName
 * 2) в Encrypted убрать scanner и sout. Записывать рещультат всегда в туже папку откуда исходный файл, под именем 1)
 * 3) Набросать план брутфорс. Весь текст из файла построчно соединяем в одну строку () и дешифруем ее целиком
 * 4) проверь текст если длина каждого слова не превышает 28 символов, то возможно удалась дешифровка.
 * 5) проверяем точка пробел, запятая пробел, воскзнак пробел, вопросзнак пробел
 * 6) вывести кусочек текста пользователю, и спросить читаемый текст? да/нет
 */