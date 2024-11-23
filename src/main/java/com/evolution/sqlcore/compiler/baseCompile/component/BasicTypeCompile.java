package com.evolution.sqlcore.compiler.baseCompile.component;

import com.evolution.sqlcore.compiler.baseCompile.CompileConfig;
import com.evolution.sqlcore.compiler.baseCompile.baseConfig.KeyConstraintProvider;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Setter
public class BasicTypeCompile {
    private CompileConfig compileConfig;

    public void compile(Object sqlElement) {
        StringBuilder sqlBuilder = compileConfig.getSqlBuilder();
        buildSql(sqlBuilder, sqlElement);
    }

    public String singleCompile(Object sqlElement) {
        StringBuilder sqlBuilder = new StringBuilder();
        buildSql(sqlBuilder, sqlElement);
        return sqlBuilder.toString();
    }

    public void buildSql(StringBuilder sqlBuilder, Object sqlElement) {
        if (sqlElement instanceof String) {
            sqlBuilder
                    .append(compileConfig.getKeyConstraint().SINGLE_QUOTE())
                    .append(sqlElement)
                    .append(compileConfig.getKeyConstraint().SINGLE_QUOTE())
            ;
        } else if (sqlElement instanceof Integer) {
            sqlBuilder.append(sqlElement);
        } else if (sqlElement instanceof Float) {
            sqlBuilder.append(sqlElement);
        } else if (sqlElement instanceof Double) {
            sqlBuilder.append(sqlElement);
        } else if (sqlElement instanceof Long) {
            sqlBuilder.append(sqlElement);
        } else if (sqlElement instanceof Byte) {
            sqlBuilder.append(sqlElement);
        } else if (sqlElement instanceof Short) {
            sqlBuilder.append(sqlElement);
        } else if (sqlElement instanceof Number) {
            sqlBuilder.append(sqlElement);
        } else if (sqlElement instanceof Boolean) {
            sqlBuilder.append(sqlElement);
        } else if (sqlElement instanceof Character) {
            sqlBuilder.append(sqlElement);
        } else if (sqlElement instanceof List) {
            compileList(sqlElement);
        } else if (sqlElement instanceof LocalDateTime) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            sqlBuilder
                    .append(compileConfig.getKeyConstraint().SINGLE_QUOTE())
                    .append(((LocalDateTime) sqlElement).format(formatter))
                    .append(compileConfig.getKeyConstraint().SINGLE_QUOTE())
            ;
        } else if (sqlElement instanceof LocalDate) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            sqlBuilder
                    .append(compileConfig.getKeyConstraint().SINGLE_QUOTE())
                    .append(((LocalDate) sqlElement).format(formatter))
                    .append(compileConfig.getKeyConstraint().SINGLE_QUOTE())
            ;
        } else if (sqlElement instanceof Date) {
            sqlBuilder
                    .append(compileConfig.getKeyConstraint().SINGLE_QUOTE())
                    .append(new SimpleDateFormat("yyyy-MM-dd").format((Date) sqlElement))
                    .append(compileConfig.getKeyConstraint().SINGLE_QUOTE())
            ;
        }
        compileConfig.setIsLastElementSpace(false);
    }

    private void compileList(Object sqlElement) {
        StringBuilder sqlBuilder = compileConfig.getSqlBuilder();
        KeyConstraintProvider keyConstraint = compileConfig.getKeyConstraint();
        List<?> list = (List<?>) sqlElement;
        if (!list.isEmpty()) {
            sqlBuilder.append(keyConstraint.LEFT_BRACKET());
            for (Object element : list) {
                if (element instanceof String) {
                    sqlBuilder
                            .append(keyConstraint.SINGLE_QUOTE())
                            .append(element)
                            .append(keyConstraint.SINGLE_QUOTE())
                            .append(keyConstraint.COMMA());
                } else {
                    compile(element);
                    sqlBuilder.append(keyConstraint.COMMA());
                }
            }
            // 移除最后一个逗号
            if (sqlBuilder.length() > 0) {
                sqlBuilder.setLength(sqlBuilder.length() - 1);
            }
            sqlBuilder.append(keyConstraint.RIGHT_BRACKET());
        }
    }

   public void appendSpace(StringBuilder sqlBuilder) {
        if (!compileConfig.getIsLastElementSpace()) {
            sqlBuilder.append(compileConfig.getKeyConstraint().SPACE());
            compileConfig.setIsLastElementSpace(true);
        }
    }
}
