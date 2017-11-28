import javax.swing.*;

public class Player extends Person {
    private int position;
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
        if(position >= 0 && position < 7) {
            if ((position - roll) < 0) {
                JOptionPane.showMessageDialog(null, "You must get the correct roll to finish");
            } else {
                position = (position - roll);
                if (position == 0) {
                    setWinner(true);
                }
            }
        }else if ((position % 20) > 9) {
            position = (position + roll);
            if ((position % 20) < 10) {
                position = ((position - (10 + (position % 10))) - (position - (position - ((position % 10) + 1))));
            }
        }else if ((position % 20) < 10) {
            position = (position - roll);
            if ((position % 20) > 9) {
                position = ((position - (position % 10)) + ((position - (position % 10) + 9) - (position)));
            }
        }
    }

    @Override
    public String toString() {
        return "Name: " + getName() +"\nPosition: " + getPosition() + "\n" +getToken().toString() + "\n\n";
    }
}
