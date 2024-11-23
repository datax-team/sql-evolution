package com.evolution.sqlcore.enums;

public enum DataTypeEnum {
    INT("int"),
    STRING("varchar"),
    TEXT("text"),
    DATE("date"),
    DATETIME("datetime"),
    BIGINT("bigint"),
    DECIMAL("decimal"),
    FLOAT("float"),
    DOUBLE("double"),
    BOOLEAN("boolean");

    private String code;

    DataTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    public static DataTypeEnum getDataTypeByCode(String code) {
        return DataTypeEnum.valueOf(code.toUpperCase());
    }
}
