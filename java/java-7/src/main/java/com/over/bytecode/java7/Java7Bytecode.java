package com.over.bytecode.java7;

import com.over.bytecode.java5.Java5Bytecode;

/**
 * Represents the class file format introduced in Java 7 (major version 51).
 *
 * <p>Java 6 (major version 50) introduced the split verifier and made the
 * StackMapTable attribute required in Code attributes for class files targeting
 * version 50 and above. The StackMapTable attribute encodes stack frame types
 * at verification branch targets, enabling faster bytecode verification.
 *
 * <p>Java 7 added the {@code invokedynamic} instruction and the BootstrapMethods
 * attribute to support dynamic language runtimes on the JVM.
 * The BootstrapMethods table holds the bootstrap method handle used to link
 * each {@code invokedynamic} call site at first invocation.
 *
 * <p>New predefined class file attributes: StackMapTable (Java 6), BootstrapMethods (Java 7).
 */
public interface Java7Bytecode extends Java5Bytecode {

    int MAJOR_VERSION = 51;

    // ── Verification type info tags (JVMS §4.7.4, Table 4.7.4-A) ─────────────
    // Introduced in Java 6 (class file version 50).
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

    // ── Attributes first defined in Java 6 ───────────────────────────────────

    /**
     * Used within the Code attribute; describes stack and local variable types
     * at each verification-relevant branch target.
     * Required for code compiled to class file version 50.0 and above.
     */
    String ATTR_STACK_MAP_TABLE = "StackMapTable";

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
