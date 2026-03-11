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
        int lastDot = path.lastIndexOf(".");
        String dotExt = "";
        if (lastDot != -1) {
            dotExt = path.substring(lastDot);
            path = path.substring(0, lastDot);
        }
        Path scrPath = Paths.get(path);
        Path scrNameFile = scrPath.getFileName();
        Path scrParentDirectory = scrPath.getParent();
        Path dst = scrParentDirectory.resolve(scrNameFile + suffix + dotExt);
        return dst;
    }

    public Path dstFilename(String path, boolean flag, String suffix) {
        String extFile = flag ? "_e" : "_d";
        return buildFileName(path, extFile);
    }
}
