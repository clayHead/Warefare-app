package clayHead.warfare.Order;

import clayHead.warfare.Unit;

public class Order {
    protected static Unit primary;   // The Unit performing the order
    protected static Unit secondary; // The Unit (if any) that is the target of the action (ie. the defender of an attack)

    public static void setPrimary(Unit unit) {
        primary = unit;
    }

    public static void setSecondary(Unit unit) {
        secondary = unit;
    }
}