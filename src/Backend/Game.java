/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.Stack;

/**
 *
 * @author Opsi Jay
 */
public class Game {

    Player turn;
    Player[] players;
    Market market = new Market();
    Pile pile = new Pile();

    public Game(Player[] players, Deck deck) {
        this.players = players;
        turn = this.players[0];
        setGame();
        for(int i = 0;i<deck.getSize();i++){
            market.push(deck.getCard(i));
        }
        market.shuffle();
        share();
    }
    public void getMarketSize(){
    
    }

    private void setGame() {
        for (Player p : players) {
            p.getHand().setGame(this);
        }
    }

    private void share() {
        for (int i = 0; i < 4; i++) {
            for (Player p : players) {
                p.getHand().addCard((Card) market.pop());
            }
        }
        boolean act = true;
        Stack temp = new Stack();
        while (act) {
            if (((Card) market.peek()).hasAbility()) {
                temp.push(market.pop());
            } else {
                pile.push(market.pop());
                act = false;
                while (temp.size() > 0) {
                    market.push(temp.pop());
                }
            }
        }
        market.shuffle();
    }
//public play
  //      public bool can play
    public void end() {
        for (Player p : players) {
            if (p.getHand().getSize() == 0) {
                System.out.println(p.getName() + " Wins");
            }
        }
        //What happens when two pwople have the same score
        int[] scores = new int[players.length];
        for(int i =0;i<players.length;i++){
            scores[i]=players[i].getHand().submitCards();
        }
        
                //tender
    }
    private void sort(int []scores){
        for(int i=0;i<scores.length;i++){
            for (int j=0;j<i;j++){
                if(scores[i]<scores[j]){
                    
                }
            }
        }
    }

    public Player next() {
        turn.setTurn(false);
        for (int i =0; i< players.length; i++) {
            if(players[i] == turn){
                turn=players[(i==players.length-1)?0:i+1];
                turn.setTurn(true);
                return turn;
            }
        }
        return null;
    }
}
