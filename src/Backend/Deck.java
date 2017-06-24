/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 * The Deck Class, An Object of this class will Contain enough information to
 * generate objects of all the Cards that should appear in this Deck
 *
 * @author Opsi Jay
 */
public final class Deck {

    private final Suite[] suites;
    private final Image back;
    private final ArrayList<Card> cards = new ArrayList<>();

    /**
     *
     * @param suites An array of all Suites in this Deck
     * @param back The Image at the Back of all Cards in this Deck
     */
    public Deck(Suite[] suites, Image back) {
        this.suites = suites;
        this.back = back;
        create();
    }

    /**
     * For My Controller Class, Since I have no images to Pass in, NOT TO BE
     * USED IN FINAL CODE
     *
     * @param suites
     */
    public Deck(Suite[] suites) {
        this.suites = suites;
        this.back = null;
      //  create();
        createController();
    }
    /**
     * 
     * @return All suites in this deck 
     */
    public Suite[]getSuites(){
        Suite[] ret=new Suite[suites.length];
        int i=0;
        for(Suite s:this.suites){
            ret[i++]=s;
        }
        return ret;
    }

    /**
     *
     * @return The Image at the Back of all cards in this Deck
     */
    public Image getBackImage() {
        return back;
    }

    /**
     * Creates objects to represent all cards in this Deck of Cards, and Stores
     * them in a Card List;
     */
    private void create() {
        for (Suite s : suites) {
            for (int i : s.getRanks()) {
                Card card = new Card(i, s, s.getFront(i), back);
                this.cards.add(card);
            }
        }

    }

    /**
     * Creates objects to represent all cards in this Deck of Cards, and Prints
     * them out;
     */
    private void createController() {
        for (Suite s : suites) {
            for (int i : s.getRanks()) {
                //    System.out.print(i + " of " + s.getName()); 
                if(s.getWeight()>1){
                //    System.out.print(" and "+s.getWeight()+"x Weight");
                }
                System.out.println("");
                 Card card = new Card(i,s,null,null);
                 cards.add(card);
                 System.out.println(card);
            }
        }

    }

    /* public void setBackImage(Image back){
        this= new Deck(suites,  back,  abilities);
    }*/
    /**
     *
     * @return The Number of Cards in the Deck
     */
    public int getSize() {
        return cards.size();
    }

    /**
     * Returns a Copy of the Card from the specified index in the deck
     *
     * @param index The location of the Card you want
     * @return an Object of the card in that location
     */
    public Card getCard(int index) {
        Card card = cards.get(index);
        return card;
    }
}
