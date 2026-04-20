package com.over.bytecode.java21;

import com.over.bytecode.java17.Java17Bytecode;

/**
 * Represents the class file format targeting Java 21 (major version 65).
 *
 * <p>Java 21 (LTS) finalized several language features without introducing new
 * predefined class file attributes: virtual threads (JEP 444), sequenced
 * collections (JEP 431), record patterns (JEP 440), and pattern matching for
 * switch (JEP 441) are library or compiler-only changes.
 *
 * <p>This interface is the top of the bytecode hierarchy as of Java 21 LTS
 * and inherits all class file attributes from prior major versions.
 */
public interface Java21Bytecode extends Java17Bytecode {

    int MAJOR_VERSION = 65;

    @Override
    default int majorVersion() {
        return MAJOR_VERSION;
    }
}
