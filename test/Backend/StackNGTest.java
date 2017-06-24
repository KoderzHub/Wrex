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
 * @author Phillz Mike
 */
public class StackNGTest {
    
    public StackNGTest() {
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
     * Test of empty method, of class Stack.
     */
    @Test
    public void testEmpty() {
        System.out.println("empty");
        Stack instance = new Stack();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(result, expResult);
        
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        Stack instance = new Stack();
        Card expResult = new Card(2,new Suite("Hi",null,null),null,null);
        instance.push(expResult);
        Card result = instance.peek();
        assertEquals(result, expResult);
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Card x = null;
        Stack instance = new Stack();
        instance.push(x);
        
        assertEquals(x, instance.element[0]);
        
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        Stack instance = new Stack();
        Card expResult = new Card(1,new Suite("Hi",null,null),null,null);
        instance.push(expResult);
        Card result = instance.pop();
        assertEquals(result, expResult);
    }

    /**
     * Test of getSize method, of class Stack.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Stack instance = new Stack();
        int expResult = 0;
        int result = instance.size();
        assertEquals(result, expResult);
    }
    
}
