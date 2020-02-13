package clayHead.warfare.Equipment;

import clayHead.warfare.Unit;

public abstract class Equipment {
    int equipmentAttack;
    int equipmentPower;
    int equipmentDefense;
    int equipmentToughness;
    int equipmentMorale;
    Unit unitPointer;
    String name;

    // ID is used to identify the class when making a unit in Unit constructor
    // 0- light. 1- medium. 2- heavy. 3- super-heavy
    public int ID;

    // Called in inherited class constructor. A unit will contain an equipment
    void addStats() {
        unitPointer.addAttack(equipmentAttack);
        unitPointer.addPower(equipmentPower);
        unitPointer.addDefense(equipmentDefense);
        unitPointer.addToughness(equipmentToughness);
        unitPointer.addMorale(equipmentMorale);
    }

    public void setUnitPointer(Unit unit) { this.unitPointer = unit; }

    public String toString() {
        return this.name;
    }

    public String getEquipment() {
        return this.name;
    }
}