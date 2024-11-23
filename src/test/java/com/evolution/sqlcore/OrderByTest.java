package com.evolution.sqlcore;

import com.evolution.sqlcore.actions.Queryable;
import com.evolution.sqlcore.compiler.sqlServer.MsCompile;
import com.evolution.sqlcore.enums.SortTypeEnum;
import com.evolution.sqlcore.elements.TableInfo;
import org.junit.jupiter.api.Test;

public class OrderByTest {
    @Test
    public void test1() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] ORDER BY [Users].[userId] ASC";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select().column(x ->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable).orderBy(userTable.column("userId"), SortTypeEnum.ASC)
        ;
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
     @Test
    public void test2() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] ORDER BY [userId],[email] ASC";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select().column(x ->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable).orderBy(x->x.column("userId").column("email"), SortTypeEnum.ASC)
        ;
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
}
