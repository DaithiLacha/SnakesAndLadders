public class Snake extends Square{
    public Snake() {
        this(0);
    }

    public Snake(int squareNum) {
        super(squareNum);
        setName("Snake");
        setMove((int)(Math.random()* 10) + 5);
    }

    @Override
    public void movePlayer(Player p) {
        p.setPosition(p.getPosition() - getMove());
    }

    @Override
    public String toString() {
        return super.toString() + "\nMoves player back " + getMove() + " spaces";
    }
}
