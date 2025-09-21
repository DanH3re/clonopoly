package dev.clonopoly.game;

public class Player {
    private String name;
    private int position;
    private int money;

    public Player(String name) {
        this.name = name;
        this.position = 0; // Start position
        this.money = 1500; // Starting money
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}