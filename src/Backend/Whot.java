/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.Stack;
import javafx.scene.image.Image;

/**
 *There is no Whot Class, Just keeping frames of other peoples classes Here
 * For now
 * @author Opsi Jay
 */
public class Whot {

  

    
}

class Card {
    public Card(int rank, Suite suites,ability power,Image front,Image Back){
    
    }
    public boolean hasAbility() {
        return true;
    }

}

class Player {

    private Hand hand;
    private String name;

    public String getName() {
        return name;
    }

    private boolean turn;

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public Hand getHand() {
        return hand;
    }
}

class Hand {

    private int size;

    public void addCard(Card card) {

    }
    public int submitCards() {
        return 5;
    }  

    public int getSize() {
        return size;
    }

    public void setGame(Game game) {

    }
}

class Pile extends Stack {

}

class Market extends Stack {

    public void refill(Pile deck) {

    }

    public void shuffle() {
    }
}
