package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;

public class Gnome extends Unit {
    public Gnome () {
        super();
        this.setName("Default Gnome");
        this.addAttack(1);
        this.addPower(-1);
        this.addDefense(1);
        this.addToughness(-1);
        this.addMorale(1);
    }

    public Gnome(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(1);
        this.addPower(-1);
        this.addDefense(1);
        this.addToughness(-1);
        this.addMorale(1);
    }

    public String toString() {
        return this.name + ", a unit of Gnome " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Gnome"; }
}