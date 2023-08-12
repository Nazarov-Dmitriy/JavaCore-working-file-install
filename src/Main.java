import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File main = new File("src/main");
        File utils = new File("src/main");
        File test = new File("src/test");
        File drawables = new File("res/drawables");
        File vectors = new File("res/vectors");
        File icons = new File("res/icons");
        File savegames = new File("savegames");
        File tempTxt = new File("temp.txt");
        File mainJava = new File("src/main/Main.java");
        File utilsJava = new File("src/main/Utils.java");
        List<File> listFolder = new ArrayList<>(List.of(new File[]{main, utils, test, drawables, vectors, icons, savegames}));
        List<File> listFile = new ArrayList<>(List.of(new File[]{mainJava, utilsJava}));
        StringBuilder temp = new StringBuilder();

        try {
            tempTxt.createNewFile();
            temp.append("фаил " + tempTxt.getName() + " успешно создан \n");
        } catch (IOException e) {
            temp.append("произошла ошибка при создание файла " + tempTxt.getName() + "\n");
            throw new RuntimeException(e);
        }


        for (File folder : listFolder) {
            folder.mkdirs();
            temp.append("дериктория " + folder.getName() + " успешно создана \n");
        }

        for (File file : listFile) {
            try {
                file.createNewFile();
                temp.append("фаил " + file.getName() + " успешно создан \n");
            } catch (IOException e) {
                temp.append("произошла ошибка при создание файла " + file.getName() + "\n");
                throw new RuntimeException(e);
            }
        }

        try (FileWriter writer = new FileWriter("temp.txt", false)) {
            writer.write(String.valueOf(temp));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
