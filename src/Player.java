public class Player extends Person {
    private int position;
    private Token token;

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

    public void rollDice() {
        int roll = (int)((Math.random() * 6) + 1);
        setPosition(getPosition() + roll);
    }

    @Override
    public String toString() {
        return super.toString() +"\nPosition: " + getPosition() + "\nToken: " + getToken().toString();
    }
}
