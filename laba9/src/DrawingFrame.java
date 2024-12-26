import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingFrame extends JFrame {
    private Color currentColor = Color.BLACK;
    private int currentThickness = 5;

    public DrawingFrame() {
        setTitle("Paint");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu colorMenu = new JMenu("Цвет");
        JMenuItem redColor = new JMenuItem("Красный");
        redColor.addActionListener(e -> currentColor = Color.RED);
        JMenuItem greenColor = new JMenuItem("Зеленый");
        greenColor.addActionListener(e -> currentColor = Color.GREEN);
        JMenuItem blueColor = new JMenuItem("Голубой");
        blueColor.addActionListener(e -> currentColor = Color.BLUE);
        JMenuItem blackColor = new JMenuItem("Черный");
        blackColor.addActionListener(e -> currentColor = Color.BLACK);
        JMenuItem yellowColor = new JMenuItem("Желтый");
        yellowColor.addActionListener(e -> currentColor = Color.YELLOW);
        JMenuItem orangeColor = new JMenuItem("Оранжевый");
        orangeColor.addActionListener(e -> currentColor = Color.ORANGE);
        JMenuItem purpleColor = new JMenuItem("Фиолетовый");
        purpleColor.addActionListener(e -> currentColor = new Color(128, 0, 128));

        colorMenu.add(redColor);
        colorMenu.add(greenColor);
        colorMenu.add(blueColor);
        colorMenu.add(blackColor);
        colorMenu.add(yellowColor);
        colorMenu.add(orangeColor);
        colorMenu.add(purpleColor);
        menuBar.add(colorMenu);

        JMenu thicknessMenu = new JMenu("Толщина кисти");
        JMenuItem thin = new JMenuItem("Тонкая (1)");
        thin.addActionListener(e -> currentThickness = 1);
        JMenuItem medium = new JMenuItem("Средняя (5)");
        medium.addActionListener(e -> currentThickness = 5);
        JMenuItem thick = new JMenuItem("Толстая (10)");
        thick.addActionListener(e -> currentThickness = 10);

        thicknessMenu.add(thin);
        thicknessMenu.add(medium);
        thicknessMenu.add(thick);
        menuBar.add(thicknessMenu);

        setJMenuBar(menuBar);
        setVisible(true);
    }

    class DrawingPanel extends JPanel {
        private ArrayList<Line> lines = new ArrayList<>();
        private Point startPoint = null;

        public DrawingPanel() {
            setBackground(Color.WHITE);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    startPoint = e.getPoint();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (startPoint != null) {
                        lines.add(new Line(startPoint, e.getPoint(), currentColor, currentThickness));
                        startPoint = null;
                        repaint();
                    }
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if (startPoint != null) {
                        lines.add(new Line(startPoint, e.getPoint(), currentColor, currentThickness));
                        startPoint = e.getPoint();
                        repaint();
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (Line line : lines) {
                g2d.setColor(line.color);
                g2d.setStroke(new BasicStroke(line.thickness));
                g2d.drawLine(line.start.x, line.start.y, line.end.x, line.end.y);
            }
        }
    }

    class Line {
        Point start;
        Point end;
        Color color;
        int thickness;

        Line(Point start, Point end, Color color, int thickness) {
            this.start = start;
            this.end = end;
            this.color = color;
            this.thickness = thickness;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DrawingFrame::new);
    }
}