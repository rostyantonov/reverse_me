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
