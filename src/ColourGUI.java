import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColourGUI extends JFrame implements ActionListener {
    JButton redButton;
    JButton blueButton;
    JButton greenButton;
    JButton yellowButton;

    public ColourGUI() {
        setTitle("Select your piece");
        setSize(240, 350);
        Container pane = getContentPane();
        JPanel boardPanel = new JPanel();
        boardPanel.setPreferredSize(new Dimension(64, 64));
        pane.add(boardPanel);
        GridLayout layout = new GridLayout(4,2,2,2);
        boardPanel.setLayout(layout);
        JLabel greenLabel = new JLabel(SnakesAndLaddersGUI.green);
        boardPanel.add(greenLabel);
        greenButton = new JButton("Green");
        boardPanel.add(greenButton);
        greenButton.addActionListener(this);
        JLabel blueLabel = new JLabel(SnakesAndLaddersGUI.blue);
        boardPanel.add(blueLabel);
        blueButton = new JButton("Blue");
        boardPanel.add(blueButton);
        blueButton.addActionListener(this);
        JLabel redLabel = new JLabel(SnakesAndLaddersGUI.red);
        boardPanel.add(redLabel);
        redButton = new JButton("Red");
        boardPanel.add(redButton);
        redButton.addActionListener(this);
        JLabel yellowLabel = new JLabel(SnakesAndLaddersGUI.yellow);
        boardPanel.add(yellowLabel);
        yellowButton = new JButton("Yellow");
        boardPanel.add(yellowButton);
        yellowButton.addActionListener(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Blue")) {
            SnakesAndLaddersGUI.players.get(SnakesAndLaddersGUI.count).setToken(new Token("Blue"));
            SnakesAndLaddersGUI.count++;
            setVisible(false);
        }else if(e.getActionCommand().equals("Red")) {
            SnakesAndLaddersGUI.players.get(SnakesAndLaddersGUI.count).setToken(new Token("Red"));
            SnakesAndLaddersGUI.count++;
            setVisible(false);
        }else if(e.getActionCommand().equals("Yellow")) {
            SnakesAndLaddersGUI.players.get(SnakesAndLaddersGUI.count).setToken(new Token("Yellow"));
            SnakesAndLaddersGUI.count++;
            setVisible(false);
        }else if(e.getActionCommand().equals("Green")) {
            SnakesAndLaddersGUI.players.get(SnakesAndLaddersGUI.count).setToken(new Token("Green"));
            SnakesAndLaddersGUI.count++;
            setVisible(false);
        }
    }
}
