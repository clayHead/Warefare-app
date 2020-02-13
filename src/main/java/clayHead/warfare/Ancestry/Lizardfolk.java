package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;

public class Lizardfolk extends Unit {
    public Lizardfolk() {
        super();
        this.setName("Default Lizardfolk");
        this.addAttack(2);
        this.addPower(1);
        this.addDefense(-1);
        this.addToughness(1);
        this.addMorale(1);
    }

    public Lizardfolk(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(2);
        this.addPower(1);
        this.addDefense(-1);
        this.addToughness(1);
        this.addMorale(1);
    }

    public String toString() {
        return this.name + ", a unit of Lizardfolk " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Lizardfolk"; }
}