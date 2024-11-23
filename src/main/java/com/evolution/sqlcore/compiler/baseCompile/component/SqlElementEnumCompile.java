package com.evolution.sqlcore.compiler.baseCompile.component;

import com.evolution.sqlcore.compiler.baseCompile.CompileConfig;
import com.evolution.sqlcore.enums.SqlElementEnum;
import lombok.Setter;

public class SqlElementEnumCompile {
    @Setter
    private CompileConfig compileConfig;

    public String compile(SqlElementEnum sqlElementEnum) {
        StringBuilder sqlBuilder = compileConfig.getSqlBuilder();
        appendSpace(sqlBuilder);
        switch (sqlElementEnum) {
            case SELECT:
                sqlBuilder.append(compileConfig.getKeyConstraint().SELECT());
                addSpace(sqlBuilder);
                break;
            case FROM:
                sqlBuilder.append(compileConfig.getKeyConstraint().FROM());
                addSpace(sqlBuilder);
                break;
            case DISTINCT:
                sqlBuilder.append(compileConfig.getKeyConstraint().DISTINCT());
                addSpace(sqlBuilder);
                break;
            case WHERE:
                sqlBuilder
                        .append(compileConfig.getKeyConstraint().WHERE());
                addSpace(sqlBuilder);
                break;
            case GROUP_BY:
                sqlBuilder
                        .append(compileConfig.getKeyConstraint().GROUP_BY());
                addSpace(sqlBuilder);
                break;

            case HAVING:
                sqlBuilder
                        .append(compileConfig.getKeyConstraint().HAVING());
                addSpace(sqlBuilder);
                break;
            case ORDER_BY:
                sqlBuilder
                        .append(compileConfig.getKeyConstraint().ORDER_BY());
                addSpace(sqlBuilder);
                break;
            case LIMIT:
                sqlBuilder.append(compileConfig.getKeyConstraint().LIMIT());
                addSpace(sqlBuilder);
                break;
            case OFFSET:
                sqlBuilder.append(compileConfig.getKeyConstraint().OFFSET());
                addSpace(sqlBuilder);
                break;
            case UNION:
                sqlBuilder
                        .append(compileConfig.getKeyConstraint().UNION());
                addSpace(sqlBuilder);
                break;
            case UNION_ALL:
                sqlBuilder
                        .append(compileConfig.getKeyConstraint().UNION_ALL());
                addSpace(sqlBuilder);
                break;
            case INTERSECT:
                sqlBuilder.append(compileConfig.getKeyConstraint().INTERSECT());
                addSpace(sqlBuilder);
                break;
            case EXCEPT:
                sqlBuilder.append(compileConfig.getKeyConstraint().EXCEPT());
                addSpace(sqlBuilder);
                break;
            case AND:
                sqlBuilder
                        .append(compileConfig.getKeyConstraint().AND())
                ;
                addSpace(sqlBuilder);
                break;
            case OR:
                sqlBuilder
                        .append(compileConfig.getKeyConstraint().OR());
                addSpace(sqlBuilder);
                break;
            case NOT:
                sqlBuilder.append(compileConfig.getKeyConstraint().NOT());
                addSpace(sqlBuilder);
                break;
            case IN:
                sqlBuilder.append(compileConfig.getKeyConstraint().IN());
                addSpace(sqlBuilder);
                break;
            case BETWEEN:
                sqlBuilder.append(compileConfig.getKeyConstraint().BETWEEN());
                addSpace(sqlBuilder);
                break;
            case LIKE:
                sqlBuilder.append(compileConfig.getKeyConstraint().LIKE());
                addSpace(sqlBuilder);
                break;
            case IS_NULL:
                sqlBuilder.append(compileConfig.getKeyConstraint().IS_NULL());
                addSpace(sqlBuilder);
                break;
            case IS_NOT_NULL:
                sqlBuilder.append(compileConfig.getKeyConstraint().IS_NOT_NULL());
                addSpace(sqlBuilder);
                break;
            case CASE:
                sqlBuilder.append(compileConfig.getKeyConstraint().CASE());
                addSpace(sqlBuilder);
                break;
            case WHEN:
                sqlBuilder.append(compileConfig.getKeyConstraint().WHEN());
                addSpace(sqlBuilder);
                break;
            case THEN:
                sqlBuilder.append(compileConfig.getKeyConstraint().THEN());
                addSpace(sqlBuilder);
                break;
            case ELSE:
                sqlBuilder.append(compileConfig.getKeyConstraint().ELSE());
                addSpace(sqlBuilder);
                break;
            case LEFT_JOIN:
                sqlBuilder
                        .append(compileConfig.getKeyConstraint().LEFT())
                        .append(compileConfig.getKeyConstraint().SPACE())
                        .append(compileConfig.getKeyConstraint().JOIN());
                addSpace(sqlBuilder);
                break;
            case RIGHT_JOIN:
                sqlBuilder
                        .append(compileConfig.getKeyConstraint().RIGHT())
                        .append(compileConfig.getKeyConstraint().SPACE())
                        .append(compileConfig.getKeyConstraint().JOIN());
                addSpace(sqlBuilder);
                break;
            case INNER_JOIN:
                sqlBuilder
                        .append(compileConfig.getKeyConstraint().INNER())
                        .append(compileConfig.getKeyConstraint().SPACE())
                        .append(compileConfig.getKeyConstraint().JOIN());
                addSpace(sqlBuilder);
                break;
            case ON:
                sqlBuilder
                        .append(compileConfig.getKeyConstraint().ON());
                addSpace(sqlBuilder);
                break;
            case EQUAL:
                sqlBuilder.append(compileConfig.getKeyConstraint().EQUAL());
                break;
            case TOP:
                sqlBuilder.append(compileConfig.getKeyConstraint().TOP());
                addSpace(sqlBuilder);
                break;
            default:
                throw new IllegalArgumentException("[0516]未知的SQL元素: " + sqlElementEnum);
        }
        return sqlBuilder.toString();
    }

    public void appendSpace(StringBuilder sqlBuilder) {
        if (!compileConfig.getIsLastElementSpace()) {
            sqlBuilder.append(compileConfig.getKeyConstraint().SPACE());
            compileConfig.setIsLastElementSpace(true);
        }
    }

    public void addSpace(StringBuilder sqlBuilder) {
        compileConfig.setIsLastElementSpace(false);
        appendSpace(sqlBuilder);

    }

}
