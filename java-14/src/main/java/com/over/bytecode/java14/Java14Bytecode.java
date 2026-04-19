package com.over.bytecode.java14;

import com.over.bytecode.java13.Java13Bytecode;

public interface Java14Bytecode extends Java13Bytecode {
    int JAVA_14_MAJOR = 58;

    @Override
    default int majorVersion() {
        return JAVA_14_MAJOR;
    }
}
