import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

@UtilityClass
public class ConsoleHelper {

    private final BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public void writeMessage(String message) {
        System.out.println(message);
    }

    @SneakyThrows
    public String readString() {
        return console.readLine();
    }

    public int readInt() {
        int enterDigit = 0;
        try {
            enterDigit = Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            writeMessage("Произошла ошибка при попытке ввода, попробуйте еще раз");
            enterDigit = readInt();
        }
        return enterDigit;
    }

    public Path buildFileName(String path, String suffix) {
        Path scrPath = Paths.get(path);
        String scrNameFile = scrPath.getFileName().toString();
        Path parentDirectory = scrPath.getParent();
        String newFileName;
        if (scrNameFile.contains(".")) {
            int index = scrNameFile.indexOf(".");
            newFileName = scrNameFile.substring(0, index) + suffix + scrNameFile.substring(index);
        } else {
            newFileName = scrNameFile + suffix;
        }
        return parentDirectory.resolve(newFileName);
    }
}
