package clayHead.warfare.Experience;

import clayHead.warfare.Unit;

public class Green extends Experience {
    public Green(Unit unit) {
        this.experienceAttack = 0;
        this.experiencePower = 0;
        this.experienceDefense = 0;
        this.experienceToughness = 0;
        this.experienceMorale = 0;
        this.unitPointer = unit;
        this.name = "Green";

        this.ID = 0;

        this.addStats();
    }
}