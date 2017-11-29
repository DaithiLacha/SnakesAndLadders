import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SnakesAndLaddersGUI extends JFrame implements ActionListener{
    // JMenus, fileMenu for the new/save/open/quit functionality & playerMenu to add players and display player details
    private JMenu fileMenu;
    private JMenu playerMenu;
    //Players which will take part in the game
    static ArrayList<Player> players;
    // 2D array which will be used to populate the board with its individual labels
    private JPanel[][] panelHolder = new JPanel[10][10];
    static int count = 0;
    // Images for the player tokens
    static ImageIcon blue = new ImageIcon("images/bluePiece.png");
    static ImageIcon red = new ImageIcon("images/redPiece.png");
    static ImageIcon green = new ImageIcon("images/greenPiece.png");
    static ImageIcon yellow = new ImageIcon("images/yellowPiece.png");
    // JLabels to hold the token image at the players previous location so it can then be removed
    JLabel currentBluePiece;
    JLabel currentRedPiece;
    JLabel currentGreenPiece;
    JLabel currentYellowPiece;
    private int counter;

    /**
     * Constructor for the GUI which will include the game board as well as the roll dice button
     */
    public SnakesAndLaddersGUI() {
        newGame();
        ImageIcon snake = new ImageIcon("images/Snake.png");
        ImageIcon ladder = new ImageIcon("images/Ladder.png");
        setTitle("Snakes and Ladders");
        setSize(950, 700);
        createFileMenu();
        createPlayerMenu();
        // adding the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(playerMenu);
        Container pane = getContentPane();
        // assigning the layout of the container pane
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        JPanel boardPanel = new JPanel();
        JPanel boardPanel2 = new JPanel();
        pane.add(boardPanel);
        pane.add(boardPanel2);
        boardPanel2.setLayout(new FlowLayout());
        //setting panel's layout to grind layout to mimic the look of a board
        GridLayout boardLayout = new GridLayout(10, 10);
        boardPanel.setLayout(boardLayout);

        // iterating through the 2D array
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                // Setting specific squares on board to snake or ladder
                if((i != 0) && (i % 2 == 0) && (j == 2)) {
                    JPanel panel = new JPanel();
                    panel.setPreferredSize(new Dimension(50,50));
                    panel.setLayout(new BorderLayout());
                    panelHolder[i][j] = panel;
                    boardPanel.add(panelHolder[i][j]);
                    panelHolder[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    panelHolder[i][j].add(new JLabel(ladder));
                }else if((i % 2 != 0) && (j == 6)) {
                    JPanel panel = new JPanel();
                    panel.setPreferredSize(new Dimension(50,50));
                    panel.setLayout(new BorderLayout());
                    panelHolder[i][j] = panel;
                    boardPanel.add(panelHolder[i][j]);
                    panelHolder[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    panelHolder[i][j].add(new JLabel(ladder));
                }else if((i % 2 == 0) && (j == 4)) {
                    JPanel panel = new JPanel();
                    panel.setPreferredSize(new Dimension(50,50));
                    panel.setLayout(new BorderLayout());
                    panelHolder[i][j] = panel;
                    boardPanel.add(panelHolder[i][j]);
                    panelHolder[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    panelHolder[i][j].add(new JLabel(snake));
                }else if(i < 9 && (i % 2 != 0) && (j == 9)) {
                    JPanel panel = new JPanel();
                    panel.setPreferredSize(new Dimension(50,50));
                    panel.setLayout(new BorderLayout());
                    panelHolder[i][j] = panel;
                    boardPanel.add(panelHolder[i][j]);
                    panelHolder[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    panelHolder[i][j].add(new JLabel(snake));
                }else {
                    // setting the default squares
                    if(((i % 2) == 0)) {
                        JPanel panel = new JPanel();
                        panel.setPreferredSize(new Dimension(50,50));
                        panel.setLayout(new BorderLayout());
                        panelHolder[i][j] = panel;
                        boardPanel.add(panelHolder[i][j]);
                        JLabel label = new JLabel("Square " + (9 - i) + "" + (9 - j));
                        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        panelHolder[i][j].add(label);
                    }else {
                        JPanel panel = new JPanel();
                        panel.setPreferredSize(new Dimension(50,50));
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
        // Adding the "Roll Dice" button
        JButton button1 = new JButton("Roll Dice");
        button1.setBounds(20,250, 100, 62);
        boardPanel2.add(button1);
        // adding the action listener to the "Roll Dice" button
        button1.addActionListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Creating and populating the fileMenu while also adding action listeners
     */
    private void createFileMenu(){
        // adding the drop-down items for file menu and assigning each an action listener
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

    /**
     * Creating and populating the playerMenu while also adding action listeners
     */
    private void createPlayerMenu(){
        // adding the drop-down items for player menu and assigning each an action listener
        playerMenu = new JMenu("Player");
        JMenuItem item;
        item = new JMenuItem("Add");
        item.addActionListener(this);
        playerMenu.add(item);
        item = new JMenuItem("Display");
        item.addActionListener(this);
        playerMenu.add(item);
    }

    /**
     * Adding a player to the game
     */
    public void addPlayer() {
        String name = JOptionPane.showInputDialog("Enter Name");
        players.add(new Player(name));
        // launching the token selection GUI
        ColourGUI frame = new ColourGUI();
        frame.setVisible(true);
    }

    /**
     * Displaying player details
     */
    public void displayPlayers() {
        String playerDetails = "";
        // iterating through the players arraylist using an enhanced for-loop
        for(Player p : players) {
            playerDetails += p.toString();
        }
        JOptionPane.showMessageDialog(null, playerDetails);
    }

    /**
     * Starting a new game
     */
    public void newGame(){
        // resetting the the players list on launch of a new game
        players = new ArrayList<>();
        count = 0;
        JOptionPane.showMessageDialog(null, "New Game started feel free to add a few players");
    }

    /**
     * Creating the functionality for each of the action listeners created
     */
    public void actionPerformed(ActionEvent e) {
        // setting what happens on the occurrence of each event
        if(e.getActionCommand().equals("Roll Dice")) {
            if(players.size() == 0) {
                // Reminding the user to add a player before starting the game
                JOptionPane.showMessageDialog(null, "You must add a player before they can roll the dice");
            }else {
                int[] coOrds;
                Player player = players.get(counter);
                /*
                 *  calling the convert method from the Convert class to attain the square of the board the player's
                 *  position attribute corresponds to
                 */
                coOrds = Convert.getCoOrds(player);

                // removing the players token image from the square they were previously on
                if(panelHolder[coOrds[0]][coOrds[1]].getComponents().length>1) {
                    panelHolder[coOrds[0]][coOrds[1]].remove(panelHolder[coOrds[0]][coOrds[1]].getComponents()[1]);
                }
                // updating the board
                repaint();
                validate();

                // player rolls the dice
                player.rollDice();

                JLabel bluePiece = new JLabel(blue);
                JLabel redPiece = new JLabel(red);
                JLabel greenPiece = new JLabel(green);
                JLabel yellowPiece = new JLabel(yellow);

                currentBluePiece = bluePiece;
                currentRedPiece = redPiece;
                currentGreenPiece = greenPiece;
                currentYellowPiece = yellowPiece;

                // call on method to determine if the player landed on a snake/ladder/default square
                DetermineSquareType.determineSquareType(player);

                coOrds = Convert.getCoOrds(player);

                // paint the player's game piece image onto their current square number
                if(player.getToken().getColour().equals("Blue")) {
                    panelHolder[coOrds[0]][coOrds[1]].add(bluePiece);
                }else if(player.getToken().getColour().equals("Red")) {
                    panelHolder[coOrds[0]][coOrds[1]].add(redPiece);
                }else if(player.getToken().getColour().equals("Green")) {
                    panelHolder[coOrds[0]][coOrds[1]].add(greenPiece);
                }else if(player.getToken().getColour().equals("Yellow")) {
                    panelHolder[coOrds[0]][coOrds[1]].add(yellowPiece);
                }

                repaint();
                validate();

                if(player.isWinner()) {
                    JOptionPane.showMessageDialog(null, "Congrats " + player.getName() + " you win");
                    player.setWins(player.getWins() + 1);
                    // loop to iterate through the arraylist of players to remove their pieces from the board and reset their position
                    for(Player p : players) {
                        coOrds = Convert.getCoOrds(p);
                        String winningColour = player.getToken().getColour();
                        if(p.getToken().getColour().equals(winningColour)) {
                            panelHolder[coOrds[0]][coOrds[1]].remove(panelHolder[coOrds[0]][coOrds[1]].getComponents()[1]);
                            repaint();
                            validate();
                            p.setPosition(90);
                        }else if(!(p.getToken().getColour().equals(winningColour))) {
                            panelHolder[coOrds[0]][coOrds[1]].remove(panelHolder[coOrds[0]][coOrds[1]].getComponents()[1]);
                            repaint();
                            validate();
                            p.setPosition(90);
                        }
                    }
                    player.setWinner(false);
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
            if(players.size() != 0) {
                int[] coOrds;
                for(Player p : players) {
                    coOrds = Convert.getCoOrds(p);
                    panelHolder[coOrds[0]][coOrds[1]].remove(panelHolder[coOrds[0]][coOrds[1]].getComponents()[1]);
                    repaint();
                    validate();
                }
            }
            newGame();
        }else if(e.getActionCommand().equals("Save")) {
            try {
                // write the objects i.e. the players to a file
                InputOutput.objectOutputStream();
            } catch (Exception e1) {
                // error message if there is a problem with the write
                JOptionPane.showMessageDialog(null, "Error saving the file!");
            }
        }else if(e.getActionCommand().equals("Open")) {
            try {
                // read the file back into the program
                InputOutput.objectInputStream();
            } catch (Exception e1) {
                // error message if there is a problem with the read
                JOptionPane.showMessageDialog(null, "Error opening the file!");
            }
        }else if(e.getActionCommand().equals("Quit")) {
            System.exit(0);
        }
    }
}

