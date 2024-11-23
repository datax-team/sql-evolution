package com.evolution.sqlcore.enums;

public enum ColumnKeyEnum {

    /**
     * 主键
     */
    PRIMARY_KEY("PRIMARY_KEY", "主键"),
    /**
     * 唯一键
     */
    UNIQUE_KEY("UNIQUE_KEY","唯一键");

    private String code;
    private String name;

    ColumnKeyEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public static ColumnKeyEnum getColumnKeyByCode(String code) {
        for (ColumnKeyEnum columnKeyEnum : ColumnKeyEnum.values()) {
            if (columnKeyEnum.getCode().equalsIgnoreCase(code)) {
                return columnKeyEnum;
            }
        }
        throw new RuntimeException("未找到对应的列主键类型");
    }
}
