public class Square implements SquareActions {
    private int squareNum;
    private int move;

    public Square() {
        this(0);
    }

    public Square(int squareNum) {
        setSquareNum(squareNum);
        setMove((int)(Math.random()* 10) + 5);
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

    public void movePlayer() {

    }
    
    @Override
    public String toString() {
        return "Square Number: " + getSquareNum();
    }
}
