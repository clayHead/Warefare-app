package clayHead.warfare.Equipment;

import clayHead.warfare.Unit;

public class Heavy extends Equipment {
    public Heavy(Unit unit) {
        this.equipmentAttack = 0;
        this.equipmentPower = 4;
        this.equipmentDefense = 4;
        this.equipmentToughness = 0;
        this.equipmentMorale = 0;
        this.unitPointer = unit;
        this.name = "Heavy";

        this.ID = 2;

        this.addStats();
    }
}