package com.ananth.game.model.weapon;

public class Weapon {

    protected int WEAPON_MAX_POWER = 100;

    void hit() {

    }

    @Override
    public String toString() {
        return "Weapon{" +
                "WEAPON_MAX_POWER=" + WEAPON_MAX_POWER +
                '}';
    }
}
