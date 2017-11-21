import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SnakesAndLaddersGUI extends JFrame implements ActionListener{
    JMenu fileMenu;
    ArrayList<Player> players;
    Square[][] board;
    GridLayout boardLayout;
    JPanel[][] panelHolder = new JPanel[10][10];

    public static void main(String[] args) {
        SnakesAndLaddersGUI frame = new SnakesAndLaddersGUI();
        frame.setVisible(true);
    }

    public SnakesAndLaddersGUI() {
        newGame();
        ImageIcon snake = new ImageIcon("images/Snake.png");
        ImageIcon blue = new ImageIcon("images/bluePiece.png");
        ImageIcon ladder = new ImageIcon("images/Ladder.png");
        setTitle("Snakes and Ladders");
        setSize(1500, 850);
        Container pane = getContentPane();
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(null);
        JPanel boardPanel2 = new JPanel();
        boardPanel2.setLayout(new BorderLayout());
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, boardPanel, boardPanel2);
        pane.add(splitPane);
        boardLayout = new GridLayout(10, 10);
        boardPanel.setLayout(boardLayout);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i != 0) && (i % 2 == 0) && (j == 2)) {
                    JPanel panel = new JPanel();
                    panel.setLayout(new BorderLayout());
                    panelHolder[i][j] = panel;
                    boardPanel.add(panelHolder[i][j]);
                    panelHolder[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    panelHolder[i][j].add(new JLabel(ladder));
                } else if ((i % 2 != 0) && (j == 6)) {
                    JPanel panel = new JPanel();
                    panel.setLayout(new BorderLayout());
                    panelHolder[i][j] = panel;
                    boardPanel.add(panelHolder[i][j]);
                    panelHolder[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    panelHolder[i][j].add(new JLabel(ladder));
                } else if ((i % 2 == 0) && (j == 4)) {
                    JPanel panel = new JPanel();
                    panel.setLayout(new BorderLayout());
                    panelHolder[i][j] = panel;
                    boardPanel.add(panelHolder[i][j]);
                    panelHolder[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    panelHolder[i][j].add(new JLabel(snake));
                } else if (i < 9 && (i % 2 != 0) && (j == 9)) {
                    JPanel panel = new JPanel();
                    panel.setLayout(new BorderLayout());
                    panelHolder[i][j] = panel;
                    boardPanel.add(panelHolder[i][j]);
                    panelHolder[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    panelHolder[i][j].add(new JLabel(snake));
                } else {
                    if(((i % 2) == 0)) {
                        JLabel label = new JLabel("Square " + (9 - i) + "" + (9 - j));
                        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        boardPanel.add(label);
                    }else {
                        JLabel label = new JLabel("Square " + (9 - i) + "" + (j));
                        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        boardPanel.add(label);
                    }
                }
            }
        }
        panelHolder[2][4].add(new JLabel(blue));
        JButton button1 = new JButton("Roll Dice");
        button1.setBounds(20,250, 100, 62);
        boardPanel2.add(button1);
        button1.addActionListener(this);
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

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Roll Dice")) {
            JOptionPane.showMessageDialog(null, "Hello");

        }

    }
}

