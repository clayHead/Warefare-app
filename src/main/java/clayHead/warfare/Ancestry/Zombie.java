package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;

public class Zombie extends Unit {
    public Zombie() {
        super();
        this.setName("Default Zombie");
        this.addAttack(-2);
        this.addDefense(2);
        this.addToughness(2);
        this.addMorale(2);
    }

    public Zombie(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(-2);
        this.addDefense(2);
        this.addToughness(2);
        this.addMorale(2);
    }

    public String toString() {
        return this.name + ", a unit of Zombie " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Zombie"; }

    public boolean moraleCheck(int DC) {
        return true;
    }

    public boolean moraleCheck(int DC, boolean advantage) {
        return true;
    }
}