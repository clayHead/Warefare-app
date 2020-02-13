package clayHead.warfare;

import java.util.ArrayList;

public class Army {
    private int size;
    private ArrayList<Unit> units;
    private ArrayList<Unit> levies;
    private ArrayList<Unit> infantry;
    private ArrayList<Unit> archers;
    private ArrayList<Unit> cavalry;
    private String name;

    private boolean allFresh = true;

    // Default constructor
    public Army() {
        this.units = new ArrayList<Unit>();
        this.levies = new ArrayList<Unit>();
        this.infantry = new ArrayList<Unit>();
        this.archers = new ArrayList<Unit>();
        this.cavalry = new ArrayList<Unit>();
        this.name = "Default Army";
    }
    
    public String toString() {
    	String returnVal =  this.name + " an army consisting of, \n";
    	for (Unit unit : units) {
    		returnVal += unit.toString();
    		returnVal += "\n";
    	}
    	return returnVal;
    }

    /**
     * Call a retreat on the Army. Only able to if all units are fresh.
     * Performs a moral check (with consequences of failure) and removes from battle
     */
    public void retreat() {
        if (this.allFresh()) {
            for(Unit unit : units) {
                unit.moraleCheck(15);
            }
            // TODO Remove from battle
        }
    }

    /**
     * Checks all units and if any are exhausted, set the allFresh variable to be false for O(1) checking later.
     * @return if all units are fresh
     */
    private boolean areFresh() {
        for (Unit unit : units) if (unit.isExhausted()) {
            this.allFresh = false;
            return false;
        }
        return true;
    }

    /**
     * Refreshes all units. Called once all units are exhausted during battle.
     */
    private void refreshAll() {
        for (Unit unit : units) unit.refresh();
        allFresh = true;
    }

    /**
     * Adds unit to the units Arraylist and appropiate specific Arraylist to check battlefield conditions.
     * Will not add if another unit has the same name
     * Operates in time O(x) because the name checking most itterate through all units
     * @param unit Unit to be added
     */
    public void add(Unit unit) { 
        if (checkName(unit.getName())) {
            unit.setArmy(this);
            this.units.add(unit);
            String type = unit.getType();
            if (type.equals("Levies")) this.levies.add(unit);
            else if (type.equals("Infantry")) this.infantry.add(unit);
            else if (type.equals("Archers")) this.archers.add(unit);
            else if (type.equals("Cavalry")) this.cavalry.add(unit);
        }
        else {
            System.out.println("Error: Unit with that name already in Army.");
        }
    }

    /**
     * Internal function to itterate through names of units and checks units against
     *  param name. Returns false if it finds a duplicate, otherwise returns true.
     * @param name Name of Unit to be checked against
     * @return if there is no other name
     */
    private boolean checkName(String name) {
        for (Unit unit : this.units) {
            if (name.equals(unit.getName())) return false;
        }
        return true;
    }

    /**
     * Removes a unit from the Arraylist. Used when a unit is defeated in battle.
     * @param unit Unit to be removed
     */
    public void remove(Unit unit) { 
        this.units.remove(unit);
        String type = unit.getType();
        if (type.equals("Levies")) this.levies.remove(unit);
        else if (type.equals("Infantry")) this.infantry.remove(unit);
        else if (type.equals("Archers")) this.archers.remove(unit);
        else if (type.equals("Cavalry")) this.cavalry.remove(unit);
    }

    /**
     * Checks if there are levies in the army
     * @return if there are levies
     */
    public boolean areLevies() { return this.levies.size() > 0; }

    /**
     * Checks if there are infantry in the army
     * @return if there are infantry
     */
    public boolean areInfantry() { return this.infantry.size() > 0; }

    /**
     * Checks if there are archers in the army
     * @return if there are archers
     */
    public boolean areArchers() { return this.archers.size() > 0; }

    /**
     * Checks if there are cavalry in the army
     * @return if there are cavalry
     */
    public boolean areCavalry() { return this.cavalry.size() > 0; }

    /**
     * Checks if all units are fresh and able to recieve an order.
     * @return if all units are fresh
     */
    public boolean allFresh() { return this.allFresh; }

    /**
     * Sets the name of the Army
     * @param name New name
     */
    void setName(String name) { this.name = name; }

    /**
     * Get how many units total in army
     * @return How many units total
     */
    public int getLength() { return units.size(); }
}
