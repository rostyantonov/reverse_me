package com.over.bytecode.java12;

import com.over.bytecode.java11.Java11Bytecode;

public interface Java12Bytecode extends Java11Bytecode {
    int JAVA_12_MAJOR = 56;

    @Override
    default int majorVersion() {
        return JAVA_12_MAJOR;
    }
}
