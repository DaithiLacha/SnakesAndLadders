import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SnakesAndLaddersGUI extends JFrame {
    JMenu fileMenu;
    ArrayList<Player> players;
    Square[][] board;
    GridLayout boardLayout;

    public static void main(String[] args) {
        SnakesAndLaddersGUI frame = new SnakesAndLaddersGUI();
        frame.setVisible(true);
    }

    public SnakesAndLaddersGUI() {
        newGame();
        ImageIcon snake = new ImageIcon("images/Snake.png");
        ImageIcon ladder = new ImageIcon("images/Ladder.png");
        setTitle("Snakes and Ladders");
        setSize(1500, 850);
        Container pane = getContentPane();
        JPanel boardPanel = new JPanel();
        pane.add(boardPanel);
        boardLayout = new GridLayout(10, 10);
        boardPanel.setLayout(boardLayout);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i != 0) && (i % 2 == 0) && (j == 2)) {
                    boardPanel.add(new JLabel(ladder));
                } else if ((i % 2 != 0) && (j == 6)) {
                    boardPanel.add(new JLabel(ladder));
                } else if ((i % 2 == 0) && (j == 4)) {
                    boardPanel.add(new JLabel(snake));
                } else if (i < 9 && (i % 2 != 0) && (j == 9)) {
                    boardPanel.add(new JLabel(snake));
                } else {
                    if(((i % 2) == 0)) {
                        boardPanel.add(new JLabel("Square " + (9 - i) + "" + (9 - j)));
                    }else {
                        boardPanel.add(new JLabel("Square " + (9 - i) + "" + j));
                    }
                }
            }
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void newGame() {
        //newPlayerSet();
    }

    public void newPlayerSet() {
        players = new ArrayList<>();
        int ans =JOptionPane.showConfirmDialog(null, "Add new player?",
                    "Add Player", JOptionPane.YES_NO_OPTION);
        while(players.size() < 4) {
            while (ans == JOptionPane.YES_OPTION) {
                String name = JOptionPane.showInputDialog("Enter player name");
                players.add(new Player(name));
                ans = JOptionPane.showConfirmDialog(null, "Add new player?",
                        "Add Player", JOptionPane.YES_NO_OPTION);
            }
        }
    }

//    public Container setBoard() {
//
//        return pane;
//    }
}
