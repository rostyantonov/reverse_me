package com.over.bytecode.java11;

import com.over.bytecode.java10.Java10Bytecode;

public interface Java11Bytecode extends Java10Bytecode {
    int JAVA_11_MAJOR = 55;

    @Override
    default int majorVersion() {
        return JAVA_11_MAJOR;
    }
}
