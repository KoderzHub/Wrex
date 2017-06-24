/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import javafx.scene.image.Image;

/**
 *
 * @author Phillz Mike
 */
public class Profile {
    private final String name;
    private Image dp;
    private int noOfGames;
    private int noOfWins;
    private int noOfLosses;
    private int winStreak;
    private int rating;
    
    public Profile(String name){
        this.name = name;
//        this.dp = null;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the profile picture
     */
    public Image getDp() {
        return dp;
    }

    /**
     * @param dp the profile picture to set
     */
    public void setDp(Image dp) {
        this.dp = dp;
    }

    /**
     * @return the noOfGames
     */
    public int getNoOfGames() {
        return noOfGames;
    }

    /**
     * @param noOfGames the noOfGames to set
     */
    public void setNoOfGames(int noOfGames) {
        this.noOfGames = noOfGames;
    }

    /**
     * @return the noOfWins
     */
    public int getNoOfWins() {
        return noOfWins;
    }

    /**
     * @param noOfWins the noOfWins to set
     */
    public void setNoOfWins(int noOfWins) {
        this.noOfWins = noOfWins;
    }

    /**
     * @return the noOfLosses
     */
    public int getNoOfLosses() {
        return noOfLosses;
    }

    /**
     * @param noOfLosses the noOfLosses to set
     */
    public void setNoOfLosses(int noOfLosses) {
        this.noOfLosses = noOfLosses;
    }

    /**
     * @return the winStreak
     */
    public int getWinStreak() {
        return winStreak;
    }

    /**
     * @param winStreak the winStreak to set
     */
    public void setWinStreak(int winStreak) {
        this.winStreak = winStreak;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

}
