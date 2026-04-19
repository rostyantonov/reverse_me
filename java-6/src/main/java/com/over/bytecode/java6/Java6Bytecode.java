package com.over.bytecode.java6;

import com.over.bytecode.java5.Java5Bytecode;

public interface Java6Bytecode extends Java5Bytecode {
    int JAVA_6_MAJOR = 50;

    @Override
    default int majorVersion() {
        return JAVA_6_MAJOR;
    }
}
