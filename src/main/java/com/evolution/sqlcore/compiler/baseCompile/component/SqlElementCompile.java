package com.evolution.sqlcore.compiler.baseCompile.component;

import com.evolution.sqlcore.compiler.baseCompile.CompileConfig;
import com.evolution.sqlcore.compiler.baseCompile.baseConfig.KeyConstraintProvider;
import com.evolution.sqlcore.elements.ValueElement;
import com.evolution.sqlcore.enums.SymbolElementEnum;
import com.evolution.sqlcore.func.ConvertFunc;
import com.evolution.sqlcore.func.SqlFunc;
import com.evolution.sqlcore.elements.ColumnInfo;
import com.evolution.sqlcore.elements.ConditionInfo;
import com.evolution.sqlcore.elements.TableInfo;
import com.evolution.sqlcore.enums.SqlElementEnum;
import com.evolution.sqlcore.enums.ComparisonOperatorEnum;
import com.evolution.sqlcore.enums.SortTypeEnum;
import lombok.Setter;

import java.util.List;

public class SqlElementCompile {
    @Setter
    private CompileConfig compileConfig;

    public void compile(Object sqlElement) {
        StringBuilder sqlBuilder = compileConfig.getSqlBuilder();
        KeyConstraintProvider keyConstraint = compileConfig.getKeyConstraint();

        if (sqlElement instanceof SqlElementEnum) {
            compileConfig.getSqlElementEnumCompile().compile((SqlElementEnum) sqlElement);
        } else if (sqlElement instanceof SortTypeEnum) {
            SortTypeEnum sortType = (SortTypeEnum) sqlElement;
            appendSpace(sqlBuilder);
            if (sortType.getCode().equals(SortTypeEnum.ASC.getCode())) {
                sqlBuilder.append(keyConstraint.ASC());
            } else {
                sqlBuilder.append(keyConstraint.DESC());
            }
        } else if (sqlElement instanceof ConditionInfo) {
            compileConfig.getConditionInfoCompile().compile((ConditionInfo) sqlElement);
        } else if (sqlElement instanceof ColumnInfo) {
            compileConfig.getColumnInfoCompile().compile((ColumnInfo) sqlElement);
        } else if (sqlElement instanceof TableInfo) {
            sqlBuilder.append(compileConfig.getTableInfoCompile().compile((TableInfo) sqlElement));

        } else if (sqlElement instanceof List) {
            appendSpace(sqlBuilder);
            compileList(sqlElement);
        } else if (sqlElement instanceof ComparisonOperatorEnum) {
            compileConfig.getComparisonOperatorEnumCompile().compile((ComparisonOperatorEnum) sqlElement);
        } else if (sqlElement instanceof ValueElement) {
            compileConfig.getValueCompile().compile((ValueElement)sqlElement);
        } else if (sqlElement instanceof SymbolElementEnum) {
            compileConfig.getSymbolElementEnumCompile().compile((SymbolElementEnum)sqlElement);
        }
    }

    private void compileList(Object sqlElement) {
        StringBuilder sqlBuilder = compileConfig.getSqlBuilder();
        KeyConstraintProvider keyConstraint = compileConfig.getKeyConstraint();
        List<?> list = (List<?>) sqlElement;
        if (!list.isEmpty()) {
            for (Object element : list) {

                if (element instanceof ColumnInfo) {
                    compileConfig.getColumnInfoCompile().compile((ColumnInfo) element);
                    sqlBuilder.append(keyConstraint.COMMA());
                } else if (element instanceof SqlFunc) {
                    SqlFunc sqlFunc = (SqlFunc) element;
                    compileConfig.getSqlFuncCompile().compile(sqlFunc);
                    sqlBuilder.append(keyConstraint.COMMA());
                }
                else if (element instanceof ValueElement) {
                    ValueElement valueElement = (ValueElement) element;
                    compileConfig.getValueCompile().compile(valueElement);
                    sqlBuilder.append(keyConstraint.COMMA());
                }
                else if (element instanceof ConvertFunc) {
                    ConvertFunc convertFunc = (ConvertFunc) element;
                    compileConfig.getConvertFuncCompile().compile(convertFunc);
                    sqlBuilder.append(keyConstraint.COMMA());
                }
            }
            // 移除最后一个逗号
            if (sqlBuilder.length() > 0) {
                sqlBuilder.setLength(sqlBuilder.length() - 1);
            }
            sqlBuilder.append(keyConstraint.SPACE());
            compileConfig.setIsLastElementSpace(true);
        }
    }

    public void appendSpace(StringBuilder sqlBuilder) {
        if (!compileConfig.getIsLastElementSpace()) {
            sqlBuilder.append(compileConfig.getKeyConstraint().SPACE());
            compileConfig.setIsLastElementSpace(true);
        }
    }

}
