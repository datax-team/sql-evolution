package com.evolution.sqlcore.enums;

public enum ColumnTypeEnum {
    INT("int", "int"),
    VARCHAR("varchar", "string"),
    CHAR("char", "string"),
    DATE("date", "date"),
    TIMESTAMP("timestamp", "date"),
    BIGINT("bigint", "long"),
    DECIMAL("decimal", "double"),
    FLOAT("float", "float"),
    DOUBLE("double", "double"),
    BOOLEAN("boolean", "boolean"),
    TEXT("text", "string"),
    LONGTEXT("longtext", "string"),
    TINYINT("tinyint", "int"),
    SMALLINT("smallint", "int"),
    BIT("bit", "boolean"),
    BLOB("blob", "string"),
    YEAR("year", "int");
    public String code;
    public String name;

    ColumnTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ColumnTypeEnum getColumnTypeByCode(String code) {
        for (ColumnTypeEnum columnType : ColumnTypeEnum.values()) {
            if (columnType.code.equalsIgnoreCase(code)) {
                return columnType;
            }
        }
        System.out.println("没有找到对应的类型");
        throw new RuntimeException("没有找到对应的类型");
    }


}
