package com.evolution.sqlcore;

import org.junit.jupiter.api.Test;
import com.evolution.sqlcore.actions.Queryable;
import com.evolution.sqlcore.compiler.sqlServer.MsCompile;
import com.evolution.sqlcore.elements.TableInfo;
import com.evolution.sqlcore.func.AnyFunc;

public class AnyFuncTest {
    @Test
    public void query1() {
        String targetSql = "SELECT [userId],[username],[email],[Users].[userId]||[username]||[Users].[userId]||'email' FROM [Users]";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x ->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                                .columnFunc(
                                        AnyFunc.createSqlFunc("{0}||{1}||{0}||{2}",
                                                c -> c
                                                        .column(userTable, "userId")
                                                        .column("username")
                                                        .value("email")))
                )
                .from().table(userTable);
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }

    @Test
    public void caseWhenTest() {
        String targetSql = "SELECT [userId],[username],[email],CASE WHEN [Users].[age] < 18 THEN '未成年' WHEN [Users].[age] >= 18 AND [Users].[age] < 60 THEN '成年人' ELSE '老年' END AS '年龄分类' FROM [Users]";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x ->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                                .columnFunc(
                                        AnyFunc.createSqlFunc("CASE WHEN {0} < 18 THEN {1} WHEN {0} >= 18 AND {0} < 60 THEN {2} ELSE {3} END AS {4}",
                                                c -> c
                                                        .column(userTable, "age")
                                                        .value("未成年").value("成年人").value("老年").value("年龄分类")
                                        ))
                )
                .from().table(userTable);
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }

    @Test
    public void convertTest() {
        String targetSql = "SELECT CONVERT(varchar(255),[Users].[age]) AS 年龄,CONVERT(int,[Users].[age]),'静态值' AS [静态值],1 AS [数字],CONVERT(varchar(255),2),CONVERT(decimal(5,2),[Users].[age]),[userId],[username],[email],CASE WHEN [Users].[age] < 18 THEN '未成年' WHEN [Users].[age] >= 18 AND [Users].[age] < 60 THEN '成年人' ELSE '老年' END AS '年龄分类',[dddd] FROM [Users]";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x ->
                        {
                            x.columnToString(userTable.columnAs("age","年龄"))
                                    .columnToInt(userTable.column("age"))
                                    .valueAs("静态值","静态值")
                                    .valueAs(1,"数字")
                                    .valueToString(2)
                                    .columnToDecimal(userTable.column("age"), 5, 2)
                                    .column("userId")
                                    .column("username")
                                    .column("email")
                                    .columnFunc(
                                            AnyFunc.createSqlFunc("CASE WHEN {0} < 18 THEN {1} WHEN {0} >= 18 AND {0} < 60 THEN {2} ELSE {3} END AS {4}",
                                                    c -> c
                                                            .column(userTable, "age")
                                                            .value("未成年").value("成年人").value("老年").value("年龄分类")
                                            ));
                            x.column("dddd");
                        }

                )
                .from(userTable);
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
}
