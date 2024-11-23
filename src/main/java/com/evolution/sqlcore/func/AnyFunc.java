package com.evolution.sqlcore.func;

import java.util.function.Consumer;

public class AnyFunc {
    public static SqlFunc createSqlFunc(String strTemplate, Consumer<SqlFunc> anyFuntionConsumer)
    {
        SqlFunc sqlFunc = new SqlFunc();
        sqlFunc.setStrTemplate(strTemplate);
        anyFuntionConsumer.accept(sqlFunc);
        return sqlFunc;
    }
}
