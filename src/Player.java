import javax.swing.*;

public class Player extends Person {
    private int position;
    private Token token;
    protected static boolean winner = false;

    public Player() {
       this("Unknown");
    }

    public Player(String name) {
        super(name);
        setPosition(90);
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

    public static void setWinner(boolean winner) {
        Player.winner = winner;
    }

    public void rollDice() {
        int roll = (int)((Math.random() * 6) + 1);
        if(getPosition() >= 90) {
            setPosition(getPosition() + roll);
            if (getPosition() > 99) {
                setPosition(90 - (getPosition() - 99));
            }
        }
        if(getPosition() >= 80) {
            setPosition(getPosition() - roll);
            if (getPosition() < 80) {
                setPosition(70 + (80 - getPosition()));
            }
        }
        if(getPosition() >= 70) {
            setPosition(getPosition() + roll);
            if (getPosition() > 79) {
                setPosition(70 - (getPosition() - 79));
            }
        }
        if(getPosition() >= 60) {
            setPosition(getPosition() - roll);
            if (getPosition() < 60) {
                setPosition(50 + (60 - getPosition()));
            }
        }
        if(getPosition() >= 50) {
            setPosition(getPosition() + roll);
            if (getPosition() > 59) {
                setPosition(50 - (getPosition() - 59));
            }
        }
        if(getPosition() >= 40) {
            setPosition(getPosition() - roll);
            if (getPosition() < 40) {
                setPosition(30 + (40 - getPosition()));
            }
        }
        if(getPosition() >= 30) {
            setPosition(getPosition() + roll);
            if (getPosition() > 39) {
                setPosition(30 - (getPosition() - 39));
            }
        }
        if(getPosition() >= 20) {
            setPosition(getPosition() - roll);
            if (getPosition() < 20) {
                setPosition(10 + (20 - getPosition()));
            }
        }
        if(getPosition() >= 10) {
            setPosition(getPosition() + roll);
            if (getPosition() > 19) {
                setPosition(10 - (getPosition() - 19));
            }
        }
        if(getPosition() >= 0) {
            if ((getPosition() - roll) < 0) {
                JOptionPane.showMessageDialog(null, "You must get the correct roll to finish");
            }else {
                setPosition(getPosition() - roll);
                if(getPosition() == 0) {
                    setWinner(true);
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() +"\nPosition: " + getPosition() + "\nToken: " + getToken().toString() + "\n\n";
    }
}
