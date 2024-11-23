package com.evolution.sqlcore.compiler.baseCompile.component;

import com.evolution.sqlcore.compiler.baseCompile.CompileConfig;
import com.evolution.sqlcore.compiler.baseCompile.syntaxConfig.KeyConstraint;
import com.evolution.sqlcore.elements.ColumnInfo;
import lombok.Setter;

public class ColumnInfoCompile {
    @Setter
    private CompileConfig compileConfig;

    public void compile(ColumnInfo columnInfo) {
        StringBuilder sqlBuilder = compileConfig.getSqlBuilder();
        buildSql(sqlBuilder, columnInfo);
        compileConfig.setIsLastElementSpace(false);
    }

    public String singleCompile(ColumnInfo columnInfo) {
        StringBuilder sqlBuilder = new StringBuilder();
        buildSql(sqlBuilder, columnInfo);
        compileConfig.setIsLastElementSpace(false);
        return sqlBuilder.toString();
    }

    public void buildSql(StringBuilder sqlBuilder, ColumnInfo columnInfo) {
        if (columnInfo.getAggregateType() != null) {
            sqlBuilder.append(columnInfo.getAggregateType().getCode())
                    .append(compileConfig.getKeyConstraint().LEFT_BRACKET());
        }
        String databaseName = compileConfig.getTableInfoCompile().compileDatabaseName(columnInfo.getDatabaseName());
        String schema = compileConfig.getTableInfoCompile().compileSchema(columnInfo.getSchema());
        String tableName = compileConfig.getTableInfoCompile().compileTableName(columnInfo.getTableName());
        tableName = String.format("%s%s%s", databaseName, schema, tableName);
        String tableAlias = compileConfig.getTableInfoCompile().compileTableAlias(columnInfo.getTableAlias());

        if (!tableAlias.equals(KeyConstraint.EMPTY)) {
            sqlBuilder
                    .append(tableAlias)
                    .append(compileConfig.getKeyConstraint().DOT());
        }
        if (tableAlias.equals(KeyConstraint.EMPTY) && !tableName.equals(KeyConstraint.EMPTY)) {
            sqlBuilder.append(tableName)
                    .append(compileConfig.getKeyConstraint().DOT())
            ;
        }
        sqlBuilder.append(compileConfig.getKeyConstraint().COLUMN_LEFT_BRACKET())
                .append(columnInfo.getColumnName())
                .append(compileConfig.getKeyConstraint().COLUMN_RIGHT_BRACKET());
        if (columnInfo.getAggregateType() != null) {
            sqlBuilder
                    .append(compileConfig.getKeyConstraint().RIGHT_BRACKET());
        }
        String columnAlias = compileColumnAlias(columnInfo.getAlias());
        if (!columnAlias.equals(KeyConstraint.EMPTY)) {
            sqlBuilder.append(columnAlias);
        }
        compileConfig.setIsLastElementSpace(false);
    }

    public String compileColumnAlias(String alias) {
        if (alias != null) {
            return String.format("%s%s%s%s%s%s",
                    compileConfig.getKeyConstraint().SPACE(),
                    compileConfig.getKeyConstraint().AS(),
                    compileConfig.getKeyConstraint().SPACE(),
                    compileConfig.getKeyConstraint().COLUMN_LEFT_BRACKET(),
                    alias,
                    compileConfig.getKeyConstraint().COLUMN_RIGHT_BRACKET());

        } else {
            compileConfig.setIsLastElementSpace(false);
            return KeyConstraint.EMPTY;
        }

    }

    public void appendSpace(StringBuilder sqlBuilder) {
        if (!compileConfig.getIsLastElementSpace()) {
            sqlBuilder.append(compileConfig.getKeyConstraint().SPACE());
            compileConfig.setIsLastElementSpace(true);
        }
    }
}
