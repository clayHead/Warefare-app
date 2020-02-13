package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;

public class Human extends Unit {
    private boolean usedCourageous = false;

    public Human() {
        super();
        this.setName("Default Human");
        this.addAttack(2);
        this.addMorale(1);
    }
    
    public Human(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(2);
        this.addMorale(1);
    }

    public String toString() {
        return this.name + ", a unit of Human " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Human"; }

    public void useCourageous() { this.usedCourageous = false; }
}