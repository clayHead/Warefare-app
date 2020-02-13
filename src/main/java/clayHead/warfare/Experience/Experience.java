package clayHead.warfare.Experience;

import clayHead.warfare.Unit;

public abstract class Experience {
    int experienceAttack;
    int experiencePower;
    int experienceDefense;
    int experienceToughness;
    int experienceMorale;
    Unit unitPointer;
    String name;

    // ID is used to identify the class when making a unit in Unit constructor
    // 0- green. 1- regular. 2- seasoned. 3- veteran. 4- elite. 5- super-elite
    public int ID;

    // Called in inherited class constructor. A unit will contain an experience level
    void addStats() {
        unitPointer.addAttack(experienceAttack);
        unitPointer.addPower(experiencePower);
        unitPointer.addDefense(experienceDefense);
        unitPointer.addToughness(experienceToughness);
        unitPointer.addMorale(experienceMorale);
    }

    public void setUnitPointer(Unit unit) { this.unitPointer = unit; }

    public String toString() {
        return this.name;
    }

    public String getExperience() {
        return this.name;
    }
}
