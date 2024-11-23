package com.evolution.sqlcore.func;

import com.evolution.sqlcore.elements.ColumnInfo;
import com.evolution.sqlcore.elements.TableInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SqlFunc implements BaseFunc {
    private String strTemplate;
    public List<Object> params=new ArrayList<>();
    public SqlFunc column(String columnName) {
        ColumnInfo columnInfo = ColumnFunc.column(columnName);
        params.add(columnInfo);
        return this;
    }

    public SqlFunc column(TableInfo tableInfo, String columnName) {
        ColumnInfo columnInfo = ColumnFunc.column(tableInfo, columnName);
        params.add(columnInfo);
        return this;
    }
    public SqlFunc value(Object value) {
        params.add(value);
        return this;
    }
}
