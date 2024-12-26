public class Main {
    public static void main(String[] args) {
        ExpenseView view = new ExpenseViewImpl();
        ExpensePresenter presenter = new ExpensePresenter(view);

        presenter.addExpense(50.0, "Еда", "12-12-2012");
        presenter.addExpense(30.0, "Транспорт", "10-11-2013");
        presenter.addExpense(100.0, "Шоппинг", "10-10-2003");
    }
}