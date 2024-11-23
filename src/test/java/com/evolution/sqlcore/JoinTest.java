package com.evolution.sqlcore;

import com.evolution.sqlcore.actions.Queryable;
import com.evolution.sqlcore.compiler.sqlServer.MsCompile;
import com.evolution.sqlcore.func.ColumnFunc;
import com.evolution.sqlcore.func.TableFunc;
import com.evolution.sqlcore.elements.TableInfo;
import org.junit.jupiter.api.Test;

public class JoinTest {
    @Test
    public void query1() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] LEFT JOIN [Orders] ON [Users].[userId] = [Orders].[userId]";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        TableInfo orderTable=TableFunc.createTable("Orders");
        queryable.select(x ->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable).leftJoin().table(orderTable).on(x->x.eq(userTable.column("userId"),orderTable.column("userId")))
        ;
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void query2() {
        String targetSql = "SELECT [userId],[Orders].[user_Id],[username],[email] FROM [Users] LEFT JOIN [Orders] ON [userId] = [user_Id]";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        TableInfo orderTable=TableFunc.createTable("Orders");
        queryable.select(x ->
                        x
                                .column("userId")
                                .column(orderTable,"user_Id")
                                .column("username")
                                .column("email")
                )
                .from(userTable).leftJoin().table(orderTable).on(x->x.eq(ColumnFunc.column("userId"),ColumnFunc.column("user_Id")))
        ;
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
}
