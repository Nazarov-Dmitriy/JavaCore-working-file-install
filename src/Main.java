import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listFolder = new ArrayList<>(List.of(new String[]{"src/main", "src/main", "src/test", "res/drawables", "res/vectors", "res/icons", "savegames"}));
        List<String> listFile = new ArrayList<>(List.of(new String[]{"temp.txt", "src/main/Main.java", "src/main/Utils.java"}));
        StringBuilder temp = new StringBuilder();

        createFolder(listFolder, temp);
        createFiles(listFile, temp);
        logTemp(temp);    }

    private static void logTemp(StringBuilder temp) {
        try (FileWriter writer = new FileWriter("temp.txt", false)) {
            writer.write(String.valueOf(temp));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createFiles(List<String> listFile, StringBuilder temp) {
        for (String fileName : listFile) {
            try {
                File file = new File(fileName);
                file.createNewFile();
                temp.append("фаил " + file.getName() + " успешно создан \n");
            } catch (IOException e) {
                temp.append("произошла ошибка при создание файла " + fileName + "\n");
                throw new RuntimeException(e);
            }
        }
    }

    private static void createFolder(List<String> listFolder, StringBuilder temp) {
        for (String folderPath : listFolder) {
            File folder = new File(folderPath);
            folder.mkdirs();
            temp.append("дериктория " + folder.getName() + " успешно создана \n");
        }
    }
}
