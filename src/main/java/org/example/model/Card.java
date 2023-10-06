package org.example.model;

import lombok.Data;

@Data
public class Card {
    /**
     * Integer value of the card.
     */
    private int range;
    /**
     * Symbol of the suit.
     */
    private Symbol symbol;
    /**
     * Constructor for a card.
     */
    public Card(int range, Symbol symbol) {
        this.range = range;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return  "[ "+range + " , " + symbol + " ]";
    }
}
