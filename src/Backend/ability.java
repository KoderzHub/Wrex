/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *All the abilities the Cards can Have
 * @author Opsi Jay
 */
public enum ability {
     /**
      *Pick 2
      * The next player is expected to pick 2 Cards and Misses a turn
      */
    P2, 
      /**
      *Pick 3
      * The next player is expected to pick 3 Cards and Misses a turn
      */
    P3,  
    /**
      *Suspension
      * The next player misses a turn
      */
    SUSPEND,
      /**
      *General market
      * Every other Player Picks a card, and this Player gets another turn
      */
        GEN,
      /**
      *Hold On
      * The player gets another turn
      */
    HOLD,
    /**
     *I Need
     * The Player decides what suite will be played next
     */
    JOKER,
    /**
     *No Power
     *Any card of ability Normal has no ability and is played regularly
     */
    NORMAL
}
