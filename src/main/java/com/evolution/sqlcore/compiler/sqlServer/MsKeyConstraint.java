package com.evolution.sqlcore.compiler.sqlServer;

import com.evolution.sqlcore.compiler.baseCompile.syntaxConfig.KeyConstraint;

public class MsKeyConstraint extends KeyConstraint {
    @Override
    public String TABLE_NAME_LEFT_BRACKET() {
        return "[";
    }
    @Override
    public String TABLE_NAME_RIGHT_BRACKET() {
        return "]";
    }
    @Override
    public String DATABASE_NAME_LEFT_BRACKET() {
        return "[";
    }
    @Override
    public String DATABASE_NAME_RIGHT_BRACKET() {
        return "]";
    }
    @Override
    public String SCHEMA_NAME_LEFT_BRACKET() {
        return "[";
    }
    @Override
    public String SCHEMA_NAME_RIGHT_BRACKET() {
        return "]";
    }

    @Override
    public String TOP() {
        return "TOP";
    }

    @Override
    public String KEY_LEFT_BRACKET() {
        return "[";
    }
    @Override
    public String KEY_RIGHT_BRACKET() {
        return "]";
    }
    @Override
    public String COLUMN_LEFT_BRACKET() {
        return "[";
    }
    @Override
    public String COLUMN_RIGHT_BRACKET() {
        return "]";
    }
    @Override
    public String FETCH() {
        return "FETCH";
    }
    @Override
    public String NEXT() {
        return "NEXT";
    }
    @Override
    public String ROWS() {
        return "ROWS";
    }
    @Override
    public String ONLY() {
        return "ONLY";
    }


}
