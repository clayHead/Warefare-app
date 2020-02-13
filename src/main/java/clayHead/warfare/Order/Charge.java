package clayHead.warfare.Order;

import clayHead.warfare.*;

public class Charge extends Order {

    public static boolean charge(Unit attacker, Unit defender) {
        setPrimary(attacker);
        setSecondary(defender);

        if (primary.getType().equals("Cavalry") && !primary.isEngaged()) {
            Attack.setAdvantage(true);
            if (Attack.attack(primary, secondary)) {
                // attack clayHeadmand already inflicts one casualty (two on crit), charging inflicts another
                Unit.inflictCasualty(secondary);
                return true;
            }
        }
        return false;
    }
}