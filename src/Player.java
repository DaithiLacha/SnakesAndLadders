import javax.swing.*;
import java.io.Serializable;

public class Player extends Person implements Serializable {
    private int position;
    private int wins = 0;
    private Token token;
    protected boolean winner;

    public Player() {
       this("Unknown");
    }

    public Player(String name) {
        super(name);
        setToken(new Token());
        setPosition(90);
        setWinner(false);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean isWinner() {
        return winner;
    }

    public void rollDice() {
        int roll = (int)((Math.random() * 6) + 1);
        JOptionPane.showMessageDialog(null, getName() + " rolled a " + roll);
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
            setPosition(getPosition() + roll);
            if((getPosition() % 20) < 10) {
                setPosition((getPosition() - (10 + (getPosition() % 10))) - (getPosition() - (getPosition() - ((getPosition() % 10) + 1))));
            }
        }else if((getPosition() % 20) < 10) {
            setPosition(getPosition() - roll);
            if((getPosition() % 20) > 9) {
                setPosition((getPosition() - (getPosition() % 10)) + ((getPosition() - (getPosition() % 10) + 9) - (getPosition())));
            }
        }
    }

    @Override
    public String toString() {
        return "Name: " + getName() +"\nPosition: " + getPosition() + "\n" + getToken().toString() + "\n\n";
    }
}
