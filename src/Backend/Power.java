/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
/**
 *The Power class holding information on all abilities in the Deck and 
 * the corresponding ranks to each ability
 * @author Opsi Jay
 */
public class Power {
    private final ability name;
    private final int rank;
    /**
     *
     * @param name The name of the ability.
     * @param rank The number/rank which carries this ability.
     */
   public Power(ability name, int rank){
        this.name=name;
        this.rank=rank;
    }

    /**
     * Get the name of the Ability
     * @return Ability
     */
    public ability getPower(){
        return name;
    }
    /**
     * 
     * @return Rank that carries the power 
     */
    public int getRank(){
        return rank;
    }
}
