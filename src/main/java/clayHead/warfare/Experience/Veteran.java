package clayHead.warfare.Experience;

import clayHead.warfare.Unit;

public class Veteran extends Experience {
    public Veteran(Unit unit) {
        this.experienceAttack = 1;
        this.experiencePower = 0;
        this.experienceDefense = 0;
        this.experienceToughness = 1;
        this.experienceMorale = 3;
        this.unitPointer = unit;
        this.name = "Veteran";

        this.ID = 3;

        this.addStats();
    }
}