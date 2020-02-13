package clayHead.warfare.Ancestry;

import clayHead.warfare.BattlefieldEntity;
import clayHead.warfare.Unit;

public class Ancestry {

    /**
     * Function to determine if a unit has the horrify trait based off its ancestry
     * @param other Unit to check
     * @return if unit has horrify
     */
    public static boolean isHorify(BattlefieldEntity other) {
        if (other.getAncestry().equals("Ghoul") || other.getAncestry().equals("Skeleton") || other.getAncestry().equals("Zombe")) {
            return true;
        }
        return false;
    }

    public static boolean isEternal(BattlefieldEntity other) {
        if (other.getAncestry().equals("Elf") || other.getAncestry().equals("Winged-Elf")) {
            return true;
        }
        return false;
    }
}