/*
 * Created by t00196827 on 21/11/2017.
 */
public class Convert {
    public static String convert(Player p) {
        int position, squareNum;
        String squareNumAsString = "";
        position = p.getPosition();

        if(position > 89 && position < 100) {
            squareNum = (position - 90);
            squareNumAsString = ("0" + squareNum);
        }else if(position > 79 && position < 90) {
            switch (position) {
                case 80:
                    squareNum = (position - 61);
                    break;
                case 81:
                    squareNum = (position - 63);
                    break;
                case 82:
                    squareNum = (position - 65);
                    break;
                case 83:
                    squareNum = (position - 67);
                    break;
                case 84:
                    squareNum = (position - 69);
                    break;
                case 85:
                    squareNum = (position - 71);
                    break;
                case 86:
                    squareNum = (position - 73);
                    break;
                case 87:
                    squareNum = (position - 75);
                    break;
                case 88:
                    squareNum = (position - 77);
                    break;
                default:
                    squareNum = (position - 79);
            }
            squareNumAsString = ("" + squareNum);
        }else if(position > 69 && position < 80) {
            squareNum = (position - 50);
            squareNumAsString = ("" + squareNum);
        }else if(position > 59 && position < 70) {
            switch (position) {
                case 60:
                    squareNum = (position - 21);
                    break;
                case 61:
                    squareNum = (position - 23);
                    break;
                case 62:
                    squareNum = (position - 25);
                    break;
                case 63:
                    squareNum = (position - 27);
                    break;
                case 64:
                    squareNum = (position - 29);
                    break;
                case 65:
                    squareNum = (position - 31);
                    break;
                case 66:
                    squareNum = (position - 33);
                    break;
                case 67:
                    squareNum = (position - 35);
                    break;
                case 68:
                    squareNum = (position - 37);
                    break;
                default:
                    squareNum = (position - 39);
            }
            squareNumAsString = ("" + squareNum);
        }else if(position > 49 && position < 60) {
            squareNum = (position - 10);
            squareNumAsString = ("" + squareNum);
        }else if(position > 39 && position < 50) {
            switch (position) {
                case 40:
                    squareNum = (position + 19);
                    break;
                case 41:
                    squareNum = (position + 17);
                    break;
                case 42:
                    squareNum = (position + 15);
                    break;
                case 43:
                    squareNum = (position + 13);
                    break;
                case 44:
                    squareNum = (position + 11);
                    break;
                case 45:
                    squareNum = (position + 9);
                    break;
                case 46:
                    squareNum = (position + 7);
                    break;
                case 47:
                    squareNum = (position + 5);
                    break;
                case 48:
                    squareNum = (position + 3);
                    break;
                default:
                    squareNum = (position + 1);
            }
            squareNumAsString = ("" + squareNum);
        }else if(position > 29 && position < 40) {
            squareNum = (position + 30);
            squareNumAsString = ("" + squareNum);
        }else if(position > 19 && position < 30) {
            switch (position) {
                case 20:
                    squareNum = (position + 59);
                    break;
                case 21:
                    squareNum = (position + 57);
                    break;
                case 22:
                    squareNum = (position + 55);
                    break;
                case 23:
                    squareNum = (position + 53);
                    break;
                case 24:
                    squareNum = (position + 51);
                    break;
                case 25:
                    squareNum = (position + 49);
                    break;
                case 26:
                    squareNum = (position + 47);
                    break;
                case 27:
                    squareNum = (position + 45);
                    break;
                case 28:
                    squareNum = (position + 43);
                    break;
                default:
                    squareNum = (position + 41);
            }
            squareNumAsString = ("" + squareNum);
        }else if(position > 9 && position < 20) {
            squareNum = (position + 70);
            squareNumAsString = ("" + squareNum);
        }else if(position >= 0 && position < 10) {
            switch (position) {
                case 0:
                    squareNum = (position + 99);
                    break;
                case 1:
                    squareNum = (position + 97);
                    break;
                case 2:
                    squareNum = (position + 95);
                    break;
                case 3:
                    squareNum = (position + 93);
                    break;
                case 4:
                    squareNum = (position + 91);
                    break;
                case 5:
                    squareNum = (position + 89);
                    break;
                case 6:
                    squareNum = (position + 87);
                    break;
                case 7:
                    squareNum = (position + 85);
                    break;
                case 8:
                    squareNum = (position + 83);
                    break;
                default:
                    squareNum = (position + 18);
            }
            squareNumAsString = ("" + squareNum);
        }

        return squareNumAsString;
    }
}
