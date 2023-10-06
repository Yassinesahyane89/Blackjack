package org.example.services;

import org.example.util.CardConstants;
import org.example.model.Card;

import java.util.Random;

public class GameService {
    public  static final String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    public static Card[] newDeck = new Card[52];
    public static Integer newSize =0;
    public static Card[] CreateDeck(){

        Card[] deck = new Card[52];

        int cardIndex = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck[cardIndex] = new Card(j+1, CardConstants.suits[i]);
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

    public static Card[] DeleteElementFromArray(Card[] deck, int indic) {
        int lengthOldDeck = deck.length;
        Card[] newDeck = new Card[lengthOldDeck - 1];

        for (int i = 0; i < indic - 1; i++) {
            newDeck[i] = deck[i];
        }

        for (int i = indic; i < lengthOldDeck; i++) {
            newDeck[i - 1] = deck[i];
        }

        return newDeck;
    }
    public static Card[][] extractThCard(Card[] deck, int indic){
        Card cardDeleted = deck[indic-1];
        Card[] remainingCards = DeleteElementFromArray(deck,indic);

        Card[][] result = new Card[2][];
        result[0] = new Card[]{cardDeleted};
        result[1] = remainingCards;

        return result;
    }
    public static Card[][] DrawACard(Card[] deck){

        Random rand = new Random();
        int indic = rand.nextInt(deck.length) + 1;

        Card[][] extractionResult = extractThCard(deck, indic);

        deck = extractionResult[1];
        newDeck[newSize]=extractionResult[0][0];
        newSize++;

        Card[][] DrawACard = new Card[2][];
        DrawACard[0] = deck;
        DrawACard[1] = newDeck;
        return DrawACard;
    }
    public static Card[] ShuffleGameCards(Card[] deck){
        while (deck.length != 0) {
            Card[][] shuffleCards = DrawACard(deck);
            deck = shuffleCards[0];
        }
        return newDeck;
    }
    public static Card[][] drawNCards(Card[] deck, int n) {
        Card[] drawnCards = new Card[n];
        Card[] remainingCards = new Card[deck.length - n];

        for (int i = 0; i < n; i++) {
            drawnCards[i] = deck[i];
        }

        for (int i = n; i < deck.length; i++) {
            remainingCards[i - n] = deck[i];
        }

        Card[][] result = new Card[2][];
        result[0] = drawnCards;
        result[1] = remainingCards;

        return result;
    }
    public static Card[] DiscardCards(Card[] list1, Card[] list2){
        Card[] newList = new Card[list1.length+list2.length];
        int index=0;
        for (int i = 0; i <list1.length ; i++) {
            newList[index] = list1[i];
            index++;
        }
        for (int i = 0; i < list2.length; i++) {
            newList[index] = list2[i];
            index++;
        }

        return newList;
    }

}
