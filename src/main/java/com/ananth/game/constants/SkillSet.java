package com.ananth.game.constants;

public enum SkillSet {

    FIGHTING("FIGHTING");

    private String skillName;

    SkillSet(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillName() {
        return this.skillName;
    }
}
