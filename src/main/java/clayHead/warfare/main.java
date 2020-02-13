package clayHead.warfare;

import clayHead.warfare.Ancestry.*;
import clayHead.warfare.Order.*;

public class main {

        static Unit test = new Human();
        static Unit test_Infantry = new Human("Test_Infantry", 6, 0, 0, 1);
        static Unit test_Archer = new Human("Test_Archer", 6, 0, 0, 2);
        static Unit test_Cavalry = new Human("Test_Cavalry", 6, 0, 0, 3);
        static Unit test_Airborne = new Human("Test_Airborne", 6, 0, 0, 4);
        static Unit test_Siege = new Human("Test_Siege", 6, 0, 0, 5);

        static Unit test_2 = new Human();
        static Unit test_Infantry_2 = new Human("Test_Infantry", 6, 0, 0, 1);
        static Unit test_Archer_2 = new Human("Test_Archer", 6, 0, 0, 2);
        static Unit test_Cavalry_2 = new Human("Test_Cavalry", 6, 0, 0, 3);
        static Unit test_Airborne_2 = new Human("Test_Airborne", 6, 0, 0, 4);
        static Unit test_Siege_2 = new Human("Test_Siege", 6, 0, 0, 5);

        static Army testArmy = new Army();
        static Army testArmy_2 = new Army();

    public static void main(String[] args) {
        // write your code here
        testArmy.add(test);
        testArmy.add(test_Infantry);
        testArmy.add(test_Archer);
        testArmy.add(test_Cavalry);
        testArmy.add(test_Airborne);
        testArmy.add(test_Siege);

        testArmy_2.add(test_2);
        testArmy_2.add(test_Infantry_2);
        testArmy_2.add(test_Archer_2);
        testArmy_2.add(test_Cavalry_2);
        testArmy_2.add(test_Airborne_2);
        testArmy_2.add(test_Siege_2);
        
        creationTest();
        validAttackTest();
    }

    private static void creationTest() {
        System.out.println("Test stats: \nAttack: " + test.getAttackBonus() + "\nDefense: " + test.getDefense() +
                "\nPower: " + test.getPowerBonus() + "\nToughness: " + test.getToughness() + "\nMorale: " +
                test.getMoraleBonus() + "\nName: " + test.toString());
        System.out.println("Test_I stats: \nAttack: " + test_Infantry.getAttackBonus() + "\nDefense: " + test_Infantry.getDefense() +
                "\nPower: " + test_Infantry.getPowerBonus() + "\nToughness: " + test_Infantry.getToughness() + "\nMorale: " +
                test_Infantry.getMoraleBonus() + "\nName: " + test_Infantry.toString());
        System.out.println("Test_Ar stats: \nAttack: " + test_Archer.getAttackBonus() + "\nDefense: " + test_Archer.getDefense() +
                "\nPower: " + test_Archer.getPowerBonus() + "\nToughness: " + test_Archer.getToughness() + "\nMorale: " +
                test_Archer.getMoraleBonus() + "\nName: " + test_Archer.toString());
        System.out.println("Test_C stats: \nAttack: " + test_Cavalry.getAttackBonus() + "\nDefense: " + test_Cavalry.getDefense() +
                "\nPower: " + test_Cavalry.getPowerBonus() + "\nToughness: " + test_Cavalry.getToughness() + "\nMorale: " +
                test_Cavalry.getMoraleBonus() + "\nName: " + test_Cavalry.toString());
        System.out.println("Test_Ai stats: \nAttack: " + test_Airborne.getAttackBonus() + "\nDefense: " + test_Airborne.getDefense() +
                "\nPower: " + test_Airborne.getPowerBonus() + "\nToughness: " + test_Airborne.getToughness() + "\nMorale: " +
                test_Airborne.getMoraleBonus() + "\nName: " + test_Airborne.toString());
        System.out.println("Test_S stats: \nAttack: " + test_Siege.getAttackBonus() + "\nDefense: " + test_Siege.getDefense() +
                "\nPower: " + test_Siege.getPowerBonus() + "\nToughness: " + test_Siege.getToughness() + "\nMorale: " +
                test_Siege.getMoraleBonus() + "\nName: " + test_Siege.toString());
    }

    private static void validAttackTest() {
        Attack.setPrimary(test);
        Attack.setSecondary(test_2);

        // Attack levies to levies
        // true

        System.out.println("1: " + Attack.testValidAttack() + ", true");

        // Attack infantry to infantry
        // false

        Attack.setPrimary(test_Infantry);
        Attack.setSecondary(test_Infantry_2);
        System.out.println("2: " + Attack.testValidAttack() + ", false");

        // Attack infantry to infantry, no levies
        // true

        testArmy_2.remove(test_2);
        System.out.println("3: " + Attack.testValidAttack() + ", true");

        // Attack infantry to Archer
        // false

        Attack.setSecondary(test_Archer_2);
        System.out.println("4: " + Attack.testValidAttack() + ", false");

        // Attack infantry to Archer, no infantry
        // true

        testArmy_2.remove(test_Infantry_2);
        System.out.println("5: " + Attack.testValidAttack() + ", true");

        // Attack infantry to Cavalry
        // false

        Attack.setSecondary(test_Cavalry_2);
        System.out.println("6: " + Attack.testValidAttack() + ", false");

        // Attack inantry to Airborne
        // false

        Attack.setSecondary(test_Airborne_2);
        System.out.println("7: " + Attack.testValidAttack() + ", false");

        // Attack infantry to Siege
        // false

        Attack.setSecondary(test_Siege_2);
        System.out.println("8: " + Attack.testValidAttack() + ", false");

        // Attack Infantry to Siege, no cavalry or archers
        // True

        testArmy_2.remove(test_Archer_2);
        testArmy_2.remove(test_Cavalry_2);
        System.out.println("9: " + Attack.testValidAttack() + ", true");
    }

}