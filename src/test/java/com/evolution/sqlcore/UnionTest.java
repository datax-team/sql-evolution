package com.evolution.sqlcore;

import com.evolution.sqlcore.actions.Queryable;
import com.evolution.sqlcore.compiler.sqlServer.MsCompile;
import com.evolution.sqlcore.elements.TableInfo;
import org.junit.jupiter.api.Test;

public class UnionTest {
    @Test
    public void test1() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] UNION SELECT [userId2],[username2],[email2] FROM [Orders]";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        TableInfo orderTable = queryable.createTable(x -> x.tableName("Orders"));
        queryable.select().column(x ->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable).union()
                .select(x -> x.column("userId2")
                        .column("username2")
                        .column("email2"))
                .from(orderTable)
        ;
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
}
