package org.example;

import lombok.Data;
@Data
public class ExtractionResult {
    private Card extractedCard;
    private Card[] remainingCards;
    public ExtractionResult(Card extractedCard, Card[] remainingCards) {
        this.extractedCard = extractedCard;
        this.remainingCards = remainingCards;
    }
}