package com.evolution.sqlcore.elements;

import com.evolution.sqlcore.enums.ComparisonOperatorEnum;
import lombok.Data;

@Data
public class ConditionInfo {
    private Object leftValue;
    private Object rightValue;
    private ComparisonOperatorEnum operator;
}
