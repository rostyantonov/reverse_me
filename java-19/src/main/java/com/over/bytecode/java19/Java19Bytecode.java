package com.over.bytecode.java19;

import com.over.bytecode.java18.Java18Bytecode;

public interface Java19Bytecode extends Java18Bytecode {
    int JAVA_19_MAJOR = 63;

    @Override
    default int majorVersion() {
        return JAVA_19_MAJOR;
    }
}
