import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpensePresenter {
    private List<Expense> expenses = new ArrayList<>();
    private ExpenseView view;

    public ExpensePresenter(ExpenseView view) {
        this.view = view;
    }

    public void addExpense(double amount, String category, String date) {
        expenses.add(new Expense(amount, category, date));
        updateView();
    }

    private double calculateTotalExpense() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    private List<String> getUniqueCategories() {
        Set<String> categories = new HashSet<>();
        for (Expense expense : expenses) {
            categories.add(expense.getCategory());
        }
        return new ArrayList<>(categories);
    }

    public void updateView() {
        view.displayTotalExpense(calculateTotalExpense());
        view.displayCategories(getUniqueCategories());
    }
}