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
public class Player {
    private final Hand hand;
    private boolean turn;
    private final  Profile profile;
    private final int id;
    /**
     * Creates a new instance of a player
     * @param profile the profile of the player to be created
     * @param id a string representation the player to be created
     */
    public Player(Profile profile, int id){
        this.profile = profile;
        this.id = id;
        hand=new Hand();
    }
    /**
     * 
     * @return the name of this player
     */
    public String getName(){
        return profile.getName();
    }
    /**
     * 
     * @return true if it is this player's turn to play and false if otherwise
     */
    public boolean isTurn(){
        return turn;
    }
    /**
     * sets the turn of this player to true
     */
    public void setTurn(){
        turn  = true;
    }
    /**
     * 
     * @param card the card to be played by the player
     * @return true if the player has the card and false if otherwise
     */
    public boolean playCard(Card card){
        if(hand.playCard(card)){
            turn = false;
            return true;
        }
        return false;
        
    }
    /**
     * 
     * @return the hand of this player 
     */
    public Hand getHand(){
        return hand;
    }
    /**
     * 
     * @return the string id of this player
     */
    public int getId() {
        return id;
    }
}
