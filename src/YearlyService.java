public class YearlyService {

    int sumExpensesYearly(int month, YearlyReport reportY) {
        YearlyReportMonth oneMonthData = reportY.monthsData.get(month);
        int sum = oneMonthData.expenses;
        return sum;
    }

    int sumIncomeYearly(int month, YearlyReport reportY) {
        YearlyReportMonth oneMonthData = reportY.monthsData.get(month);
        int sum = oneMonthData.income;
        return sum;
    }

    int sumProfit(int month, YearlyReport reportY) {
        YearlyReportMonth oneMonthData = reportY.monthsData.get(month);
        return oneMonthData.income - oneMonthData.expenses;
    }

    int calculateAverageExpenses(YearlyReport reportY) {
        int quantity = 0;
        int sum = 0;
        for (YearlyReportMonth oneMonthData : reportY.monthsData.values()) {
            quantity++;
            sum = sum + oneMonthData.expenses;
        }
        return sum / quantity;
    }

    int calculateAverageIncome(YearlyReport reportY) {
        int quantity = 0;
        int sum = 0;
        for (YearlyReportMonth oneMonthData : reportY.monthsData.values()) {
            quantity++;
            sum = sum + oneMonthData.income;
        }
        return sum / quantity;
    }
}
