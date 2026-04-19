package com.over.bytecode.java5;

import com.over.bytecode.java4.Java4Bytecode;

public interface Java5Bytecode extends Java4Bytecode {
    int JAVA_5_MAJOR = 49;

    @Override
    default int majorVersion() {
        return JAVA_5_MAJOR;
    }
}
