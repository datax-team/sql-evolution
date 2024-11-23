package com.evolution.sqlcore.compiler.baseCompile.baseConfig;


public interface KeyConstraintProvider {
    String SELECT();

    String FROM();

    String WHERE();

    String GROUP_BY();

    String HAVING();

    String ORDER_BY();

    String JOIN();

    String LIMIT();

    String OFFSET();

    String ASC();

    String DESC();

    String LEFT();

    String RIGHT();

    String INNER();

    String OUTER();

    String AND();

    String OR();

    String NOT();

    String AS();

    String IS_NULL();

    String IS_NOT_NULL();

    String IN();

    String NOT_IN();

    String BETWEEN();

    String NOT_BETWEEN();

    String LIKE();

    String NOT_LIKE();

    String EQUAL();
    String TOP();

    String NOT_EQUAL();

    String GREATER_THAN();

    String LESS_THAN();

    String GREATER_THAN_OR_EQUAL();

    String LESS_THAN_OR_EQUAL();

    String UNION();

    String UNION_ALL();

    String INTERSECT();

    String EXCEPT();

    String CROSS_JOIN();

    String NATURAL_JOIN();

    String USING();

    String CASE();

    String WHEN();

    String THEN();

    String ELSE();

    String END();

    String AVG();

    String COUNT();

    String MAX();

    String MIN();

    String SUM();

    String DISTINCT();

    String ALL();

    String ON();

    String USING_AS();

    String USING_ON();

    String COMMA();

    String DOT();

    String LEFT_BRACKET();

    String RIGHT_BRACKET();

    String UNDER_SCORE();

    String QUESTION_MARK();

    String SINGLE_QUOTE();

    String DOUBLE_QUOTE();

    String BACK_SLASH();

    String SLASH();

    String NEW_LINE();

    String TAB();

    String SPACE();

    String EMPTY();

    String KEY_LEFT_BRACKET();
    String KEY_RIGHT_BRACKET();

    String COLUMN_LEFT_BRACKET();
    String COLUMN_RIGHT_BRACKET();

    String TABLE_NAME_LEFT_BRACKET();
    String TABLE_NAME_RIGHT_BRACKET();

    String DATABASE_NAME_LEFT_BRACKET();
    String DATABASE_NAME_RIGHT_BRACKET();
    String SCHEMA_NAME_LEFT_BRACKET();
    String SCHEMA_NAME_RIGHT_BRACKET();



    String FETCH();
    String NEXT();
    String ROWS();
    String ONLY();

    /**
     * 符号 %
     */
    String PERCENT();
}