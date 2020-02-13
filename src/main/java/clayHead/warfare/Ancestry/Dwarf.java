package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;

public class Dwarf extends Unit {
    // TODO disadvantage for battle against Dwarf

    public Dwarf() {
        super();
        this.setName("Default Dwarf");
        this.addAttack(3);
        this.addPower(1);
        this.addDefense(1);
        this.addToughness(1);
        this.addMorale(2);
    }

    public Dwarf(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(3);
        this.addPower(1);
        this.addDefense(1);
        this.addToughness(1);
        this.addMorale(2);
    }

    public String toString() {
        return this.name + ", a unit of Dwarf " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Dwarf"; }
}