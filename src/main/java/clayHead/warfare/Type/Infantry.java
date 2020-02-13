package clayHead.warfare.Type;

import clayHead.warfare.Unit;

public class Infantry extends Type {
    public Infantry(Unit unit) {
        this.typeAttack = 0;
        this.typePower = 0;
        this.typeDefense = 1;
        this.typeToughness = 1;
        this.typeMorale = 0;
        this.costModifier = 1;
        this.unitPointer = unit;
        this.name = "Infantry";

        this.ID = 1;

        this.addStats();
    }
}
