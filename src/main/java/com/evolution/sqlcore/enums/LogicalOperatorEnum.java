package com.evolution.sqlcore.enums;

public enum LogicalOperatorEnum {
    And("and", "并且"),
    Or("or", "或");
    private String code;
    private String name;
    LogicalOperatorEnum(String code, String name)
    {
        this.code = code;
        this.name = name;
    }
    public String getCode()
    {
        return code;
    }
    public String getName()
    {
        return name;
    }
    public static LogicalOperatorEnum getOperatorByCode(String code)
    {
        for (LogicalOperatorEnum operator : LogicalOperatorEnum.values())
        {
            if (operator.getCode().equals(code))
            {
                return operator;
            }
        }
        return null;
    }

}
