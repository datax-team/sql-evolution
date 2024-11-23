package com.evolution.sqlcore;

import org.junit.jupiter.api.Test;
import com.evolution.sqlcore.actions.Queryable;
import com.evolution.sqlcore.compiler.sqlServer.MsCompile;
import com.evolution.sqlcore.elements.TableInfo;

public class limitTest {
    @Test
    public void test1() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] LIMIT 10 OFFSET 10";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select().column(x ->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable).limit(10,10);
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void test2() {
        String targetSql = "SELECT TOP 10 [userId],[username],[email] FROM [Users]";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select().top(10).column(x ->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable);
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
}
