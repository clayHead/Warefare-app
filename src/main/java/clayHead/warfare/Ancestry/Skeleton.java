package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;

public class Skeleton extends Unit {
    public Skeleton() {
        super();
        this.setName("Default Skeleton");
        this.addAttack(-2);
        this.addPower(-1);
        this.addDefense(1);
        this.addToughness(1);
        this.addMorale(1);
    }

    public Skeleton(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(-2);
        this.addPower(-1);
        this.addDefense(1);
        this.addToughness(1);
        this.addMorale(1);
    }

    public String toString() {
        return this.name + ", a unit of Skeleton " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Skeleton"; }

    public boolean moraleCheck(int DC) {
        return true;
    }

    public boolean moraleCheck(int DC, boolean advantage) {
        return true;
    }
}
