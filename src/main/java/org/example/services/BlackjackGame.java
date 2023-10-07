package org.example.services;

import org.example.model.Card;
import org.example.model.Player;
import org.example.model.Symbol;
import org.example.util.Colors;

import java.util.*;

public class BlackjackGame {
    /**
     * Initial deck of the game composed of a number of cards multiple of 52 up to 416.
     */
    private final ArrayList<Card> deck = shuffleDeck(CreateDeck());
    /**
     * Maximum card value to win.
     */
    public static final int MAX_CARDS_VALUE = 21;
    /**
     * Minimum bet to play.
     */
    public static final int MIN_BET = 2;
    /**
     * Minimum bet to play.
     */
    public static ArrayList<Card> newDeck = new ArrayList<>();
    /**
     * player.
     */
    private final Player player;
    /**
     * Dealer.
     */
    private final Player dealer;
    /**
     * Indicates whether the game is currently in progress (true) or has finished (false).
     */
    private boolean isGameInProgress;

    /**
     * Indicates whether it's currently the player's turn (true) or the player's turn has ended (false).
     */
    private boolean isPlayerTurn;
    /**
     * Constructor for a Blackjack game with an already initialized player.
     */
    public BlackjackGame(Player player){
        dealer = new Player();
        dealer.setName("dealer");
        this.player = player;
        isGameInProgress = true;
        isPlayerTurn = true;
    }
    /**
     * Method to initialize the deck of cards.
     */
    public ArrayList<Card> CreateDeck(){
        ArrayList<Card> deck = new ArrayList<>();

        Symbol[] symbols = Symbol.values();

        for (int i = 0; i < symbols.length; i++) {
            for (int j = 1; j <= 13; j++) {
                deck.add(new Card(j,symbols[i]));
            }
        }

        return deck;
    }
    /**
     * Extracts a card from the deck at the specified index.
     */
    public HashMap<Integer,ArrayList<Card>> extractCardAtIndex(ArrayList<Card> deck, int indic){
        ArrayList<Card> cardDeleted = new ArrayList<>();
        cardDeleted.add(deck.remove(indic));

        HashMap<Integer,ArrayList<Card>> extractThCard = new HashMap<>();
        extractThCard.put(1,cardDeleted);
        extractThCard.put(2,deck);

        return extractThCard;
    }
    /**
     * Draws a random card from the deck and updates the deck.
     */
    public HashMap<Integer,ArrayList<Card>> drawRandomCard(ArrayList<Card> deck){

        Random rand = new Random();
        int indic = rand.nextInt(deck.size());

        HashMap<Integer,ArrayList<Card>> extractionResult = extractCardAtIndex(deck, indic);

        deck = extractionResult.get(2);
        newDeck.add(extractionResult.get(1).get(0));

        HashMap<Integer,ArrayList<Card>> DrawACard = new HashMap<>();
        DrawACard.put(1,deck);
        DrawACard.put(2,newDeck);

        return DrawACard;
    }
    /**
     * Shuffles the deck of cards by repeatedly drawing and adding cards back to the deck until it's shuffled.
     */
    public ArrayList<Card> shuffleDeck(ArrayList<Card> deck){
        while (!deck.isEmpty()) {
            HashMap<Integer, ArrayList<Card>> drawResult = drawRandomCard(deck);
            newDeck = drawResult.get(2); // Update newDeck with the drawn cards.
        }
        return newDeck;
    }
    /**
     * Calculates the total value of the player hand.
     */
    public int calculateCardsValue(Player player){
        ArrayList<Card> playerCards = player.getCards();
        int value =0;
        boolean hasAce = false;
        for (Card card : playerCards){
            int cardValue = card.getRange();
            if(cardValue == 1){
                hasAce=true;
                value += 11;
            } else if (cardValue >=10) {
                value += 10;
            } else {
                value += cardValue;
            }
        }

        if( hasAce && value > MAX_CARDS_VALUE){
            value -= 10;
        }

        return value;
    }
    /**
     * Handles the player's turn.
     */
    public void PalyerPaly(){
        Scanner sc = new Scanner(System.in);
        if(player.getCards().size()<2){
            player.addCard(deck.remove(0));
        }else{
            if(calculateCardsValue(player)!=MAX_CARDS_VALUE){
                System.out.println(Colors.YELLOW + "\n\n1 -> Hit" + Colors.RESET);
                System.out.println(Colors.YELLOW + "2 -> Stand " + Colors.RESET);
                System.out.print("Enter your choice : ");
                int responce = sc.nextInt();
                if(responce == 1){
                    player.addCard(deck.remove(0));
                }else{
                    isPlayerTurn = false;
                }
                if(calculateCardsValue(player) == MAX_CARDS_VALUE){
                    isPlayerTurn = false;
                }
                if(calculateCardsValue(player) > MAX_CARDS_VALUE){
                    isPlayerTurn = false;
                    isGameInProgress = false;
                }
            }else{
                isPlayerTurn = false;
            }
        }
    }
    /**
     * Handles the dealer's turn.
     */
    public void DealerPlay(){
        if(dealer.getCards().size()<2){
            dealer.addCard(deck.remove(0));
        } else if (calculateCardsValue(dealer) < calculateCardsValue(player)) {
            dealer.addCard(deck.remove(0));
        }else{
            isGameInProgress = false;
        }

        if(dealer.getCards().size()>=2 && calculateCardsValue(dealer)>calculateCardsValue(player) || calculateCardsValue(dealer)>=MAX_CARDS_VALUE){
            isGameInProgress=false;
        }
    }
    /**
     * Prints the cards and their values for the player and dealer.
     */
    public void printPlayerAndDealerCards(){
        System.out.println("\n"+dealer.getName()+"  "+dealer.getCards()+"  values => " + calculateCardsValue(dealer));
        System.out.println(player.getName()+"  "+player.getCards()+"  values => " + calculateCardsValue(player));
    }
    /**
     * Determines the winner of the game based on the card values.
     */
    public void determineWinner(){
        int playerValue = calculateCardsValue(player);
        int dealerValue = calculateCardsValue(dealer);
        if (playerValue == MAX_CARDS_VALUE && dealerValue == MAX_CARDS_VALUE) {
            System.out.println(Colors.YELLOW + "\n\nIt's a tie! Both player and dealer have blackjack!,bets have been refunded" + Colors.RESET);
        } else if (playerValue == MAX_CARDS_VALUE) {
            System.out.println(Colors.BLUE + "\n\nPlayer wins with blackjack! wins $" +player.getBet()*1.5 + Colors.RESET);
        } else if (dealerValue == MAX_CARDS_VALUE) {
            System.out.println(Colors.RED + "\n\nDealer wins with blackjack!" + Colors.RESET);
        } else {
            // Compare total card values to determine the winner.
            if (playerValue > MAX_CARDS_VALUE) {
                System.out.println(Colors.RED + "\n\nDealer wins. Player busts!" + Colors.RESET);
            } else if (dealerValue > MAX_CARDS_VALUE) {
                System.out.println(Colors.BLUE + "\n\nPlayer wins. Dealer busts! wins $" +player.getBet()*2 + Colors.RESET);
            } else if (playerValue > dealerValue) {
                System.out.println(Colors.BLUE + "\n\nPlayer wins! wins $" +player.getBet()*2 + Colors.RESET);
            } else if (dealerValue > playerValue) {
                System.out.println(Colors.RED + "\n\nDealer wins!" + Colors.RESET);
            } else {
                System.out.println(Colors.YELLOW + "\n\nIt's a tie!,bets have been refunded" + Colors.RESET);
            }
        }
    }
    /**
     * Starts the game and handles player and dealer turns until the game ends.
     */
    public void play(){
        DealerPlay();
        while (isGameInProgress){
            while (isPlayerTurn){
                PalyerPaly();
                printPlayerAndDealerCards();
            }
            if(isGameInProgress){
                DealerPlay();
                printPlayerAndDealerCards();
            }
        }
        determineWinner();
    }
}
