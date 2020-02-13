package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;
import clayHead.warfare.Dice;

public class Ogre extends Unit {
    public Ogre() {
        super();
        this.setName("Default Ogre");
        this.addPower(2);
        this.addDefense(0);
        this.addToughness(2);
        this.addMorale(1);
    }

    public Ogre(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addPower(2);
        this.addDefense(0);
        this.addToughness(2);
        this.addMorale(1);
    }

    public String toString() {
        return this.name + ", a unit of Ogre " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Ogre"; }

    protected boolean power(Unit other, boolean crit) {
        if (crit) {
            // Count num of power check successes
            int successes = 0;
            if (Dice.check(this.powerBonus, other.getToughness())) {
                Unit.inflictCasualty(other);
                Unit.inflictCasualty(other);
                successes += 1;
            }
            if (Dice.check(this.powerBonus, other.getToughness())) {
                Unit.inflictCasualty(other);
                Unit.inflictCasualty(other);
                successes += 1;
            }
            return successes >= 1;
        }
        else {
            if (Dice.check(this.powerBonus, other.getToughness())) {
                Unit.inflictCasualty(other);
                Unit.inflictCasualty(other);
                return true;
            }
        }
        return false;
    }
}