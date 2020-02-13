package clayHead.warfare.Ancestry;

import clayHead.warfare.Dice;
import clayHead.warfare.Unit;

public class Bugbear extends Unit {
    public Bugbear() {
        super();
        this.setName("Default Bugbear");
        this.addAttack(2);
        this.addMorale(1);
    }

    public Bugbear(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(2);
        this.addMorale(1);
    }

    public String toString() {
        return this.name + ", a unit of Bugbear " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }
    
    public String getAncestry() { return "Bugbear"; }

    protected boolean power(Unit other, boolean crit) {
        if (crit) {
            // Count num of power check successes
            int successes = 0;
            if (Dice.check(this.powerBonus, other.getToughness())) {
                if (this.sizeCurrent > other.getSize()) {
                    Unit.inflictCasualty(other);
                }
                Unit.inflictCasualty(other);
                successes += 1;
            }
            if (Dice.check(this.powerBonus, other.getToughness())) {
                if (this.sizeCurrent > other.getSize()) {
                    Unit.inflictCasualty(other);
                }
                Unit.inflictCasualty(other);
                successes += 1;
            }
            return successes >= 1;
        }
        else {
            if (Dice.check(this.powerBonus, other.getToughness())) {
                if (this.sizeCurrent > other.getSize()) {
                    Unit.inflictCasualty(other);
                }
                Unit.inflictCasualty(other);
                return true;
            }
        }
        return false;
    }

    
}