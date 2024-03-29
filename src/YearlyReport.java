import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class YearlyReport {
    public HashMap<Integer, YearlyReportMonth> monthsData = new HashMap<>();

    public YearlyReport() {
        String yearPath = "resources/y.2021.csv";
        String content = readFileContentsOrNull(yearPath); //
        if (content == null) {
            return;
        } else {
            String[] lines = content.split("\r?\n"); // массив строк
            for (int i = 1; i < lines.length; i++) {
                String line = lines[i]; // "01,350000,true"
                String[] parts = line.split(","); // "01,350000,true" -> ["01", "350000", "true"]
                int month = Integer.parseInt(parts[0]);
                int sum = Integer.parseInt(parts[1]);
                boolean isExpense = Boolean.parseBoolean(parts[2]);
                if (!monthsData.containsKey(month)) {
                    monthsData.put(month, new YearlyReportMonth(month));
                }
                YearlyReportMonth oneMonthData = monthsData.get(month);
                if (isExpense) {
                    oneMonthData.expenses += sum;
                } else {
                    oneMonthData.income += sum;
                }
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



