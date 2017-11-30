import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColourGUI extends JFrame implements ActionListener {
    private static int blueSelected;
    private static int redSelected;
    private static int greenSelected;
    private static int yellowSelected;

    /**
     * Constructor for the game piece selection GUI
     */
    ColourGUI() {
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
        JButton greenButton = new JButton("Green");
        boardPanel.add(greenButton);
        greenButton.addActionListener(this);
        JLabel blueLabel = new JLabel(SnakesAndLaddersGUI.blue);
        boardPanel.add(blueLabel);
        JButton blueButton = new JButton("Blue");
        boardPanel.add(blueButton);
        blueButton.addActionListener(this);
        JLabel redLabel = new JLabel(SnakesAndLaddersGUI.red);
        boardPanel.add(redLabel);
        JButton redButton = new JButton("Red");
        boardPanel.add(redButton);
        redButton.addActionListener(this);
        JLabel yellowLabel = new JLabel(SnakesAndLaddersGUI.yellow);
        boardPanel.add(yellowLabel);
        JButton yellowButton = new JButton("Yellow");
        boardPanel.add(yellowButton);
        yellowButton.addActionListener(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Setting what is to happen following the occurrence of the events being listened for
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Blue")) {
            if(blueSelected == 1) {
                JOptionPane.showMessageDialog(null, "That colour has already been selected... try again");
            }else {
                blueSelected++;
                SnakesAndLaddersGUI.players.get(SnakesAndLaddersGUI.count).setToken(new Token("Blue"));
                SnakesAndLaddersGUI.count++;
                setVisible(false);
            }
        }else if(e.getActionCommand().equals("Red")) {
            if(redSelected == 1) {
                JOptionPane.showMessageDialog(null, "That colour has already been selected... try again");
            }else {
                redSelected++;
                SnakesAndLaddersGUI.players.get(SnakesAndLaddersGUI.count).setToken(new Token("Red"));
                SnakesAndLaddersGUI.count++;
                setVisible(false);
            }
        }else if(e.getActionCommand().equals("Yellow")) {
            if(yellowSelected == 1) {
                JOptionPane.showMessageDialog(null, "That colour has already been selected... try again");
            }else {
                yellowSelected++;
                SnakesAndLaddersGUI.players.get(SnakesAndLaddersGUI.count).setToken(new Token("Yellow"));
                SnakesAndLaddersGUI.count++;
                setVisible(false);
            }
        }else if(e.getActionCommand().equals("Green")) {
            if (greenSelected == 1) {
                JOptionPane.showMessageDialog(null, "That colour has already been selected... try again");
            } else {
                greenSelected++;
                SnakesAndLaddersGUI.players.get(SnakesAndLaddersGUI.count).setToken(new Token("Green"));
                SnakesAndLaddersGUI.count++;
                setVisible(false);
            }
        }
    }
}
