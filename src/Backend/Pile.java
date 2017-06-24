/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author Phillz Mike
 */
public class Pile extends Stack{
   
    /**
     * Removes all element in the pile except the card on the top of the pile
     * @return an array of all the cards in the pile except the card on the top of the pile
     */
    public Card[] empty(){
        Card top = this.pop();
        Card[] cards = new Card[this.size()];
        int i=0;
        while(this.size()>0)
            cards[i++] = this.pop();
        
        this.push(top);
        return cards;
    }
}
