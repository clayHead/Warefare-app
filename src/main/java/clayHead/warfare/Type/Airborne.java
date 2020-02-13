package clayHead.warfare.Type;

import clayHead.warfare.Unit;

public class Airborne extends Type {
    public Airborne(Unit unit) {
        this.typeAttack = 0;
        this.typePower = 0;
        this.typeDefense = 0;
        this.typeToughness = 0;
        this.typeMorale = 3;
        this.costModifier = 2.00;
        this.unitPointer = unit;
        this.name = "Airborne";

        this.ID = 4;

        this.addStats();
    }
}