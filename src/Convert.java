import javax.swing.*;

/*
 * Created by t00196827 on 21/11/2017.
 */
public class Convert {
//    public static void main(String[] args) {
//        Player bob = new Player("Bob");
//        int[] coOrds;
//        for(int i = 0; i < 5; i++) {
//            coOrds = convert(bob);
//            JOptionPane.showMessageDialog(null, "Bob's position: " + bob.getPosition());
//            JOptionPane.showMessageDialog(null, "Bob's square number " + coOrds[0] + "" + coOrds[1]);
//            bob.rollDice();
//            coOrds = convert(bob);
//            JOptionPane.showMessageDialog(null, "Bob's position: " + bob.getPosition());
//            JOptionPane.showMessageDialog(null, "Bob's square number " + coOrds[0] + "" + coOrds[1]);
//        }
//    }
    public static int[] convert(Player p) {
        int position, squareNum;
        int[] coOrds = new int[2];
        position = p.getPosition();
        if(position > 89 && position < 100) {
            squareNum = (position - 90);
            coOrds[0] = 0;
            coOrds[1] = squareNum % 10;
        }else if(position > 79 && position < 90) {
            coOrds[0] = 1;
            coOrds[1] = 9 - (position % 10);
        }else if(position > 69 && position < 80) {
            squareNum = (position - 50);
            coOrds[0] = 2;
            coOrds[1] = squareNum % 10;
        }else if(position > 59 && position < 70) {
            coOrds[0] = 3;
            coOrds[1] = 9 - (position % 10);
        }else if(position > 49 && position < 60) {
            squareNum = (position - 10);
            coOrds[0] = 4;
            coOrds[1] = squareNum % 10;
        }else if(position > 39 && position < 50) {
            coOrds[0] = 5;
            coOrds[1] = 9 - (position % 10);
        }else if(position > 29 && position < 40) {
            squareNum = (position + 30);
            coOrds[0] = 6;
            coOrds[1] = squareNum % 10;
        }else if(position > 19 && position < 30) {
            coOrds[0] = 7;
            coOrds[1] = 9 - (position % 10);
        }else if(position > 9 && position < 20) {
            squareNum = (position + 70);
            coOrds[0] = 8;
            coOrds[1] = squareNum % 10;
        }else if(position >= 0 && position < 10) {
            coOrds[0] = 9;
            coOrds[1] = 9 - (position % 10);
        }

        return coOrds;
    }
    public static int convertSquareNumtoPosition(int[] coOrds) {
        String num = coOrds[0] + "" + coOrds[1];
        int number = Integer.parseInt(num);
        if(number > -1 && number < 10) {
            return (number + 90);
        }else if(number > 9 && number < 20) {
            coOrds[0] = 8;
            coOrds[1] = (9 - (coOrds[1]%10));
            num = coOrds[0] + "" + coOrds[1];
            number = Integer.parseInt(num);
            return number;
        }else if(number > 19 && number < 30) {
            return (number + 50);
        }else if(number > 29 && number < 40) {
            coOrds[0] = 6;
            coOrds[1] = (9 - (coOrds[1]%10));
            num = coOrds[0] + "" + coOrds[1];
            number = Integer.parseInt(num);
            return number;
        }else if(number > 39 && number < 50) {
            return (number + 10);
        }else if(number > 49 && number < 60) {
            coOrds[0] = 4;
            coOrds[1] = (9 - (coOrds[1]%10));
            num = coOrds[0] + "" + coOrds[1];
            number = Integer.parseInt(num);
            return number;
        }else if(number > 59 && number < 70) {
            return (number - 30);
        }else if(number > 69 && number < 80) {
            coOrds[0] = 2;
            coOrds[1] = (9 - (coOrds[1]%10));
            num = coOrds[0] + "" + coOrds[1];
            number = Integer.parseInt(num);
            return number;
        }else if(number > 79 && number < 90) {
            return (number - 70);
        }else {
            coOrds[0] = 0;
            coOrds[1] = (9 - (coOrds[1]%10));
            num = "" + coOrds[0] + "" + coOrds[1];
            number = Integer.parseInt(num);
            return number;
        }
    }

    public static void main(String[] args) {
        System.out.println(convertSquareNumtoPosition(new int[] {9,0}));
    }
}
