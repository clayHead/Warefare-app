package clayHead.warfare.Equipment;

import clayHead.warfare.Unit;

public class Medium extends Equipment {
    public Medium(Unit unit) {
        this.equipmentAttack = 0;
        this.equipmentPower = 2;
        this.equipmentDefense = 2;
        this.equipmentToughness = 0;
        this.equipmentMorale = 0;
        this.unitPointer = unit;
        this.name = "Medium";

        this.ID = 1;

        this.addStats();
    }
}