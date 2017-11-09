public class Ladder extends Square{
    public Ladder() {
        this(0);
    }

    public Ladder(int squareNum) {
        setSquareNum(squareNum);
        setName("Ladder");
        setMove((int)(Math.random()* 10) + 5);
    }

    @Override
    public void movePlayer(Player p) {
        p.setPosition(p.getPosition() + getMove());
    }

    @Override
    public String toString() {
        return super.toString() + "\nMoves player back " + getMove() + " spaces";
    }
}
