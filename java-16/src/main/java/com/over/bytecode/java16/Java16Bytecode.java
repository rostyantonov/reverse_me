package com.over.bytecode.java16;

import com.over.bytecode.java15.Java15Bytecode;

public interface Java16Bytecode extends Java15Bytecode {
    int JAVA_16_MAJOR = 60;

    @Override
    default int majorVersion() {
        return JAVA_16_MAJOR;
    }
}
