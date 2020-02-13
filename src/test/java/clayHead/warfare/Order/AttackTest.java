package clayHead.warfare.Order;

import junit.framework.TestCase;

import clayHead.warfare.*;
import clayHead.warfare.Ancestry.*;
import clayHead.warfare.Fort.*;

public class AttackTest extends TestCase {
	Unit test = new Human();
    Unit test_Infantry = new Human("Test_Infantry", 6, 0, 0, 1);
    Unit test_Archer = new Human("Test_Archer", 6, 0, 0, 2);
    Unit test_Cavalry = new Human("Test_Cavalry", 6, 0, 0, 3);
    Unit test_Airborne = new Human("Test_Airborne", 6, 0, 0, 4);
    Unit test_Siege = new Human("Test_Siege", 6, 0, 0, 5);

    Unit test_2 = new Human("Test_Levy_2", 6, 0, 0, 0);
    Unit test_Infantry_2 = new Human("Test_Infantry_2", 6, 0, 0, 1);
    Unit test_Archer_2 = new Human("Test_Archer_2", 6, 0, 0, 2);
    Unit test_Cavalry_2 = new Human("Test_Cavalry_2", 6, 0, 0, 3);
    Unit test_Airborne_2 = new Human("Test_Airborne_2", 6, 0, 0, 4);
    Unit test_Siege_2 = new Human("Test_Siege_2", 6, 0, 0, 5);

    Army testArmy = new Army();
    Army testArmy_2 = new Army();
    
    Fort fort = new Keep();

