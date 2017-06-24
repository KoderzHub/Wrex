/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import java.util.ArrayList;
import java.util.List;

/**
 
 * @author Phillz Mike
 * @since 09.06.2017
 * This Class is responsible for getting the current hand of a player
 */
public class Hand {
    private final List<Card> hand;
    private Game game;
    /**
     * The constructor accepts creates an instance of hand for a player
     */
    public Hand(){
        hand = new ArrayList<>();
    }
    /**
     * The methods adds a single card to the current cards held by the player 
     * @param card the card object sent to be added
     */
    public void addCard(Card card){
        hand.add(card);
    }
    /**
     * this method adds multiple cards to the current cards held by the player
     * @param card represents s list of Cards to be added to the current number of cards held by the player
     */
    public void addCards(List<Card> card){
        card.stream().forEach((c) -> {
            this.hand.add(c);
        });
    }
    /**
     * 
     * @return the number of Cards in this hand 
     */
    public int getSize(){
        return this.hand.size();
    }
    /**
     * 
     * @param index the index of the Card to be returned
     * @return the card at index  
     */
    public Card getCard(int index){
        return this.hand.get(index);
    }
    /**
     * 
     * @param card the card whose position is to be returned
     * @return the position of card in the hand and returns -1 if the card is not in this hand
     */
    public int getPosition(Card card){
        return this.hand.indexOf(card);
    }
    /**
     * This method shows the game the present hand is playing
     * @param game this represents the game object the hand is playing
     */
    public void setGame(Game game){
        this.game = game;
    }
    /**
     * 
     * @return the game object the hand is currently playing  
     */
    public Game getGame(){
        return game;
    }
    /**
     * this method basically plays a card from the hand
     * @param card represents the card you want
     * @return true if card is in this hand and false if otherwise
     */
    public boolean playCard(Card card){
        if(this.hand.contains(card)){
            this.hand.remove(card);
            return true;
        }
        return false;
        
    }
    /**
     * The methods rearranges to cards in this hand
     * @param from the card to be moved
     * @param card the card whose position we want to move from to
     */
    public void reOrder(Card from, Card card){
        this.hand.add(getPosition(from), from);
    }
    /**
     * 
     * @return all the cards in this hand
     */
    public Card[] submitCards(){
        Card[] cards = new Card[hand.size()];
        for(int i=0;i<hand.size();i++){
            cards[i] = hand.get(i);
        }
        hand.clear();
        return cards;
    }
    /**
     * 
     * @return An array of all Cards in the Hand.  
     */
    //TODO TEST: get rid of this Function
    public Card[] showAllCards(){
        Card[] cards = new Card[hand.size()];
        for(int i=0;i<hand.size();i++){
            cards[i] = hand.get(i);
        }
        return cards;
    }
}
