package clayHead.warfare.Ancestry;

import clayHead.warfare.Unit;
import clayHead.warfare.Type.Siege;
import clayHead.warfare.Equipment.Light;
import clayHead.warfare.Experience.Green;

public class Treant extends Unit {
    public Treant() {
        this.sizeMax = 6;
        this.sizeCurrent = this.sizeMax;
        this.diminished = false;
        this.exhausted = false;
        this.rallied = false;

        this.experience = new Green(this);
        this.equipment = new Light(this);
        this.type = new Siege(this);

        this.calculateCost();
        this.setName("Default Treant");
        this.addPower(2);
        this.addToughness(2);
    }

    public Treant(String name, int size, int expID, int equID, int typeID) {
        super(name, size, expID, equID, 5); // Treants are always siege engines
        this.addPower(2);
        this.addToughness(2);
    }

    public String toString() {
        return this.name + ", a unit of Treant " + this.experience.toString() + " " +
                this.equipment.toString() + " " + this.type.toString();
    }

    public String getAncestry() { return "Treant"; }
}