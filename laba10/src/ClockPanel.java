import javax.swing.*;
import java.awt.*;

class ClockPanel extends JPanel {
    private int hours, minutes, seconds;

    public void updateTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(Color.BLACK);
        g.drawString(String.format("%02d:%02d:%02d", hours, minutes, seconds), 100, 100);
    }
}