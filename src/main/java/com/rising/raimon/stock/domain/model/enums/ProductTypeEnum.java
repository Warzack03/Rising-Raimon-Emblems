package com.rising.raimon.stock.domain.model.enums;

public enum ProductTypeEnum {

    FAN_SHIRTS("FAN_SHIRTS"),
    PLAYER_SHIRTS("PLAYER_SHIRTS"),
    STRING_BACKPACK("STRING_BACKPACK"),
    SCARF("SCARF"),
    FLAG("FLAG");

    private final String value;

    ProductTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
