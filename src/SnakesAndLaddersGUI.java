import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SnakesAndLaddersGUI extends JFrame implements ActionListener {
    JMenu fileMenu;
    ArrayList<Player> players;
    Square[][] board;

    public SnakesAndLaddersGUI() {

    }

    public void newGame() {
        newPlayerSet();
        setBoard();
    }

    public void newPlayerSet() {
        for(int i = 0; i < 4; i++) {
            int ans =JOptionPane.showConfirmDialog(null, "Add new player?",
                    "Add Player", JOptionPane.YES_NO_OPTION);
            while(ans == JOptionPane.YES_OPTION) {
                String name = JOptionPane.showInputDialog("Enter player name");
                String colour = JOptionPane.showInputDialog("Enter token colour");
                players.add(new Player(name, colour));
            }
        }
    }

    public void setBoard() {
        board = new Square[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(i > 1 && (j % 6 == 0)) {
                    String num = "" + i + "" + j;
                    int number = Integer.parseInt(num);
                    board[i][j] = new Snake(number);
                }else if(i < 9 && (j % 3 == 0)) {
                    String num = "" + i + "" + j;
                    int number = Integer.parseInt(num);
                    board[i][j] = new Ladder(number);
                }else {
                    String num = "" + i + "" + j;
                    int number = Integer.parseInt(num);
                    board[i][j] = new Square(number);
                }
            }
        }
    }
}
