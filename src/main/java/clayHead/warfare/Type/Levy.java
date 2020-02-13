package clayHead.warfare.Type;

import clayHead.warfare.Unit;

public class Levy extends Type {
    public Levy(Unit unit) {
        this.typeAttack = 0;
        this.typePower = 0;
        this.typeDefense = 0;
        this.typeToughness = 0;
        this.typeMorale = -1;
        this.costModifier = 0.75;
        this.unitPointer = unit;
        this.name = "Levies";

        this.ID = 0;

        this.addStats();
    }
}
