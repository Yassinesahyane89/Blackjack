package org.example;

import lombok.Data;

@Data
public class DrawCardResult {
    private Card[] remainingCards;
    private Card[] newDeck;

    public DrawCardResult(Card[] remainingCards, Card[] newDeck) {
        this.remainingCards = remainingCards;
        this.newDeck = newDeck;
    }
}
