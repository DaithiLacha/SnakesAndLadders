import javax.swing.*;
import java.io.Serializable;
import java.util.Arrays;

public class Player extends Person implements Serializable {
    private int position;
    private Token token;
    private int wins;
    private boolean winner;

    /**
     * No argument constructor for Player
     */
    public Player() {
       this("Unknown");
    }

    /**
     * Single argument constructor for Player
     */
    public Player(String name) {
        super(name);
        setToken(new Token());
        setPosition(90);
        setWinner(false);
        setWins(0);
    }

    /**
     * Accessor method for the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Mutator method for the position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Accessor method for the token
     */
    public Token getToken() {
        return token;
    }

    /**
     * Mutator method for the token
     */
    public void setToken(Token token) {
        this.token = token;
    }

    /**
     * Accessor method for the wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Mutator method for the wins
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * Accessor method for the winner
     */
    public boolean isWinner() {
        return winner;
    }

    /**
     * Mutator method for the winner
     */
    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    /**
     * Method to allow the player to roll the dice and advance based on the roll
     */
    public void rollDice() {
        int roll = (int)((Math.random() * 6) + 1);
        JOptionPane.showMessageDialog(null, getName() + " rolled a " + roll);
        // Making it that the player cannot advance outside the bounds of the array
        if(getPosition() >= 0 && getPosition() < 7) {
            if((getPosition() - roll) < 0) {
                JOptionPane.showMessageDialog(null, "You must get the correct roll to finish");
            } else {
                setPosition(getPosition() - roll);
                if (getPosition() == 0) {
                    setWinner(true);
                }
            }
        }else if((getPosition() % 20) > 9) {
            // adjusting the effect of the advance on roll when the player is advancing left on the board
            setPosition(getPosition() + roll);
            if((getPosition() % 20) < 10) {
                setPosition((getPosition() - (10 + (getPosition() % 10))) - (getPosition() - (getPosition() - ((getPosition() % 10) + 1))));
            }
        }else if((getPosition() % 20) < 10) {
            // adjusting the effect of the advance on roll when the player is advancing right on the board
            setPosition(getPosition() - roll);
            if((getPosition() % 20) > 9) {
                setPosition((getPosition() - (getPosition() % 10)) + ((getPosition() - (getPosition() % 10) + 9) - (getPosition())));
            }
        }
    }

    /**
     * toString method for the player
     */
    @Override
    public String toString() {
        return "Name: " + getName() +"\nPosition: " + Arrays.toString(Convert.convert(this)).replace("[","").replace("]","").replace(", ", "")
                + "\n" + getToken().toString() + "\nWins: " + getWins() + "\n\n";
    }
}
