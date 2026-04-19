package com.over.bytecode.java18;

import com.over.bytecode.java17.Java17Bytecode;

public interface Java18Bytecode extends Java17Bytecode {
    int JAVA_18_MAJOR = 62;

    @Override
    default int majorVersion() {
        return JAVA_18_MAJOR;
    }
}
