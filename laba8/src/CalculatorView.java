import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    private JTextField inputXField;
    private JTextField inputTermsField;
    private JTextField inputNField;
    private JTextField inputRField;
    private JButton calculateSeriesButton;
    private JButton calculateDoubleSumButton;
    private JTextArea resultArea;

    public CalculatorView() {
        setTitle("Z Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("X:"));
        inputXField = new JTextField();
        inputPanel.add(inputXField);
        inputPanel.add(new JLabel("i:"));
        inputTermsField = new JTextField();
        inputPanel.add(inputTermsField);
        inputPanel.add(new JLabel("N:"));
        inputNField = new JTextField();
        inputPanel.add(inputNField);
        inputPanel.add(new JLabel("R:"));
        inputRField = new JTextField();
        inputPanel.add(inputRField);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        calculateSeriesButton = new JButton("Итог 1 выражения:");
        calculateDoubleSumButton = new JButton("Итог 2 выражения:");
        buttonPanel.add(calculateSeriesButton);
        buttonPanel.add(calculateDoubleSumButton);

        add(buttonPanel, BorderLayout.CENTER);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        inputPanel.setBackground(Color.BLUE);
        buttonPanel.setBackground(Color.WHITE);
        resultArea.setBackground(Color.WHITE);
        resultArea.setForeground(Color.BLACK);
    }

    public String getInputX() {
        return inputXField.getText();
    }

    public String getInputTerms() {
        return inputTermsField.getText();
    }

    public String getInputN() {
        return inputNField.getText();
    }

    public String getInputR() {
        return inputRField.getText();
    }

    public void setResult(String result) {
        resultArea.setText(result);
    }

    public JButton getCalculateSeriesButton() {
        return calculateSeriesButton;
    }

    public JButton getCalculateDoubleSumButton() {
        return calculateDoubleSumButton;
    }
}