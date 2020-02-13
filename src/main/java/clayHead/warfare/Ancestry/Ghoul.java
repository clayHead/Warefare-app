package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;
import clayHead.warfare.Dice;

public class Ghoul extends Unit {
    // TODO green and regular troops need to make DC15 morale to attack

    public Ghoul() {
        super();
        this.setName("Default Ghoul");
        this.addAttack(-1);
        this.addDefense(2);
        this.addToughness(2);
    }

    public Ghoul(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(-1);
        this.addDefense(2);
        this.addToughness(2);
    }

    public String toString() {
        return this.name + ", a unit of Ghoul " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Ghoul"; }

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
                if (!other.getAncestry().equals("Elf") || !other.getAncestry().equals("Winged-Elf") || other.moraleCheck(15)) {
                    other.exhaust();
                }
                return true;
            }
        }
        else {
            if (Dice.check(this.powerBonus, other.getToughness())) {
                Unit.inflictCasualty(other);
                if (!other.getAncestry().equals("Elf") || !other.getAncestry().equals("Winged-Elf") || other.moraleCheck(15)) {
                    other.exhaust();
                }
                return true;
            }
        }
        return false;
    }
}