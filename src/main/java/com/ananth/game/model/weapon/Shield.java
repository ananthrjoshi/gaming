package com.ananth.game.model.weapon;

public class Shield extends Weapon{

    private int maxPower = 100;

    private int quantity = 100;

    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Shield{" +
                "maxPower=" + maxPower +
                ", quantity=" + quantity +
                '}';
    }
}
