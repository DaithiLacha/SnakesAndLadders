import java.io.Serializable;

public abstract class Person implements PlayerActions, Serializable {
    private String name;

    /**
     * No argument constructor for Person
     */
    public Person() {
        this("Unknown");
    }

    /**
     * Single-argument constructor for Person
     */
    Person(String name) {
        setName(name);
    }

    /**
     * Accessor method for the name
     */
    String getName() {
        return name;
    }


    /**
     * Mutator method for the name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Abstract rollDice Method
     */
    public abstract void rollDice();

    /**
     * toString method for a person
     */
    public String toString() {
        return "Name: " + getName();
    }
}
