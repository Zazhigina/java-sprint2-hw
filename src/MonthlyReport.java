import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    public int month;
    public static final int MONTHS_COUNT = 3;

    public HashMap<Integer, ArrayList<Month>> monthly = new HashMap<>();

    public MonthlyReport() {
        for (int m = 1; m <= MONTHS_COUNT; m++) {
            month = m;
            ArrayList<Month> monthContents = new ArrayList<>();
            String monthPath = "resources/m.20210" + month + ".csv";
            String content = readFileContentsOrNull(monthPath);
            if (content == null) {
                return;
            } else {
                String[] lines = content.split("\r?\n"); // массив строк
                for (int i = 1; i < lines.length; i++) {
                    String line = lines[i]; // "Коньки,TRUE,50,2000"
                    String[] parts = line.split(","); // "Коньки,TRUE,50,2000" -> ["Коньки", "TRUE", "50" ,"2000"]
                    monthContents.add(new Month(parts[0], Boolean.parseBoolean(parts[1]), Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3])));
                }
                monthly.put(month, monthContents);
            }
        }
    }


    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом.");
            System.out.println("Возможно, файл не находится в нужной директории");
            return null;
        }
    }
}


