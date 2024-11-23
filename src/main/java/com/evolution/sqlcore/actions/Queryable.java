package com.evolution.sqlcore.actions;

import com.evolution.sqlcore.elements.ValueElement;
import com.evolution.sqlcore.enums.ComparisonOperatorEnum;
import com.evolution.sqlcore.enums.SortTypeEnum;
import com.evolution.sqlcore.enums.SqlElementEnum;
import com.evolution.sqlcore.elements.ColumnInfo;
import com.evolution.sqlcore.enums.SymbolElementEnum;
import com.evolution.sqlcore.provider.ColumnProvider;
import com.evolution.sqlcore.provider.ConditionProvider;
import com.evolution.sqlcore.elements.TableInfo;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Queryable {
    @Getter
    private final List<Object> sqlElements = new ArrayList<>();
    private final Map<String, TableInfo> tableProviders = new HashMap<>();

    public void addTableProvider(TableInfo provider) {
        if (tableProviders.containsKey(provider.getTableFlag())) {
            throw new IllegalArgumentException("重复添加 table");
        }
        tableProviders.put(provider.getTableFlag(), provider);
    }

    public Queryable from() {
        sqlElements.add(SqlElementEnum.FROM);
        return this;
    }

    public Queryable from(TableInfo tableInfo) {
        sqlElements.add(SqlElementEnum.FROM);
        table(tableInfo);
        return this;
    }

    public Queryable leftJoin() {
        sqlElements.add(SqlElementEnum.LEFT_JOIN);
        return this;
    }

    public Queryable rightJoin() {
        sqlElements.add(SqlElementEnum.RIGHT_JOIN);
        return this;
    }

    public Queryable innerJoin() {
        sqlElements.add(SqlElementEnum.INNER_JOIN);
        return this;
    }

    public Queryable fullJoin() {
        sqlElements.add(SqlElementEnum.FULL_JOIN);
        return this;
    }

    public Queryable crossJoin() {
        sqlElements.add(SqlElementEnum.CROSS_JOIN);
        return this;
    }

    public Queryable on() {
        sqlElements.add(SqlElementEnum.ON);
        return this;
    }

    public Queryable on(Consumer<ConditionProvider> conditionProvider) {
        on();
        ConditionProvider provider = new ConditionProvider();
        provider.setSqlElements(sqlElements);
        conditionProvider.accept(provider);
        return this;
    }

    public Queryable on(Object leftValue, ComparisonOperatorEnum operator, Object rightValue) {
        on();
        condition(leftValue, operator, rightValue);
        return this;
    }

    public Queryable and() {
        sqlElements.add(SqlElementEnum.AND);
        return this;
    }

    public Queryable and(Object leftValue, ComparisonOperatorEnum operator, Object rightValue) {
        and();
        condition(leftValue, operator, rightValue);
        return this;
    }

    public Queryable or() {
        sqlElements.add(SqlElementEnum.OR);
        return this;
    }

    public Queryable or(Object leftValue, ComparisonOperatorEnum operator, Object rightValue) {
        or();
        condition(leftValue, operator, rightValue);
        return this;
    }

    public Queryable lb() {
        sqlElements.add(SymbolElementEnum.LEFT_BRACKET);
        return this;
    }

    public Queryable rb() {
        sqlElements.add(SymbolElementEnum.RIGHT_BRACKET);
        return this;
    }

    public Queryable condition(Object leftValue, ComparisonOperatorEnum operator, Object rightValue) {
        sqlElements.add(leftValue);
        sqlElements.add(operator);
        sqlElements.add(rightValue);
        return this;
    }

    public TableInfo createTable(Consumer<TableInfo> tableProvider) {
        TableInfo provider = new TableInfo();
        tableProvider.accept(provider);
        return provider;
    }

    public Queryable table(TableInfo tableInfo) {
        addTableProvider(tableInfo);
        sqlElements.add(tableInfo);
        return this;
    }


    public Queryable select() {
        sqlElements.add(SqlElementEnum.SELECT);
        return this;
    }

    public Queryable select(Consumer<ColumnProvider> columnProvider) {
        select();
        ColumnProvider provider = new ColumnProvider();
        columnProvider.accept(provider);
        sqlElements.add(provider.getColumnInfos());
        return this;
    }

    public Queryable distinct() {
        sqlElements.add(SqlElementEnum.DISTINCT);
        return this;
    }

    public Queryable groupBy() {
        sqlElements.add(SqlElementEnum.GROUP_BY);
        return this;
    }

    public Queryable groupBy(ColumnInfo columnInfo) {
        groupBy();
        sqlElements.add(columnInfo);
        return this;
    }

    public Queryable groupBy(Consumer<ColumnProvider> columnProvider) {
        groupBy();
        ColumnProvider provider = new ColumnProvider();
        columnProvider.accept(provider);
        sqlElements.add(provider.getColumnInfos());
        return this;
    }


    public Queryable having() {
        sqlElements.add(SqlElementEnum.HAVING);
        return this;
    }

    public Queryable union() {
        sqlElements.add(SqlElementEnum.UNION);
        return this;
    }

    public Queryable unionAll() {
        sqlElements.add(SqlElementEnum.UNION_ALL);
        return this;
    }


    public Queryable where() {
        sqlElements.add(SqlElementEnum.WHERE);
        return this;
    }

    public Queryable where(Consumer<ConditionProvider> conditionProvider) {
        sqlElements.add(SqlElementEnum.WHERE);
        ConditionProvider provider = new ConditionProvider();
        provider.setSqlElements(sqlElements);
        conditionProvider.accept(provider);
        return this;
    }


    public Queryable orderBy(ColumnInfo columnInfo, SortTypeEnum sortType) {
        sqlElements.add(SqlElementEnum.ORDER_BY);
        sqlElements.add(columnInfo);
        sqlElements.add(sortType);
        return this;
    }

    public Queryable orderBy(Consumer<ColumnProvider> columnProvider, SortTypeEnum sortType) {
        sqlElements.add(SqlElementEnum.ORDER_BY);
        ColumnProvider provider = new ColumnProvider();
        columnProvider.accept(provider);
        sqlElements.add(provider.getColumnInfos());
        sqlElements.add(sortType);
        return this;
    }


    public Queryable column(Consumer<ColumnProvider> columnProvider) {
        ColumnProvider provider = new ColumnProvider();
        columnProvider.accept(provider);
        sqlElements.add(provider.getColumnInfos());
        return this;
    }

    /**
     * @param limit 0表示无限制
     */
    public Queryable limit(int limit) {
        sqlElements.add(SqlElementEnum.LIMIT);
        sqlElements.add(new ValueElement().setValue(limit));
        return this;
    }

    /**
     * @param limit  每页的行数
     * @param offset 跳过的行数
     * @return
     */
    public Queryable limit(int limit, int offset) {
        sqlElements.add(SqlElementEnum.LIMIT);
        sqlElements.add(new ValueElement().setValue(limit));
        sqlElements.add(SqlElementEnum.OFFSET);
        sqlElements.add(new ValueElement().setValue(offset));
        return this;
    }

    public Queryable top(int num) {
        sqlElements.add(SqlElementEnum.TOP);
        sqlElements.add(new ValueElement().setValue(num));
        return this;
    }
//    public Queryable column(String columnName) {
//        ColumnInfo columnInfo = ColumnFunc.column(columnName);
//        sqlElements.add(columnInfo);
//        return this;
//    }
//    public Queryable columnAs(String columnName, String columnAlias) {
//        ColumnInfo columnInfo = ColumnFunc.columnAs(columnName,columnAlias);
//        sqlElements.add(columnInfo);
//        return this;
//    }
}
