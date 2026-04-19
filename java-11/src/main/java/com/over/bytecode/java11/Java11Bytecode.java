package com.over.bytecode.java11;

import com.over.bytecode.java9.Java9Bytecode;

/**
 * Represents the class file format introduced in Java 11 (major version 55).
 *
 * <p>Java 11 (LTS) introduced nest-based access control (JEP 181), replacing
 * the compiler trick of generating synthetic bridge methods for private access
 * between a host class and its nest members. Two new attributes record the
 * nest relationship so the JVM can perform direct access checks.
 *
 * <p>Java 11 also introduced Constant Dynamic (JEP 309): a new constant pool
 * tag that allows lazy, bootstrap-driven constant computation analogous to
 * {@code invokedynamic} but for constants.
 *
 * <p>New predefined class file attributes: NestHost, NestMembers.
 */
public interface Java11Bytecode extends Java9Bytecode {

    int MAJOR_VERSION = 55;

    // ── New constant pool tag (JVMS §4.4) ────────────────────────────────────

    /**
     * Represents a dynamically-computed constant — tag value 17 (JEP 309).
     * Analogous to CONSTANT_InvokeDynamic but for constant values rather than
     * call sites. The entry carries a bootstrap method index and a
     * CONSTANT_NameAndType index; the bootstrap method is invoked once to
     * produce the constant value.
     */
    int CONSTANT_DYNAMIC = 17;

    // ── Attributes first defined in Java 11 ──────────────────────────────────

    /**
     * Used on a member class of a nest; identifies the host class (top-level
     * class or interface) of the nest this class belongs to.
     * Enables private access between nest members without bridge methods.
     */
    String ATTR_NEST_HOST = "NestHost";

    /**
     * Used on a nest host class; lists all the member classes that belong
     * to the nest. Enables the JVM to verify nest membership and allow
     * direct access to private members.
     */
    String ATTR_NEST_MEMBERS = "NestMembers";

    @Override
    default int majorVersion() {
        return MAJOR_VERSION;
    }
}
