public class ReportManager {
    public static final int MONTHS_COUNT = 3;
    public static YearlyReport reportY;
    public static MonthlyReport reportM;

    public static YearlyService yearlyService;

    public static MonthService monthService;
    public static final int YEARLY_COUNT = 2021;

    public ReportManager() {
        yearlyService = new YearlyService();
        monthService = new MonthService();
    }

    void readFileMonthly() {
        reportM = new MonthlyReport();
    }

    void readFileYearly() {
        reportY = new YearlyReport();
    }

    void checkFiles() {
        if (reportY == null || reportM == null) {
            System.out.println("Файлы еще не считаны! Сначала считайте все отчеты по месяцам и годовой.");
        } else {

            for (int m = 1; m <= MONTHS_COUNT; m++) {
                if (!(yearlyService.sumExpensesYearly(m, reportY) == monthService.sumExpensesMonthly(m, reportM))) {
                    System.out.println("Ошибка! В сверке расходов " + m + " месяца");
                } else {
                    System.out.println("Сверка расходов за " + m + " месяц завершена");
                }
                if (!(yearlyService.sumIncomeYearly(m, reportY) == monthService.sumIncomeMonthly(m, reportM))) {
                    System.out.println("Ошибка! В сверке доходов" + m + "месяца");
                } else {
                    System.out.println("Сверка доходов за " + m + " месяц завершена");
                }

            }
        }
    }

    void outputInformationMonthly() {
        if (reportM == null) {
            System.out.println("Файлы еще не считаны! Сначала считайте все отчеты по месяцам ");
        } else {
            for (int m = 1; m <= MONTHS_COUNT; m++) {
                System.out.println(monthService.getNameMonth(m));

                Month monthlyMaxIncome = monthService.getMonthlyMaxIncome(m, reportM);
                Month monthlyMaxExpenses = monthService.getMaxExpenses(m, reportM);

                if (null == monthlyMaxIncome || null == monthlyMaxExpenses) {
                    System.out.println("Данные по выбранному месяцу отсутствуют");
                } else {
                    System.out.println("1. Самая большая трата: " + monthlyMaxIncome.getPriceIncomeAndExpenses() + " в категории " + monthlyMaxIncome.getName());
                    System.out.println("2. Самый большой доход: " + monthlyMaxExpenses.getPriceIncomeAndExpenses() + " в категории " + monthlyMaxExpenses.getName());
                }
            }
        }
    }

    void outputInformationYearly() {
        if (reportY == null) {
            System.out.println("Файлы еще не считаны! Сначала считайте все отчеты по году.");
        } else {
            System.out.println("Год: " + YEARLY_COUNT);
            for (int m = 1; m <= MONTHS_COUNT; m++) {
                System.out.println("1. Прибыль за " + m + " месяц составила " + yearlyService.sumProfit(m, reportY));
            }
            System.out.println("2. Средный расход в этом месяце составил " + yearlyService.calculateAverageExpenses(reportY));
            System.out.println("3. Средный доход в этом месяце составил " + yearlyService.calculateAverageIncome(reportY));
        }
    }
}

