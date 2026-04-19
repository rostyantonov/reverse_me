package com.over.bytecode.java21;

import com.over.bytecode.java20.Java20Bytecode;

public interface Java21Bytecode extends Java20Bytecode {
    int JAVA_21_MAJOR = 65;

    @Override
    default int majorVersion() {
        return JAVA_21_MAJOR;
    }
}
