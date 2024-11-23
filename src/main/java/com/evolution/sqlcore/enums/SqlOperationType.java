package com.evolution.sqlcore.enums;

public enum SqlOperationType {
    SELECT("SELECT"),
    INSERT("INSERT"),
    UPDATE("UPDATE");

    private final String code;

    SqlOperationType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    public static SqlOperationType getByCode(String code) {
        for (SqlOperationType sqlOperationType : SqlOperationType.values()) {
            if (sqlOperationType.getCode().equals(code)) {
                return sqlOperationType;
            }
        }
        return null;
    }
}
