import java.util.ArrayList;

public class MonthService {
    String getNameMonth(int month) {
        String name = "Декабрь";

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
        }

        return name;
    }

    Month getMonthlyMaxIncome(int month, MonthlyReport reportM) {
        return getMonthlyMaxByExpense(month, reportM, true);
    }

    Month getMaxExpenses(int month, MonthlyReport reportM) {
        return getMonthlyMaxByExpense(month, reportM, false);
    }

    int sumExpensesMonthly(int month, MonthlyReport reportM) {
        int sum = 0;
        for (Month value : reportM.monthly.get(month)) {
            if (value.isExpense()) {
                sum = sum + value.getPriceIncomeAndExpenses();
            }
        }
        return sum;
    }

    int sumIncomeMonthly(int month, MonthlyReport reportM) {
        int sum = 0;
        for (Month value : reportM.monthly.get(month)) {
            if (!value.isExpense()) {
                sum = sum + value.getPriceIncomeAndExpenses();
            }
        }
        return sum;
    }

    Month getMonthlyMaxByExpense(int month, MonthlyReport reportM, boolean isExpense) {
        Month maxExpenses = null;

        ArrayList<Month> oneMonthData = reportM.monthly.get(month);
        for (Month expense : oneMonthData) {
            if (expense.isExpense() == isExpense) {
                if (null == maxExpenses || expense.getPriceIncomeAndExpenses() > maxExpenses.getPriceIncomeAndExpenses()) {
                    maxExpenses = expense;
                }
            }
        }
        return maxExpenses;
    }
}

