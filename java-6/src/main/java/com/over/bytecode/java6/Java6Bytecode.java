package com.over.bytecode.java6;

import com.over.bytecode.java5.Java5Bytecode;

/**
 * Represents the class file format introduced in Java 6 (major version 50).
 *
 * <p>Java 6 introduced the split verifier and made the StackMapTable attribute
 * required in Code attributes for class files targeting version 50 and above.
 * The StackMapTable attribute encodes stack frame types at verification branch
 * targets, enabling faster bytecode verification.
 *
 * <p>New predefined class file attribute: StackMapTable.
 */
public interface Java6Bytecode extends Java5Bytecode {

    int MAJOR_VERSION = 50;

    // ── Verification type info tags (JVMS §4.7.4, Table 4.7.4-A) ─────────────
    // Used in StackMapTable frame entries to describe operand stack and
    // local variable types at each branch target.

    /** Represents an unusable or uninitialized slot; also "top" of the verification type lattice. */
    int ITEM_TOP = 0;
    /** Represents a value of type {@code int}, {@code boolean}, {@code byte}, {@code char}, or {@code short}. */
    int ITEM_INTEGER = 1;
    /** Represents a value of type {@code float}. */
    int ITEM_FLOAT = 2;
    /** Represents a value of type {@code double}. */
    int ITEM_DOUBLE = 3;
    /** Represents a value of type {@code long}. */
    int ITEM_LONG = 4;
    /** Represents the {@code null} reference. */
    int ITEM_NULL = 5;
    /** Represents the uninitialised {@code this} reference inside a constructor before {@code invokespecial <init>}. */
    int ITEM_UNINITIALIZED_THIS = 6;
    /**
     * Represents a reference to an instance of a specific class.
     * The verification_type_info entry also carries a constant pool index for the class.
     */
    int ITEM_OBJECT = 7;
    /**
     * Represents a reference to an object created by {@code new} that has not yet
     * been passed to an {@code invokespecial} constructor call.
     * The entry also carries the bytecode offset of the creating {@code new} instruction.
     */
    int ITEM_UNINITIALIZED = 8;

    // ── Attributes first defined in Java 6 ───────────────────────────────────

    /**
     * Used within the Code attribute; describes stack and local variable types
     * at each verification-relevant branch target.
     * Required for code compiled to class file version 50.0 and above.
     */
    String ATTR_STACK_MAP_TABLE = "StackMapTable";

    @Override
    default int majorVersion() {
        return MAJOR_VERSION;
    }
}
