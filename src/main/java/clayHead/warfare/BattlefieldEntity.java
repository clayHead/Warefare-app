package clayHead.warfare;

public abstract class BattlefieldEntity {
    protected int toughness = 10;
    protected int sizeCurrent;
    protected int sizeMax;
    Army army;
    protected String name;

    public abstract String getSubType();

    public BattlefieldEntity() {}

    public int getToughness() { return this.toughness; }

    public int getSize() { return this.sizeCurrent; }

    public Army getArmy() { return this.army; }

    protected void setArmy(Army army) { this.army = army; }

    public String getName() { return this.name; }

    protected void setName(String name) { this.name = name; }

    /**
     * Function to take a Casualty. 
     * Used externally if an order inflicts multiple casualties.
     * Calls internal function.
     * @param unit Unit which is taking casualty
     */
    public static void inflictCasualty(BattlefieldEntity entity) {
        entity.takeCasualty();
    }

    /**
     * Internal function for an entity to take a casualty.
     */
    protected abstract void takeCasualty();

    /**
     * Internal function to decrement die (reduce size)
     */
    protected abstract void decrementDie();

    /**
     * Internal function to increment die
     */
    protected abstract void incrementDie();
}