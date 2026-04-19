package com.over.bytecode.java10;

import com.over.bytecode.java9.Java9Bytecode;

public interface Java10Bytecode extends Java9Bytecode {
    int JAVA_10_MAJOR = 54;

    @Override
    default int majorVersion() {
        return JAVA_10_MAJOR;
    }
}
