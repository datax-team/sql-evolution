package com.evolution.sqlcore.provider;

import com.evolution.sqlcore.enums.SqlElementEnum;
import com.evolution.sqlcore.enums.ComparisonOperatorEnum;
import com.evolution.sqlcore.elements.ConditionInfo;
import com.evolution.sqlcore.elements.TableInfo;
import lombok.Getter;
import lombok.Setter;
import com.evolution.sqlcore.enums.SymbolElementEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConditionProvider {

    @Getter
    private List<Object> conditionList = new ArrayList<>();
    @Getter
    private TableInfo tableInfo;
    @Setter
    private List<Object> sqlElements;
    public ConditionProvider table(TableInfo tableInfo){
        this.tableInfo = tableInfo;
        return this;
    }
    private ConditionProvider addCondition(Object leftValue, ComparisonOperatorEnum operator, Object rightValue) {
        ConditionInfo conditionInfo = new ConditionInfo();
        conditionInfo.setLeftValue(leftValue);
        conditionInfo.setOperator(operator);
        conditionInfo.setRightValue(rightValue);
        sqlElements.add(conditionInfo);
        return this;
    }
    public ConditionProvider and() {
        sqlElements.add(SqlElementEnum.AND);
        return this;
    }
    public ConditionProvider or() {
        sqlElements.add(SqlElementEnum.OR);
        return this;
    }
    public ConditionProvider lb() {
        sqlElements.add(SymbolElementEnum.LEFT_BRACKET);
        return this;
    }
    public ConditionProvider rb() {
        sqlElements.add(SymbolElementEnum.RIGHT_BRACKET);
        return this;
    }

    /**
     * 等于
     * @param leftValue
     * @param rightValue
     * @return
     */
    public ConditionProvider eq(Object leftValue,Object rightValue) {
        addCondition(leftValue, ComparisonOperatorEnum.Equals, rightValue);
        return this;
    }

    /**
     * 不等于
     * @param leftValue
     * @param rightValue
     * @return
     */
    public ConditionProvider ne(Object leftValue,Object rightValue) {
        addCondition(leftValue, ComparisonOperatorEnum.NotEquals, rightValue);
        return this;
    }

    /**
     * 大于
     * @param leftValue
     * @param rightValue
     * @return
     */
    public ConditionProvider gt(Object leftValue,Object rightValue) {
        addCondition(leftValue, ComparisonOperatorEnum.GreaterThan, rightValue);
        return this;
    }

    /**
     * 大于等于
     * @param leftValue
     * @param rightValue
     * @return
     */
    public ConditionProvider ge(Object leftValue,Object rightValue) {
        addCondition(leftValue, ComparisonOperatorEnum.GreaterThanOrEqual, rightValue);
        return this;
    }

    /**
     * 小于
     * @param leftValue
     * @param rightValue
     * @return
     */
    public ConditionProvider lt(Object leftValue,Object rightValue) {
        addCondition(leftValue, ComparisonOperatorEnum.LessThan, rightValue);
        return this;
    }

 /**
     * 小于等于
     * @param leftValue
     * @param rightValue
     * @return
     */
 public ConditionProvider le(Object leftValue,Object rightValue) {
     addCondition(leftValue, ComparisonOperatorEnum.LessThanOrEqual, rightValue);
     return this;
 }

    /**
     * 模糊匹配
     * @param leftValue
     * @param rightValue
     * @return
     */
    public ConditionProvider like(Object leftValue,Object rightValue) {
        addCondition(leftValue, ComparisonOperatorEnum.Like, rightValue);
        return this;
    }
    public ConditionProvider notLike(Object leftValue,Object rightValue) {
        addCondition(leftValue, ComparisonOperatorEnum.NotLike, rightValue);
        return this;
    }
    public ConditionProvider in(Object leftValue,Object rightValue) {
        addCondition(leftValue, ComparisonOperatorEnum.In, rightValue);
        return this;
    }
    public ConditionProvider notIn(Object leftValue,Object rightValue) {
        addCondition(leftValue, ComparisonOperatorEnum.NotIn, rightValue);
        return this;
    }
    public ConditionProvider between(Object leftValue,Object startValue,Object endValue) {
        addCondition(leftValue, ComparisonOperatorEnum.Between, Arrays.asList(startValue,endValue));
        return this;
    }
    public ConditionProvider notBetween(Object leftValue,Object rightValue) {
        addCondition(leftValue, ComparisonOperatorEnum.NotBetween, rightValue);
        return this;
    }
    public ConditionProvider isNull(Object leftValue) {
        addCondition(leftValue, ComparisonOperatorEnum.IsNull, null);
        return this;
    }
    public ConditionProvider isNotNull(Object leftValue) {
        addCondition(leftValue, ComparisonOperatorEnum.IsNot, null);
        return this;
    }
    public ConditionProvider regex(Object leftValue,Object rightValue) {
        addCondition(leftValue, ComparisonOperatorEnum.Regex, rightValue);
        return this;
    }
    public ConditionProvider inSubQuery(Object leftValue,Object rightValue) {
        addCondition(leftValue, ComparisonOperatorEnum.InSubQuery, rightValue);
        return this;
    }
    public ConditionProvider notInSubQuery(Object leftValue,Object rightValue) {
        addCondition(leftValue, ComparisonOperatorEnum.NotInSubQuery, rightValue);
        return this;
    }
    public ConditionProvider exists(Object leftValue) {
        addCondition(leftValue, ComparisonOperatorEnum.Exists, null);
        return this;
    }
    public ConditionProvider notExists(Object leftValue) {
        addCondition(leftValue, ComparisonOperatorEnum.NotExists, null);
        return this;
    }


}
