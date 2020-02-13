package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;

public class Goblin extends Unit {
    public Goblin() {
        super();
        this.setName("Default Goblin");
        this.addAttack(-1);
        this.addPower(-1);
        this.addDefense(1);
        this.addToughness(-1);
    }

    public Goblin(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(-1);
        this.addPower(-1);
        this.addDefense(1);
        this.addToughness(-1);
    }

    public String toString() {
        return this.name + ", a unit of Goblin " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Goblin"; }
}