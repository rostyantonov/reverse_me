package com.over.bytecode.java1;

import com.over.bytecode.common.BytecodeVersion;

/**
 * Represents the class file format introduced in Java 1.0.2 (major version 45)
 * and extended in Java 1.1.
 *
 * <p>Predefined attributes (Java 1.0.2):
 * ConstantValue, Code, Exceptions, SourceFile, LineNumberTable, LocalVariableTable
 *
 * <p>Predefined attributes added in Java 1.1:
 * InnerClasses, Synthetic, Deprecated
 */
public interface Java1Bytecode extends BytecodeVersion {

    int MAJOR_VERSION = 45;

    // ── Attributes first defined in Java 1.0.2 ───────────────────────────────

    /** Used on fields; holds the constant value for a static field. */
    String ATTR_CONSTANT_VALUE = "ConstantValue";

    /** Used on methods; contains the bytecode instructions and associated data. */
    String ATTR_CODE = "Code";

    /** Used on methods; lists checked exception types that a method may throw. */
    String ATTR_EXCEPTIONS = "Exceptions";

    /** Used on classes; holds the source file name for debug information. */
    String ATTR_SOURCE_FILE = "SourceFile";

    /** Used in the Code attribute; maps bytecode offsets to source line numbers. */
    String ATTR_LINE_NUMBER_TABLE = "LineNumberTable";

    /** Used in the Code attribute; maps bytecode offsets to local variable names. */
    String ATTR_LOCAL_VARIABLE_TABLE = "LocalVariableTable";

    // ── Attributes first defined in Java 1.1 ─────────────────────────────────

    /** Used on classes; describes nested and inner class relationships. */
    String ATTR_INNER_CLASSES = "InnerClasses";

    /** Marks a field, method, or class as compiler-generated. */
    String ATTR_SYNTHETIC = "Synthetic";

    /** Marks a field, method, or class as deprecated. */
    String ATTR_DEPRECATED = "Deprecated";

    @Override
    default int majorVersion() {
        return MAJOR_VERSION;
    }
}
