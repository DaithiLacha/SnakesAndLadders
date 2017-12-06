/*
 * Created by David O'Connor T00196827
 */
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;


public class InputOutput {
    /**
     * Method to write the arraylist of players to a file
     */
    static void objectOutputStream() throws Exception {
        File outFile = new File("objects.data");
        FileOutputStream outFileStream = new FileOutputStream(outFile);
        ObjectOutputStream os = new ObjectOutputStream(outFileStream);

        os.writeObject(SnakesAndLaddersGUI.players);

        os.close();
    }

    /**
     * Method to read the arraylist of players from a file
     */
    static void objectInputStream() throws Exception {
        File inFile = new File("objects.data");
        FileInputStream inFileStream = new FileInputStream(inFile);
        ObjectInputStream in = new ObjectInputStream(inFileStream);

        //Got Code from https://stackoverflow.com/questions/16111496/java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the
        ArrayList<Player> players = (ArrayList<Player>) in.readObject();
        //End of Referenced Code
        String display = "";
        for(Player p : players) {
            display += p.toString();
        }
        JOptionPane.showMessageDialog(null, display);
        in.close();
    }
}
