package com.over.bytecode.java13;

import com.over.bytecode.java12.Java12Bytecode;

public interface Java13Bytecode extends Java12Bytecode {
    int JAVA_13_MAJOR = 57;

    @Override
    default int majorVersion() {
        return JAVA_13_MAJOR;
    }
}
