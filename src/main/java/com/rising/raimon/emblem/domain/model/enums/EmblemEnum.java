package com.rising.raimon.emblem.domain.model.enums;

public enum EmblemEnum {

    EMBLEM_ADMIN("ADMIN", 100),
    EMBLEM_FOUNDER_PLAYER("FOUNDER_PLAYER", 1);

    private final String name;
    private final int level;

    EmblemEnum(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
}
