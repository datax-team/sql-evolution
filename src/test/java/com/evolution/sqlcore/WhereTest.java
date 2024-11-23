package com.evolution.sqlcore;


import com.evolution.sqlcore.actions.Queryable;
import com.evolution.sqlcore.compiler.sqlServer.MsCompile;
import com.evolution.sqlcore.func.ColumnFunc;
import com.evolution.sqlcore.elements.TableInfo;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class WhereTest {
    @Test
    public void query1() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] WHERE [username] = '张三'";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable)
                .where(x->x.eq(ColumnFunc.column("username"),"张三"));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void query2() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] WHERE [username] <> '张三'";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable)
                .where(x->x.ne(ColumnFunc.column("username"),"张三"));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void query3() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] WHERE [username] > '张三'";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable)
                .where(x->x.gt(ColumnFunc.column("username"),"张三"));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void query4() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] WHERE [username] < '张三'";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable)
                .where(x->x.lt(ColumnFunc.column("username"),"张三"));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void query5() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] WHERE [username] >= '张三'";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable)
                .where(x->x.ge(ColumnFunc.column("username"),"张三"));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void query6() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] WHERE [username] <= '张三'";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable)
                .where(x->x.le(ColumnFunc.column("username"),"张三"));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void query7() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] WHERE [username] IN ('张三','李四')";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable)
                .where(x->x.in(ColumnFunc.column("username"), Arrays.asList("张三", "李四")));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void query8() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] WHERE [username] NOT IN ('张三','李四')";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable)
                .where(x->x.notIn(ColumnFunc.column("username"), Arrays.asList("张三", "李四")));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void query9() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] WHERE [username] LIKE '%张%'";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable)
                .where(x->x.like(ColumnFunc.column("username"),"张"));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void query10() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] WHERE [username] NOT LIKE '%张三%'";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable)
                .where(x->x.notLike(ColumnFunc.column("username"), "张三"));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void query11() {
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] WHERE [username] BETWEEN 1 AND 2";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable)
                .where(x->x.between(ColumnFunc.column("username"), 1,2));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void query12() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusDays(1);
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] WHERE [username] BETWEEN '"+start.format(formatter)+"' AND '"+end.format(formatter)+"'";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable)
                .where(x->x.between(ColumnFunc.column("username"), start,end));
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }
    @Test
    public void query13() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusDays(1);
        String targetSql = "SELECT [userId],[username],[email] FROM [Users] WHERE [createTime] = '"+start.format(formatter)+"'"
                + " OR [createTime] = '"+end.format(formatter)+"' AND [username] = '张三'" + " AND ([username] = '李四' OR [username] LIKE '%王五%')";
        Queryable queryable = new Queryable();
        TableInfo userTable = queryable.createTable(x -> x.tableName("Users"));
        queryable.select(x->
                        x
                                .column("userId")
                                .column("username")
                                .column("email")
                )
                .from(userTable)
                .where(x->{
                    x.eq(ColumnFunc.column("createTime"), start)
                            .or()
                            .eq(ColumnFunc.column("createTime"), end);
                    x.and().eq(ColumnFunc.column("username"), "张三")
                            .and().lb()
                            .eq(ColumnFunc.column("username"), "李四")
                            .or().like(ColumnFunc.column("username"), "王五")
                            .rb();
                });
        MsCompile msCompile = new MsCompile();
        String sql = msCompile.compile(queryable);
        System.out.println(sql);
        assert sql.equals(targetSql);
    }


}
