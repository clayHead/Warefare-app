package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;

public class Troll extends Unit {
    private boolean takenMagic = false; // TODO: set magic flag

    public Troll() {
        super();
        this.setName("Default Troll");
        this.addPower(2);
        this.addToughness(2);
    }

    public Troll(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addPower(2);
        this.addToughness(2);
    }

    public String toString() {
        return this.name + ", a unit of Troll " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Troll"; }

    protected void refresh() { 
        this.incrementDie();
        this.exhausted = false; 
    }
}