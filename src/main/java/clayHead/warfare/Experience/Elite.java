package clayHead.warfare.Experience;

import clayHead.warfare.Unit;

public class Elite extends Experience {
    public Elite(Unit unit) {
        this.experienceAttack = 2;
        this.experiencePower = 0;
        this.experienceDefense = 0;
        this.experienceToughness = 2;
        this.experienceMorale = 4;
        this.unitPointer = unit;
        this.name = "Elite";

        this.ID = 4;

        this.addStats();
    }
}