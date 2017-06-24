/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Opsi Jay
 */
public class GameNGTest {
    
    public GameNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getPlayers method, of class Game.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        Game instance = null;
        Player[] expResult = null;
        Player[] result = instance.getPlayers();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarketSize method, of class Game.
     */
    @Test
    public void testGetMarketSize() {
        System.out.println("getMarketSize");
        Game instance = null;
        int expResult = 0;
        int result = instance.getMarketSize();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clickMarket method, of class Game.
     */
    @Test
    public void testClickMarket() {
        System.out.println("clickMarket");
        Player p = null;
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.pickMarket(p);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasAbility method, of class Game.
     */
    @Test
    public void testHasAbility() {
        System.out.println("hasAbility");
        Card card = null;
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.hasAbility(card);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of INEED method, of class Game.
     */
    @Test
    public void testINEED() {
        System.out.println("INEED");
        Game instance = null;
//        instance.INEED();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of play method, of class Game.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Card card = null;
        Player player = null;
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.play(card, player);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
