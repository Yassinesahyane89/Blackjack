package org.example.game;

import org.example.model.Card;
import org.example.model.Symbol;

import java.util.ArrayList;

public class BlackjackGame {
    /**
     * Maximum card value to win.
     */
    public static final int MAX_CARDS_VALUE = 21;
    /**
     * Minimum bet to play.
     */
    public static final int MIN_BET = 2;

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
}
