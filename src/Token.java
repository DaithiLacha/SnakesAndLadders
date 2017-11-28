import java.io.Serializable;

public class Token implements Serializable {
    private String colour;

    public Token() {
        this("Unspecified");
    }

    public Token(String colour) {
        setColour(colour);
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Token colour: " + getColour();
    }
}
