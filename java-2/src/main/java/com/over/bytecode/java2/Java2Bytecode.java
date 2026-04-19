package com.over.bytecode.java2;

import com.over.bytecode.java1.Java1Bytecode;

public interface Java2Bytecode extends Java1Bytecode {
    int JAVA_2_MAJOR = 46;

    @Override
    default int majorVersion() {
        return JAVA_2_MAJOR;
    }
}
