package com.evolution.sqlcore;

import com.evolution.sqlcore.actions.Queryable;
import com.evolution.sqlcore.compiler.sqlServer.MsCompile;
import com.evolution.sqlcore.func.TableFunc;
import org.junit.jupiter.api.Test;

public class DistinctTest {
    @Test
    public void test() {
        String targetSql = "SELECT DISTINCT [id],[name],[age] FROM [user]";
        Queryable queryable = new Queryable();
        queryable.select()
                .distinct()
                .column(x->x.column("id")
                .column("name")
                .column("age"))
                .from(TableFunc.createTable("user"));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
}
