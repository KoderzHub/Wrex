/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Phillz Mike
 */
public class MarketNGTest {
    
    public MarketNGTest() {
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
     * Test of shuffle method, of class Market.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        Market instance = new Market();
        for(int i=0;i<52;i++){
            instance.push(new Card(i,new Suite("Hi",null,null),null,null));
            System.out.println(instance.peek());
        }
        instance.shuffle();
    }
    
}
