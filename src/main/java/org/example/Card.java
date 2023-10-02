package org.example;

import lombok.Data;

@Data
public class Card {
    private int Range;
    private String Suit;

    public Card(int range, String suit) {
        Range = range;
        Suit = suit;
    }
}
