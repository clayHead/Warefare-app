package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;
import clayHead.warfare.Dice;

public class Orc extends Unit {
    private boolean usedSavage = false;

    public Orc() {
        super();
        this.setName("Default Orc");
        this.addAttack(2);
        this.addPower(1);
        this.addDefense(1);
        this.addToughness(1);
        this.addMorale(2);
    }

    public Orc(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(2);
        this.addPower(1);
        this.addDefense(1);
        this.addToughness(1);
        this.addMorale(2);
    }

    public String toString() {
        return this.name + ", a unit of Orc " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Orc"; }

    public boolean attack(Unit other) {
        if (!this.isExhausted() || !this.engaged || (this.engagedPointer == other)) {
            this.exhausted = true;
            if (!this.usedSavage) {
                this.usedSavage = true;
                return this.attack(other, true);
            }
            else {
                int roll = Dice.roll(this.attackBonus);
                if (roll >= other.getDefense()) {
                    return this.power(other, (roll - this.attackBonus) == 20);
                }
            }
        }
        return false;
    }
}