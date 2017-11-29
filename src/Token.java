import java.io.Serializable;

public class Token implements Serializable {
    private String colour;

    /**
     * No argument constructor for the token
     */
    public Token() {
        this("Unspecified");
    }

    /**
     * Single argument constructor for the token
     */
    public Token(String colour) {
        setColour(colour);
    }

    /**
     * Accessor method for the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * Mutator method for the colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * toString method for the token
     */
    @Override
    public String toString() {
        return "Token colour: " + getColour();
    }
}
