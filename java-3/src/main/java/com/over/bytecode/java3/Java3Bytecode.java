package com.over.bytecode.java3;

import com.over.bytecode.java2.Java2Bytecode;

public interface Java3Bytecode extends Java2Bytecode {
    int JAVA_3_MAJOR = 47;

    @Override
    default int majorVersion() {
        return JAVA_3_MAJOR;
    }
}
