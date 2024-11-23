package com.evolution.sqlcore.compiler.baseCompile.component;

import lombok.Setter;
import com.evolution.sqlcore.compiler.baseCompile.CompileConfig;
import com.evolution.sqlcore.enums.SymbolElementEnum;

public class SymbolElementEnumCompile {
    @Setter
    private CompileConfig compileConfig;
    public String compile(SymbolElementEnum sqlElementEnum) {
        StringBuilder sqlBuilder = compileConfig.getSqlBuilder();
        switch (sqlElementEnum) {
            case LEFT_BRACKET:
                sqlBuilder.append(compileConfig.getKeyConstraint().LEFT_BRACKET());
                break;
            case RIGHT_BRACKET:
                sqlBuilder.append(compileConfig.getKeyConstraint().RIGHT_BRACKET());
                break;
            case COMMA:
                sqlBuilder.append(compileConfig.getKeyConstraint().COMMA());
                break;
            case DOT:
                sqlBuilder.append(compileConfig.getKeyConstraint().DOT());
                break;
            default:
                throw new IllegalArgumentException("[0028]未知的SQL元素: " + sqlElementEnum);
        }
        return sqlBuilder.toString();
    }
}
