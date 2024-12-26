import java.util.List;

public interface ExpenseView {
    void displayTotalExpense(double total);
    void displayCategories(List<String> categories);
}