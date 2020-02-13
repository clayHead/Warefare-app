package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;

public class Dragonborn extends Unit {
    // TODO Courageous
    private boolean usedCourageous = false;

    public Dragonborn() {
        super();
        this.setName("Default Dragonborn");
        this.addAttack(2);
        this.addPower(2);
        this.addDefense(1);
        this.addToughness(1);
        this.addMorale(1);
    }

    public Dragonborn(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(2);
        this.addPower(2);
        this.addDefense(1);
        this.addToughness(1);
        this.addMorale(1);
    }

    public String toString() {
        return this.name + ", a unit of Dragonborn " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Dragonborn"; }

    public void useCourageous() { this.usedCourageous = false; }
}