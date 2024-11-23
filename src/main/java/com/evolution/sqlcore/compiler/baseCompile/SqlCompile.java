package com.evolution.sqlcore.compiler.baseCompile;

import com.evolution.sqlcore.actions.Queryable;
import com.evolution.sqlcore.compiler.baseCompile.baseConfig.KeyConstraintProvider;
import lombok.Getter;
import lombok.Setter;
import com.evolution.sqlcore.compiler.baseCompile.component.ConvertFuncCompile;

import java.util.List;

public abstract class SqlCompile {
    @Getter
    @Setter
    private CompileConfig compileConfig=new CompileConfig();
    public void useKeyConstraint(KeyConstraintProvider keyConstraintProvider) {
        this.compileConfig.setKeyConstraint(keyConstraintProvider);
    }

    protected void useFormatSql(Boolean formatSql) {
        this.compileConfig.setFormatSql(formatSql);
    }
    protected void useConvertFuncCompile(ConvertFuncCompile convertFuncCompile) {
        this.compileConfig.setConvertFuncCompile(convertFuncCompile);
    }
    public String compile(Queryable queryable) {
        List<Object> sqlElements = queryable.getSqlElements();
        for (Object sqlElement : sqlElements) {
            this.compileConfig.getSqlElementCompile().compile(sqlElement);
        }
        return compileConfig.getSqlBuilder().toString().trim();
    }
}
