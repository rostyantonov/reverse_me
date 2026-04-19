package com.over.bytecode.java9;

import com.over.bytecode.java8.Java8Bytecode;

public interface Java9Bytecode extends Java8Bytecode {
    int JAVA_9_MAJOR = 53;

    @Override
    default int majorVersion() {
        return JAVA_9_MAJOR;
    }
}
