package org.example;

import org.example.services.BlackjackGame;
import org.example.model.Player;
import org.example.util.Colors;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Player player = new Player();

        /**
         * Enter Player name
         */
        System.out.print("Enter your name : ");
        String playerName = sc.nextLine();
        while (playerName.isEmpty() || !playerName.matches("^[a-zA-Z0-9]*$")){
            System.out.println("Invalid name. Please use only letters and numbers.");
            System.out.print("Enter your name : ");
            playerName = sc.nextLine();
        }

        /**
         * Enter Player Money.
         */
        player.setName(playerName);
        System.out.print("Enter how much money you have: ");
        int playerMoney = sc.nextInt();
        while (playerMoney<=0 || playerMoney < BlackjackGame.MIN_BET){
            System.out.println("Invalid money amount. Please enter a non-negative integer && greath than ."+BlackjackGame.MIN_BET);
            System.out.print("Enter how much money you have: ");
            playerMoney = sc.nextInt();
        }
        player.setMoney(playerMoney);

        System.out.println("Lets play ");
        System.out.println(Colors.YELLOW + "\n☛ Your account: $" + player.getMoney() + Colors.RESET);

        System.out.println("\nThe Min bet => "+BlackjackGame.MIN_BET);
        System.out.print("\nEnter your Bet :");
        int bet = sc.nextInt();
        while (bet > player.getMoney() || bet < BlackjackGame.MIN_BET){
            System.out.println(Colors.RED + "⚠ Attention ⚠ Enter a bet between " + BlackjackGame.MIN_BET + " and " + player.getMoney() + " : " + Colors.RESET);
            bet = sc.nextInt();
        }
        player.setBet(bet);

        BlackjackGame blackjackGame = new BlackjackGame(player);
        blackjackGame.play();

        System.out.println("\n\nThanks for playing!");
    }

}
