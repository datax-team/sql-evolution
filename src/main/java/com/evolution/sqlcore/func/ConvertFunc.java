package com.evolution.sqlcore.func;

import lombok.Data;
import com.evolution.sqlcore.enums.DataTypeEnum;

@Data
public class ConvertFunc implements BaseFunc {
    /**
     * 目标元素
     */
    private Object element;
    private String alias;
    /**
     * 数据类型
     */
    private DataTypeEnum dataType;
    /**
     * 精度（总长度）
     */
    private Integer precision;
    /**
     * 小数位数
     */
    private Integer scale;

}
