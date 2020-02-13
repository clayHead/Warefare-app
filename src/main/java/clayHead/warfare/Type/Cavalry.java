package clayHead.warfare.Type;

import clayHead.warfare.Unit;

public class Cavalry extends Type {
    public Cavalry(Unit unit) {
        this.typeAttack = 1;
        this.typePower = 1;
        this.typeDefense = 0;
        this.typeToughness = 0;
        this.typeMorale = 2;
        this.costModifier = 1.50;
        this.unitPointer = unit;
        this.name = "Cavalry";

        this.ID = 3;

        this.addStats();
    }
}