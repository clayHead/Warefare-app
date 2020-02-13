package clayHead.warfare.Experience;

import clayHead.warfare.Unit;

public class Seasoned extends Experience {
    public Seasoned(Unit unit) {
        this.experienceAttack = 1;
        this.experiencePower = 0;
        this.experienceDefense = 0;
        this.experienceToughness = 1;
        this.experienceMorale = 2;
        this.unitPointer = unit;
        this.name = "Seasoned";

        this.ID = 2;

        this.addStats();
    }
}