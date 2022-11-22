import java.util.ArrayList;

public class Month {

    String name;
    boolean expense;
    int quantity;
    int sumOfOne;

    public Month(String name, boolean expense, int quantity, int sumOfOne) {
        this.name = name;
        this.expense = expense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }

    public String getName()
    {
        return name;
    }

    public boolean isExpense() {

        return expense;
    }

    public int getPriceIncomeAndExpenses() {
        return quantity * sumOfOne;
    }
}

