package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;

public class Elf extends Unit {
    // cannot be horrified done in ghoul horrify check
    // TODO doesn't need to make morale check to attack fiends and undead

    public Elf() {
        super();
        this.setName("Default Elf");
        this.addAttack(2);
        this.addMorale(1);
    }

    public Elf(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(2);
        this.addMorale(1);
    }

    public String toString() {
        return this.name + ", a unit of Elf " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Elf"; }
}