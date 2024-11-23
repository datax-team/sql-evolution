package com.evolution.sqlcore.compiler.baseCompile.component;

import com.evolution.sqlcore.compiler.baseCompile.CompileConfig;
import com.evolution.sqlcore.compiler.baseCompile.baseConfig.KeyConstraintProvider;
import com.evolution.sqlcore.elements.ColumnInfo;
import com.evolution.sqlcore.elements.ConditionInfo;
import com.evolution.sqlcore.enums.ComparisonOperatorEnum;
import lombok.Setter;

import java.util.List;

public class ConditionInfoCompile {
    @Setter
    private CompileConfig compileConfig;
    void compile(ConditionInfo conditionInfo) {
        StringBuilder sqlBuilder = compileConfig.getSqlBuilder();
        KeyConstraintProvider keyConstraint = compileConfig.getKeyConstraint();
        if (conditionInfo.getLeftValue() instanceof ColumnInfo) {
          compileConfig.getColumnInfoCompile().compile((ColumnInfo) conditionInfo.getLeftValue());
        } else {
            compileConfig.getBasicTypeCompile().compile(conditionInfo.getLeftValue());
        }

        sqlBuilder.append(keyConstraint.SPACE());
        compileConfig.getComparisonOperatorEnumCompile().compile(conditionInfo.getOperator());
        sqlBuilder.append(keyConstraint.SPACE());
        if (conditionInfo.getRightValue() instanceof ColumnInfo) {
            compileConfig.getColumnInfoCompile().compile((ColumnInfo) conditionInfo.getRightValue());
        } else {
            String operatorCode = conditionInfo.getOperator().getCode();
            if (operatorCode.equals(ComparisonOperatorEnum.Like.getCode())
                    || operatorCode.equals(ComparisonOperatorEnum.NotLike.getCode())
            ) {
                sqlBuilder
                        .append(keyConstraint.SINGLE_QUOTE())
                        .append(keyConstraint.PERCENT())
                        .append(conditionInfo.getRightValue())
                        .append(keyConstraint.PERCENT())
                        .append(keyConstraint.SINGLE_QUOTE())
                ;
            } else if (operatorCode.equals(ComparisonOperatorEnum.Between.getCode())
            ) {
                if (conditionInfo.getRightValue() instanceof List) {
                    List<?> list = (List<?>) conditionInfo.getRightValue();
                    if (list.size() == 2) {
                        compileConfig.getBasicTypeCompile().compile(list.get(0));
                        sqlBuilder
                                .append(keyConstraint.SPACE())
                                .append(keyConstraint.AND())
                                .append(keyConstraint.SPACE());
                        ;
                        compileConfig.getBasicTypeCompile().compile(list.get(1));
                    }
                }
            } else {
                compileConfig.getBasicTypeCompile().compile(conditionInfo.getRightValue());
            }
        }

    }
}
