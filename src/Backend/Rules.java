/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
/**
 *
 * @author Opsi Jay
 */
public class Rules {
    private final boolean Defend;//Specifies Wheather you can defend, by bouncing or Blocking
    private final boolean Bouncing;//Bounce if true, block if false and defend = true;
    private final boolean Tender;//Tender if true, Refill market if false;
    private final int TenderAfter;
    private int TenderLeft;//Refiil market this number of times, then Tender
    private final boolean Joke2,Joke3;//Specifies if the Joker Can also Block p2 and p3
    private final int [] Pow;
    private final boolean CanOss;
    private final Suite onlySuspendSuite;//If only one suite can Suspend it's stored here else it's null
    private final boolean cont;
    /**
     * 
     * @param bounce Set to true If action Cards can be Passed On
     * @param block Set to true(Only if bounce is false) If Action Cards are Blocked...If Bounce is true block will be false
     * @param tender Number of times market is refilled before Tender, set to 0 to Tender the first time Market finishes, set to -1 to never Tender
     * @param jokerBlocks2 Set to True if Joker can block pick 2
     * @param jokerBlocks3 Set to True if Joker can Block pick 3
     * @param oss If only one Suite can Suspend, put it here, else put anything or null 
     * @param pow an Array of ranks with Powers {HoldOn,Suspension,Pick2,Pick3,GeneralMarket},set -1 for any Power not Present
     * @param cont True if other Players Can Continue Playing after One Checks-Up, False if Game Ends there
     */
    public Rules(boolean bounce,boolean block,int tender,boolean jokerBlocks2,boolean jokerBlocks3,Suite oss,int []pow,boolean cont){
        if(bounce==true){
            this.Defend=true;
            this.Bouncing=true;
        }else if(block==true){
            this.Defend=true;
            this.Bouncing=false;
        }else{
            this.Defend=false;
            this.Bouncing=false;
        }
        
        if(tender>=0){
            this.Tender=true;
            this.TenderAfter=tender;
            this.TenderLeft=tender;
        }else{
            this.Tender=false;
            this.TenderAfter=this.TenderLeft=-1;
        }
        this.Joke2=jokerBlocks2;
        this.Joke3=jokerBlocks3;
        this.CanOss=!(oss==null);
        if(CanOss){onlySuspendSuite=oss;}else{onlySuspendSuite=null;}
        this.Pow=pow;
        this.cont=cont;
    }
    /**
     * Run This method When a new Game Starts
     */
    public void newGame(){TenderLeft=TenderAfter;}
    /**
     * 
     * @return True if Action Cards can be Blocked, False if not 
     */
    public boolean getBlocking(){if(Defend==true){if(Bouncing==false){return true;}}return false;}
    /**
     * 
     * @return True if Action Cards are Bounced(Passed on),False if not 
     */
    public boolean getBouncing(){{if(Defend==true){if(Bouncing==true){return true;}}return false;}}
    /**
     * 
     * @return True if you are to Tender during the Game; 
     */
    public boolean getTender(){return Tender;} 
    /**
     * 
     * @return The number of Market refills Left before Tender, returns 0 if you are to Tender after this market ends,returns -1 if you never Tender 
     */
    public int getTenderCount(){if(Tender){return TenderLeft;}return -1;}
    /**
     * Reduces by 1 the number of Tenders left, to be used after each market refill
     * 
     */
    public void reduceTenderLeft(){TenderLeft-=1;}
    /**
     * 
     * @return True if only one suite can Suspend.  
     */
    public boolean canOnlyOneSuiteSuspend(){
        return CanOss;
    }
    /**
     * 
     * @return The Suite that is Solely responsibly for Suspension, else returns null
     */
    public Suite getOnlySuspendSuite(){
        return onlySuspendSuite;
    }
    /**
     * 
     * @param pow The Power to check if Joker can Block(Must be Pick 2 or Pick three)
     * 
     * @return True if Joker Can Defend The ability passed in , 2 for pick 2 and 3 for pick 3
     */
    public boolean getJokeBlock(int i){
        switch (i) {
            case 2:
                return Joke2;
            case 3:
                return Joke3;
            default:
                return false;
        }
    }
    /**
     * 
     * @return An Array of Ranks for all Powers, 
     * <br>[0] holds the rank with power HoldOn
     * <br> [1] holds the rank with power Suspension
     * <br>[2] holds the rank with power Pick 2
     * <br>[3] holds the rank with power Pick 3 
     * <br>[4] holds the rank with power General Market
     * <br>Any Holding -1 means that Power is not present
     */
    public int[] getPowered(){
        int[] ret = new int[Pow.length];
        int j=0;
        for(int i:Pow){
            ret[j++]=i;
        }
        return ret;
    }
    //TODO Multiple Droping
    //TODO Pick Half market
    //TODO Tournament
    /**
     * 
     * @return True if game Can Continue After a Player ChecksUp, and False if the game ends there 
     */
public boolean getContinue(){return this.cont;}
}

