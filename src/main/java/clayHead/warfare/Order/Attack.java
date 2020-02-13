package clayHead.warfare.Order;

import java.beans.Transient;

import clayHead.warfare.*;
import clayHead.warfare.Ancestry.Ancestry;

public class Attack extends Order {
    private static boolean advantage = false;
    private static boolean disadvantage = false;

    static void setAdvantage(boolean bool) { advantage = bool; }
    static void setDisadvantage(boolean bool) { advantage = bool; } 
    
    // returns true if attack succeeded, false if not
    public static boolean attack(Unit attacker, BattlefieldEntity defender) {
        setPrimary(attacker);
        setSecondary(defender);
        if(isValidAttack()) {
            if (advantage) {
                advantage = false; 
                disadvantage = false; 
                return primary.attack(secondary, true);
            }
            else if (disadvantage) {
                advantage = false; 
                disadvantage = false; 
                return primary.attack(secondary, false);
            }
            else { 
                advantage = false; 
                disadvantage = false; 
                return primary.attack(defender);
            }
        }
        return false;
    }

    public static boolean testValidAttack() {
        return Attack.isValidAttack();
    }

    private static boolean isValidAttack() {
        // Check all conditions (are archers, are cavalry, is target fort, etc)
        // Based on flags, if attacker is correct, return true

        Army defenders = secondary.getArmy();

        // Are there archers?
        boolean archers = defenders.areArchers();

        // Are there levies?
        boolean levies = defenders.areLevies();

        // Are there infantry?
        boolean infantry = defenders.areInfantry();

        // Are there cavalry?
        boolean cavalry = defenders.areCavalry();

        // First, if the unit has horrify and the unit is green or regular, if they aren't eternal, they fail
        if (Ancestry.isHorify(secondary)) {
            if (!Ancestry.isEternal(primary) || primary.getExperience().equals("Green") || primary.getExperience().equals("Regular")) {
                return false;
            }
        }
        // Go defending type by defending type by Xcel chart to check logic
        if (secondary.getType().equals("Fort")) {
            // Only Siege Engines can attack forts
            if (primary.getType().equals("Siege Engine")) return true;
            else return false;
        }
        else if (secondary.getType().equals("Siege Engine")) {
            // Siege Engines can only be attacked by non Siege engines if no other types of units are on field
            if (primary.getType().equals("Siege Engine") || levies || infantry || archers || cavalry) {
                return false;
            }
            return true;
        }
        else if (secondary.getType().equals("Airborne")) {
            // Airborne can only be attacked by other airborne and archers
            if (primary.getType().equals("Airborne") || primary.getType().equals("Archers")) {
                return true;
            }
            return false;
        }
        else if (secondary.getType().equals("Cavalry")) {
            // Siege engines cannot hit cavalry
            if (primary.getType() == "Siege") return false;
            // Archers attack cavalry at disadvantage
            else if (primary.getType().equals("Archers")) {
                disadvantage = true;
                return true;
            }
            // Cavalry and Airborne attack cavalry normally (not checking turns right here for cavalry)
            else if (primary.getType().equals("Airborne") || (primary.getType().equals("Cavalry"))) {
                return true;
            }
            // if a unit is engaged with the cavalry, they may attack
            else if (primary.isEngaged() && primary.getEngagedTarget() == secondary) return true;
            // No other units can attack cavalry
            return false;
        }
        else if (secondary.getType().equals("Archers")) {
            // Archers can be attacked by anyone except if the attacker is infantry or levies there cannot be those types on field
            if (primary.getType().equals("Infantry") || primary.getType().equals("Levies")) {
                if (levies || infantry) return false;
            }
            return true;
        }
        else if (secondary.getType().equals("Infantry")) {
            // Infantry can be attacked by anyone except if attacker is levies there cannot be those types on field
        	if (primary.getType().equals("Levies") || primary.getType().equals("Infantry")) {	
                if (levies) return false;
            }
            return true;
        }
        // Levies are the only type remaining and they can be attacked by anyone
        return true;
    }
}
