/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phillz Mike
 * @since 20.06.2017
 */
public class Market extends Stack{
    
    /**
     * The method shuffles all the cards in this market
     */
    public void shuffle(){
        Card[] card = new Card[this.size()];
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<this.size();i++)
            temp.add(i);
        
        int size = this.size();
        for(int i= 0; i<size;i++){
            int remove = (int)(Math.random()*temp.size());
            
            card[temp.remove(remove)] = this.pop();
            
        }
        for(int i=0;i<size;i++)
            this.push(card[i]);
    }
    
}
