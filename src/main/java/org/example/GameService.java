package org.example;

public class GameService {

    public static Card[] CreateDeck(){
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
        Card[] deck = new Card[52];

        int cardIndex = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck[cardIndex] = new Card(j,suits[i]);
                cardIndex++;
            }
        }
        return deck;
    }
}
