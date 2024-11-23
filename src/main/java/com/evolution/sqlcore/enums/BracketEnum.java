package com.evolution.sqlcore.enums;

public enum BracketEnum {
    Left("(", "左括号"),
    Right(")", "右括号");
    private String code;
    private String name;

    BracketEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    public static BracketEnum getBracketByCode(String code) {
        for (BracketEnum bracketEnum : BracketEnum.values()) {
            if (bracketEnum.getCode().equals(code)) {
                return bracketEnum;
            }
        }
        return null;
    }
}
