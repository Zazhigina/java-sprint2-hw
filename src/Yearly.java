import java.util.HashMap;

public class Yearly {
    public YearlyReport reportY;

    public Yearly(YearlyReport reportY) {
        this.reportY = reportY;
    }

    int SumProfit(int month) {
        YearlyReportMonth oneMonthData = reportY.monthsData.get(month);
        return oneMonthData.income - oneMonthData.expenses;
    }

    int CalculateAverageExpenses() {
        int profit = 0;
        int sum = 0;
        for (YearlyReportMonth oneMonthData : reportY.monthsData.values()) {
            profit++;
            sum = sum + oneMonthData.expenses;
        }
        return sum = sum / profit;
    }

    int CalculateAverageIncome() {
        int profit = 0;
        int sum = 0;
        for (YearlyReportMonth oneMonthData : reportY.monthsData.values()) {
            profit++;
            sum = sum + oneMonthData.income;
        }
        return sum = sum / profit;
    }
}
