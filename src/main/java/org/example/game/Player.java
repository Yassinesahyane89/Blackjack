package org.example.game;

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
}
