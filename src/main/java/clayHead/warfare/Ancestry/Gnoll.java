package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;
import clayHead.warfare.Dice;

public class Gnoll extends Unit {
    public Gnoll() {
        super();
        this.setName("Default Gnoll");
        this.addAttack(2);
        this.addMorale(1);
    }

    public Gnoll(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(2);
        this.addMorale(1);
    }

    public String toString() {
        return this.name + ", a unit of Gnoll " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Gnoll"; }

    protected boolean power(Unit other, boolean crit) {
        if (crit) {
            // Count num of power check successes
            int successes = 0;
            if (Dice.check(this.powerBonus, other.getToughness())) {
                Unit.inflictCasualty(other);
                successes += 1;
            }
            if (Dice.check(this.powerBonus, other.getToughness())) {
                Unit.inflictCasualty(other);
                successes += 1;
            }
            if (successes >= 1) {
                if (other.isDiminished()) { this.frenzy(other); }
                return true;
            }
        }
        else {
            if (Dice.check(this.powerBonus, other.getToughness())) {
                Unit.inflictCasualty(other);
                if (other.isDiminished()) { this.frenzy(other); }
                return true;
            }
        }
        return false;
    }

    private boolean frenzy(Unit other) {
        if (Dice.check(this.attackBonus, other.getDefense())) {
            if (Dice.check(this.powerBonus, other.getToughness())) {
                Unit.inflictCasualty(other);
                return true;
            }
        }
        return false;
    }
}