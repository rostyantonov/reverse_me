package com.over.bytecode.java1;

import com.over.bytecode.common.BytecodeVersion;

public interface Java1Bytecode extends BytecodeVersion {
    int JAVA_1_MAJOR = 45;

    @Override
    default int majorVersion() {
        return JAVA_1_MAJOR;
    }
}
