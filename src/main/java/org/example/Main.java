package org.example;

public class Main {

    public static void main(String[] args) {
        Card[] deck= GameService.CreateSubDeck(new Card(4,"Diamonds"));

        for (Card card: deck) {
            System.out.println("[ " + card.getRange() + "," + card.getSuit() + " ]");
        }


    }

}
