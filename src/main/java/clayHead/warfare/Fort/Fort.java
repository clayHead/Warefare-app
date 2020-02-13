package clayHead.warfare.Fort;

import clayHead.warfare.BattlefieldEntity;

public abstract class Fort extends BattlefieldEntity {
    public String getSubType() { return "Fort"; }
    
    /*
     * These functions are so functionality of previosly exsisting code before the battlefieldentity class is okay
     */
    public String getType() { return "Fort"; }
    public String getAncestry() { return "None"; }
    public boolean moraleCheck(int DC) {return false; }
    protected boolean isExhausted() {return false; }
    protected void refresh() {}

    protected int level;
    int moralBonus;

    public Fort() {this.name = "Fort";}
    
    public int getDefense() { return 0; }

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