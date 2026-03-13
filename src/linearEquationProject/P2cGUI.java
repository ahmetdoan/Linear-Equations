package linearEquationProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P2cGUI extends JFrame {
    private JTextField[] inputs = new JTextField[8];
    private JLabel resultLabel = new JLabel("Enter coordinates and click solve", SwingConstants.CENTER);

    public P2cGUI() {
        setTitle("Line Intersection Finder");
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout(10, 10));

        // Header
        JLabel header = new JLabel("Find Intersection of Two Lines", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 18));
        add(header, BorderLayout.NORTH);

        // Girdi paneli
        JPanel inputPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        String[] labels = {"x1", "y1", "x2", "y2", "x3", "y3", "x4", "y4"};
        for (int i = 0; i < 8; i++) {
            inputPanel.add(new JLabel(labels[i] + ":", SwingConstants.RIGHT));
            inputs[i] = new JTextField();
            inputPanel.add(inputs[i]);
        }
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        add(inputPanel, BorderLayout.CENTER);

        // Buton ve sonuç 
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        JButton solveButton = new JButton("Find Intersection");
        solveButton.setFont(new Font("Arial", Font.BOLD, 14));
        bottomPanel.add(solveButton, BorderLayout.NORTH);

        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        resultLabel.setForeground(Color.BLUE);
        bottomPanel.add(resultLabel, BorderLayout.CENTER);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        add(bottomPanel, BorderLayout.SOUTH);

        // Buton hareketi
        solveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double[] values = new double[8];
                    for (int i = 0; i < 8; i++) {
                        values[i] = Double.parseDouble(inputs[i].getText());
                    }

                    double a = values[1] - values[3];
                    double b = values[2] - values[0];
                    double c = values[5] - values[7];
                    double d = values[6] - values[4];
                    double eVal = a * values[0] + b * values[1];
                    double fVal = c * values[4] + d * values[5];

                    
                    LinearEquation le = new LinearEquation(a, b, c, d, eVal, fVal);

                    if (le.isSolvable()) {
                        resultLabel.setText(String.format("intersection at (%.4f, %.4f)", le.getX(), le.getY()));
                    } else {
                        resultLabel.setText("Lines are parallel.");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input! please enter numbers.");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new P2cGUI());
    }
}