	protected void setUp() throws Exception {
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
        testArmy_2.add(fort);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAttack() {
		fail("Not yet implemented");
	}

	public void testTestValidAttackLevy() {
		Attack.setPrimary(test);

        // levy to levy
        Attack.setSecondary(test_2);
        assertTrue(Attack.testValidAttack());

        // levy to infantry w/ levies
        Attack.setSecondary(test_Infantry_2);
        assertFalse(Attack.testValidAttack());

        // levy to archer w/ levies
        Attack.setSecondary(test_Archer_2);
        assertFalse(Attack.testValidAttack());

        // levy to cavalry
        Attack.setSecondary(test_Cavalry_2);
        assertFalse(Attack.testValidAttack());
        
        // levy to cavalry w/ engaged
        test.testEngaged(true, test_Cavalry_2);
        assertTrue(Attack.testValidAttack());
        test.testEngaged(false, null);

        // levy to airborne
        Attack.setSecondary(test_Airborne_2);
        assertFalse(Attack.testValidAttack());

        // levy to siege w/ levies
        Attack.setSecondary(test_Siege_2);
        assertFalse(Attack.testValidAttack());

        // remove levies
        testArmy_2.remove(test_2);

        // levy to infantry w/o levies
        Attack.setSecondary(test_Infantry_2);
        assertTrue(Attack.testValidAttack());
        
        // levy to archer w/o levies
        Attack.setSecondary(test_Archer_2);
        assertFalse(Attack.testValidAttack());

        // levy to siege w/o levies
        Attack.setSecondary(test_Siege_2);
        assertFalse(Attack.testValidAttack());

        // remove infantry
        testArmy_2.remove(test_Infantry_2);

        // levy to archer w/o infantry
        Attack.setSecondary(test_Archer_2);
        assertTrue(Attack.testValidAttack());

        // levy to siege w/o infantry
        Attack.setSecondary(test_Siege_2);
        assertFalse(Attack.testValidAttack());
        
        // remove archer
        testArmy_2.remove(test_Archer_2);

        // levy to siege w/o archer
        assertFalse(Attack.testValidAttack());

        // remove cavalry
        testArmy_2.remove(test_Cavalry_2);
        
        // levy to siege w/o cavalry
        assertTrue(Attack.testValidAttack());
        
        // levy to fort
        Attack.setSecondary(fort);
        assertFalse(Attack.testValidAttack());
	}
	
	public void testTestValidAttackInfantry() {
		Attack.setPrimary(test_Infantry);
		
		// infantry to levy
        Attack.setSecondary(test_2);
        assertTrue(Attack.testValidAttack());

        // infantry to infantry w/ levies
        Attack.setSecondary(test_Infantry_2);
        assertFalse(Attack.testValidAttack());

        // infantry to archer w/ levies
        Attack.setSecondary(test_Archer_2);
        assertFalse(Attack.testValidAttack());

        // infantry to cavalry
        Attack.setSecondary(test_Cavalry_2);
        assertFalse(Attack.testValidAttack());
        
        // infantry to cavalry w/ engaged
        test_Infantry.testEngaged(true, test_Cavalry_2);
        assertTrue(Attack.testValidAttack());
        test_Infantry.testEngaged(false, null);
        

        // infantry to airborne
        Attack.setSecondary(test_Airborne_2);
        assertFalse(Attack.testValidAttack());

        // infantry to siege w/ levies
        Attack.setSecondary(test_Siege_2);
        assertFalse(Attack.testValidAttack());

        // remove levies
        testArmy_2.remove(test_2);

        // infantry to infantry w/o levies
        Attack.setSecondary(test_Infantry_2);
        assertTrue(Attack.testValidAttack());

        // infantry to archer w/o levies
        Attack.setSecondary(test_Archer_2);
        assertFalse(Attack.testValidAttack());

        // infantry to siege w/o levies
        Attack.setSecondary(test_Siege_2);
        assertFalse(Attack.testValidAttack());

        // remove infantry
        testArmy_2.remove(test_Infantry_2);

        // infantry to archer w/o infantry
        Attack.setSecondary(test_Archer_2);
        assertTrue(Attack.testValidAttack());

        // infantry to siege w/o infantry
        Attack.setSecondary(test_Siege_2);
        assertFalse(Attack.testValidAttack());
        
        // remove archer
        testArmy_2.remove(test_Archer_2);

        // infantry to siege w/o archer
        assertFalse(Attack.testValidAttack());

        // remove cavalry
        testArmy_2.remove(test_Cavalry_2);
        
        // infantry to siege w/o cavalry
        assertTrue(Attack.testValidAttack());
        
     // infantry to fort
        Attack.setSecondary(fort);
        assertFalse(Attack.testValidAttack());
	}

	public void testTestValidAttackArcher() {
		Attack.setPrimary(test_Archer);
		
		// archer to levy
		Attack.setSecondary(test_2);
		assertTrue(Attack.testValidAttack());
		
		// archer to infantry
		Attack.setSecondary(test_Infantry_2);
		assertTrue(Attack.testValidAttack());
		
		// archer to archer
		Attack.setSecondary(test_Archer_2);
		assertTrue(Attack.testValidAttack());
		
		// archer to cavalry
		Attack.setSecondary(test_Cavalry_2);
		assertTrue(Attack.testValidAttack());
		
		// archer to airborne
		Attack.setSecondary(test_Airborne_2);
		assertTrue(Attack.testValidAttack());
		
		// archer to siege
		Attack.setSecondary(test_Siege_2);
		assertFalse(Attack.testValidAttack());
		
		// archer to siege w/o levies
		testArmy_2.remove(test_2);
		assertFalse(Attack.testValidAttack());
		
		// archer to siege w/o infantry
		testArmy_2.remove(test_Infantry_2);
		assertFalse(Attack.testValidAttack());
		
		// archer to siege w/o archer
		testArmy_2.remove(test_Archer_2);
		assertFalse(Attack.testValidAttack());
		
		// archer to siege w/o cavalry
		testArmy_2.remove(test_Cavalry_2);
		assertTrue(Attack.testValidAttack());
		
		// archer to fort
        Attack.setSecondary(fort);
        assertFalse(Attack.testValidAttack());
	}

	public void testTestValidAttackCavalry() {
		Attack.setPrimary(test_Cavalry);
		
		// cavalry to levy
		Attack.setSecondary(test_2);
		assertTrue(Attack.testValidAttack());
		
		// cavalry to infantry
		Attack.setSecondary(test_Infantry_2);
		assertTrue(Attack.testValidAttack());
		
		// cavalry to archer
		Attack.setSecondary(test_Archer_2);
		assertTrue(Attack.testValidAttack());
		
		// cavalry to cavalry
		Attack.setSecondary(test_Cavalry_2);
		assertTrue(Attack.testValidAttack());
		
		// cavalry to airborne
		Attack.setSecondary(test_Airborne_2);
		assertFalse(Attack.testValidAttack());
		
		// cavalry to siege
		Attack.setSecondary(test_Siege_2);
		assertFalse(Attack.testValidAttack());
		
		// cavalry to siege w/o levies
		testArmy_2.remove(test_2);
		assertFalse(Attack.testValidAttack());
		
		// cavalry to siege w/o infantry
		testArmy_2.remove(test_Infantry_2);
		assertFalse(Attack.testValidAttack());
		
		// cavalry to siege w/o archer
		testArmy_2.remove(test_Archer_2);
		assertFalse(Attack.testValidAttack());
		
		// cavalry to siege w/o cavalry
		testArmy_2.remove(test_Cavalry_2);
		assertTrue(Attack.testValidAttack());
		
		// cavalry to fort
        Attack.setSecondary(fort);
        assertFalse(Attack.testValidAttack());
	}
	
	public void testTestValidAttackAirborne() {
		Attack.setPrimary(test_Airborne);
		
		// airborne to levy
		Attack.setSecondary(test_2);
		assertTrue(Attack.testValidAttack());
		
		// airborne to infantry
		Attack.setSecondary(test_Infantry_2);
		assertTrue(Attack.testValidAttack());
		
		// airborne to archer
		Attack.setSecondary(test_Archer_2);
		assertTrue(Attack.testValidAttack());
		
		// airborne to cavalry
		Attack.setSecondary(test_Cavalry_2);
		assertTrue(Attack.testValidAttack());
		
		// airborne to airborne
		Attack.setSecondary(test_Airborne_2);
		assertTrue(Attack.testValidAttack());
        
		// airborne to siege
		Attack.setSecondary(test_Siege_2);
		assertFalse(Attack.testValidAttack());		
		
		// airborne to siege w/o levies
		testArmy_2.remove(test_2);
		assertFalse(Attack.testValidAttack());
		
		// airborne to siege w/o infantry
		testArmy_2.remove(test_Infantry_2);
		assertFalse(Attack.testValidAttack());
		
		// airborne to siege w/o archer
		testArmy_2.remove(test_Archer_2);
		assertFalse(Attack.testValidAttack());
		
		// airborne to siege w/o cavalry
		testArmy_2.remove(test_Cavalry_2);
		assertTrue(Attack.testValidAttack());
		
		// airborne to fort
        Attack.setSecondary(fort);
        assertFalse(Attack.testValidAttack());
	}
	
	public void testTestValidAttackSiege() {
		Attack.setPrimary(test_Siege);
		
		// siege to levy
		Attack.setSecondary(test_2);
		assertTrue(Attack.testValidAttack());
		
		// siege to infantry
		Attack.setSecondary(test_Infantry_2);
		assertTrue(Attack.testValidAttack());
		
		// siege to archer
		Attack.setSecondary(test_Archer_2);
		assertTrue(Attack.testValidAttack());
		
		// siege to cavalry
		Attack.setSecondary(test_Cavalry_2);
		assertFalse(Attack.testValidAttack());
		
		// siege to airborne
		Attack.setSecondary(test_Airborne_2);
		assertFalse(Attack.testValidAttack());
		
		// siege to siege
		Attack.setSecondary(test_Siege_2);
		assertFalse(Attack.testValidAttack());
		
		// siege to fort
        Attack.setSecondary(fort);
        assertTrue(Attack.testValidAttack());
	}
}
