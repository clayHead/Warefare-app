package clayHead.warfare.Equipment;

import clayHead.warfare.Unit;

public class SuperHeavy extends Equipment {
    public SuperHeavy(Unit unit) {
        this.equipmentAttack = 0;
        this.equipmentPower = 6;
        this.equipmentDefense = 6;
        this.equipmentToughness = 0;
        this.equipmentMorale = 0;
        this.unitPointer = unit;
        this.name = "Super-Heavy";

        this.ID = 3;

        this.addStats();
    }
}