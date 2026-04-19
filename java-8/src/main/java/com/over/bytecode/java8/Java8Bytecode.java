package com.over.bytecode.java8;

import com.over.bytecode.java7.Java7Bytecode;

public interface Java8Bytecode extends Java7Bytecode {
    int JAVA_8_MAJOR = 52;

    @Override
    default int majorVersion() {
        return JAVA_8_MAJOR;
    }
}
