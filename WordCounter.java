import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame implements ActionListener {
    private final JTextArea textArea;
    private final JLabel resultLabel;
    private final JButton countButton;

    public WordCounter() {

        textArea = new JTextArea(25, 35);
        resultLabel = new JLabel("Word count: 0");
        countButton = new JButton("Count Words");

        countButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(countButton, BorderLayout.SOUTH);
        panel.add(resultLabel, BorderLayout.NORTH);

        add(panel);
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String text = textArea.getText();
            int wordCount = countWords(text);
            resultLabel.setText("Word count: " + wordCount);
        }
    }

    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {

        WordCounter wc = new WordCounter();
        wc.setTitle("Word Counter");
        wc.setVisible(true);
        wc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wc.setLocationRelativeTo(null);
    }
}