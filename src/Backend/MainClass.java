/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.Arrays;

/**
 *
 * @author Phillz Mike
 */
import java.util.Scanner;
import javafx.scene.image.Image;

public class MainClass {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Finally this is done!!\nWhot brought to you guyz by shitting 2ce ");
        Rules rules = new Rules(true, true, -1, true, true, null, new int[]{1, 8, 2, 5, 14},false);
        Player[] players = new Player[4];
        Suite[] suites = new Suite[0];
        System.out.println("Press 1 to make a new Suite, any other Key to Exit");
        int input = scan.nextInt();

        while (input == 1) {
            suites = addSuites(suites, createSuites());
            System.out.println("Press 1 to make a new Suite, any other Key to Exit");
            input = scan.nextInt();
        }

        System.out.println("Type the numbers Associated with These Powers, Type 0 if you don't have the Power");

        Deck deck = new Deck(suites);

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(new Profile("p" + (i + 1)), i);
        }
        System.out.println("Starting game");
        Game game = new Game(players, deck, rules);
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + "has the following cards : \n"
                    + Arrays.toString(players[i].getHand().showAllCards()));
        }

        while (true) {
            for (int i = 0; i < players.length; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.println("***********************************************************");
                }
                System.out.println(game.getPile().peek());
                System.out.println("Player " + (i + 1) + "has the following cards : \n"
                        + Arrays.toString(players[i].getHand().showAllCards()));
                System.out.println("Enter the index of the card you want to play");
                int cardNo = scan.nextInt();

                try {
                    if (cardNo == -1) {
                        if (!game.pickMarket(players[i])) {
                            throw new Exception();
                        }
                    } else {
                        if (!game.play(players[i].getHand().getCard(cardNo), players[i])) {
                            throw new Exception();
                        }
                        if (game.getPile().peek().getSuite().isJoker()) {
                            System.out.println("What Suite do You need");
                            int indx = 0;
                            for (Suite s : game.getDeck().getSuites()) {
                                if(!s.isJoker())
                                    System.out.println(indx++ + ":" + s.getName());
                            }
                            int needNo = scan.nextInt();
                            game.iNEED(game.getDeck().getSuites()[needNo]);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("Index is out of bounds");
                    i -= 1;
                    continue;
                }
                System.out.println("Player " + (i + 1) + "has the following cards : \n" + Arrays.toString(players[i].getHand().showAllCards()));
                i = game.turn.getId() - 1;

            }
        }
    }

    static int[] add(int[] ranks, int input) {
        int[] newArr = new int[ranks.length + 1];
        System.arraycopy(ranks, 0, newArr, 0, ranks.length);
        newArr[ranks.length] = input;
        return newArr;
    }

    static Suite[] addSuites(Suite[] suites, Suite input) {
        Suite[] newArr = new Suite[suites.length + 1];
        System.arraycopy(suites, 0, newArr, 0, suites.length);
        newArr[suites.length] = input;
        return newArr;
    }

    static Suite createSuites() {
        System.out.println("Enter the Name of the Suite");
        String name = scan.next();
        System.out.println("Enter Weight");
        int weight = scan.nextInt();
        System.out.println("Enter All numbers in this Suite, Stop by entering 0 or a negative number");
        int input;
        int[] ranks = new int[0];
        input = scan.nextInt();
        while (input > 0) {
            ranks = add(ranks, input);
            input = scan.nextInt();
        }
        return new Suite(name, weight, ranks, new Image[0]);
    }
}
