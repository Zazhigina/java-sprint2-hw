import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    public int month;
    public HashMap<Integer, ArrayList<Row>> monthly = new HashMap<>();
    public static final int MONTHS_COUNT = 3;

    public static class Row {
        int sumOfOne;
        String name;
        boolean expense;
        int quantity;

        public Row(String name, boolean expense, int quantity, int sumOfOne) {
            this.sumOfOne = sumOfOne;
            this.name = name;
            this.expense = expense;
            this.quantity = quantity;
        }

        public String getName(Row value) {

            return name;
        }

        public boolean isExpense(Row value) {

            return expense;
        }

        public int getPriceIncomeAndExpenses(Row value) {
            return quantity * sumOfOne;
        }
    }

    public MonthlyReport() {

        for (int m = 1; m <= MONTHS_COUNT; m++) {
            this.month = m;

            ArrayList<Row> monthContents = new ArrayList<>();

            String monthPath = "resources/m.20210" + month + ".csv";
            String content = readFileContentsOrNull(monthPath);
            System.out.println(content);
            String[] lines = content.split("\r?\n"); // массив строк
            for (int i = 1; i < lines.length; i++) {
                String line = lines[i]; // "Коньки,TRUE,50,2000"
                String[] parts = line.split(","); // "Коньки,TRUE,50,2000" -> ["Коньки", "TRUE", "50" ,"2000"]
                monthContents.add(new Row(parts[0], Boolean.parseBoolean(parts[1]), Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3])));
            }
            monthly.put(month, monthContents);
        }
    }

    int SumExpensesMonthly(int month) {
        int sum = 0;
        for (Row value : monthly.get(month)) {
            if (value.isExpense(value)) {
                sum = sum + value.getPriceIncomeAndExpenses(value);
            }
        }
        return sum;
    }

    int SumIncomeMonthly(int month) {
        int sum = 0;
        for (Row value : monthly.get(month)) {
            if (!value.isExpense(value)) {
                sum = sum + value.getPriceIncomeAndExpenses(value);
            }
        }
        return sum;
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

