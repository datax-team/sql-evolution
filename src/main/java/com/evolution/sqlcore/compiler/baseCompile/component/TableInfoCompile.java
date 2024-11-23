package com.evolution.sqlcore.compiler.baseCompile.component;

import com.evolution.sqlcore.compiler.baseCompile.CompileConfig;
import com.evolution.sqlcore.compiler.baseCompile.syntaxConfig.KeyConstraint;
import com.evolution.sqlcore.elements.TableInfo;
import lombok.Setter;

public class TableInfoCompile {
    @Setter
    private CompileConfig compileConfig;

    public String compile(TableInfo tableInfo) {
        String databaseName = compileDatabaseName(tableInfo.getDatabaseName());
        String schema = compileSchema(tableInfo.getSchema());
        String tableName = compileTableName(tableInfo.getTableName());
        String tableAlias = compileTableAlias(tableInfo.getAlias());
        String str = null;
        if ("".equals(tableAlias)) {
            str = String.format("%s%s%s",
                    databaseName, schema, tableName);
        } else {
            str = String.format("%s%s%s%s%s%s%s",
                    databaseName, schema, tableName, compileConfig.getKeyConstraint().SPACE(), compileConfig.getKeyConstraint().AS(), compileConfig.getKeyConstraint().SPACE(), tableAlias);
        }
        compileConfig.setIsLastElementSpace(false);
        return str;
    }

    public String compileDatabaseName(String databaseName) {
        if (databaseName != null) {
            return String.format("%s%s%s%s",
                    compileConfig.getKeyConstraint().DATABASE_NAME_LEFT_BRACKET(),
                    databaseName,
                    compileConfig.getKeyConstraint().DATABASE_NAME_RIGHT_BRACKET(),
                    compileConfig.getKeyConstraint().DOT());
        } else {
            return KeyConstraint.EMPTY;
        }
    }

    public String compileSchema(String schema) {
        if (schema != null) {
            return String.format("%s%s%s%s",
                    compileConfig.getKeyConstraint().SCHEMA_NAME_LEFT_BRACKET(),
                    schema, compileConfig.getKeyConstraint().SCHEMA_NAME_RIGHT_BRACKET(),
                    compileConfig.getKeyConstraint().DOT());
        } else {
            return KeyConstraint.EMPTY;
        }
    }

    public String compileTableName(String tableName) {
        if (tableName != null) {
            return String.format("%s%s%s",
                    compileConfig.getKeyConstraint().TABLE_NAME_LEFT_BRACKET(),
                    tableName,
                    compileConfig.getKeyConstraint().TABLE_NAME_RIGHT_BRACKET());
        }
        return KeyConstraint.EMPTY;
    }

    public String compileTableAlias(String alias) {
        if (alias != null) {
            return String.format("%s%s%s",
                    compileConfig.getKeyConstraint().TABLE_NAME_LEFT_BRACKET(),
                    alias,
                    compileConfig.getKeyConstraint().TABLE_NAME_RIGHT_BRACKET());
        } else {
            return KeyConstraint.EMPTY;
        }
    }
}
