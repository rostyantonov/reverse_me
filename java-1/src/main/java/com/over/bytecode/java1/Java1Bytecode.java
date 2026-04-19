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

    // ── Constant pool tags (JVMS §4.4) ───────────────────────────────────────

    /** UTF-8 encoded string — tag value 1. */
    int CONSTANT_UTF8 = 1;
    /** 4-byte int constant — tag value 3. */
    int CONSTANT_INTEGER = 3;
    /** 4-byte float constant — tag value 4. */
    int CONSTANT_FLOAT = 4;
    /** 8-byte long constant — tag value 5. Uses two constant-pool slots. */
    int CONSTANT_LONG = 5;
    /** 8-byte double constant — tag value 6. Uses two constant-pool slots. */
    int CONSTANT_DOUBLE = 6;
    /** Class or interface symbolic reference — tag value 7. */
    int CONSTANT_CLASS = 7;
    /** String object symbolic reference — tag value 8. */
    int CONSTANT_STRING = 8;
    /** Field symbolic reference — tag value 9. */
    int CONSTANT_FIELDREF = 9;
    /** Class-method symbolic reference — tag value 10. */
    int CONSTANT_METHODREF = 10;
    /** Interface-method symbolic reference — tag value 11. */
    int CONSTANT_INTERFACE_METHODREF = 11;
    /** Field or method name-and-type descriptor pair — tag value 12. */
    int CONSTANT_NAME_AND_TYPE = 12;

    // ── JVM base types — field and method descriptor characters (JVMS §4.3) ──

    /** Descriptor character for the primitive type {@code byte}. */
    char TYPE_BYTE = 'B';
    /** Descriptor character for the primitive type {@code char}. */
    char TYPE_CHAR = 'C';
    /** Descriptor character for the primitive type {@code double}. */
    char TYPE_DOUBLE = 'D';
    /** Descriptor character for the primitive type {@code float}. */
    char TYPE_FLOAT = 'F';
    /** Descriptor character for the primitive type {@code int}. */
    char TYPE_INT = 'I';
    /** Descriptor character for the primitive type {@code long}. */
    char TYPE_LONG = 'J';
    /**
     * Descriptor character introducing a reference (class/interface) type.
     * Followed by the binary class name and terminated by {@code ';'}.
     * Example: {@code Ljava/lang/String;}
     */
    char TYPE_REFERENCE = 'L';
    /** Descriptor character for the primitive type {@code short}. */
    char TYPE_SHORT = 'S';
    /** Descriptor character for the primitive type {@code boolean}. */
    char TYPE_BOOLEAN = 'Z';
    /** Descriptor character for the return type {@code void} (method descriptors only). */
    char TYPE_VOID = 'V';
    /**
     * Descriptor character indicating an array type.
     * One {@code '['} per dimension, followed by the component type descriptor.
     * Example: {@code [[I} is {@code int[][]}.
     */
    char TYPE_ARRAY = '[';

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
