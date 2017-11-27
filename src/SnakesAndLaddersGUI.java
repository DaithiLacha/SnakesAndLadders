import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SnakesAndLaddersGUI extends JFrame implements ActionListener{
    private JMenu fileMenu;
    private JMenu playerMenu;
    static ArrayList<Player> players;
    private JPanel[][] panelHolder = new JPanel[10][10];
    static int count = 0;
    static ImageIcon blue = new ImageIcon("images/bluePiece.png");
    static ImageIcon red = new ImageIcon("images/redPiece.png");
//    static ImageIcon green = new ImageIcon("images/greenPiece.png");
//    static ImageIcon yellow = new ImageIcon("images/yellowPiece.png");
    private static int counter;

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
        JPanel boardPanel2 = new JPanel();
        boardPanel2.setLayout(new FlowLayout());
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, boardPanel, boardPanel2);
        pane.add(splitPane);
        GridLayout boardLayout = new GridLayout(10, 10);
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
                        JPanel panel = new JPanel();
                        panel.setLayout(new BorderLayout());
                        panelHolder[i][j] = panel;
                        boardPanel.add(panelHolder[i][j]);
                        JLabel label = new JLabel("Square " + (9 - i) + "" + (9 - j));
                        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        panelHolder[i][j].add(label);
                    }else {
                        JPanel panel = new JPanel();
                        panel.setLayout(new BorderLayout());
                        panelHolder[i][j] = panel;
                        boardPanel.add(panelHolder[i][j]);
                        JLabel label = new JLabel("Square " + (9 - i) + "" + (j));
                        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        panelHolder[i][j].add(label);
                    }
                }
            }
        }
        JButton button1 = new JButton("Roll Dice");
        button1.setBounds(20,250, 100, 62);
        boardPanel2.add(button1);
        button1.addActionListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createFileMenu();
        createPlayerMenu();
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(playerMenu);
    }

    private void createFileMenu(){
        fileMenu = new JMenu("File");
        JMenuItem item;
        item = new JMenuItem("Save");
        item.addActionListener(this);
        fileMenu.add(item);
        item = new JMenuItem("Open");
        item.addActionListener(this);
        fileMenu.add(item);
        item = new JMenuItem("New");
        item.addActionListener(this);
        fileMenu.add(item);
        fileMenu.addSeparator();
        item = new JMenuItem("Quit");
        item.addActionListener(this);
        fileMenu.add(item);
    }

    private void createPlayerMenu(){
        playerMenu = new JMenu("Player");
        JMenuItem item;
        item = new JMenuItem("Add");
        item.addActionListener(this);
        playerMenu.add(item);
        item = new JMenuItem("Display");
        item.addActionListener(this);
        playerMenu.add(item);
    }

    public void addPlayer() {
        String name = JOptionPane.showInputDialog("Enter Name");
        players.add(new Player(name));
        ColourGUI frame = new ColourGUI();
        frame.setVisible(true);
    }

    public void displayPlayers() {
        String playerDetails = "";
        for(Player p : players) {
            playerDetails += p.toString();
        }
        JOptionPane.showMessageDialog(null, playerDetails);
    }

    public void newGame(){
        players = new ArrayList<>();
        count = 0;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Roll Dice")) {
            JLabel bluePiece = new JLabel(blue);
            if(players.size() == 0) {
                JOptionPane.showMessageDialog(null, "You must add a player before they can roll the dice");
            }else{
                Player player = players.get(counter);
                String pos = "" + player.getPosition() + "";
                int xCo = Integer.parseInt(pos.substring(0,1));
                int yCo = Integer.parseInt(pos.substring(1,2));
                panelHolder[xCo][yCo].remove(bluePiece);
                repaint();
                validate();
                player.rollDice();
                DetermineSquareType.determineSquareType(player);
                pos = "" + player.getPosition() + "";
                xCo = Integer.parseInt(pos.substring(0,1));
                yCo = Integer.parseInt(pos.substring(1,2));
                panelHolder[xCo][yCo].add(bluePiece);
                repaint();
                validate();
                    if(player.isWinner()) {
                        JOptionPane.showMessageDialog(null, "Congrats " + player.getName() + " you win");
                    }
                    counter++;
                    if(counter >= players.size()){
                        counter = 0;
                    }

            }
        }else if(e.getActionCommand().equals("Add")) {
            if(players.size() < 4) {
                addPlayer();
            }else {
                JOptionPane.showMessageDialog(null, "Four players is the maximum allowed");
            }
        }else if(e.getActionCommand().equals("Display")) {
            displayPlayers();
        }else if(e.getActionCommand().equals("New")) {
            newGame();
        }
    }
}

