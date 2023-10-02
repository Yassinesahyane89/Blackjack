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

    public static int ElementIndex(String suit){
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

        int suitIndex = ElementIndex(startingCard.getSuit());
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
}
