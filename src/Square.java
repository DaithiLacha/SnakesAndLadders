public class Square implements SquareActions {
    private String name;
    private int squareNum;
    private int move;

    public Square() {
        this(0);
    }

    public Square(int squareNum) {
        setName("Default");
        setSquareNum(squareNum);
        setMove(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSquareNum() {
        return squareNum;
    }

    public void setSquareNum(int squareNum) {
        this.squareNum = squareNum;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int change) {
        this.move = change;
    }

    public void movePlayer(Player p) {

    }

    @Override
    public String toString() {
        return "Square Type: " + getName() + "\nSquare Number: " + getSquareNum();
    }
}
