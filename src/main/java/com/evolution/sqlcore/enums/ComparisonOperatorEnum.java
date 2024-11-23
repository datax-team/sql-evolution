package com.evolution.sqlcore.enums;

public enum ComparisonOperatorEnum {
    Equals("equals", "等于"),
    NotEquals("not_equals", "不等于"),
    GreaterThan("greater_than", "大于"),
    GreaterThanOrEqual("greater_than_or_equal", "大于等于"),
    LessThan("less_than", "小于"),
    LessThanOrEqual("less_than_or_equal", "小于等于"),
    Like("like", "模糊匹配"),
    In("in", "包含"),
    NotIn("not_in", "不包含"),
    Between("between", "在之间"),
    NotBetween("not_between", "不在之间"),
    IsNull("is_null", "为空"),
    IsNot("is_not", "不为空"),
    NotLike("not_like", "不匹配"),
    Regex("regex", "正则匹配"),
    InSubQuery("in_sub_query", "在子查询中"),
    NotInSubQuery("not_in_sub_query", "不在子查询中"),
    Exists("exists", "存在"),
    NotExists("not_exists", "不存在"),
    Not("not", "非"),
    Is("is", "值"),
    Null("Null", "null");

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    ComparisonOperatorEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ComparisonOperatorEnum getOperatorByCode(String code) {
        for (ComparisonOperatorEnum operator : ComparisonOperatorEnum.values()) {
            if (operator.getCode().equalsIgnoreCase(code)) {
                return operator;
            }
        }
        throw new RuntimeException("未找到对应的操作符");
    }
}
