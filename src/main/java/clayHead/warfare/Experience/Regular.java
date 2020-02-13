package clayHead.warfare.Experience;

import clayHead.warfare.Unit;

public class Regular extends Experience {
    public Regular(Unit unit) {
        this.experienceAttack = 1;
        this.experiencePower = 0;
        this.experienceDefense = 0;
        this.experienceToughness = 1;
        this.experienceMorale = 1;
        this.unitPointer = unit;
        this.name = "Regular";

        this.ID = 1;

        this.addStats();
    }
}
