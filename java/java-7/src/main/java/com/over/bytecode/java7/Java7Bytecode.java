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

    // ── New constant pool tags (JVMS §4.4) ───────────────────────────────────

    /**
     * Represents a method handle — tag value 15.
     * The entry carries a {@code reference_kind} byte and a reference index
     * pointing to a field, method, or interface-method constant pool entry.
     */
    int CONSTANT_METHOD_HANDLE = 15;

    /**
     * Represents a method type (a bare method descriptor without a class) — tag value 16.
     * The entry carries an index to a CONSTANT_Utf8 method descriptor.
     */
    int CONSTANT_METHOD_TYPE = 16;

    /**
     * Represents an {@code invokedynamic} call site — tag value 18.
     * The entry carries a bootstrap method index and a CONSTANT_NameAndType index.
     */
    int CONSTANT_INVOKE_DYNAMIC = 18;

    // ── Method-handle reference_kind values (JVMS §4.4.8, Table 4.4.8-A) ─────
    // Stored as a 1-byte field inside CONSTANT_MethodHandle entries.

    /** {@code getfield} — reads an instance field. */
    int REF_GET_FIELD = 1;
    /** {@code getstatic} — reads a static field. */
    int REF_GET_STATIC = 2;
    /** {@code putfield} — writes an instance field. */
    int REF_PUT_FIELD = 3;
    /** {@code putstatic} — writes a static field. */
    int REF_PUT_STATIC = 4;
    /** {@code invokevirtual} — invokes an instance method via virtual dispatch. */
    int REF_INVOKE_VIRTUAL = 5;
    /** {@code invokestatic} — invokes a static method. */
    int REF_INVOKE_STATIC = 6;
    /** {@code invokespecial} — invokes an instance method directly (constructor, super, private). */
    int REF_INVOKE_SPECIAL = 7;
    /**
     * {@code new} + {@code invokespecial} — creates a new instance and invokes its constructor.
     * The referenced method must be a constructor ({@code <init>}).
     */
    int REF_NEW_INVOKE_SPECIAL = 8;
    /** {@code invokeinterface} — invokes an interface method. */
    int REF_INVOKE_INTERFACE = 9;

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
