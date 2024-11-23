package com.evolution.sqlcore;

import com.evolution.sqlcore.actions.Queryable;
import com.evolution.sqlcore.compiler.sqlServer.MsCompile;
import com.evolution.sqlcore.elements.TableInfo;
import org.junit.jupiter.api.Test;

public class SelectTest {
    @Test
    public void query1() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users]";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x ->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from().table(userTable);
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }

    @Test
    public void query2() {
        String targetSql = "SELECT [userId],[username],[email]," +
                "MAX([age]) AS [最大年龄],MIN([age]) AS [最小年龄],SUM([age]) AS [年龄总和],AVG([age]) AS [平均年龄],COUNT([age]) AS [年龄个数] " +
                "FROM [Users] GROUP BY [userId],[username],[email]";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable
                .select(x ->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                                .maxAs("age", "最大年龄")
                                .minAs("age", "最小年龄")
                                .sumAs("age", "年龄总和")
                                .avgAs("age", "平均年龄")
                                .countAs("age", "年龄个数")
                )
                .from(userTable)
                .groupBy(x -> x.column("userId").column("username").column("email"));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }

}
