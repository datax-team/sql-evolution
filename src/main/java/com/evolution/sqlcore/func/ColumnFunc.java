package com.evolution.sqlcore.func;

import com.evolution.sqlcore.elements.ValueElement;
import com.evolution.sqlcore.elements.ColumnInfo;
import com.evolution.sqlcore.elements.TableInfo;

public class ColumnFunc {
    private TableInfo tableInfo;

    public static ColumnInfo column(TableInfo tableInfo, String columnName) {
        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.setColumnName(columnName);
        new TableFunc().setColumnOfTableInfo(tableInfo, columnInfo);
        return columnInfo;
    }

    public static ColumnInfo column(String columnName) {
        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.setColumnName(columnName);
        return columnInfo;
    }

    public static ValueElement value(Object value) {
        ValueElement valueElement = new ValueElement();
        valueElement.setValue(valueElement);
        return valueElement;
    }

    public static ColumnInfo columnAs(TableInfo tableInfo, String columnName, String alias) {
        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.setColumnName(columnName);
        columnInfo.setAlias(alias);
        new TableFunc().setColumnOfTableInfo(tableInfo, columnInfo);
        return columnInfo;
    }

    public static ColumnInfo columnAs(String columnName, String alias) {
        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.setColumnName(columnName);
        columnInfo.setAlias(alias);
        return columnInfo;
    }
}
