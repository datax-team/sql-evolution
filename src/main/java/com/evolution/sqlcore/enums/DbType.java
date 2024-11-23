package com.evolution.sqlcore.enums;

public enum DbType {
    MYSQL("mysql"),
    POSTGRESQL("postgresql"),
    ORACLE("oracle"),
    SQLSERVER("sqlserver");

    private String code;

    DbType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static DbType getDbTypeByCode(String code) {
        for (DbType dbType : DbType.values()) {
            if (dbType.getCode().equals(code)) {
                return dbType;
            }
        }
        System.out.println("不支持的数据库类型：" + code);
        throw new RuntimeException("不支持的数据库类型：" + code);
    }
}
