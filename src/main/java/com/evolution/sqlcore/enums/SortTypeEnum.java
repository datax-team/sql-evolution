package com.evolution.sqlcore.enums;

public enum SortTypeEnum {
    ASC("ASC"),
    DESC("DESC");

    private String code;

    SortTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    public static SortTypeEnum getEnum(String key) {
        for (SortTypeEnum orderByEnum : SortTypeEnum.values()) {
            if (orderByEnum.getCode().equals(key)) {
                return orderByEnum;
            }
        }
        return null;
    }
}
