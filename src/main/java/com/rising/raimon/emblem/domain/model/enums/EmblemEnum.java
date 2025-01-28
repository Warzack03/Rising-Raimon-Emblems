package com.rising.raimon.emblem.domain.model.enums;

public enum EmblemEnum {

    EMBLEM_ADMIN("ADMIN", 1000),
    EMBLEM_FOUNDER_PLAYER("FOUNDER_PLAYER", 10);

    private final String value;
    private final int level;

    EmblemEnum(String value, int level) {
        this.value = value;
        this.level = level;
    }

    public String getValue() {
        return value;
    }
    public int getLevel() {
        return level;
    }
}
