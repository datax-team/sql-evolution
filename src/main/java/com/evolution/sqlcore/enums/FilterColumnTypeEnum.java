package com.evolution.sqlcore.enums;

public enum FilterColumnTypeEnum {
    Column("column"),
    Value("value");

    private final String code;

    FilterColumnTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
