package clayHead.warfare.Order;

import clayHead.warfare.*;

public class Disengage extends Order {

    public static boolean disengage(Unit unit) {
        setPrimary(unit);
        return unit.disengage();
    }
}