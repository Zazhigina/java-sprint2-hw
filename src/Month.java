import java.util.ArrayList;

public class Month {
    public MonthlyReport reportM;

    public Month(MonthlyReport reportM) {
        this.reportM = reportM;
    }

    String name = null;
    String nameMaxI = null;
    String nameMaxE = null;

    String GetNameMonth(int month) {
        if (month == 1) {
            name = "Январь";
        } else if (month == 2) {
            name = "Февраль";
        } else if (month == 3) {
            name = "Март";
        } else if (month == 4) {
            name = "Апрель";
        } else if (month == 5) {
            name = "Май";
        } else if (month == 6) {
            name = "Июнь";
        } else if (month == 7) {
            name = "Июль";
        } else if (month == 8) {
            name = "Август";
        } else if (month == 9) {
            name = "Сентябрь";
        } else if (month == 10) {
            name = "Октябрь";
        } else if (month == 11) {
            name = "Ноябрь";
        } else {
            name = "Декабрь";
        }
        return name;
    }

    int GetMaxIncome(int month) {
        int maxIncome = 0;
        ArrayList<MonthlyReport.Row> oneMonthData = reportM.monthly.get(month);
        for (MonthlyReport.Row income : oneMonthData) {
            if (income.isExpense(income)) {
                if (income.getPriceIncomeAndExpenses(income) > maxIncome) {
                    maxIncome = maxIncome + income.getPriceIncomeAndExpenses(income);
                    nameMaxI = income.getName(income);
                }
            }
        }
        return maxIncome;
    }

    int GetMaxExpenses(int month) {
        int maxExpenses = 0;

        ArrayList<MonthlyReport.Row> oneMonthData = reportM.monthly.get(month);
        for (MonthlyReport.Row expense : oneMonthData) {
            if (!expense.isExpense(expense)) {
                if (expense.getPriceIncomeAndExpenses(expense) > maxExpenses) {
                    maxExpenses = maxExpenses + expense.getPriceIncomeAndExpenses(expense);
                    nameMaxE = expense.getName(expense);
                }
            }
        }
        return maxExpenses;
    }

}

