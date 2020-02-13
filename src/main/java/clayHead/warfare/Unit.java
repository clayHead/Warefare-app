package clayHead.warfare;

import clayHead.warfare.Equipment.*;
import clayHead.warfare.Experience.*;
import clayHead.warfare.Type.*;

public abstract class Unit extends BattlefieldEntity {
    public String getSubType() { return "Unit"; }

    protected int attackBonus = 0;
    protected int powerBonus = 0;
    protected int defense = 10;
    protected int moraleBonus = 0;
    protected double cost = 0;
    protected boolean diminished;
    protected boolean exhausted;
    protected boolean rallied;
    protected boolean engaged;
    protected boolean engaging;
    protected Unit engagedPointer;
    protected Experience experience;
    protected Equipment equipment;
    protected Type type;

    public String getType() { return this.type.getType(); }

    public String getExperience() { return this.experience.getExperience(); }

    public String getEquipment() { return this.equipment.getEquipment(); }

    public int getToughness() { return this.toughness; }

    public int getDefense() { return this.defense; }

    protected int getMoraleBonus() { return this.moraleBonus; }

    protected int getPowerBonus() { return this.powerBonus; }

    protected int getAttackBonus() { return this.attackBonus; }

    protected boolean isExhausted() { return this.exhausted; }

    public boolean isEngaged() { return this.engaged; }

    public abstract String getAncestry(); 

    public boolean isDiminished() { return this.diminished; }

    // Default Constructor
    public Unit() {
        this.sizeMax = 6;
        this.sizeCurrent = this.sizeMax;
        this.diminished = false;
        this.exhausted = false;
        this.rallied = false;

        this.experience = new Green(this);
        this.equipment = new Light(this);
        this.type = new Levy(this);

        this.calculateCost();
    }

    // Constructor
    public Unit(String name, int size, int expID, int equID, int typeID) {
        this.name = name;
        this.sizeMax = size;
        this.sizeCurrent = this.sizeMax;
        this.diminished = false;
        this.exhausted = false;
        this.rallied = false;

        this.setModifiers(expID, equID, typeID);

        this.calculateCost();
    }

    public abstract String toString();

    /**
     * Internal function to set the attack, power, defense, toughness, and moral.
     * Based of the unique ID's of each ancestry, eqipment, expirence, and type.
     * @param ancID  ID of ancestry
     * @param expID  ID of expirence
     * @param equID  ID of equipment
     * @param typeID ID of type
     */
    private void setModifiers(int expID, int equID, int typeID) {
        // Set experience
        switch (expID) {
            case 0: this.experience = new Green(this);      break;
            case 1: this.experience = new Regular(this);    break;
            case 2: this.experience = new Seasoned(this);   break;
            case 3: this.experience = new Veteran(this);    break;
            case 4: this.experience = new Elite(this);      break;
            case 5: this.experience = new SuperElite(this); break;
            default: System.out.println("Error");
        }
        // set equipment
        switch (equID) {
            case 0: this.equipment = new Light(this);       break;
            case 1: this.equipment = new Medium(this);      break;
            case 2: this.equipment = new Heavy(this);       break;
            case 3: this.equipment = new SuperHeavy(this);  break;
            default: System.out.println("Error");
        }
        // set type
        switch (typeID) {
            case 0: this.type = new Levy(this);     break;
            case 1: this.type = new Infantry(this); break;
            case 2: this.type = new Archers(this);  break;
            case 3: this.type = new Cavalry(this);  break;
            case 4: this.type = new Airborne(this); break;
            case 5: this.type = new Siege(this);    break;
            default: System.out.println("Error");
        }
    }

    // TODO(clayhead): I would like less visability on these functions

    /**
     * Internal function to add attack to unit. Used in modifier classes
     * @param bonus num to add
     */
    public void addAttack(int bonus) {
        this.attackBonus += bonus;
    }

