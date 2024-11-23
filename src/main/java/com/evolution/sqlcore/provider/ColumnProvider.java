package com.evolution.sqlcore.provider;

import com.evolution.sqlcore.elements.ValueElement;
import com.evolution.sqlcore.enums.AggregateTypeEnum;
import com.evolution.sqlcore.enums.DataTypeEnum;
import com.evolution.sqlcore.func.ConvertFunc;
import com.evolution.sqlcore.func.SqlFunc;
import com.evolution.sqlcore.elements.ColumnInfo;
import com.evolution.sqlcore.func.ColumnFunc;
import com.evolution.sqlcore.elements.TableInfo;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ColumnProvider {
    private TableInfo tableInfo;

    public ColumnProvider table(TableInfo tableInfo) {
        this.tableInfo = tableInfo;
        return this;
    }

    @Getter
    private List<Object> columnInfos = new ArrayList<>();

    public ColumnProvider column(String columnName) {
        ColumnInfo columnInfo = ColumnFunc.column(tableInfo, columnName);
        columnInfos.add(columnInfo);
        return this;
    }

    public ColumnProvider value(Object val) {
        ValueElement valueElement = new ValueElement().setValue(val);
        columnInfos.add(valueElement);
        return this;
    }
    public ColumnProvider valueAs(Object val,String alias) {
        ValueElement valueElement = new ValueElement().setValue(val).setAlias(alias);
        columnInfos.add(valueElement);
        return this;
    }

    public ColumnProvider columnFunc(SqlFunc function) {
        columnInfos.add(function);
        return this;
    }

    public ColumnProvider column(TableInfo tableInfo, String columnName) {
        ColumnInfo columnInfo = ColumnFunc.column(tableInfo, columnName);
        columnInfos.add(columnInfo);
        return this;
    }

    public ColumnProvider columnAs(String columnName, String columnAlias) {
        ColumnInfo columnInfo = ColumnFunc.columnAs(tableInfo, columnName, columnAlias);
        columnInfos.add(columnInfo);
        return this;
    }

    public ColumnProvider columnAs(TableInfo tableInfo, String columnName, String columnAlias) {
        ColumnInfo columnInfo = ColumnFunc.columnAs(tableInfo, columnName, columnAlias);
        columnInfos.add(columnInfo);
        return this;
    }

    public ColumnProvider max(String columnName) {
        ColumnInfo columnInfo = ColumnFunc.column(tableInfo, columnName);
        columnInfo.setAggregateType(AggregateTypeEnum.MAX);
        columnInfos.add(columnInfo);
        return this;
    }

    public ColumnProvider maxAs(String columnName, String columnAlias) {
        ColumnInfo columnInfo = ColumnFunc.columnAs(tableInfo, columnName, columnAlias);
        columnInfo.setAggregateType(AggregateTypeEnum.MAX);
        columnInfos.add(columnInfo);
        return this;
    }

    public ColumnProvider min(String columnName) {
        ColumnInfo columnInfo = ColumnFunc.column(tableInfo, columnName);
        columnInfo.setAggregateType(AggregateTypeEnum.MIN);
        columnInfos.add(columnInfo);
        return this;
    }

    public ColumnProvider minAs(String columnName, String columnAlias) {
        ColumnInfo columnInfo = ColumnFunc.columnAs(tableInfo, columnName, columnAlias);
        columnInfo.setAggregateType(AggregateTypeEnum.MIN);
        columnInfos.add(columnInfo);
        return this;
    }

    public ColumnProvider count(String columnName) {
        ColumnInfo columnInfo = ColumnFunc.column(tableInfo, columnName);
        columnInfo.setAggregateType(AggregateTypeEnum.COUNT);
        columnInfos.add(columnInfo);
        return this;
    }

    public ColumnProvider countAs(String columnName, String columnAlias) {
        ColumnInfo columnInfo = ColumnFunc.columnAs(tableInfo, columnName, columnAlias);
        columnInfo.setAggregateType(AggregateTypeEnum.COUNT);
        columnInfos.add(columnInfo);
        return this;
    }

    public ColumnProvider sum(String columnName) {
        ColumnInfo columnInfo = ColumnFunc.column(tableInfo, columnName);
        columnInfo.setAggregateType(AggregateTypeEnum.SUM);
        columnInfos.add(columnInfo);
        return this;
    }

    public ColumnProvider sumAs(String columnName, String columnAlias) {
        ColumnInfo columnInfo = ColumnFunc.columnAs(tableInfo, columnName, columnAlias);
        columnInfo.setAggregateType(AggregateTypeEnum.SUM);
        columnInfos.add(columnInfo);
        return this;
    }

    public ColumnProvider avg(String columnName) {
        ColumnInfo columnInfo = ColumnFunc.column(tableInfo, columnName);
        columnInfo.setAggregateType(AggregateTypeEnum.AVG);
        columnInfos.add(columnInfo);
        return this;
    }

    /**
     * 将列转换为字符串类型
     *
     * @param columnInfo
     * @return
     */
    public ColumnProvider columnToString(ColumnInfo columnInfo) {
        ConvertFunc function = new ConvertFunc();
        function.setElement(columnInfo);
        function.setDataType(DataTypeEnum.STRING);
        function.setPrecision(255);
        function.setAlias(columnInfo.getAlias());
        columnInfo.setAlias(null);
        columnInfos.add(function);
        return this;
    }

    public ColumnProvider columnToString(ColumnInfo columnInfo, Integer precision) {
        ConvertFunc function = new ConvertFunc();
        function.setElement(columnInfo);
        function.setDataType(DataTypeEnum.STRING);
        function.setPrecision(precision);
        columnInfos.add(function);
        return this;
    }
    public ColumnProvider columnToStringAs(ColumnInfo columnInfo, Integer precision) {
        ConvertFunc function = new ConvertFunc();
        function.setElement(columnInfo);
        function.setDataType(DataTypeEnum.STRING);
        function.setPrecision(precision);
        function.setAlias(columnInfo.getAlias());
        columnInfo.setAlias(null);
        columnInfos.add(function);
        return this;
    }

    public ColumnProvider avgAs(String columnName, String columnAlias) {
        ColumnInfo columnInfo = ColumnFunc.columnAs(tableInfo, columnName, columnAlias);
        columnInfo.setAggregateType(AggregateTypeEnum.AVG);
        columnInfos.add(columnInfo);
        return this;
    }
    public ColumnProvider valueToString(Object val) {
        ConvertFunc function = new ConvertFunc();
        ValueElement valueElement = new ValueElement().setValue(val);
        function.setElement(valueElement);
        function.setDataType(DataTypeEnum.STRING);
        function.setPrecision(255);
        columnInfos.add(function);
        return this;
    }

    /**
     * 将列转换为整型
     *
     * @param columnInfo
     * @return
     */
    public ColumnProvider columnToInt(ColumnInfo columnInfo) {
        ConvertFunc function = new ConvertFunc();
        function.setElement(columnInfo);
        function.setDataType(DataTypeEnum.INT);
        columnInfos.add(function);
        return this;
    }

    /**
     * 将列转换为浮点数类型
     *
     * @param columnInfo
     * @param precision
     * @param scale
     * @return
     */
    public ColumnProvider columnToDecimal(ColumnInfo columnInfo, Integer precision, Integer scale) {
        ConvertFunc function = new ConvertFunc();
        function.setElement(columnInfo);
        function.setDataType(DataTypeEnum.DECIMAL);
        function.setPrecision(precision);
        function.setScale(scale);
        columnInfos.add(function);
        return this;
    }

    /**
     * 将列转换为日期类型
     *
     * @param columnInfo
     * @return
     */
    public ColumnProvider columnToDate(ColumnInfo columnInfo) {
        ConvertFunc function = new ConvertFunc();
        function.setElement(columnInfo);
        function.setDataType(DataTypeEnum.DATE);
        columnInfos.add(function);
        return this;
    }

    /**
     * 将列转换为日期时间类型
     *
     * @param columnInfo
     * @return
     */
    public ColumnProvider columnToDatetime(ColumnInfo columnInfo) {
        ConvertFunc function = new ConvertFunc();
        function.setElement(columnInfo);
        function.setDataType(DataTypeEnum.DATETIME);
        columnInfos.add(function);
        return this;
    }

}
