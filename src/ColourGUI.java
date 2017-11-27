import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColourGUI extends JFrame implements ActionListener {
    JButton redButton, blueButton;

    public ColourGUI() {

        setTitle("Select your piece");
        setSize(240, 240);
        Container pane = getContentPane();
        JPanel boardPanel = new JPanel();
        pane.add(boardPanel);
        GridLayout layout = new GridLayout(2,2,2,2);
        boardPanel.setLayout(layout);
//        boardPanel.add(new JButton("Green"));
//        boardPanel.add(new JLabel(green));
        blueButton = new JButton("Blue");
        boardPanel.add(blueButton);
        blueButton.addActionListener(this);
        JLabel blueLabel = new JLabel(SnakesAndLaddersGUI.blue);
        boardPanel.add(blueLabel);
        redButton = new JButton("Red");
        redButton.addActionListener(this);
        boardPanel.add(redButton);
        JLabel redLabel = new JLabel(SnakesAndLaddersGUI.red);
        boardPanel.add(redLabel);
//        boardPanel.add(new JButton("Yellow"));
//        boardPanel.add(new JLabel(yellow));

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
        }
//        else if(e.getActionCommand().equals("Yellow")) {
//            SnakesAndLaddersGUI.players.get(SnakesAndLaddersGUI.count).setToken(new Token("Yellow"));
//            SnakesAndLaddersGUI.count++;
//            setVisible(false);
//        }else if(e.getActionCommand().equals("Green")) {
//            SnakesAndLaddersGUI.players.get(SnakesAndLaddersGUI.count).setToken(new Token("Green"));
//            SnakesAndLaddersGUI.count++;
//            setVisible(false);
//        }
    }
}
