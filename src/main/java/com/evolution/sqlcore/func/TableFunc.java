package com.evolution.sqlcore.func;

import com.evolution.sqlcore.elements.ColumnInfo;
import com.evolution.sqlcore.elements.TableInfo;

public class TableFunc {
    public static TableInfo createTable(String tableName) {
        return new TableInfo().tableName(tableName);
    }

    public static TableInfo createTable(String tableName, String alias) {
        return new TableInfo().tableName(tableName).alias(alias);
    }

    public void setColumnOfTableInfo(TableInfo tableInfo, ColumnInfo columnInfo) {
        if (tableInfo != null) {
            columnInfo.setDatabaseName(tableInfo.getDatabaseName());
            columnInfo.setSchema(tableInfo.getSchema());
            columnInfo.setTableName(tableInfo.getTableName());
            columnInfo.setTableAlias(tableInfo.getAlias());
        }
    }
}
