package com.evolution.sqlcore;

import com.evolution.sqlcore.actions.Queryable;
import com.evolution.sqlcore.compiler.sqlServer.MsCompile;
import com.evolution.sqlcore.enums.ComparisonOperatorEnum;
import com.evolution.sqlcore.enums.SortTypeEnum;
import com.evolution.sqlcore.elements.TableInfo;
import org.junit.jupiter.api.Test;

public class QueryTest {
    @Test
    public void joinTest1() {
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(tableProvider -> {
            tableProvider.databaseName("testDb")
                    .schema("public")
                    .tableName("user")
                    .alias("u");
        });
        TableInfo depTable = queryable.createTable(tableProvider -> {
            tableProvider.databaseName("testDb")
                    .schema("public")
                    .tableName("department")
                    .alias("dep");
        });
        queryable.select(columnProvider -> {
                    columnProvider.table(userTable)
                            .columnAs("id", "ID")
                            .columnAs("name", "名字");
                })
                .from()
                .table(userTable)
                .leftJoin().table(depTable)
                .on(userTable.column("id"), ComparisonOperatorEnum.Equals, depTable.column("user_id"))
                .and(userTable.column("id"), ComparisonOperatorEnum.GreaterThan, 10)
                .where().condition(userTable.column("id"), ComparisonOperatorEnum.GreaterThan, 10)
                .groupBy(userTable.column("id"))
                .having().condition(userTable.column("id"), ComparisonOperatorEnum.GreaterThan, 10)
                .orderBy(userTable.column("id"), SortTypeEnum.ASC);
        MsCompile msCompile = new MsCompile();
        msCompile.useFormatSql(true);
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
    }


    @Test
    public void queryNestTest() {

    }

    @Test
    public void test02() {
    }
}
