package clayHead.warfare.Type;

import clayHead.warfare.Unit;

public class Siege extends Type {
    public Siege(Unit unit) {
        this.typeAttack = 1;
        this.typePower = 1;
        this.typeDefense = 0;
        this.typeToughness = 1;
        this.typeMorale = 0;
        this.costModifier = 1.50;
        this.unitPointer = unit;
        this.name = "Siege Engine";

        this.ID = 5;

        this.addStats();
    }
}