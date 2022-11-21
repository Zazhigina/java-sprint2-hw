import java.util.Scanner;

public class Main {
    public static final int MONTHS_COUNT = 3;
    public static YearlyReport reportY;
    public static MonthlyReport reportM;
    public static final int YEARLY_COUNT = 2021;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            printMenu();

            int command = scanner.nextInt();

            selectAction(scanner, command);
            if (command == 1234) {
                System.out.println("Программа завершена");
                break;
            }
        }
    }

    public static void printMenu() {

        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("Выход");
    }

    public static void selectAction(Scanner scanner, int command) {

        if (command == 1) {
            reportM = new MonthlyReport();
            System.out.println("Отсчет за месяц считан.");
        } else if (command == 2) {
            reportY = new YearlyReport(YEARLY_COUNT, "resources/y.2021.csv");
            System.out.println("Отсчет за год считан.");
        } else if (command == 3) {
            if ((reportY == null) && (reportM == null)) {
                System.out.println("Файлы еще не считаны! Сначала считайте все отчеты по месяцам и годовой.");
            } else {
                for (int m = 1; m <= MONTHS_COUNT; m++) {
                    if (reportY.SumExpensesYearly(m) == reportM.SumExpensesMonthly(m)) {
                    } else {
                        System.out.println("Ошибка! В сверке расходов " + m + " месяца");
                    }
                    System.out.println("Сверка расходов за " + m + " месяц завершена");
                }
                for (int m = 1; m <= MONTHS_COUNT; m++) {
                    if (reportY.SumIncomeYearly(m) == reportM.SumIncomeMonthly(m)) {
                    } else {
                        System.out.println("Ошибка! В сверке доходов" + m + "месяца");
                    }
                    System.out.println("Сверка доходов за " + m + " месяц завершена");
                }
            }

        } else if (command == 4) {
            if ((reportY == null) && (reportM == null)) {
                System.out.println("Файлы еще не считаны! Сначала считайте все отчеты по месяцам и годовой.");
            } else {

                Month month = new Month(reportM);
                for (int m = 1; m <= MONTHS_COUNT; m++) {
                    System.out.println(month.GetNameMonth(m));

                    System.out.println("1.Самая большая трата: " + month.GetMaxIncome(m) + " в категории " +
                            month.nameMaxI);
                    System.out.println("2. Самая большая трата: " + month.GetMaxExpenses(m) + " в категории " +
                            month.nameMaxE);
                }
            }
        } else if (command == 5) {
            if ((reportY == null) && (reportM == null)) {
                System.out.println("Файлы еще не считаны! Сначала считайте все отчеты по месяцам и годовой.");
            } else {
                Yearly yearly = new Yearly(reportY);
                System.out.println("Год: " + YEARLY_COUNT);
                for (int m = 1; m <= MONTHS_COUNT; m++) {
                    System.out.println("1. Прибыль за " + m + " месяц составила " + yearly.SumProfit(m));
                }
                System.out.println("2. Средный расход в этом месяце составил " + yearly.CalculateAverageExpenses());
                System.out.println("3. Средный доход в этом месяце составил " + yearly.CalculateAverageIncome());
            }
        } else {
            System.out.println("Такой команды нету,введите снова.");
        }

    }
}





