package clayHead.warfare.Equipment;

import clayHead.warfare.Unit;

public class Light extends Equipment {
    public Light(Unit unit) {
        this.equipmentAttack = 0;
        this.equipmentPower = 1;
        this.equipmentDefense = 1;
        this.equipmentToughness = 0;
        this.equipmentMorale = 0;
        this.unitPointer = unit;
        this.name = "Light";

        this.ID = 0;

        this.addStats();
    }
}
