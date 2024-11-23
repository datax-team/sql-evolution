package com.evolution.sqlcore.compiler.baseCompile.component;

import com.evolution.sqlcore.compiler.baseCompile.CompileConfig;
import com.evolution.sqlcore.func.ConvertFunc;

public interface ConvertFuncCompile {
    public ConvertFuncCompile setCompileConfig(CompileConfig compileConfig);
    public void compile(ConvertFunc convertFunc);
}
