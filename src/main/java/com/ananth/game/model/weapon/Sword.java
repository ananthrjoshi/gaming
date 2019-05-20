package com.ananth.game.model.weapon;

public class Sword extends Weapon {

    private int maxPower = 100;

    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    @Override
    public void hit() {

    }

    @Override
    public String toString() {
        return "Sword{" +
                "maxPower=" + maxPower +
                '}';
    }
}
