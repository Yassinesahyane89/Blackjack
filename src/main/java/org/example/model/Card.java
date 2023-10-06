package org.example.model;

import lombok.Data;

@Data
public class Card {
    /**
     * Integer value of the card.
     */
    private int Range;
    /**
     * Symbol of the suit.
     */
    private Symbol symbol;
    /**
     * Constructor for a card.
     */
    public Card(int range, Symbol symbol) {
        Range = range;
        this.symbol = symbol;
    }
}
