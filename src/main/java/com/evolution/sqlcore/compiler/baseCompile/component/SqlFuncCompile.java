package com.evolution.sqlcore.compiler.baseCompile.component;

import com.evolution.sqlcore.compiler.baseCompile.CompileConfig;
import com.evolution.sqlcore.elements.ColumnInfo;
import com.evolution.sqlcore.func.SqlFunc;
import lombok.Setter;
import com.evolution.sqlcore.utils.StringTools;

import java.util.ArrayList;
import java.util.List;

public class SqlFuncCompile {
    @Setter
    private CompileConfig compileConfig;

    public void compile(SqlFunc sqlFunc) {
        List<Object> params = sqlFunc.getParams();
        String template = sqlFunc.getStrTemplate();
        List<String> paramList = compileParams(params);
        String sqlFuncStr = StringTools.format(template, paramList);
        compileConfig.getSqlBuilder().append(sqlFuncStr);
    }

    public List<String> compileParams(List<Object> params) {
        List<String> paramList = new ArrayList<>();
        if (params != null) {
            for (Object param : params) {
                if (param instanceof ColumnInfo) {
                    String paramStr = compileConfig.getColumnInfoCompile().singleCompile((ColumnInfo) param);
                    paramList.add(paramStr);
                } else {
                    String paramStr = compileConfig.getBasicTypeCompile().singleCompile(param);
                    paramList.add(paramStr);
                }
            }
        }
        return paramList;
    }
}
