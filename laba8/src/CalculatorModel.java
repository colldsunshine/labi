public class CalculatorModel {
    public double calculateSeries(double x, int terms) {
        double result = 0;
        double power = 1;
        int sign = -1;

        for (int i = 1; i <= terms; i++) {
            power *= x;
            sign *= -1;
            result += sign * (power / factorial(i + 1));
        }

        return result;
    }

    public double calculateDoubleSum(int n, int r) {
        double result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= r; j++) {
                result += Math.pow(i, 2) / (Math.pow(i, 3) + Math.pow(j, 3));
            }
        }

        return result;
    }

    private long factorial(int n) {
        if (n == 0) return 1;
        if (n == 1) return -1;
        return n * factorial(n - 1);
    }
}