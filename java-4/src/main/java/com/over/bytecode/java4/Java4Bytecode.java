package com.over.bytecode.java4;

import com.over.bytecode.java3.Java3Bytecode;

public interface Java4Bytecode extends Java3Bytecode {
    int JAVA_4_MAJOR = 48;

    @Override
    default int majorVersion() {
        return JAVA_4_MAJOR;
    }
}
