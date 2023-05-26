import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI implements ActionListener {

    JPanel panel = new JPanel();
    JFrame frame = new JFrame();

    public GUI(String s) {
        JLabel label = new JLabel(s);

        JButton button = new JButton("Click to close");
        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(button);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Message:");
        frame.pack();
        frame.setVisible(true);
    }

    public GUI(String s, String s1) {
        JLabel label = new JLabel(s);
        JLabel label1 = new JLabel(s1);

        JButton button = new JButton("Click to close");
        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        label.setHorizontalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label1);
        panel.add(button);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Message:");
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
    }

}
