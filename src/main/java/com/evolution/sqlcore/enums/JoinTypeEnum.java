package com.evolution.sqlcore.enums;

public enum JoinTypeEnum {
    FROM("FROM"),
    INNER("INNER JOIN"),
    LEFT("LEFT JOIN"),
    RIGHT("RIGHT JOIN"),
    FULL("FULL OUTER JOIN");

    private String code;

    JoinTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    public static JoinTypeEnum getJoinTypeByCode(String code) {
        for (JoinTypeEnum joinTypeEnum : JoinTypeEnum.values()) {
            if (joinTypeEnum.getCode().equals(code)) {
                return joinTypeEnum;
            }
        }
        return null;
    }
}
