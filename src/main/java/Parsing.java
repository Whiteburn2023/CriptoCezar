import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Parsing {
    @SneakyThrows
    public static void parse() {
        ConsoleHelper.writeMessage("Введите путь к файлу для его расшифровки: ");
        String pathEncrypted = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Введите путь к файлу для набора статистики: ");
        String pathStatistic = ConsoleHelper.readString();
        Path dst = ConsoleHelper.buildFileName(pathEncrypted, "_parsing");

        Map<Character, Integer> mapEncrypted = fillMapValues(pathEncrypted);
        Map<Character, Integer> mapStatistic = fillMapValues(pathStatistic);


    }

    @SneakyThrows
    private static Map<Character,Integer> fillMapValues(String path){
        Map<Character, Integer> map = new HashMap<>();

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(path))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                stringBuilder.append(string);
            }
            char[] charArray = stringBuilder.toString().toCharArray();

            for (char aChar : charArray) {
//                if (!mapEncrypted.containsKey(aChar)) {
//                    mapEncrypted.put(aChar, 1);
//                } else {
//                    Integer integer = mapEncrypted.get(aChar);
//                    mapEncrypted.put(aChar, integer + 1);
//                }
                map.merge(aChar, 1, (oldV, newV) -> oldV + newV);
            }
        }
        return map;
    }
}
