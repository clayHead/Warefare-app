package clayHead.warfare.Type;

import clayHead.warfare.Unit;

public class Archers extends Type {
    public Archers(Unit unit) {
        this.typeAttack = 0;
        this.typePower = 1;
        this.typeDefense = 0;
        this.typeToughness = 0;
        this.typeMorale = 1;
        this.costModifier = 1.75;
        this.unitPointer = unit;
        this.name = "Archers";

        this.ID = 2;

        this.addStats();
    }
}