    /**
     * Internal function to add power to unit. Used in modifier classes
     * @param bonus num to add
     */
    public void addPower(int bonus) {
        this.powerBonus += bonus;
    }

    /**
     * Internal function to add defense to unit. Used in modifier classes
     * @param bonus num to add
     */
    public void addDefense(int bonus) {
        this.defense += bonus;
    }

    /**
     * Internal function to add toughness to unit. Used in modifier classes
     * @param bonus num to add
     */
    public void addToughness(int bonus) {
        this.toughness += bonus;
    }

    /**
     * Internal function to add morale to unit. Used in modifier classes
     * @param bonus num to add
     */
    public void addMorale(int bonus) {
        this.moraleBonus += bonus;
    }

    /**
     * Runs full attack. Rolls an attack and power check. Returns true if both succeed.
     * Checks if unit is engaged and if attacking the engaged unit. 
     * If roll is natural 20, perform 2 power checks (this is homebrew, not in book).
     * Exhausts unit regardless of outcome.
     * @param other Unit to attack
     * @return if attack and power check succeed. 
     */
    public boolean attack(Unit other) {
        if (!this.isExhausted() || !this.engaged || (this.engagedPointer == other)) {
            this.exhausted = true;
            int roll = Dice.roll(this.attackBonus);
            if (roll >= other.getDefense()) {
                return this.power(other, (roll - this.attackBonus) == 20);
            }
        }
        return false;
    }

    /**
     * Runs same attack sequence but with advantage or disadvantage.
     * @param other Unit to attack
     * @param advantage True for advantage, false for disadvantage.
     * @return if power and attack check succeeds
     */
    public boolean attack(Unit other, boolean advantage) {
        if (!this.isExhausted() || !this.engaged || (this.engagedPointer == other)) {
            this.exhausted = true;
            int roll = Dice.rollAdvantage(this.attackBonus, advantage);
            if (Dice.rollAdvantage(this.attackBonus, advantage) >= other.getDefense()) {
                return this.power(other, (roll - this.attackBonus) == 20);
            }
        }
        return false;
    }

    /**
     * Internal function to preform a power check. If the unit was hit with a crit, they will take two checks and the 
     *  function will return true if at least one hit, otherwise false. If it was a normal hit, the function will return the
     *  result of the power check.
     * @param other Unit defending against check
     * @param crit  Boolean flag to know if the triggering attack was a crit
     * @return  If the unit was hit (and took a casualty)
     */
    protected boolean power(BattlefieldEntity other, boolean crit) {
        if (crit) {
            // Count num of power check successes
            int successes = 0;
            if (Dice.check(this.powerBonus, other.getToughness())) {
                other.takeCasualty();
                successes += 1;
            }
            if (Dice.check(this.powerBonus, other.getToughness())) {
                other.takeCasualty();
                successes += 1;
            }
            return successes >= 1;
        }
        else {
            if (Dice.check(this.powerBonus, other.getToughness())) {
                other.takeCasualty();
                return true;
            }
        }
        return false;
    }

    /**
     * Internal function for a unit to take a casualty.
     * Decrements the die and if unit is diminished, makes a morale check.
     * If the unit's size is 0 and hasn't rallied, makes a rally check 
     */
    protected void takeCasualty() {
        this.decrementDie();
        if (this.diminished) this.moraleCheck(15);
        if (this.sizeCurrent == 0 && !this.rallied) this.rallyCheck();
    }

    /**
     * Internal fucntion to decrement die (reduce size) and check diminished status
     */
    protected void decrementDie() {
        this.sizeCurrent -= 1;
        this.diminished = (this.sizeCurrent == this.sizeMax/2);
    }

    /**
     * Internal function to increment die and check diminished status
     */
    protected void incrementDie() {
        this.sizeCurrent += 1;
        this.diminished = (this.sizeCurrent == this.sizeMax/2);
    }

