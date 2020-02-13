package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;

public class Kobold extends Unit {
    public Kobold() {
        super();
        this.setName("Default Kobold");
        this.addAttack(-1);
        this.addPower(-1);
        this.addDefense(1);
        this.addToughness(-1);
        this.addMorale(-1);
    }

    public Kobold(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(-1);
        this.addPower(-1);
        this.addDefense(1);
        this.addToughness(-1);
        this.addMorale(-1);
    }

    public String toString() {
        return this.name + ", a unit of Kobold " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Kobold"; }
}