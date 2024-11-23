package com.evolution.sqlcore.elements;

import com.evolution.sqlcore.enums.AggregateTypeEnum;
import com.evolution.sqlcore.enums.ColumnKeyEnum;
import com.evolution.sqlcore.enums.ColumnTypeEnum;
import lombok.Data;

@Data
public class ColumnInfo {
    private String DatabaseName;
    private String Schema;
    private String tableAlias;
    private String tableName;
    /**
     * 列名
     */
    private String columnName;

    /**
     * 别名
     */
    private String alias;

    /**
     * 数据类型
     */
    private ColumnTypeEnum columnType;

    /**
     * 列注释
     */
    private String columnComment;

    /**
     * 默认值
     */
    private String columnDefault;

    /**
     * 列键
     */
    private ColumnKeyEnum columnKey;

    /**
     * 长度
     */
    private String columnLength;
    /**
     * 小数位数
     */
    private String columnScale;

    /**
     * 是否是子查询
     */
    private boolean isSubQuery;

    /**
     * 聚合类型
     */
    private AggregateTypeEnum aggregateType;

    public ColumnInfo() {
    }

    public ColumnInfo(String columnName, String alias) {
        this.columnName = columnName;
        this.alias = alias;
    }
    public ColumnInfo(String columnName, AggregateTypeEnum aggregateType) {
        this.columnName = columnName;
        this.aggregateType = aggregateType;
    }
    public ColumnInfo(String columnName, String alias, AggregateTypeEnum aggregateType) {
        this.columnName = columnName;
        this.aggregateType = aggregateType;
        this.alias = alias;
    }
    public ColumnInfo(String columnName) {
        this.columnName = columnName;
    }
}
