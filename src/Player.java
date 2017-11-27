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
        JOptionPane.showMessageDialog(null, "You rolled a " + roll);
        if(position >= 90) {
            position = (position + roll);
            if (position > 99) {
                position = (90 - (position - 99));
            }
        }else if(position >= 80) {
            position = (position - roll);
            if (position < 80) {
                position = (70 + (79 - position));
            }
        }else if(position >= 70) {
            position = (position + roll);
            if (position > 79) {
                position = (70 - (position - 79));
            }
        }else if(position >= 60) {
            position = (position - roll);
            if (position < 60) {
                position = (50 + (59 - position));
            }
        }else if(position >= 50) {
            position = (position + roll);
            if (position > 59) {
                position = (50 - (position - 59));
            }
        }else if(position >= 40) {
            position = (position - roll);
            if (position < 40) {
                position = (30 + (39 - position));
            }
        }else if(position >= 30) {
            position = (position + roll);
            if (position > 39) {
                position = (30 - (position - 39));
            }
        }else if(position >= 20) {
            position = (position - roll);
            if (position < 20) {
                position = (10 + (19 - position));
            }
        }else if(position >= 10) {
            position = (position + roll);
            if (position > 19) {
                position = (10 - (position - 19));
            }
        }else if(position >= 0) {
            if ((position - roll) < 0) {
                JOptionPane.showMessageDialog(null, "You must get the correct roll to finish");
            }else {
                position = (position - roll);
                if(position == 0) {
                    setWinner(true);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Name: " + getName() +"\nPosition: " + getPosition() + getToken().toString() + "\n\n";
    }
}
