package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;

public class WingedElf extends Unit {
    public WingedElf() {
        super();
        this.setName("Default Winged-Elf");
        this.addAttack(1);
        this.addPower(1);
        this.addMorale(1);
    }

    public WingedElf(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, typeID);
        this.addAttack(1);
        this.addPower(1);
        this.addMorale(1);
    }

    public String toString() {
        return this.name + ", a unit of Winged-Elf " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Winged-Elf"; }
}