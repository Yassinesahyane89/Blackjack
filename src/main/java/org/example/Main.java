package org.example;

public class Main {

    public static void main(String[] args) {
        Card[] deck= GameService.CreateDeck();
        Card[] newDeck = GameService.DeleteElementFromArray(deck, 2);

        for (Card card: newDeck) {
            System.out.println("[ " + card.getRange() + "," + card.getSuit() + " ]");
        }



    }

}
