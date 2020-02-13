package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;
import clayHead.warfare.Dice;

public class Hobgoblin extends Unit {
    public Hobgoblin() {
        super();
        this.setName("Default Hobgoblin");
        this.addAttack(2);
        this.addMorale(1);
    }

    public Hobgoblin(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
    }

    public String toString() {
        return this.name + ", a unit of Hobgoblin " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Hobgoblin"; }

    protected void decrementDie() {
        this.sizeCurrent -= 1;
    }

    protected void incrementDie() {
        this.sizeCurrent += 1;
    }

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

    // TODO cannot have disadvantage on morale checks (but can still have advantage)
    boolean moraleCheckAdvantage(int DC, boolean advantage) {
        if (Dice.checkAdvantage(this.moraleBonus, DC, advantage)) {
            System.out.println("Morale check passed!");
            return true;
        }
        System.out.println("Morale check failed!");
        this.decrementDie();
        return false;
    }
}