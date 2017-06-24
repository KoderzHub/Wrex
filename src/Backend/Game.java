/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 * The Model Class of the Whot Game
 * <br>Receives the Players, Deck and Rules
 * <br>Call the play() method when someone plays
 * <br>Call the pickMarket() method when a player goes to Market
 * <br>Call the iNEED() method when SOmeone Plays a Joker
 *
 * @author Opsi Jay
 */
public class Game {

    private int bounced;
    private Suite need;
    //TODO TEST: make Private :D
    Player turn;
    private Player[] allPlayers;
    private final Player[] players;
    private boolean defend;
    private final Market market = new Market();
    private final Pile pile = new Pile();
    private final Rules rule;
    private final Deck deck;
    private boolean gameOn;

    /**
     *
     * @param players An Array of all the Players in this GAme, The player in
     * Array[0] starts the match
     * @param deck A deck object, Holding all the Cards to be used in this game
     * @param rule A rules object, defining the rules to be followed in this
     * Game
     */
    public Game(Player[] players, Deck deck, Rules rule) {
        this.bounced = 0;
        this.players = players;
        this.rule = rule;
        this.turn = this.players[0];
        this.deck = deck;
        this.gameOn = true;
        setGame();
        for (int i = 0; i < deck.getSize(); i++) {
            this.market.push(deck.getCard(i));
        }

        this.market.shuffle();

        share();
    }

    /**
     *
     * @return The deck Used in this Game
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Set this game object into all Hands Playing(Just here because of Leaking
     * this in Constructor error)
     */
    private void setGame() {
        for (Player p : players) {
            p.getHand().setGame(this);
        }
    }

    /**
     *
     * @return An array of all Players in this Game, In the Order [0]->[1]->[2]
     */
    public Player[] getPlayers() {
        Player[] ret = new Player[players.length];
        int i = 0;
        for (Player p : players) {
            ret[i++] = p;
        }
        return ret;
    }

    public Rules getRules() {
        return rule;
    }

    private void refillMarket() {
        Card[] pilecards = pile.empty();
        Stack temp = new Stack();
        while (market.size() > 0) {
            temp.push(market.pop());
        }
        for (Card i : pilecards) {
            market.push(i);
        }
        market.shuffle();
        while (temp.size() > 0) {
            market.push(temp.pop());
        }
    }

    /**
     *
     * @return The number of cards left in the Market
     */
    public int getMarketSize() {
        return market.size();
    }

    /**
     *
     * @param p The player Who wants to go to the Market
     * @return True if the Player Can go to the Market, False if the Player
     * Can't
     */
    public boolean pickMarket(Player p) {
        if (p.getId() == turn.getId()) {
            if (defend) {
                if (rule.getBouncing()) {
                    if (bounced > 0) {
                        while (bounced > 0) {
                            goToMarket();
                            bounced--;
                        }
                        next();
                        defend = false;
                        return true;
                    }
                } else {
                    if (pile.peek().getRank() == rule.getPowered()[2]) {
                        goToMarket();
                        goToMarket();
                        next();
                        defend = false;
                        return true;
                    }
                    if (pile.peek().getRank() == rule.getPowered()[3]) {
                        goToMarket();
                        goToMarket();
                        goToMarket();
                        next();
                        defend = false;
                        return true;
                    }
                }
            }
            goToMarket();
            next();
            return true;
        }
        return false;

    }

    private void goToMarket() {
        turn.getHand().addCard(market.pop());
        if (market.size() == 0) {
            if (rule.getTender()) {
                if (rule.getTenderCount() > 0) {
                    refillMarket();
                } else {
                    end();
                }
            } else {
                refillMarket();
            }
        }
    }

