package com.evolution.sqlcore.compiler.baseCompile.syntaxConfig;

import com.evolution.sqlcore.compiler.baseCompile.baseConfig.KeyConstraintProvider;

public abstract class KeyConstraint implements KeyConstraintProvider {

    public static final String EMPTY = "";

    @Override
    public String SELECT() {
        return "SELECT";
    }

    @Override
    public String FROM() {
        return "FROM";
    }

    @Override
    public String WHERE() {
        return "WHERE";
    }

    @Override
    public String GROUP_BY() {
        return "GROUP BY";
    }

    @Override
    public String HAVING() {
        return "HAVING";
    }

    @Override
    public String ORDER_BY() {
        return "ORDER BY";
    }

    @Override
    public String JOIN() {
        return "JOIN";
    }

    @Override
    public String LIMIT() {
        return "LIMIT";
    }

    @Override
    public String OFFSET() {
        return "OFFSET";
    }

    @Override
    public String ASC() {
        return "ASC";
    }

    @Override
    public String DESC() {
        return "DESC";
    }

    @Override
    public String LEFT() {
        return "LEFT";
    }

    @Override
    public String RIGHT() {
        return "RIGHT";
    }

    @Override
    public String INNER() {
        return "INNER";
    }

    @Override
    public String OUTER() {
        return "OUTER";
    }

    @Override
    public String AND() {
        return "AND";
    }

    @Override
    public String OR() {
        return "OR";
    }

    @Override
    public String NOT() {
        return "NOT";
    }

    @Override
    public String AS() {
        return "AS";
    }

    @Override
    public String IS_NULL() {
        return "IS NULL";
    }

    @Override
    public String IS_NOT_NULL() {
        return "IS NOT NULL";
    }

    @Override
    public String IN() {
        return "IN";
    }

    @Override
    public String NOT_IN() {
        return "NOT IN";
    }

    @Override
    public String BETWEEN() {
        return "BETWEEN";
    }

    @Override
    public String NOT_BETWEEN() {
        return "NOT BETWEEN";
    }

    @Override
    public String LIKE() {
        return "LIKE";
    }

    @Override
    public String NOT_LIKE() {
        return "NOT LIKE";
    }

    @Override
    public String EQUAL() {
        return "=";
    }

    @Override
    public String NOT_EQUAL() {
        return "<>";
    }

    @Override
    public String GREATER_THAN() {
        return ">";
    }

    @Override
    public String LESS_THAN() {
        return "<";
    }

    @Override
    public String GREATER_THAN_OR_EQUAL() {
        return ">=";
    }

    @Override
    public String LESS_THAN_OR_EQUAL() {
        return "<=";
    }

    @Override
    public String UNION() {
        return "UNION";
    }

    @Override
    public String UNION_ALL() {
        return "UNION ALL";
    }

    @Override
    public String INTERSECT() {
        return "INTERSECT";
    }

    @Override
    public String EXCEPT() {
        return "EXCEPT";
    }

    @Override
    public String CROSS_JOIN() {
        return "CROSS JOIN";
    }

    @Override
    public String NATURAL_JOIN() {
        return "NATURAL JOIN";
    }

    @Override
    public String USING() {
        return "USING";
    }

    @Override
    public String CASE() {
        return "CASE";
    }

    @Override
    public String WHEN() {
        return "WHEN";
    }

    @Override
    public String THEN() {
        return "THEN";
    }

    @Override
    public String ELSE() {
        return "ELSE";
    }

    @Override
    public String END() {
        return "END";
    }

    @Override
    public String AVG() {
        return "AVG";
    }

    @Override
    public String COUNT() {
        return "COUNT";
    }

    @Override
    public String MAX() {
        return "MAX";
    }

    @Override
    public String MIN() {
        return "MIN";
    }

    @Override
    public String SUM() {
        return "SUM";
    }

    @Override
    public String DISTINCT() {
        return "DISTINCT";
    }

    @Override
    public String ALL() {
        return "ALL";
    }

    @Override
    public String ON() {
        return "ON";
    }

    @Override
    public String USING_AS() {
        return "USING AS";
    }

    @Override
    public String USING_ON() {
        return "USING ON";
    }

    @Override
    public String COMMA() {
        return ",";
    }

    @Override
    public String DOT() {
        return ".";
    }

    @Override
    public String LEFT_BRACKET() {
        return "(";
    }

    @Override
    public String RIGHT_BRACKET() {
        return ")";
    }

    @Override
    public String UNDER_SCORE() {
        return "_";
    }

    @Override
    public String QUESTION_MARK() {
        return "?";
    }

    @Override
    public String SINGLE_QUOTE() {
        return "'";
    }

    @Override
    public String DOUBLE_QUOTE() {
        return "\"";
    }

    @Override
    public String BACK_SLASH() {
        return "\\";
    }

    @Override
    public String SLASH() {
        return "/";
    }

    @Override
    public String NEW_LINE() {
        return "\n";
    }

    @Override
    public String TAB() {
        return "\t";
    }

    @Override
    public String SPACE() {
        return " ";
    }

    @Override
    public String EMPTY() {
        return "";
    }

    @Override
    public String TABLE_NAME_LEFT_BRACKET() {
        return "\"";
    }

    @Override
    public String TABLE_NAME_RIGHT_BRACKET() {
        return "\"";
    }

    @Override
    public String DATABASE_NAME_LEFT_BRACKET() {
        return "\"";
    }

    @Override
    public String DATABASE_NAME_RIGHT_BRACKET() {
        return "\"";
    }

    @Override
    public String SCHEMA_NAME_LEFT_BRACKET() {
        return "\"";
    }

    @Override
    public String SCHEMA_NAME_RIGHT_BRACKET() {
        return "\"";
    }

    @Override
    public String KEY_LEFT_BRACKET() {
        return "\"";
    }

    @Override
    public String KEY_RIGHT_BRACKET() {
        return "\"";
    }

    @Override
    public String COLUMN_LEFT_BRACKET() {
        return "\"";
    }

    @Override
    public String COLUMN_RIGHT_BRACKET() {
        return "\"";
    }

    @Override
    public String FETCH() {
        return "FETCH";
    }

    @Override
    public String NEXT() {
        return "NEXT";
    }

    @Override
    public String ROWS() {
        return "ROWS";
    }

    @Override
    public String ONLY() {
        return "ONLY";
    }

    @Override
    public String PERCENT() {
        return "%";
    }
}

