package com.over.bytecode.java7;

import com.over.bytecode.java6.Java6Bytecode;

/**
 * Represents the class file format introduced in Java 7 (major version 51).
 *
 * <p>Java 7 added the {@code invokedynamic} instruction and the BootstrapMethods
 * attribute to support dynamic language runtimes on the JVM.
 * The BootstrapMethods table holds the bootstrap method handle used to link
 * each {@code invokedynamic} call site at first invocation.
 *
 * <p>New predefined class file attribute: BootstrapMethods.
 */
public interface Java7Bytecode extends Java6Bytecode {

    int MAJOR_VERSION = 51;

    // ── Attributes first defined in Java 7 ───────────────────────────────────

    /**
     * Used on classes; holds bootstrap method handles referenced by
     * {@code invokedynamic} instructions in the class.
     * Each entry specifies a method handle and optional static arguments
     * used to link the dynamic call site.
     */
    String ATTR_BOOTSTRAP_METHODS = "BootstrapMethods";

    @Override
    default int majorVersion() {
        return MAJOR_VERSION;
    }
}
