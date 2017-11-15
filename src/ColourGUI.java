import javax.swing.*;
import java.awt.*;

public class ColourGUI extends JFrame {
    public static void main(String[] args) {
        ColourGUI frame = new ColourGUI();
        frame.setVisible(true);
    }

    public ColourGUI() {
        ImageIcon blue = new ImageIcon("images/bluePiece.png");
        ImageIcon red = new ImageIcon("images/redPiece.png");
        ImageIcon green = new ImageIcon("images/greenPiece.png");
        ImageIcon yellow = new ImageIcon("images/yellowPiece.png");
        setTitle("Select your piece");
        setSize(640, 640);
        Container pane = getContentPane();
        JPanel boardPanel = new JPanel();
        pane.add(boardPanel);
        GridLayout layout = new GridLayout(4,2,2,2);
        boardPanel.setLayout(layout);
        boardPanel.add(new JButton("Green"));
        boardPanel.add(new JLabel(green));
        boardPanel.add(new JButton("Blue"));
        boardPanel.add(new JLabel(blue));
        boardPanel.add(new JButton("Red"));
        boardPanel.add(new JLabel(red));
        boardPanel.add(new JButton("Yellow"));
        boardPanel.add(new JLabel(yellow));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
