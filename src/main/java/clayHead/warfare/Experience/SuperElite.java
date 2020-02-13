package clayHead.warfare.Experience;

import clayHead.warfare.Unit;

public class SuperElite extends Experience {
    public SuperElite(Unit unit) {
        this.experienceAttack = 2;
        this.experiencePower = 0;
        this.experienceDefense = 0;
        this.experienceToughness = 2;
        this.experienceMorale = 5;
        this.unitPointer = unit;
        this.name = "Super-Elite";

        this.ID = 5;

        this.addStats();
    }
}