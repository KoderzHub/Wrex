/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import javafx.scene.image.Image;
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
public class SuiteTest {
    
    public SuiteTest() {
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
     * Test of isJoker method, of class Suite.
     */
    @Test
    public void testIsJoker() {
        System.out.println("isJoker");
     
        Suite instance = new Suite("JOKER",new int[0],new Image[0]);
        boolean expResult =true;
        boolean result = instance.isJoker();
        assertEquals(result, expResult);
        instance = new Suite("JoKER",new int[0],new Image[0]);
        expResult =false;
        result = instance.isJoker();
        assertEquals(result, expResult);
        instance = new Suite("Steve",new int[0],new Image[0]);
        expResult =false;
        result = instance.isJoker();
        assertEquals(result, expResult);
    }
    /**
     * Test of getRanks method, of class Suite.
     */ @Test
    public void testGetRanks() {
        System.out.println("getRanks");
        int[]boyo=new int[5];
        Suite instance = new Suite("hey",boyo,new Image[0]);
        int[] expResult = boyo;
        int[] result = instance.getRanks();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Suite.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String Hello="xup";
        Suite instance = new Suite(Hello,new int[1],new Image[0]);
        String expResult = Hello;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeight method, of class Suite.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        Suite instance = new Suite("f",0, new int[0],new Image[0]);
        int expResult = 0;
        int result = instance.getWeight();
        assertEquals(expResult, result);
    }
    /**
     * Test of getFront method, of class Suite.
     */
     @Test
    public void testGetFront() {
        System.out.println("getFront");
        Image[] hi = new Image[1];
        hi[0]=null;
        Suite instance = new Suite("Hi",new int[1],hi);
        Image expResult = hi[0];
        Image result = instance.getFront(0);
        assertEquals(expResult, result);
        // fail("The test case is a prototype.");
    }
    
}