    private void share() {
        for (int i = 0; i < 4; i++) {
            for (Player p : players) {
                p.getHand().addCard(market.pop());
            }
        }
        boolean act = true;
        Stack temp = new Stack();
        while (act) {
            if (hasAbility(market.peek())) {
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

    /**
     * Check if a Card Has any Ability i.e Pick 2, Pick 3, Gen, Hold On,
     * Suspension From the rules specified in this Game
     *
     * @param card The Card to Check if it has an ability
     * @return True if the card has an Ability, and false if the Card has no
     * ability
     */
    public boolean hasAbility(Card card) {
        for (int i : rule.getPowered()) {
            if (card.getRank() == i) {
                return true;
            }
        }
        return card.getSuite().isJoker();
    }

    /**
     *
     * @return The Pile presently used in the Game
     */
    public Pile getPile() {
        return (Pile) new Stack(pile);
    }

    /**
     *
     * @return True if the Game is still Active, and False when the Game has
     * Ended
     */
    public boolean gameStillOn() {
        return gameOn;
    }

    private void end() {
        gameOn = false;
        for (Player p : players) {
            if (p.getHand().getSize() == 0) {
                if (rule.getContinue()) {
                    if(players.length>2){
                        //remove(players,p);
                        //add(allPlayers,p);
                    }else{
                        //TODO put all back
                    }
                } else {
                    int[] scores = new int[players.length];
                    for (int i = 0; i < players.length; i++) {
                        scores[i] = 0;
                        for (Card c : players[i].getHand().submitCards()) {
                            scores[i] += (c.getRank() * c.getWeight());
                        }
                    }
                    sort(scores);
                }
            }
        }

    }

    private void sort(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < i; j++) {
                if (scores[i] < scores[j]) {
                    Player tem = players[i];
                    int temp = scores[i];
                    for (int k = i - 1; k >= j; k--) {
                        scores[k + 1] = scores[k];
                        players[k + 1] = players[k];
                    }
                    scores[j] = temp;
                    players[j] = tem;
                }
            }
        }
    }

    private void performAction() {
        if (pile.peek().getRank() == rule.getPowered()[0]) {

            for (int i = 0; i < players.length; i++) {
                if (players[i] == turn) {
                    turn = players[(i == 0) ? players.length - 1 : i - 1];
                    turn.setTurn();
                    break;
                }
            }
        } else if (pile.peek().getRank() == rule.getPowered()[1]) {
            if (rule.canOnlyOneSuiteSuspend()) {
                if (rule.getOnlySuspendSuite().equals(getSuite(pile.peek()))) {
                    next();
                }
            } else {
                next();
            }
        } else if (pile.peek().getRank() == rule.getPowered()[2]) {
            next();
            goToMarket();
            goToMarket();
        } else if (pile.peek().getRank() == rule.getPowered()[3]) {
            next();
            goToMarket();
            goToMarket();
            goToMarket();
        } else if (pile.peek().getRank() == rule.getPowered()[4]) {
            Player now = turn;
            next();
            while (turn != now) {
                goToMarket();
                next();
            }
            prev();
        }
        defend = false;
    }

    /**
     * WHen the Joker Card is Played, the Player Determines What suite he wants
     * to be played Next
     *
     * @param s The Decided Suite to be Played
     */
    public void iNEED(Suite s) {
        need = s;
        defend = false;
    }

    /**
     * When a Player Attempts to Play a Card
     *
     * @param card The Card to be Played
     * @param player The Player Playing this Card
     * @return True if the User Can Play this Card, False if Playing this Card
     * at this time is illegal
     */
    public boolean play(Card card, Player player) {
        if (player.getId() == turn.getId()) {
            if (isValid(card)) {
                if (turn.playCard(card)) {
                    pile.push(card);
                    if (hasAbility(card)) {
                        if (player.getHand().getSize() == 0) {
                            goToMarket();
                        }
                        if (pile.peek().getRank() == rule.getPowered()[2] || pile.peek().getRank() == rule.getPowered()[3]) {
                            if (rule.getBouncing()) {
                                bounced = (card.getRank() == rule.getPowered()[2]) ? bounced + 2 : (card.getRank() == rule.getPowered()[3]) ? bounced + 3 : 0;
                                defend = true;
                            } else if (rule.getBlocking()) {
                                defend = !defend;
                            } else {
                                performAction();
                            }
                        } else {
                            performAction();
                        }
                    } else {
                        if (player.getHand().getSize() == 0) {
                            end();
                        }
                        defend = false;
                    }
                    next();
                    return true;

                }

            }

        }
        return false;

    }

    /**
     *
     * @param card Check if this Card can be played right now
     * @return True if it Can, False if it Can't
     */
    private boolean isValid(Card card) {
        if (card.getSuite().isJoker()) {
            if (pile.peek().getRank() == rule.getPowered()[2]) {
                return rule.getJokeBlock(2);
            } else if (pile.peek().getRank() == rule.getPowered()[3]) {
                return rule.getJokeBlock(3);
            }
            return true;
        }
        if (defend) {
            return card.getRank() == pile.peek().getRank();
        } else {
            return (card.getRank() == pile.peek().getRank()) || (card.getSuite().equals(getSuite(pile.peek())));
        }
    }

    /**
     *
     * @param card Gets the Suite of the Card on top
     * @return The Suite Needed, if the Card is a Joker, Else the Suite of the
     * Card
     */
    private Suite getSuite(Card card) {
        if (card.getSuite().isJoker()) {
            return need;
        } else {
            return card.getSuite();
        }
    }

    private void next() {
        for (int i = 0; i < players.length; i++) {
            if (players[i].getId() == turn.getId()) {
                turn = players[(i == players.length - 1) ? 0 : i + 1];
                turn.setTurn();
                break;
            }
        }

    }

    private void prev() {

        for (int i = 0; i < players.length; i++) {
            if (players[i] == turn) {
                turn = players[(i == 0) ? players.length - 1 : i - 1];
                turn.setTurn();
                break;
            }
        }

    }
}
