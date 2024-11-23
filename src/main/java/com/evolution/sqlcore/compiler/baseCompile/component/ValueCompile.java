package com.evolution.sqlcore.compiler.baseCompile.component;

import lombok.Setter;
import com.evolution.sqlcore.compiler.baseCompile.CompileConfig;
import com.evolution.sqlcore.elements.ValueElement;

@Setter
public class ValueCompile {
    private CompileConfig compileConfig;

    public void compile(ValueElement sqlElement) {
        StringBuilder sqlBuilder = compileConfig.getSqlBuilder();
        buildSql(sqlBuilder, sqlElement);
    }

    public String singleCompile(ValueElement sqlElement) {
        StringBuilder sqlBuilder = new StringBuilder();
        buildSql(sqlBuilder, sqlElement);
        return sqlBuilder.toString();
    }

    public void buildSql(StringBuilder sqlBuilder, ValueElement valueElement) {
        Object value = valueElement.getValue();
        compileConfig.getBasicTypeCompile().buildSql(sqlBuilder, value);
        if (valueElement.getAlias() != null) {
            sqlBuilder

                    .append(compileConfig.getKeyConstraint().SPACE())
                    .append(compileConfig.getKeyConstraint().AS())
                    .append(compileConfig.getKeyConstraint().SPACE())
                    .append(compileConfig.getKeyConstraint().COLUMN_LEFT_BRACKET())
                    .append(valueElement.getAlias())
                    .append(compileConfig.getKeyConstraint().COLUMN_RIGHT_BRACKET());
            ;
        }
    }
}
