package com.evolution.sqlcore.compiler.sqlServer;

import com.evolution.sqlcore.compiler.baseCompile.SqlCompile;
import com.evolution.sqlcore.compiler.sqlServer.component.MsConvertFuncCompile;

public class MsCompile extends SqlCompile {
    public MsCompile() {
        super.useKeyConstraint(new MsKeyConstraint());
        super.useConvertFuncCompile(new MsConvertFuncCompile().setCompileConfig(super.getCompileConfig()));
    }



//    @Override
//    protected void limitCompile(Queryable queryable) {
//        if (queryable.limitProvider == null) {
//            return;
//        }
//        sqlBuilder.append(getKeyConstraintProvider().OFFSET())
//                .append(getKeyConstraintProvider().SPACE())
//                .append(queryable.limitProvider.offset)
//                .append(getKeyConstraintProvider().SPACE())
//                .append(getKeyConstraintProvider().ROWS())
//                .append(getKeyConstraintProvider().SPACE())
//                .append(getKeyConstraintProvider().FETCH()).append(getKeyConstraintProvider().SPACE())
//                .append(getKeyConstraintProvider().NEXT())
//                .append(getKeyConstraintProvider().SPACE())
//                .append(queryable.limitProvider.limit)
//                .append(getKeyConstraintProvider().SPACE())
//                .append(getKeyConstraintProvider().ROWS()).append(getKeyConstraintProvider().SPACE())
//                .append(getKeyConstraintProvider().ONLY())
//                .append(getKeyConstraintProvider().SPACE());
//    }
    @Override
    public void useFormatSql(Boolean formatSql){
        super.useFormatSql(formatSql);
    }
    public Boolean getFormatSql() {
        return super.getCompileConfig().getFormatSql();
    }

}
