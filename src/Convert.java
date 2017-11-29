public class Convert {
    /**
     * Method to return the square number corresponding to the player's position attribute value
     */
    public static int[] convert(Player p) {
        int position, squareNum;
        int[] coOrds = new int[2];
        position = p.getPosition();
        if((position % 20) > 9) {
            squareNum = (position - (position - (10 + (position % 10))));
            coOrds[0] = 9 - (position / 10);
            coOrds[1] = squareNum % 10;
        }else if((position % 20) < 10) {
            coOrds[0] = 9 - (position / 10);
            coOrds[1] = 9 - (position % 10);
        }
        return coOrds;
    }

    /**
     * Method to return the player's position attribute value corresponding to square number
     */
    public static int convertSquareNumToPosition(int[] coOrds) {
        String num;
        int number;
        if((coOrds[0] % 2) == 0) {
            coOrds[0] = (9 - coOrds[0]);
            num = coOrds[0] + "" + coOrds[1];
            number = Integer.parseInt(num);
        }else {
            coOrds[0] = (9 - coOrds[0]);
            coOrds[1] = (9 - (coOrds[1]%10));
            num = coOrds[0] + "" + coOrds[1];
            number = Integer.parseInt(num);
        }
        return number;
    }

    /**
     * Method to return array containing the players x & y co-ordinates on the board - used for
     * label removal
     */
    public static int[] getCoOrds(Player p) {
        int xCo;
        int yCo;
        int[] coOrds = new int[2];
        if(p.getPosition() < 10) {
            xCo = 0;
            yCo = p.getPosition();
        }else {
            xCo = (p.getPosition() / 10);
            yCo = (p.getPosition() % 10);
        }
        coOrds[0] = xCo;
        coOrds[1] = yCo;
        return coOrds;
    }
}
