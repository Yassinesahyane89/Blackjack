package org.example;

public class Main {

    public static void main(String[] args) {
        Card[] deck= GameService.CreateDeck();
        Card[] newDeck = GameService.ShuffleGameCards(deck);

        System.out.println(newDeck.length);

        for (Card card: newDeck) {
            System.out.println("[ " + card.getRange() + "," + card.getSuit() + " ]");
        }
    }

}
