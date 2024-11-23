package com.evolution.sqlcore.enums;

public enum AggregateTypeEnum {
    AVG("AVG"),
    COUNT("COUNT"),
    MAX("MAX"),
    MIN("MIN"),
    SUM("SUM");
    private String code;

    private AggregateTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static AggregateTypeEnum getEnum(String code) {
        for (AggregateTypeEnum aggregateTypeEnum : AggregateTypeEnum.values()) {
            if (aggregateTypeEnum.getCode().equals(code)) {
                return aggregateTypeEnum;
            }
        }
        return null;
    }
}
