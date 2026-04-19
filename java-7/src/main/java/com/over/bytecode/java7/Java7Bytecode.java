package com.over.bytecode.java7;

import com.over.bytecode.java6.Java6Bytecode;

public interface Java7Bytecode extends Java6Bytecode {
    int JAVA_7_MAJOR = 51;

    @Override
    default int majorVersion() {
        return JAVA_7_MAJOR;
    }
}
