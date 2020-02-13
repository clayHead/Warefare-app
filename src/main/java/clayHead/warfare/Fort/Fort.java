package clayHead.warfare.Fort;

import clayHead.warfare.BattlefieldEntity;

public abstract class Fort extends BattlefieldEntity {
    public String getSubType() { return "Fort"; }

    protected int level;
    int moralBonus;

    public Fort() {}

    public abstract String toString();

    /**
     * Internal function for an entity to take a casualty.
     */
    protected void takeCasualty() {
        this.decrementDie();
    }

    /**
     * Internal fucntion to decrement die (reduce size)
     */
    protected void decrementDie() {
        this.sizeCurrent -= 1;
    }

    /**
     * Internal function to increment die
     */
    protected void incrementDie() {
        this.sizeCurrent += 1;
    }
}