/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

//import javafx.scene.image.Image;
//
///**
// *There is no Whot Class, Just keeping frames of other peoples classes Here
// * For now
// * @author Opsi Jay
// */
//public class Card {
//
//  
//
//    public Card(int rank, Suite suites,Image front,Image Back){
//    
//    }
//    public Card(){}
//    public int getNo(){
//        return 0;
//    }
//    public Suite getSuite(){
//        return null;
//    }
//
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import Resources.ImageManager;
import javafx.scene.image.Image;

/**
 *this Class makes A card according to the UML i was given there are no events associated with this class
 * @author USER
 */
public class Card {
    private Player player;
    private final Image front;
    private final Image back;
    private final int rank;
    private final Suite suite;
    private final int weight;
   
    public Card(int rank, Suite suite,Image Front,Image Back){
        this.rank = rank;
        this.front =Front;
        this.back = Back;
        this.suite = suite;
        this.weight = this.suite.getWeight();
    }
    /**
     * 
     * @return the rank of this card as an integer 
     */
    int getRank(){
        return this.rank;
    }
    /**
     * 
     * @param p the player holding card 
     */
     void SetHolder(Player p){
        p.getHand().addCard(this);
        this.player=p;
    }
    /**
     * 
     * @return the suite this card belongs to
     */
    Suite getSuite(){ return this.suite;}
    /**
     * 
     * @return the weight as an integer of the card 
     */
    int getWeight(){
        return this.weight;
    }
    /**
     * Here to implement getHolder,getAbility
     */
    /**
     * 
     * @return  the player holding this card
     */
    Player getholder(){ return this.player;}

 

    @Override
    public String toString() {
        String word =this.rank+" Of "+this.suite.toString();
        if(this.weight>1)
            word+="(x"+this.weight+")";
        if(this.front!=null)
            word+="\n images: "+this.front.toString();
        if(this.back!=null)
            word+=" and "+this.back.toString();
        return word;
    }   
}