package com.ananth.game.constants;

public enum WeaponSet {

    FIREBALL("FIREBALL"),
    GUN("GUN"),
    SWORD("SWORD");

    private String weaponName;
    WeaponSet(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getWeaponName() {
        return this.weaponName;
    }
}