    /**
     * Internal function to perform a rally check which is a morale check to not die.
     * Only called when sizeCurrent == 0.
     * Sets size to 1 (increments die), and sets rallied to true so it can't rally.
     */
    private void rallyCheck() {
        if (this.moraleCheck(15)) {
            this.sizeCurrent = 1;
            this.rallied = true;
        }
    }

    /**
     * Function to refresh (set exhausted to false) a unit.
     * Used in Army.java
     */
    protected void refresh() { this.exhausted = false; }

    /**
     * Performs a morale check at specified DC. Uses Dice.java
     * Used internally and externally.
     * On success nothing happens. The Unit holds.
     * On a failure, the unit is dremented. Some soliders flee in terror.
     * @param DC num to pass check
     * @return if morale check succeeded
     */
    public boolean moraleCheck(int DC) {
        if (Dice.check(this.moraleBonus, DC)) {
            System.out.println("Morale check passed!");
            return true;
        }
        System.out.println("Morale check failed!");
        this.decrementDie();
        return false;
    }

    /**
     * Same as a moralecheck but with advantage or disadvantage
     * @param DC num to pass check
     * @param advantage true for advantage, false for disadvantage
     * @return if morale check succeeded. 
     */
    boolean moraleCheckAdvantage(int DC, boolean advantage) {
        if (Dice.checkAdvantage(this.moraleBonus, DC, advantage)) {
            System.out.println("Morale check passed!");
            return true;
        }
        System.out.println("Morale check failed!");
        this.decrementDie();
        return false;
    }

    /**
     * Function to use when calling an engage or charge order.
     * @param other Unit to be engaged
     */
    void engageUnit(Unit other) {
        this.engaged = true;
        this.engagedPointer = other;
        other.setEngaged(true);
        other.setEngagedPointer(this);
    }

    /**
     * Function to use when calling a disengage order. 
     * Can only disengage if the unit was the engager and succeeds on a moral check
     * @return If disengage was a success
     */
    public boolean disengage() {
        if (this.engaging) {
            if (this.moraleCheck(13)) {
                this.setEngaged(false);
                this.setEngaging(false);
                this.setEngagedPointer(null);
                this.engagedPointer.setEngaged(false);
                this.engagedPointer.setEngagedPointer(null);
                return true;
            }
            return false;
        }
        else {
            System.out.println("Unit who was engaged by another Unit cannot disengage.");
            return false;
        }
    }

    /**
     * Internal function to set if a unit is engaged
     * @param bool new status if unit is engaged
     */
    private void setEngaged(boolean bool) { this.engaged = bool; }

    /**
     * Internal function to set which unit a unit is engaged with.
     * Important because a unit that is engaged can only attack that unit
     * @param unit Which unit that unit is engaged with
     */
    private void setEngagedPointer(Unit unit) { this.engagedPointer = unit; }

    /**
     * Internal function to set if a unit is the engager.
     * If engaged is true and engaging is true, that unit can disengage.
     * If engaged is true and engaging is false, that unit cannot disengage.
     * @param bool new status if unit is engaged.
     */
    private void setEngaging(boolean bool) { this.engaging = bool; }

    /**
     * Internal function to calculate the cost of the unit based off the rules.
     * Only called once when unit is made.
     */
    protected void calculateCost() {
        double total = 30;
        total += this.attackBonus + this.defense + this.powerBonus;
        total += (2 * this.moraleBonus);
        double temp = total * this.type.costModifier;
        double sizeTemp = 0;
        switch(this.sizeMax) {
            case 4: sizeTemp = temp * .66;      break;
            case 6: sizeTemp = temp * 1;        break;
            case 8: sizeTemp = temp * 1.33;     break;
            case 10: sizeTemp = temp * 1.66;    break;
            case 12: sizeTemp = temp * 2;       break;
            default: sizeTemp = temp;
        }
        this.cost = sizeTemp * 10;
    }

    /**
     * Used by some other classes to exhaust the unit. namely in horrify units
     */
	public void exhaust() { this.exhausted = true; }

	public Unit getEngagedTarget() { return this.engagedPointer; }
}