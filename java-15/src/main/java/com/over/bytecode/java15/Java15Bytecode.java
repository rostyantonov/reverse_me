package com.over.bytecode.java15;

import com.over.bytecode.java14.Java14Bytecode;

public interface Java15Bytecode extends Java14Bytecode {
    int JAVA_15_MAJOR = 59;

    @Override
    default int majorVersion() {
        return JAVA_15_MAJOR;
    }
}
