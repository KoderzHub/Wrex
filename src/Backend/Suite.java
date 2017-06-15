/*this is a hotdog
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import javafx.scene.image.Image;

/**
 * The Suite CLass Holding Details about a Particular suite found in a Deck
 * The information Here is used to generate Cards for a Deck,
 * details like, the the ranks present in this suite, the weight/multiplier
 * effect of the suite and the images of cards within this suite
 * @author Opsi Jay
 */
public final class Suite {

    private final int weight;
    private final Image[] front;
    private final int[] ranks;
    private final String name;
    /**
     * @param name The Name of the Suite
     * @param weight The weight of the ranks in this suite
     * @param ranks All the ranks that will appear in this suite
     * @param front All the images of cards in this suite,ensure Image array is same size with rank Array
     */
    public Suite(String name,int weight, int[] ranks, Image[] front) {
        this.name=name;
        this.weight = weight;
        this.front = front;
        this.ranks = ranks;
    }
    /**
     * @param name The Name of the Suite
     * The weight is Set to 1 by default
     * @param ranks All the ranks that will appear in this suite
     * @param front All the images of cards in this suite,ensure Image array is same size with rank Array
     */
    public Suite(String name, int[] ranks, Image[] front) {
        this.name=name;
        this.weight =1;
        this.front = front;
        this.ranks = ranks;
    }
    /**
     * Determines whether or not the Suite is the JOKER suite,
     * uses the suite name to Determine, the Suite must be named
     *  'JOKER' (All Caps no quote) to be Considered a Joker
     * @return  True if Suite is the Joker Suite i.e Suite name = JOKER
     */
    public boolean isJoker(){
        return name.equals("JOKER");
    }
    /**
     * 
     * @return An array of all ranks in this suite
     */
    public int [] getRanks(){
        return ranks;
    }
    /**
     * 
     * @return The name of the Suite 
     */
    public String getName(){
        return name;
    }
    /**
     * This will return the weight of all ranks in this suites e.g If weight is
     * 2 Then a card of rank 3 will be counted as 6(3x2) during Tending;
     *
     * @return The weight
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Provides the front image of the requested card rank
     *
     * @param rank the rank whose front image you need
     * @return The front image or null if the rank isn't present in this suite
     */
    public Image getFront(int rank) {
        for(int i=0;i<ranks.length;i++){
            if(ranks[i]==rank){
                if(front.length>i){
                 return front[i];
                }else{
                    return front[i%front.length];
                }
            }
        }
       return null;
    }

}
