package com.evolution.sqlcore.compiler.sqlServer.component;

import com.evolution.sqlcore.compiler.baseCompile.CompileConfig;
import com.evolution.sqlcore.compiler.baseCompile.component.ConvertFuncCompile;
import com.evolution.sqlcore.elements.ColumnInfo;
import com.evolution.sqlcore.elements.ValueElement;
import com.evolution.sqlcore.func.ConvertFunc;
import com.evolution.sqlcore.utils.StringTools;

public class MsConvertFuncCompile implements ConvertFuncCompile {
    public CompileConfig compileConfig;

    @Override
    public ConvertFuncCompile setCompileConfig(CompileConfig compileConfig) {
        this.compileConfig = compileConfig;
        return this;
    }

    @Override
    public void compile(ConvertFunc convertFunc) {
        StringBuilder sqlBuilder = compileConfig.getSqlBuilder();
        buildSql(sqlBuilder, convertFunc);
    }

    public String singleCompile(ConvertFunc convertFunc) {
        StringBuilder sqlBuilder = compileConfig.getSqlBuilder();
        buildSql(sqlBuilder, convertFunc);
        return sqlBuilder.toString();
    }

    public void buildSql(StringBuilder sqlBuilder, ConvertFunc convertFunc) {
        if (convertFunc.getDataType() == null) {
            throw new RuntimeException("数据类型不能为空");
        }
        String elementStr = null;
        if (convertFunc.getElement() instanceof ColumnInfo) {
            elementStr = this.compileConfig.getColumnInfoCompile().singleCompile((ColumnInfo) convertFunc.getElement());
        } else if (convertFunc.getElement() instanceof ValueElement) {
            elementStr = compileConfig.getValueCompile().singleCompile((ValueElement) convertFunc.getElement());
        } else if (convertFunc.getElement() instanceof String) {
            elementStr = compileConfig.getBasicTypeCompile().singleCompile(convertFunc.getElement());
            ;
        }
        switch (convertFunc.getDataType()) {
            case DATETIME:
                sqlBuilder.append("CONVERT(DATETIME,")
                        .append(elementStr)
                        .append(", 120)");

                break;
            case DATE:
                sqlBuilder.append("CONVERT(DATE,")
                        .append(elementStr)
                        .append(")");
                break;
            case BIGINT:
                sqlBuilder.append("CONVERT(bigint,")
                        .append(elementStr).append(")");
                break;
            case INT:
                sqlBuilder.append("CONVERT(int,")
                        .append(elementStr).append(")");
                break;
            case DECIMAL:
                sqlBuilder.append("CONVERT(decimal(" + convertFunc.getPrecision() + "," + convertFunc.getScale() + "),")
                        .append(elementStr).append(")");
                break;
            case STRING:
                sqlBuilder.append("CONVERT(varchar(").append(convertFunc.getPrecision()).append("),")
                        .append(elementStr).append(")");
                break;
            default:
                throw new RuntimeException("不支持的数据类型");
        }
        if(!StringTools.isEmpty(convertFunc.getAlias())){
            sqlBuilder
                    .append(compileConfig.getKeyConstraint().SPACE())
                    .append(compileConfig.getKeyConstraint().AS())
                    .append(compileConfig.getKeyConstraint().SPACE())
                    .append(convertFunc.getAlias());
        }
    }


}
