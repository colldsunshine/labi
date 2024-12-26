import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        view.getCalculateSeriesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(view.getInputX());
                    int terms = Integer.parseInt(view.getInputTerms());
                    double result = model.calculateSeries(x, terms);
                    view.setResult("Итог 1 выражения: " + result);
                } catch (NumberFormatException ex) {
                    view.setResult("Неверный ввод");
                }
            }
        });

        view.getCalculateDoubleSumButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(view.getInputN());
                    int r = Integer.parseInt(view.getInputR());
                    double result = model.calculateDoubleSum(n, r);
                    view.setResult("Итог 2 выражения: " + result);
                } catch (NumberFormatException ex) {
                    view.setResult("Неверный ввод");
                }
            }
        });
    }
}