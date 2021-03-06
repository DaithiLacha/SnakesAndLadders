/*
 * Created by David O'Connor T00196827
 */
import javax.swing.*;

public class DetermineSquareType {
    /**
     * Method to determine what kind of square the player has landed on and what to do afterwards
     * depending on result
     */
    static void determineSquareType(Player p) {
        int[] pos = Convert.convert(p);
        if((pos[0] != 0) && (pos[0] % 2 == 0) && (pos[1] == 9)) {
            // call the snake method
            snake(p);
            //recall the determineSquareType method after landing on a snake
            determineSquareType(p);
        }else if((pos[0] % 2 != 0) && (pos[1] == 5)) {
            snake(p);
            determineSquareType(p);
        }else if((pos[0] % 2 == 0) && (pos[1] == 6)) {
            // call the snake method
            ladder(p);
            //recall the determineSquareType method after landing on a snake
            determineSquareType(p);
        }else if((pos[0] < 9) && (pos[0] % 2 != 0) && (pos[1] == 7)) {
            ladder(p);
            determineSquareType(p);
        }else {
            int[] coOrds = Convert.convert(p);
            JOptionPane.showMessageDialog(null, p.getName() + " is on square " + coOrds[0] + "" + coOrds[1]);
        }
    }

    /**
     * Method to move a player backwards after landing on a snake
     */
    private static void snake(Player p) {
        int xCo, yCo;
        int[] coOrds = Convert.convert(p);
        int snakeLength = (int)((Math.random() * 9) + 4);
        if(snakeLength >= 10) {
            xCo = 1;
            yCo = (snakeLength % 10);
            if(coOrds[1] > yCo) {
                coOrds[0] = (coOrds[0] - xCo);
                coOrds[1] = (coOrds[1] - yCo);
            }else {
                coOrds[0] = (coOrds[0] - (xCo + 1));
                coOrds[1] = ((10 + coOrds[1]) - yCo);
            }
        }else {
            xCo = 0;
            yCo = snakeLength;
            if(coOrds[1] > yCo) {
                coOrds[1] = (coOrds[1] - yCo);
            }else {
                coOrds[0] = (coOrds[0] - (xCo + 1));
                coOrds[1] = ((10 + coOrds[1]) - yCo);
            }
        }
        JOptionPane.showMessageDialog(null, "You landed on a snake go back " + snakeLength + " spaces");
        p.setPosition(Convert.convertSquareToPos(coOrds));
    }

    /**
     * Method to move a player forward after landing on a ladder
     */
    private static void ladder(Player p) {
        int  yCo;
        int[] coOrds = Convert.convert(p);
        int ladderLength = (int)((Math.random() * 9) + 4);
        if(ladderLength >= 10) {
            yCo = (ladderLength % 10);
            if((coOrds[1] + yCo) > 9) {
                coOrds[0] = (coOrds[0] + 2);
                coOrds[1] = (coOrds[1] + yCo - 10);
            }else {
                coOrds[0] = (coOrds[0] + 1);
                coOrds[1] = (coOrds[1] + yCo);
            }
        }else {
            yCo = ladderLength;
            if((yCo + coOrds[1]) > 9) {
                coOrds[0] = (coOrds[0] + 1);
                coOrds[1] = (yCo + coOrds[1] - 10);
            }else {
                coOrds[1] = (yCo + coOrds[1]);
            }
        }
        JOptionPane.showMessageDialog(null, "You landed on a ladder advance " + ladderLength + " spaces");
        p.setPosition(Convert.convertSquareToPos(coOrds));
    }
}
