package org.example;

import org.example.game.Player;

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
        while (playerName.isEmpty() || playerName.matches("^[a-zA-Z0-9]*$")){
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
        while (playerMoney<=0){
            System.out.println("Invalid money amount. Please enter a non-negative integer.");
            System.out.print("Enter how much money you have: ");
            playerMoney = sc.nextInt();
        }
        player.setMoney(playerMoney);
    }

}
