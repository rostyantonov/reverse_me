package com.over.bytecode.java20;

import com.over.bytecode.java19.Java19Bytecode;

public interface Java20Bytecode extends Java19Bytecode {
    int JAVA_20_MAJOR = 64;

    @Override
    default int majorVersion() {
        return JAVA_20_MAJOR;
    }
}
