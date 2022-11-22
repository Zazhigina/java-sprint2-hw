import java.util.ArrayList;

public class CalculationsMonth {


    String GetNameMonth(int month) {
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

    int GetMaxIncome(int month, MonthlyReport reportM) {
        int maxIncome = 0;
        ArrayList<Month> oneMonthData = reportM.monthly.get(month);
        for (Month income : oneMonthData) {
            if (income.isExpense(income)) {
                if (income.getPriceIncomeAndExpenses(income) > maxIncome) {
                    maxIncome = maxIncome + income.getPriceIncomeAndExpenses(income);
                  //  nameMaxI = income.getName(income);
                }
            }
        }
        return maxIncome;
    }

    int GetMaxExpenses(int month, MonthlyReport reportM) {
        int maxExpenses = 0;

        ArrayList<Month> oneMonthData = reportM.monthly.get(month);
        for (Month expense : oneMonthData) {
            if (!expense.isExpense(expense)) {
                if (expense.getPriceIncomeAndExpenses(expense) > maxExpenses) {
                    maxExpenses = maxExpenses + expense.getPriceIncomeAndExpenses(expense);
                  //  nameMaxE = expense.getName(expense);
                }
            }
        }
        return maxExpenses;
    }

    int sumExpensesMonthly(int month, MonthlyReport reportM) {
        int sum = 0;
        for (Month value : reportM.monthly.get(month)) {
            if (value.isExpense(value)) {
                sum = sum + value.getPriceIncomeAndExpenses(value);
            }
        }
        return sum;
    }

    int sumIncomeMonthly(int month, MonthlyReport reportM) {
        int sum = 0;
        for (Month value : reportM.monthly.get(month)) {
            if (!value.isExpense(value)) {
                sum = sum + value.getPriceIncomeAndExpenses(value);
            }
        }
        return sum;
    }

}

