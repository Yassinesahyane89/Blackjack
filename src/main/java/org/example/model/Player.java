package org.example.model;

import lombok.Data;
import org.example.model.Card;

import java.util.ArrayList;

@Data
public class Player {
    /**
     * Player's name.
     */
    private String name;
    /**
     * Player's money.
     */
    private int money;
    /**
     * Player's bet.
     */
    private int bet;
    /**
     * Player's hand of cards.
     */
    private ArrayList<Card> cards;
    /**
     * Constructor for a player with default value.
     */
    public Player(){
        name = "undefined";
        cards = new ArrayList<>();
        money = 0;
        bet = 0;
    }
    /**
     * Adds a new card to the player's hand.
     */
    public void addCard(Card c){
        cards.add(c);
    }

}
