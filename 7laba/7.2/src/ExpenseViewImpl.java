import java.util.List;

public class ExpenseViewImpl implements ExpenseView {
    @Override
    public void displayTotalExpense(double total) {
        System.out.println("Итоговая сумма: $" + total);
    }

    @Override
    public void displayCategories(List<String> categories) {
        System.out.println("Категории:");
        for (String category : categories) {
            System.out.println("- " + category);
        }
    }
}