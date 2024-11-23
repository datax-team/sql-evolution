package com.evolution.sqlcore.elements;

import com.evolution.sqlcore.func.ColumnFunc;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TableInfo {
    @Getter
    private String databaseName;
    @Getter
    private String schema;
    @Getter
    private String tableName;
    @Getter
    private String alias;
    @Getter
    public List<ColumnInfo> columns = new ArrayList<>();
    public String getTableFlag() {
        if (StringUtils.isNotEmpty(alias)) {
            return alias;
        } else {
            return tableName;
        }
    }

    public TableInfo databaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }
    public TableInfo schema(String schema) {
        this.schema = schema;
        return this;
    }
    public TableInfo tableName(String tableName) {
        this.tableName = tableName;
        return this;
    }
    public TableInfo alias(String alias) {
        this.alias = alias;
        return this;
    }
    public ColumnInfo column(String columnName) {
        return ColumnFunc.column(this,columnName);
    }

    public ColumnInfo columnAs(String columnName, String columnAlias) {
        return ColumnFunc.columnAs(this,columnName,columnAlias);
    }
    public TableInfo addColumn(String columnName) {
        columns.add(column(columnName));
        return this;
    }

    public TableInfo addColumnAs(String columnName, String columnAlias) {
        columns.add(columnAs(columnName,columnAlias));
        return this;
    }

}
