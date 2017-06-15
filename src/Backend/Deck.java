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
    private final Power[] abilities;
    private final ArrayList<Card> cards = new ArrayList<>();

    /**
     *
     * @param suites An array of all Suites in this Deck
     * @param back The Image at the Back of all Cards in this Deck
     * @param abilities An array of all abilities present in this Deck. P.s a
     * deck is not mutable, so if you want to change Say the Abilities, you must
     * create a new Deck
     */
    public Deck(Suite[] suites, Image back, Power[] abilities) {
        this.suites = suites;
        this.back = back;
        this.abilities = abilities;
        create();
    }

    /**
     * For My Controller Class, Since I have no images to Pass in, NOT TO BE
     * USED IN FINAL CODE
     *
     * @param suites
     * @param abilities
     */
    public Deck(Suite[] suites, Power[] abilities) {
        this.suites = suites;
        this.back = null;
        this.abilities = abilities;
        createController();
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
                ability cardsPower = ability.NORMAL;
                for (Power p : abilities) {
                    if (p.getRank() == i) {
                        cardsPower = p.getPower();
                    }
                }
                if (s.isJoker()) {
                    Card card = new Card(i, s, ability.JOKER, s.getFront(i), back);
                    cards.add(card);
                }
                Card card = new Card(i, s, cardsPower, s.getFront(i), back);
                cards.add(card);
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
                ability cardsPower = ability.NORMAL;
                for (Power p : abilities) {
                    if (p.getRank() == i) {
                        cardsPower = p.getPower();
                    }
                }
                if (s.isJoker()) {
                    System.out.print(i + " of " + s.getName() + " with ability " + ability.JOKER.toString());
                }else if (cardsPower == ability.NORMAL) {
                    System.out.print(i + " of " + s.getName());
                } else {
                    System.out.print(i + " of " + s.getName() + " with ability " + cardsPower.toString());
                }
                if(s.getWeight()>1){
                    System.out.print(" and "+s.getWeight()+"x Weight");
                }
                System.out.println("");
                // Card card = new Card(i,s,cardsPower,s.getFront(i),back);
                // cards.add(card);
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
