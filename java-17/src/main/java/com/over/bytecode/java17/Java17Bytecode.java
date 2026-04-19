package com.over.bytecode.java17;

import com.over.bytecode.java16.Java16Bytecode;

public interface Java17Bytecode extends Java16Bytecode {
    int JAVA_17_MAJOR = 61;

    @Override
    default int majorVersion() {
        return JAVA_17_MAJOR;
    }
}
