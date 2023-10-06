package org.example.game;

import org.example.model.Card;
import org.example.model.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class BlackjackGame {
    /**
     * Initial deck of the game composed of a number of cards multiple of 52 up to 416.
     */
    private final ArrayList<Card> deck = CreateDeck();
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
     * Constructor for a Blackjack game with an already initialized player.
     */

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
}
