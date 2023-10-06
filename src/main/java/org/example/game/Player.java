package org.example.game;

import lombok.Data;

@Data
public class Player {
    /**
     * Player's name.
     */
    private String name;
    /**
     * Player's money.
     */
    private int money;
    /**
     * Player's bet.
     */
    private int bet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}
