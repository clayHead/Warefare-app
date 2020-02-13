package clayHead.warfare.Type;

import clayHead.warfare.Unit;

public abstract class Type {
    int typeAttack;
    int typePower;
    int typeDefense;
    int typeToughness;
    int typeMorale;
    public double costModifier;
    Unit unitPointer;
    String name;

    // ID is used to identify the class when making a unit in Unit constructor
    // 0- levy. 1- infantry. 2- archer. 3- cavalry. 4- airborne. 5- siege
    public int ID;

    // Called in inherited class constructor. A unit will contain an ancestry
    void addStats() {
        unitPointer.addAttack(typeAttack);
        unitPointer.addPower(typePower);
        unitPointer.addDefense(typeDefense);
        unitPointer.addToughness(typeToughness);
        unitPointer.addMorale(typeMorale);
    }

    public void setUnitPointer(Unit unit) { this.unitPointer = unit; }

    // Used in Unit.toString()
    public String toString() {
        return this.name;
    }

    public String getType() { return this.name; }
}
