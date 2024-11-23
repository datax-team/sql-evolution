package com.evolution.sqlcore.compiler.baseCompile;

import com.evolution.sqlcore.compiler.baseCompile.baseConfig.KeyConstraintProvider;
import com.evolution.sqlcore.compiler.baseCompile.component.*;
import lombok.Getter;
import lombok.Setter;

public class CompileConfig {
    private StringBuilder sqlBuilder;
    @Getter
    @Setter
    private TableInfoCompile tableInfoCompile;
    @Getter
    @Setter
    private ColumnInfoCompile columnInfoCompile;
    @Getter
    @Setter
    private SqlElementCompile sqlElementCompile;
    @Getter
    @Setter
    private SqlElementEnumCompile sqlElementEnumCompile;
    @Getter
    @Setter
    private SqlFuncCompile sqlFuncCompile;
    @Getter
    @Setter
    private ComparisonOperatorEnumCompile comparisonOperatorEnumCompile;
    @Getter
    @Setter
    private BasicTypeCompile basicTypeCompile;
    @Getter
    @Setter
    private ValueCompile valueCompile;
    @Getter
    @Setter
    private SymbolElementEnumCompile symbolElementEnumCompile;
    @Getter
    @Setter
    private ConditionInfoCompile conditionInfoCompile;
    @Getter
    @Setter
    private ConvertFuncCompile convertFuncCompile;
    @Getter
    @Setter
    private Boolean formatSql;
    @Getter
    @Setter
    private KeyConstraintProvider keyConstraint;

    public CompileConfig() {
        this.formatSql = false;
        this.sqlFuncCompile = new SqlFuncCompile();
        this.sqlFuncCompile.setCompileConfig(this);
        this.columnInfoCompile = new ColumnInfoCompile();
        this.columnInfoCompile.setCompileConfig(this);
        this.tableInfoCompile = new TableInfoCompile();
        this.tableInfoCompile.setCompileConfig(this);
        this.sqlElementCompile = new SqlElementCompile();
        this.sqlElementCompile.setCompileConfig(this);
        this.sqlElementEnumCompile = new SqlElementEnumCompile();
        this.sqlElementEnumCompile.setCompileConfig(this);
        this.comparisonOperatorEnumCompile = new ComparisonOperatorEnumCompile();
        this.comparisonOperatorEnumCompile.setCompileConfig(this);
        this.basicTypeCompile = new BasicTypeCompile();
        this.basicTypeCompile.setCompileConfig(this);
        this.conditionInfoCompile = new ConditionInfoCompile();
        this.conditionInfoCompile.setCompileConfig(this);
        this.valueCompile = new ValueCompile();
        this.valueCompile.setCompileConfig(this);
        this.valueCompile.setCompileConfig(this);
        this.symbolElementEnumCompile = new SymbolElementEnumCompile();
        this.symbolElementEnumCompile.setCompileConfig(this);
    }

    public StringBuilder getSqlBuilder() {
        if (sqlBuilder == null) {
            sqlBuilder = new StringBuilder();
        }
        return sqlBuilder;
    }

    /**
     * 是否为最后一个元素
     */
    @Getter
    @Setter
    public Boolean isLastElementSpace = false;
}
