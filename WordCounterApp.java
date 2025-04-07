import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounterApp extends JFrame implements ActionListener {

    JTextArea textArea;
    JButton countButton;
    JLabel resultLabel;

    WordCounterApp() {
        setTitle("Word Counter");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center the window

        // Creating components
        textArea = new JTextArea();
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word Count: 0");

        // Set layout
        setLayout(new BorderLayout());

        // Scroll pane for textarea
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Panel for button and result
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(countButton);
        bottomPanel.add(resultLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        // Add action listener
        countButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText().trim();
        if (text.isEmpty()) {
            resultLabel.setText("Word Count: 0");
        } else {
            // Split by spaces, tabs, and new lines
            String[] words = text.split("\\s+");
            resultLabel.setText("Word Count: " + words.length);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordCounterApp());
    }
}
