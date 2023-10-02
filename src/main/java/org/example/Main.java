package org.example;

public class Main {

    public static void main(String[] args) {
        Card[] deck= GameService.CreateDeck();

        for (Card card: deck) {
            System.out.println("[ " + card.getRange() + "," + card.getSuit() + " ]");
        }


    }

}
