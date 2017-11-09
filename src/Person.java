public abstract class Person implements PlayerActions {
    protected String name;

    public Person() {
        this("Unknown");
    }

    public Person(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public abstract void rollDice();

    public String toString() {
        return "Name: " + getName();
    }
}
