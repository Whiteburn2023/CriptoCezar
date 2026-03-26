import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

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

        List<Map.Entry<Character, Integer>> listEncrypted = mapToList(mapEncrypted);
        List<Map.Entry<Character, Integer>> listStatistic = mapToList(mapStatistic);

        Map<Character, Character> decrypted = new HashMap<>();
        if (listEncrypted.size() <= listStatistic.size()) {
            for (int i = 0; i < listEncrypted.size(); i++) {
                decrypted.put(listEncrypted.get(i).getKey(), listStatistic.get(i).getKey());
            }
        } else {
            ConsoleHelper.writeMessage("Размер файла статистики недостаточный");
            return;
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(pathEncrypted));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {
            while (bufferedReader.ready()) {
                StringBuilder stringBuilder = new StringBuilder();
                String string = bufferedReader.readLine();
                for (char encryptedChar : string.toCharArray()) {
                    Character decryptedChar = decrypted.get(encryptedChar);
                    stringBuilder.append(decryptedChar);
                }
                bufferedWriter.write(stringBuilder.toString());
                bufferedWriter.newLine();
            }
            ConsoleHelper.writeMessage("Содержимое расшифровано");
        }
    }

    @SneakyThrows
    private List<Map.Entry<String, Long>> convertToList(String path) {
        return Arrays.stream(Files.readString(Path.of(path)).split(""))
                .collect(Collectors.groupingBy(str -> str, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .toList();

    }

//    private static List<Map.Entry<Character, Integer>> mapToList(Map<Character, Integer> map) {
//        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
//        Comparator<Map.Entry<Character, Integer>> comparator = Map.Entry.comparingByValue();
//        list.sort(comparator.reversed());
//        return list;
//    }
//
//    @SneakyThrows
//    private static Map<Character, Integer> fillMapValues(String path) {
//        Map<Character, Integer> map = new HashMap<>();
//
//        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(path))) {
//            StringBuilder stringBuilder = new StringBuilder();
//            while (bufferedReader.ready()) {
//                String string = bufferedReader.readLine();
//                stringBuilder.append(string);
//            }
//            char[] charArray = stringBuilder.toString().toCharArray();
//
//            for (char aChar : charArray) {
//                if (!mapEncrypted.containsKey(aChar)) {
//                    mapEncrypted.put(aChar, 1);
//                } else {
//                    Integer integer = mapEncrypted.get(aChar);
//                    mapEncrypted.put(aChar, integer + 1);
//                }
//                map.merge(aChar, 1, (oldV, newV) -> oldV + newV);
//            }
//        }
//        return map;
//    }
}
