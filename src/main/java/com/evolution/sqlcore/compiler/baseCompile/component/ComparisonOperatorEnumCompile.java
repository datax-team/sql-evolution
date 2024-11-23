package com.evolution.sqlcore.compiler.baseCompile.component;

import com.evolution.sqlcore.compiler.baseCompile.CompileConfig;
import com.evolution.sqlcore.compiler.baseCompile.baseConfig.KeyConstraintProvider;
import com.evolution.sqlcore.enums.ComparisonOperatorEnum;
import lombok.Setter;

public class ComparisonOperatorEnumCompile {
    @Setter
    private CompileConfig compileConfig;
    public void compile(ComparisonOperatorEnum comparisonOperatorEnum) {
        StringBuilder sqlBuilder = compileConfig.getSqlBuilder();
        KeyConstraintProvider keyConstraint = compileConfig.getKeyConstraint();
        switch (comparisonOperatorEnum) {
            case Equals:
                sqlBuilder.append(keyConstraint.EQUAL());
                break;
            case GreaterThan:
                sqlBuilder.append(keyConstraint.GREATER_THAN());
                break;
            case GreaterThanOrEqual:
                sqlBuilder.append(keyConstraint.GREATER_THAN_OR_EQUAL());
                break;
            case LessThan:
                sqlBuilder.append(keyConstraint.LESS_THAN());
                break;
            case LessThanOrEqual:
                sqlBuilder.append(keyConstraint.LESS_THAN_OR_EQUAL());
                break;
            case Like:
                sqlBuilder.append(keyConstraint.LIKE());
                break;
            case NotEquals:
                sqlBuilder.append(keyConstraint.NOT_EQUAL());
                break;
            case NotLike:
                sqlBuilder.append(keyConstraint.NOT_LIKE());
                break;
            case In:
                sqlBuilder.append(keyConstraint.IN());
                break;
            case NotIn:
                sqlBuilder.append(keyConstraint.NOT_IN());
                break;
            case Between:
                sqlBuilder.append(keyConstraint.BETWEEN());
                break;
            case NotBetween:
                sqlBuilder.append(keyConstraint.NOT_BETWEEN());
                break;
            case IsNull:
                sqlBuilder.append(keyConstraint.IS_NULL());
                break;
            case Not:
                sqlBuilder.append(keyConstraint.NOT());
                break;
        }
    }


}
