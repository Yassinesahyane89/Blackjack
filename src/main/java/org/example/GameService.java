package org.example;

public class GameService {
    public static Card[] CreateDeck(){

        Card[] deck = new Card[52];

        int cardIndex = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck[cardIndex] = new Card(j+1,CardConstants.suits[i]);
                cardIndex++;
            }
        }
        return deck;
    }

    public static int SuitsElementIndex(String suit){
        int elementIndex = -1;
        String[] suits = CardConstants.suits;
        for (int i = 0; i < suits.length; i++) {
            if(suit.equals(suits[i])){
                elementIndex = i;
            }
        }

        return elementIndex;
    }

    public static Card[] CreateSubDeck(Card startingCard){

        int suitIndex = SuitsElementIndex(startingCard.getSuit());
        int lengthDeck = ((CardConstants.suits.length-1) - suitIndex )*13 + 13 - startingCard.getRange();

        Card[] deck = new Card[lengthDeck];

        int cardIndex = 0;
        int startingCardRange = startingCard.getRange();
        for (int i = suitIndex; i <4 ; i++) {
            for (int j = startingCardRange; j < 13; j++) {
                deck[cardIndex] = new Card(j+1,CardConstants.suits[i]);
                cardIndex++;
            }
            startingCardRange=0;
        }

        return deck;
    }

    public static Card[] DeleteElementFromArray(Card[] deck, int indic){

        int lenghtOldDeck = deck.length;
        Card[] newDeck = new Card[lenghtOldDeck-1];
        for (int i = 0; i < indic; i++) {
            newDeck[i] = deck[i];
        }
        for (int i = 0; i < lenghtOldDeck-1-indic; i++) {
            newDeck[indic + i] = deck[indic + 1 + i];
        }
        return newDeck;
    }
    public static ExtractionResult extractThCard(Card[] deck, int indic){
        Card cardDeleted = deck[indic-1];
        Card[] newDeck = DeleteElementFromArray(deck,indic);
        return new ExtractionResult(cardDeleted, newDeck);
    }
}
